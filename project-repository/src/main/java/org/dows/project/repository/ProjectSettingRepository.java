package org.dows.project.repository;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.dows.rade.crud.CrudRepository;
import org.dows.rade.crud.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.dows.project.admin.PostProjectSettingEntityRequest;
import org.dows.project.admin.PostProjectSettingEntityResponse;
import org.dows.project.admin.PutProjectSettingEntityRequest;
import org.dows.project.admin.GetProjectSettingEntityRequest;
import org.dows.project.admin.GetProjectSettingEntityResponse;
import org.dows.project.admin.GetProjectSettingPageRequest;
import org.dows.project.admin.GetProjectSettingPageResponse;
import org.dows.project.admin.PostProjectSettingListRequest;
import org.dows.project.admin.PostProjectSettingListResponse;
import org.dows.project.admin.DeleteProjectSettingEntityRequest;
import org.dows.project.entity.ProjectSettingEntity;
import org.dows.project.dao.ProjectSettingDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.dows.project.entity.table.ProjectSettingEntityTableDef.PROJECT_SETTING_ENTITY;

@Component
public class ProjectSettingRepository extends CrudRepository<ProjectSettingDao, ProjectSettingEntity> {

    @Autowired
    private ProjectSettingDao projectSettingDao;

    /**
     * 批量保存项目设置
     */
    public List<PostProjectSettingEntityResponse> saveBatch(List<PostProjectSettingEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectSettingEntity> entities = requests.stream().map(request -> {
            ProjectSettingEntity entity = new ProjectSettingEntity();
            entity.setProjectInstanceId(request.getProjectInstanceId());
            entity.setSettingKey(request.getSettingKey());
            entity.setSettingJson(request.getSettingJson());
            // 设置创建时间为当前时间
            entity.setCreateTime(now);
            return entity;
        }).collect(Collectors.toList());
        
        boolean saved = projectSettingDao.saveBatch(entities);
        
        return entities.stream().map(entity -> {
            PostProjectSettingEntityResponse response = new PostProjectSettingEntityResponse();
            response.setProjectSettingId(entity.getProjectSettingId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量更新项目设置，返回更新的ID列表
     */
    public List<PostProjectSettingEntityResponse> updateBatch(List<PutProjectSettingEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectSettingEntity> entities = requests.stream().map(request -> {
            ProjectSettingEntity entity = new ProjectSettingEntity();
            entity.setProjectSettingId(request.getProjectSettingId());
            entity.setSettingKey(request.getSettingKey());
            entity.setSettingJson(request.getSettingJson());
            // 设置更新时间为当前时间
            entity.setUpdateTime(now);
            
            // 如果 request 中没有提供 revision，从数据库查询当前的 revision 值
            if (request.getRevision() != null) {
                entity.setRevision(request.getRevision());
            } else {
                ProjectSettingEntity existingEntity = projectSettingDao.getById(request.getProjectSettingId());
                if (existingEntity != null && existingEntity.getRevision() != null) {
                    entity.setRevision(existingEntity.getRevision());
                }
            }
            
            return entity;
        }).collect(Collectors.toList());
        
        projectSettingDao.updateBatch(entities);
        
        return entities.stream().map(entity -> {
            PostProjectSettingEntityResponse response = new PostProjectSettingEntityResponse();
            response.setProjectSettingId(entity.getProjectSettingId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 分页查询项目设置
     */
    public Page<GetProjectSettingPageResponse> getPage(PageRequest pageRequest, GetProjectSettingPageRequest request) {
        // 创建分页对象
        Page<GetProjectSettingPageResponse> objectPage = Page.of(pageRequest.getPageNum(), pageRequest.getPageSize());
        
        // 创建查询条件
        QueryWrapper queryWrapper = QueryWrapper.create()
                .from(ProjectSettingEntity.class);
        
        // 过滤已删除的记录（deleteTime 为空的记录）
        queryWrapper.where(PROJECT_SETTING_ENTITY.DELETE_TIME.isNull());
        
        // 根据 request 参数拼接查询条件
        if (request.getProjectInstanceId() != null) {
            queryWrapper.where(PROJECT_SETTING_ENTITY.PROJECT_INSTANCE_ID.eq(request.getProjectInstanceId()));
        }
        if (request.getSettingKey() != null && !request.getSettingKey().isEmpty()) {
            queryWrapper.where(PROJECT_SETTING_ENTITY.SETTING_KEY.like(request.getSettingKey()));
        }
        
        // 添加排序（使用 PageRequest 的排序方法，如果没有则使用默认排序）
        if (pageRequest.getOrderBys(ProjectSettingEntity.class) != null && 
            !pageRequest.getOrderBys(ProjectSettingEntity.class).isEmpty()) {
            queryWrapper.orderBy(pageRequest.getOrderBys(ProjectSettingEntity.class));
        } else {
            // 默认按创建时间倒序
            queryWrapper.orderBy(PROJECT_SETTING_ENTITY.CREATE_TIME.desc());
        }
        
        // 执行分页查询
        pageAs(objectPage, queryWrapper, GetProjectSettingPageResponse.class);
        
        return objectPage;
    }

    /**
     * 根据ID查询项目设置
     */
    public GetProjectSettingEntityResponse getById(GetProjectSettingEntityRequest request) {
        QueryWrapper queryWrapper = QueryWrapper.create();
        queryWrapper.where(PROJECT_SETTING_ENTITY.PROJECT_SETTING_ID.eq(request.getProjectSettingId()));
        // 过滤已删除的记录（deleteTime 为空的记录）
        queryWrapper.where(PROJECT_SETTING_ENTITY.DELETE_TIME.isNull());
        
        List<ProjectSettingEntity> entities = projectSettingDao.list(queryWrapper);
        if (entities == null || entities.isEmpty()) {
            return null;
        }
        ProjectSettingEntity entity = entities.get(0);
        GetProjectSettingEntityResponse response = new GetProjectSettingEntityResponse();
        response.setProjectSettingId(entity.getProjectSettingId());
        response.setSettingKey(entity.getSettingKey());
        response.setSettingJson(entity.getSettingJson());
        return response;
    }

    /**
     * 列表查询项目设置
     */
    public List<PostProjectSettingListResponse> list(PostProjectSettingListRequest request) {
        QueryWrapper queryWrapper = QueryWrapper.create();
        // 过滤已删除的记录（deleteTime 为空的记录）
        queryWrapper.where(PROJECT_SETTING_ENTITY.DELETE_TIME.isNull());
        
        if (request.getProjectInstanceId() != null) {
            queryWrapper.where(PROJECT_SETTING_ENTITY.PROJECT_INSTANCE_ID.eq(request.getProjectInstanceId()));
        }
        List<ProjectSettingEntity> entities = projectSettingDao.list(queryWrapper);
        
        return entities.stream().map(entity -> {
            PostProjectSettingListResponse response = new PostProjectSettingListResponse();
            response.setProjectSettingId(entity.getProjectSettingId());
            response.setSettingKey(entity.getSettingKey());
            response.setSettingJson(entity.getSettingJson());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量删除项目设置（逻辑删除），返回删除的ID列表
     */
    public List<PostProjectSettingEntityResponse> removeById(List<DeleteProjectSettingEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectSettingEntity> entities = requests.stream().map(request -> {
            ProjectSettingEntity entity = new ProjectSettingEntity();
            entity.setProjectSettingId(request.getProjectSettingId());
            // 设置删除时间为当前时间
            entity.setDeleteTime(now);
            // 查询当前实体的 revision 值
            ProjectSettingEntity existingEntity = projectSettingDao.getById(request.getProjectSettingId());
            if (existingEntity != null && existingEntity.getRevision() != null) {
                entity.setRevision(existingEntity.getRevision());
            }
            return entity;
        }).collect(Collectors.toList());

        projectSettingDao.updateBatch(entities);

        return entities.stream().map(entity -> {
            PostProjectSettingEntityResponse response = new PostProjectSettingEntityResponse();
            response.setProjectSettingId(entity.getProjectSettingId());
            return response;
        }).collect(Collectors.toList());
    }
}
