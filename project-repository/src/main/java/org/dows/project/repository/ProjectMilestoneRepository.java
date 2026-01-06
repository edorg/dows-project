package org.dows.project.repository;

import com.mybatisflex.core.query.QueryWrapper;
import org.dows.rade.crud.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.dows.project.admin.PostProjectMilestoneEntityRequest;
import org.dows.project.admin.PostProjectMilestoneEntityResponse;
import org.dows.project.admin.PutProjectMilestoneEntityRequest;
import org.dows.project.admin.GetProjectMilestoneListRequest;
import org.dows.project.admin.GetProjectMilestoneListResponse;
import org.dows.project.admin.GetProjectMilestoneEntityRequest;
import org.dows.project.admin.GetProjectMilestoneEntityResponse;
import org.dows.project.admin.DeleteProjectMilestoneEntityRequest;
import org.dows.project.entity.ProjectMilestoneEntity;
import org.dows.project.dao.ProjectMilestoneDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectMilestoneRepository extends CrudRepository<ProjectMilestoneDao, ProjectMilestoneEntity> {

    @Autowired
    private ProjectMilestoneDao projectMilestoneDao;

    /**
     * 批量保存项目里程碑
     */
    public List<PostProjectMilestoneEntityResponse> saveBatch(List<PostProjectMilestoneEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectMilestoneEntity> entities = requests.stream().map(request -> {
            ProjectMilestoneEntity entity = new ProjectMilestoneEntity();
            entity.setProjectInstanceId(request.getProjectInstanceId());
            entity.setMilestoneName(request.getMilestoneName());
            entity.setDescription(request.getDescription());
            entity.setTimeUnit(request.getTimeUnit());
            entity.setDuration(request.getDuration());
            // 设置创建时间为当前时间
            entity.setCreateTime(now);
            return entity;
        }).collect(Collectors.toList());
        
        boolean saved = projectMilestoneDao.saveBatch(entities);
        if (!saved) {
            throw new RuntimeException("批量创建项目里程碑失败");
        }
        
        return entities.stream().map(entity -> {
            PostProjectMilestoneEntityResponse response = new PostProjectMilestoneEntityResponse();
            response.setProjectMilestoneId(entity.getProjectMilestoneId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量更新项目里程碑，返回更新的ID列表
     */
    public List<PostProjectMilestoneEntityResponse> updateBatch(List<PutProjectMilestoneEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectMilestoneEntity> entities = requests.stream().map(request -> {
            ProjectMilestoneEntity entity = new ProjectMilestoneEntity();
            entity.setProjectMilestoneId(request.getProjectMilestoneId());
            entity.setMilestoneName(request.getMilestoneName());
            entity.setDescription(request.getDescription());
            entity.setPhaseBudget(request.getPhaseBudget());
            entity.setPhaseCost(request.getPhaseCost());
            entity.setTimeUnit(request.getTimeUnit());
            entity.setDuration(request.getDuration());
            entity.setStartTime(request.getStartTime());
            entity.setEndTime(request.getEndTime());
            // 设置更新时间为当前时间
            entity.setUpdateTime(now);
            
            // 从数据库查询当前的 revision 值
            ProjectMilestoneEntity existingEntity = projectMilestoneDao.getById(request.getProjectMilestoneId());
            if (existingEntity != null && existingEntity.getRevision() != null) {
                entity.setRevision(existingEntity.getRevision());
            }
            
            return entity;
        }).collect(Collectors.toList());
        
        boolean updated = projectMilestoneDao.updateBatch(entities);
        if (!updated) {
            throw new RuntimeException("批量更新项目里程碑失败");
        }
        
        return entities.stream().map(entity -> {
            PostProjectMilestoneEntityResponse response = new PostProjectMilestoneEntityResponse();
            response.setProjectMilestoneId(entity.getProjectMilestoneId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 根据ID查询项目里程碑
     */
    public GetProjectMilestoneEntityResponse getById(GetProjectMilestoneEntityRequest request) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .from(ProjectMilestoneEntity.class)
                .where("project_milestone_id = ?", request.getProjectMilestoneId())
                .and("delete_time is null");
        
        List<ProjectMilestoneEntity> entities = projectMilestoneDao.list(queryWrapper);
        if (entities == null || entities.isEmpty()) {
            return null;
        }
        ProjectMilestoneEntity entity = entities.get(0);
        GetProjectMilestoneEntityResponse response = new GetProjectMilestoneEntityResponse();
        response.setProjectMilestoneId(entity.getProjectMilestoneId());
        response.setProjectInstanceId(entity.getProjectInstanceId());
        response.setMilestoneName(entity.getMilestoneName());
        response.setDescription(entity.getDescription());
        response.setPhaseBudget(entity.getPhaseBudget());
        response.setPhaseCost(entity.getPhaseCost());
        response.setTimeUnit(entity.getTimeUnit());
        response.setDuration(entity.getDuration());
        response.setStartTime(entity.getStartTime());
        response.setEndTime(entity.getEndTime());
        response.setRevision(entity.getRevision());
        response.setApp_id(entity.getAppId());
        response.setCreateTime(entity.getCreateTime());
        response.setUpdateTime(entity.getUpdateTime());
        response.setDeleteTime(entity.getDeleteTime());
        response.setCreateId(entity.getCreateId());
        response.setUpdateId(entity.getUpdateId());
        return response;
    }

    /**
     * 列表查询项目里程碑
     */
    public List<GetProjectMilestoneListResponse> list(GetProjectMilestoneListRequest request) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .from(ProjectMilestoneEntity.class)
                .where("delete_time is null");
        
        if (request.getProjectInstanceId() != null) {
            queryWrapper.and("project_instance_id = ?", request.getProjectInstanceId());
        }
        queryWrapper.orderBy("create_time", false);
        List<ProjectMilestoneEntity> entities = projectMilestoneDao.list(queryWrapper);
        
        return entities.stream().map(entity -> {
            GetProjectMilestoneListResponse response = new GetProjectMilestoneListResponse();
            response.setProjectMilestoneId(entity.getProjectMilestoneId());
            response.setProjectInstanceId(entity.getProjectInstanceId());
            response.setMilestoneName(entity.getMilestoneName());
            response.setDescription(entity.getDescription());
            response.setPhaseBudget(entity.getPhaseBudget());
            response.setPhaseCost(entity.getPhaseCost());
            response.setTimeUnit(entity.getTimeUnit());
            response.setDuration(entity.getDuration());
            response.setStartTime(entity.getStartTime());
            response.setEndTime(entity.getEndTime());
            response.setRevision(entity.getRevision());
            response.setApp_id(entity.getAppId());
            response.setCreateTime(entity.getCreateTime());
            response.setUpdateTime(entity.getUpdateTime());
            response.setDeleteTime(entity.getDeleteTime());
            response.setCreateId(entity.getCreateId());
            response.setUpdateId(entity.getUpdateId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量删除项目里程碑（逻辑删除），返回删除的ID列表
     */
    public List<PostProjectMilestoneEntityResponse> removeById(List<DeleteProjectMilestoneEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectMilestoneEntity> entities = requests.stream().map(request -> {
            ProjectMilestoneEntity entity = new ProjectMilestoneEntity();
            entity.setProjectMilestoneId(request.getProjectMilestoneId());
            // 设置删除时间为当前时间
            entity.setDeleteTime(now);
            // 查询当前实体的 revision 值
            ProjectMilestoneEntity existingEntity = projectMilestoneDao.getById(request.getProjectMilestoneId());
            if (existingEntity != null && existingEntity.getRevision() != null) {
                entity.setRevision(existingEntity.getRevision());
            }
            return entity;
        }).collect(Collectors.toList());

        boolean updated = projectMilestoneDao.updateBatch(entities);
        if (!updated) {
            throw new RuntimeException("批量删除项目里程碑失败");
        }

        return entities.stream().map(entity -> {
            PostProjectMilestoneEntityResponse response = new PostProjectMilestoneEntityResponse();
            response.setProjectMilestoneId(entity.getProjectMilestoneId());
            return response;
        }).collect(Collectors.toList());
    }
}
