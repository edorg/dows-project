package org.dows.project.repository;

import com.mybatisflex.core.query.QueryWrapper;
import org.dows.rade.crud.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.dows.project.admin.PostProjectOpsEntityRequest;
import org.dows.project.admin.PostProjectOpsEntityResponse;
import org.dows.project.admin.PutProjectOpsEntityRequest;
import org.dows.project.admin.GetProjectOpsListRequest;
import org.dows.project.admin.GetProjectOpsListResponse;
import org.dows.project.admin.GetProjectOpsEntityRequest;
import org.dows.project.admin.GetProjectOpsEntityResponse;
import org.dows.project.admin.DeleteProjectOpsEntityRequest;
import org.dows.project.entity.ProjectOpsEntity;
import org.dows.project.dao.ProjectOpsDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectOpsRepository extends CrudRepository<ProjectOpsDao, ProjectOpsEntity> {

    @Autowired
    private ProjectOpsDao projectOpsDao;

    /**
     * 批量保存项目运维
     */
    public List<PostProjectOpsEntityResponse> saveBatch(List<PostProjectOpsEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectOpsEntity> entities = requests.stream().map(request -> {
            ProjectOpsEntity entity = new ProjectOpsEntity();
            entity.setProjectInstanceId(request.getProjectInstanceId());
            entity.setScript(request.getScript());
            entity.setScriptName(request.getScriptName());
            entity.setStage(request.getStage());
            // 设置创建时间为当前时间
            entity.setCreateTime(now);
            return entity;
        }).collect(Collectors.toList());
        
        boolean saved = projectOpsDao.saveBatch(entities);
        if (!saved) {
            throw new RuntimeException("批量创建项目运维失败");
        }
        
        return entities.stream().map(entity -> {
            PostProjectOpsEntityResponse response = new PostProjectOpsEntityResponse();
            response.setProjectOpsId(entity.getProjectOpsId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量更新项目运维，返回更新的ID列表
     */
    public List<PostProjectOpsEntityResponse> updateBatch(List<PutProjectOpsEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectOpsEntity> entities = requests.stream().map(request -> {
            ProjectOpsEntity entity = new ProjectOpsEntity();
            entity.setProjectOpsId(request.getProjectOpsId());
            entity.setScript(request.getScript());
            entity.setScriptName(request.getScriptName());
            entity.setStage(request.getStage());
            // 设置更新时间为当前时间
            entity.setUpdateTime(now);
            
            // 如果 request 中没有提供 revision，从数据库查询当前的 revision 值
            if (request.getRevision() != null) {
                entity.setRevision(request.getRevision());
            } else {
                ProjectOpsEntity existingEntity = projectOpsDao.getById(request.getProjectOpsId());
                if (existingEntity != null && existingEntity.getRevision() != null) {
                    entity.setRevision(existingEntity.getRevision());
                }
            }
            
            return entity;
        }).collect(Collectors.toList());
        
        boolean updated = projectOpsDao.updateBatch(entities);
        if (!updated) {
            throw new RuntimeException("批量更新项目运维失败");
        }
        
        return entities.stream().map(entity -> {
            PostProjectOpsEntityResponse response = new PostProjectOpsEntityResponse();
            response.setProjectOpsId(entity.getProjectOpsId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 根据ID查询项目运维
     */
    public GetProjectOpsEntityResponse getById(GetProjectOpsEntityRequest request) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .from(ProjectOpsEntity.class)
                .where("project_ops_id = ?", request.getProjectOpsId())
                .and("delete_time is null");
        
        List<ProjectOpsEntity> entities = projectOpsDao.list(queryWrapper);
        if (entities == null || entities.isEmpty()) {
            return null;
        }
        ProjectOpsEntity entity = entities.get(0);
        GetProjectOpsEntityResponse response = new GetProjectOpsEntityResponse();
        response.setProjectOpsId(entity.getProjectOpsId());
        response.setProjectInstanceId(entity.getProjectInstanceId());
        response.setScript(entity.getScript());
        response.setScriptName(entity.getScriptName());
        response.setStage(entity.getStage());
        response.setRevision(entity.getRevision());
        response.setAppId(entity.getAppId());
        response.setCreateTime(entity.getCreateTime());
        response.setUpdateTime(entity.getUpdateTime());
        response.setDeleteTime(entity.getDeleteTime());
        response.setCreateId(entity.getCreateId());
        response.setUpdateId(entity.getUpdateId());
        return response;
    }

    /**
     * 列表查询项目运维
     */
    public List<GetProjectOpsListResponse> list(GetProjectOpsListRequest request) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .from(ProjectOpsEntity.class)
                .where("delete_time is null");
        
        if (request.getProjectInstanceId() != null) {
            queryWrapper.and("project_instance_id = ?", request.getProjectInstanceId());
        }
        queryWrapper.orderBy("stage", true);
        List<ProjectOpsEntity> entities = projectOpsDao.list(queryWrapper);
        
        return entities.stream().map(entity -> {
            GetProjectOpsListResponse response = new GetProjectOpsListResponse();
            response.setProjectOpsId(entity.getProjectOpsId());
            response.setProjectInstanceId(entity.getProjectInstanceId());
            response.setScript(entity.getScript());
            response.setScriptName(entity.getScriptName());
            response.setStage(entity.getStage());
            response.setRevision(entity.getRevision());
            response.setCreateTime(entity.getCreateTime());
            response.setUpdateTime(entity.getUpdateTime());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量删除项目运维（逻辑删除），返回删除的ID列表
     */
    public List<PostProjectOpsEntityResponse> removeById(List<DeleteProjectOpsEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectOpsEntity> entities = requests.stream().map(request -> {
            ProjectOpsEntity entity = new ProjectOpsEntity();
            entity.setProjectOpsId(request.getProjectOpsId());
            // 设置删除时间为当前时间
            entity.setDeleteTime(now);
            // 查询当前实体的 revision 值
            ProjectOpsEntity existingEntity = projectOpsDao.getById(request.getProjectOpsId());
            if (existingEntity != null && existingEntity.getRevision() != null) {
                entity.setRevision(existingEntity.getRevision());
            }
            return entity;
        }).collect(Collectors.toList());

        boolean updated = projectOpsDao.updateBatch(entities);
        if (!updated) {
            throw new RuntimeException("批量删除项目运维失败");
        }

        return entities.stream().map(entity -> {
            PostProjectOpsEntityResponse response = new PostProjectOpsEntityResponse();
            response.setProjectOpsId(entity.getProjectOpsId());
            return response;
        }).collect(Collectors.toList());
    }
}
