package org.dows.project.repository;

import com.mybatisflex.core.query.QueryWrapper;
import org.dows.rade.crud.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.dows.project.admin.PostProjectKanbanEntityRequest;
import org.dows.project.admin.PostProjectKanbanEntityResponse;
import org.dows.project.admin.PutProjectKanbanEntityRequest;
import org.dows.project.admin.GetProjectKanbanListRequest;
import org.dows.project.admin.GetProjectKanbanListResponse;
import org.dows.project.admin.DeleteProjectKanbanEntityRequest;
import org.dows.project.entity.ProjectKanbanEntity;
import org.dows.project.dao.ProjectKanbanDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectKanbanRepository extends CrudRepository<ProjectKanbanDao, ProjectKanbanEntity> {

    @Autowired
    private ProjectKanbanDao projectKanbanDao;

    /**
     * 批量保存项目看板
     */
    public List<PostProjectKanbanEntityResponse> saveBatch(List<PostProjectKanbanEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectKanbanEntity> entities = requests.stream().map(request -> {
            ProjectKanbanEntity entity = new ProjectKanbanEntity();
            entity.setProjectInstanceId(request.getProjectInstanceId());
            entity.setProjectFlowId(request.getProjectFlowId());
            entity.setAccountInstanceId(request.getAccountInstanceId());
            entity.setNickname(request.getNickname());
            // 设置创建时间为当前时间
            entity.setCreateTime(now);
            return entity;
        }).collect(Collectors.toList());
        
        boolean saved = projectKanbanDao.saveBatch(entities);
        if (!saved) {
            throw new RuntimeException("批量创建项目看板失败");
        }
        
        return entities.stream().map(entity -> {
            PostProjectKanbanEntityResponse response = new PostProjectKanbanEntityResponse();
            response.setProjectKanbanId(entity.getProjectKanbanId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量更新项目看板，返回更新的ID列表
     */
    public List<PostProjectKanbanEntityResponse> updateBatch(List<PutProjectKanbanEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectKanbanEntity> entities = requests.stream().map(request -> {
            ProjectKanbanEntity entity = new ProjectKanbanEntity();
            entity.setProjectKanbanId(request.getProjectKanbanId());
            entity.setProjectInstanceId(request.getProjectInstanceId());
            entity.setProjectFlowId(request.getProjectFlowId());
            entity.setAccountInstanceId(request.getAccountInstanceId());
            entity.setNickname(request.getNickname());
            // 设置更新时间为当前时间
            entity.setUpdateTime(now);
            
            // 从数据库查询当前的 revision 值
            ProjectKanbanEntity existingEntity = projectKanbanDao.getById(request.getProjectKanbanId());
            if (existingEntity != null && existingEntity.getRevision() != null) {
                entity.setRevision(existingEntity.getRevision());
            }
            
            return entity;
        }).collect(Collectors.toList());
        
        boolean updated = projectKanbanDao.updateBatch(entities);
        if (!updated) {
            throw new RuntimeException("批量更新项目看板失败");
        }
        
        return entities.stream().map(entity -> {
            PostProjectKanbanEntityResponse response = new PostProjectKanbanEntityResponse();
            response.setProjectKanbanId(entity.getProjectKanbanId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 根据ID查询项目看板
     */
    public GetProjectKanbanListResponse getById(Long projectKanbanId) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .from(ProjectKanbanEntity.class)
                .where("project_kanban_id = ?", projectKanbanId)
                .and("delete_time is null");
        
        List<ProjectKanbanEntity> entities = projectKanbanDao.list(queryWrapper);
        if (entities == null || entities.isEmpty()) {
            return null;
        }
        ProjectKanbanEntity entity = entities.get(0);
        GetProjectKanbanListResponse response = new GetProjectKanbanListResponse();
        response.setProjectKanbanId(entity.getProjectKanbanId());
        response.setProjectInstanceId(entity.getProjectInstanceId());
        response.setProjectFlowId(entity.getProjectFlowId());
        response.setAccountInstanceId(entity.getAccountInstanceId());
        response.setNickname(entity.getNickname());
        return response;
    }

    /**
     * 列表查询项目看板
     */
    public List<GetProjectKanbanListResponse> list(GetProjectKanbanListRequest request) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .from(ProjectKanbanEntity.class)
                .where("delete_time is null");
        
        if (request.getProjectInstanceId() != null) {
            queryWrapper.and("project_instance_id = ?", request.getProjectInstanceId());
        }
        if (request.getProjectFlowId() != null) {
            queryWrapper.and("project_flow_id = ?", request.getProjectFlowId());
        }
        queryWrapper.orderBy("create_time", false);
        List<ProjectKanbanEntity> entities = projectKanbanDao.list(queryWrapper);
        
        return entities.stream().map(entity -> {
            GetProjectKanbanListResponse response = new GetProjectKanbanListResponse();
            response.setProjectKanbanId(entity.getProjectKanbanId());
            response.setProjectInstanceId(entity.getProjectInstanceId());
            response.setProjectFlowId(entity.getProjectFlowId());
            response.setAccountInstanceId(entity.getAccountInstanceId());
            response.setNickname(entity.getNickname());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量删除项目看板（逻辑删除），返回删除的ID列表
     */
    public List<PostProjectKanbanEntityResponse> removeById(List<DeleteProjectKanbanEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectKanbanEntity> entities = requests.stream().map(request -> {
            ProjectKanbanEntity entity = new ProjectKanbanEntity();
            entity.setProjectKanbanId(request.getProjectKanbanId());
            // 设置删除时间为当前时间
            entity.setDeleteTime(now);
            // 查询当前实体的 revision 值
            ProjectKanbanEntity existingEntity = projectKanbanDao.getById(request.getProjectKanbanId());
            if (existingEntity != null && existingEntity.getRevision() != null) {
                entity.setRevision(existingEntity.getRevision());
            }
            return entity;
        }).collect(Collectors.toList());

        boolean updated = projectKanbanDao.updateBatch(entities);
        if (!updated) {
            throw new RuntimeException("批量删除项目看板失败");
        }

        return entities.stream().map(entity -> {
            PostProjectKanbanEntityResponse response = new PostProjectKanbanEntityResponse();
            response.setProjectKanbanId(entity.getProjectKanbanId());
            return response;
        }).collect(Collectors.toList());
    }
}
