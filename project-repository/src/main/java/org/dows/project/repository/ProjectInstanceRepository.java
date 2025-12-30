package org.dows.project.repository;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.dows.rade.crud.CrudRepository;
import org.dows.rade.crud.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.dows.project.admin.PostProjectEntityRequest;
import org.dows.project.admin.PostProjectEntityResponse;
import org.dows.project.admin.PutProjectEntityRequest;
import org.dows.project.admin.GetProjectPageRequest;
import org.dows.project.admin.GetProjectPageResponse;
import org.dows.project.admin.GetProjectEntityRequest;
import org.dows.project.admin.GetProjectEntityResponse;
import org.dows.project.admin.DeleteProjectEntityRequest;
import org.dows.project.entity.ProjectInstanceEntity;
import org.dows.project.dao.ProjectInstanceDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.dows.project.entity.table.ProjectInstanceEntityTableDef.PROJECT_INSTANCE_ENTITY;

@Component
public class ProjectInstanceRepository extends CrudRepository<ProjectInstanceDao, ProjectInstanceEntity> {

    @Autowired
    private ProjectInstanceDao projectInstanceDao;

    /**
     * 创建项目实例
     */
    public PostProjectEntityResponse save(PostProjectEntityRequest request) {
        ProjectInstanceEntity entity = new ProjectInstanceEntity();
        entity.setProjectName(request.getProjectName());
        entity.setProjectCode(request.getProjectCode());
        entity.setDescription(request.getDescription());
        entity.setIcon(request.getIcon());
        entity.setScope(request.getScope());
        entity.setStartTime(request.getStartTime());
        entity.setEndTime(request.getEndTime());
        
        // 设置创建时间为当前时间
        entity.setCreateTime(LocalDateTime.now());

        boolean save = projectInstanceDao.save(entity);

        PostProjectEntityResponse response = new PostProjectEntityResponse();
        response.setProjectInstanceId(entity.getProjectInstanceId());
        return response;
    }

    /**
     * 批量创建项目实例
     */
    public List<PostProjectEntityResponse> saveBatch(List<PostProjectEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectInstanceEntity> entities = requests.stream().map(request -> {
            ProjectInstanceEntity entity = new ProjectInstanceEntity();
            entity.setProjectName(request.getProjectName());
            entity.setProjectCode(request.getProjectCode());
            entity.setDescription(request.getDescription());
            entity.setIcon(request.getIcon());
            entity.setScope(request.getScope());
            entity.setStartTime(request.getStartTime());
            entity.setEndTime(request.getEndTime());
            
            // 设置创建时间为当前时间
            entity.setCreateTime(now);
            
            return entity;
        }).collect(Collectors.toList());
        
        boolean saved = projectInstanceDao.saveBatch(entities);
        
        return entities.stream().map(entity -> {
            PostProjectEntityResponse response = new PostProjectEntityResponse();
            response.setProjectInstanceId(entity.getProjectInstanceId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 更新项目实例
     */
    public PostProjectEntityResponse update(PutProjectEntityRequest request) {
        ProjectInstanceEntity entity = new ProjectInstanceEntity();
        entity.setProjectInstanceId(request.getProjectInstanceId());
        entity.setProjectName(request.getProjectName());
        entity.setProjectCode(request.getProjectCode());
        entity.setDescription(request.getDescription());
        entity.setIcon(request.getIcon());
        entity.setScope(request.getScope());
        entity.setStartTime(request.getStartTime());
        entity.setEndTime(request.getEndTime());
        entity.setAppId(request.getApp_id());
        
        // 设置更新时间为当前时间
        entity.setUpdateTime(LocalDateTime.now());
        
        // 如果 request 中没有提供 revision，从数据库查询当前的 revision 值
        if (request.getRevision() != null) {
            entity.setRevision(request.getRevision());
        } else {
            ProjectInstanceEntity existingEntity = projectInstanceDao.getById(request.getProjectInstanceId());
            if (existingEntity != null && existingEntity.getRevision() != null) {
                entity.setRevision(existingEntity.getRevision());
            }
        }
        
        projectInstanceDao.update(entity);
        
        PostProjectEntityResponse response = new PostProjectEntityResponse();
        response.setProjectInstanceId(entity.getProjectInstanceId());
        return response;
    }

    /**
     * 批量更新项目实例，返回更新的ID列表
     */
    public List<PostProjectEntityResponse> updateBatch(List<PutProjectEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectInstanceEntity> entities = requests.stream().map(request -> {
            ProjectInstanceEntity entity = new ProjectInstanceEntity();
            entity.setProjectInstanceId(request.getProjectInstanceId());
            entity.setProjectName(request.getProjectName());
            entity.setProjectCode(request.getProjectCode());
            entity.setDescription(request.getDescription());
            entity.setIcon(request.getIcon());
            entity.setScope(request.getScope());
            entity.setStartTime(request.getStartTime());
            entity.setEndTime(request.getEndTime());
            entity.setAppId(request.getApp_id());
            
            // 设置更新时间为当前时间
            entity.setUpdateTime(now);
            
            // 如果 request 中没有提供 revision，从数据库查询当前的 revision 值
            if (request.getRevision() != null) {
                entity.setRevision(request.getRevision());
            } else {
                ProjectInstanceEntity existingEntity = projectInstanceDao.getById(request.getProjectInstanceId());
                if (existingEntity != null && existingEntity.getRevision() != null) {
                    entity.setRevision(existingEntity.getRevision());
                }
            }
            
            return entity;
        }).collect(Collectors.toList());
        
        projectInstanceDao.updateBatch(entities);
        
        return entities.stream().map(entity -> {
            PostProjectEntityResponse response = new PostProjectEntityResponse();
            response.setProjectInstanceId(entity.getProjectInstanceId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 分页查询项目实例
     */
    public Page<GetProjectPageResponse> getPage(PageRequest pageRequest, GetProjectPageRequest request) {
        // 创建分页对象
        Page<GetProjectPageResponse> objectPage = Page.of(pageRequest.getPageNum(), pageRequest.getPageSize());
        
        // 创建查询条件
        QueryWrapper queryWrapper = QueryWrapper.create()
                .from(ProjectInstanceEntity.class);
        
        // 过滤已删除的记录（deleteTime 为空的记录）
        queryWrapper.where(PROJECT_INSTANCE_ENTITY.DELETE_TIME.isNull());
        
        // 根据 request 参数拼接查询条件
        if (request.getName() != null && !request.getName().isEmpty()) {
            queryWrapper.where(PROJECT_INSTANCE_ENTITY.PROJECT_NAME.like(request.getName()));
        }
        if (request.getCode() != null && !request.getCode().isEmpty()) {
            queryWrapper.where(PROJECT_INSTANCE_ENTITY.PROJECT_CODE.like(request.getCode()));
        }
        if (request.getStartTime() != null) {
            queryWrapper.where(PROJECT_INSTANCE_ENTITY.START_TIME.ge(request.getStartTime()));
        }
        if (request.getEndTime() != null) {
            queryWrapper.where(PROJECT_INSTANCE_ENTITY.END_TIME.le(request.getEndTime()));
        }
        
        // 添加排序（使用 PageRequest 的排序方法，如果没有则使用默认排序）
        if (pageRequest.getOrderBys(ProjectInstanceEntity.class) != null && 
            !pageRequest.getOrderBys(ProjectInstanceEntity.class).isEmpty()) {
            queryWrapper.orderBy(pageRequest.getOrderBys(ProjectInstanceEntity.class));
        } else {
            // 默认按创建时间倒序
            queryWrapper.orderBy(PROJECT_INSTANCE_ENTITY.CREATE_TIME.desc());
        }
        
        // 执行分页查询
        pageAs(objectPage, queryWrapper, GetProjectPageResponse.class);
        
        return objectPage;
    }

    /**
     * 根据ID查询项目实例详情
     */
    public GetProjectEntityResponse getById(GetProjectEntityRequest request) {
        QueryWrapper queryWrapper = QueryWrapper.create();
        queryWrapper.where(PROJECT_INSTANCE_ENTITY.PROJECT_INSTANCE_ID.eq(request.getProjectInstanceId()));
        // 过滤已删除的记录（deleteTime 为空的记录）
        queryWrapper.where(PROJECT_INSTANCE_ENTITY.DELETE_TIME.isNull());
        
        List<ProjectInstanceEntity> entities = projectInstanceDao.list(queryWrapper);
        if (entities == null || entities.isEmpty()) {
            return null;
        }
        ProjectInstanceEntity entity = entities.get(0);
        GetProjectEntityResponse response = new GetProjectEntityResponse();
        response.setProjectInstanceId(entity.getProjectInstanceId());
        response.setProjectName(entity.getProjectName());
        response.setProjectCode(entity.getProjectCode());
        response.setDescription(entity.getDescription());
        response.setIcon(entity.getIcon());
        response.setScope(entity.getScope());
        response.setStartTime(entity.getStartTime());
        response.setEndTime(entity.getEndTime());
        response.setApp_id(entity.getAppId());
        response.setCreateTime(entity.getCreateTime());
        response.setUpdateTime(entity.getUpdateTime());
        response.setDeleteTime(entity.getDeleteTime());
        response.setCreateId(entity.getCreateId());
        response.setUpdateId(entity.getUpdateId());
        return response;
    }

    /**
     * 批量删除项目实例（逻辑删除），返回删除的ID列表
     */
    public List<PostProjectEntityResponse> removeById(List<DeleteProjectEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectInstanceEntity> entities = requests.stream().map(request -> {
            ProjectInstanceEntity entity = new ProjectInstanceEntity();
            entity.setProjectInstanceId(request.getProjectInstanceId());
            // 设置删除时间为当前时间
            entity.setDeleteTime(now);            
            // 查询当前实体的 revision 值
            ProjectInstanceEntity existingEntity = projectInstanceDao.getById(request.getProjectInstanceId());
            if (existingEntity != null && existingEntity.getRevision() != null) {
                entity.setRevision(existingEntity.getRevision());
            }
            return entity;
        }).collect(Collectors.toList());

        projectInstanceDao.updateBatch(entities);

        return entities.stream().map(entity -> {
            PostProjectEntityResponse response = new PostProjectEntityResponse();
            response.setProjectInstanceId(entity.getProjectInstanceId());
            return response;
        }).collect(Collectors.toList());
    }
}