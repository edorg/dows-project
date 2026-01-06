package org.dows.project.repository;

import com.mybatisflex.core.query.QueryWrapper;
import org.dows.rade.crud.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.dows.project.admin.PostProjectFlowEntityRequest;
import org.dows.project.admin.PostProjectFlowEntityResponse;
import org.dows.project.admin.PutProjectFlowEntityRequest;
import org.dows.project.admin.GetProjectFlowListRequest;
import org.dows.project.admin.GetProjectFlowListResponse;
import org.dows.project.admin.DeleteProjectFlowEntityRequest;
import org.dows.project.entity.ProjectFlowEntity;
import org.dows.project.dao.ProjectFlowDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectFlowRepository extends CrudRepository<ProjectFlowDao, ProjectFlowEntity> {

    @Autowired
    private ProjectFlowDao projectFlowDao;

    /**
     * 批量保存项目流程
     */
    public List<PostProjectFlowEntityResponse> saveBatch(List<PostProjectFlowEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectFlowEntity> entities = requests.stream().map(request -> {
            ProjectFlowEntity entity = new ProjectFlowEntity();
            entity.setProjectInstanceId(request.getProjectInstanceId());
            entity.setStageName(request.getStageName());
            entity.setSeq(request.getSequence());
            // 设置创建时间为当前时间
            entity.setCreateTime(now);
            return entity;
        }).collect(Collectors.toList());

        boolean saveBatch = projectFlowDao.saveBatch(entities);
        if (!saveBatch) {
            throw new RuntimeException("批量创建项目流程失败");
        }

        return entities.stream().map(entity -> {
            PostProjectFlowEntityResponse response = new PostProjectFlowEntityResponse();
            response.setProjectFlowId(entity.getProjectFlowId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量更新项目流程，返回更新的ID列表
     */
    public List<PostProjectFlowEntityResponse> updateBatch(List<PutProjectFlowEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectFlowEntity> entities = requests.stream().map(request -> {
            ProjectFlowEntity entity = new ProjectFlowEntity();
            entity.setProjectFlowId(request.getProjectFlowId());
            entity.setProjectInstanceId(request.getProjectInstanceId());
            entity.setStageName(request.getStageName());
            entity.setSeq(request.getSequence());
            // 设置更新时间为当前时间
            entity.setUpdateTime(now);
            
            // 如果 request 中没有提供 revision，从数据库查询当前的 revision 值
            ProjectFlowEntity existingEntity = projectFlowDao.getById(request.getProjectFlowId());
            if (existingEntity != null && existingEntity.getRevision() != null) {
                entity.setRevision(existingEntity.getRevision());
            }
            
            return entity;
        }).collect(Collectors.toList());
        
        boolean updated = projectFlowDao.updateBatch(entities);
        if (!updated) {
            throw new RuntimeException("批量更新项目流程失败");
        }
        
        return entities.stream().map(entity -> {
            PostProjectFlowEntityResponse response = new PostProjectFlowEntityResponse();
            response.setProjectFlowId(entity.getProjectFlowId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 根据ID查询项目流程
     */
    public GetProjectFlowListResponse getById(Long projectFlowId) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .from(ProjectFlowEntity.class)
                .where("project_flow_id = ?", projectFlowId)
                .and("delete_time is null");
        
        List<ProjectFlowEntity> entities = projectFlowDao.list(queryWrapper);
        if (entities == null || entities.isEmpty()) {
            return null;
        }
        ProjectFlowEntity entity = entities.get(0);
        GetProjectFlowListResponse response = new GetProjectFlowListResponse();
        response.setProjectFlowId(entity.getProjectFlowId());
        response.setProjectInstanceId(entity.getProjectInstanceId());
        response.setStageName(entity.getStageName());
        response.setSequence(entity.getSeq());
        return response;
    }

    /**
     * 列表查询项目流程
     */
    public List<GetProjectFlowListResponse> list(GetProjectFlowListRequest request) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .from(ProjectFlowEntity.class)
                .where("delete_time is null");
        
        if (request.getProjectInstanceId() != null) {
            queryWrapper.and("project_instance_id = ?", request.getProjectInstanceId());
        }
        queryWrapper.orderBy("seq", true);
        List<ProjectFlowEntity> entities = projectFlowDao.list(queryWrapper);
        
        return entities.stream().map(entity -> {
            GetProjectFlowListResponse response = new GetProjectFlowListResponse();
            response.setProjectFlowId(entity.getProjectFlowId());
            response.setProjectInstanceId(entity.getProjectInstanceId());
            response.setStageName(entity.getStageName());
            response.setSequence(entity.getSeq());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量删除项目流程（逻辑删除），返回删除的ID列表
     */
    public List<PostProjectFlowEntityResponse> removeById(List<DeleteProjectFlowEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectFlowEntity> entities = requests.stream().map(request -> {
            ProjectFlowEntity entity = new ProjectFlowEntity();
            entity.setProjectFlowId(request.getProjectFlowId());
            // 设置删除时间为当前时间
            entity.setDeleteTime(now);
            // 查询当前实体的 revision 值
            ProjectFlowEntity existingEntity = projectFlowDao.getById(request.getProjectFlowId());
            if (existingEntity != null && existingEntity.getRevision() != null) {
                entity.setRevision(existingEntity.getRevision());
            }
            return entity;
        }).collect(Collectors.toList());

        boolean updated = projectFlowDao.updateBatch(entities);
        if (!updated) {
            throw new RuntimeException("批量删除项目流程失败");
        }

        return entities.stream().map(entity -> {
            PostProjectFlowEntityResponse response = new PostProjectFlowEntityResponse();
            response.setProjectFlowId(entity.getProjectFlowId());
            return response;
        }).collect(Collectors.toList());
    }
}
