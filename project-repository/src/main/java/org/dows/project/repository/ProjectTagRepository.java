package org.dows.project.repository;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.dows.rade.crud.CrudRepository;
import org.dows.rade.crud.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.dows.project.admin.PostProjectTagEntityRequest;
import org.dows.project.admin.PostProjectTagEntityResponse;
import org.dows.project.admin.PutProjectTagEntityRequest;
import org.dows.project.admin.GetProjectTagListRequest;
import org.dows.project.admin.GetProjectTagListResponse;
import org.dows.project.admin.GetProjectTagPageRequest;
import org.dows.project.admin.GetProjectTagPageResponse;
import org.dows.project.admin.GetProjectTagEntityRequest;
import org.dows.project.admin.GetProjectTagEntityResponse;
import org.dows.project.admin.DeleteProjectTagEntityRequest;
import org.dows.project.entity.ProjectTagEntity;
import org.dows.project.dao.ProjectTagDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.dows.project.entity.table.ProjectTagEntityTableDef.PROJECT_TAG_ENTITY;

@Component
public class ProjectTagRepository extends CrudRepository<ProjectTagDao, ProjectTagEntity> {

    @Autowired
    private ProjectTagDao projectTagDao;

    /**
     * 批量保存标签
     */
    public List<PostProjectTagEntityResponse> saveBatch(List<PostProjectTagEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectTagEntity> entities = requests.stream().map(request -> {
            ProjectTagEntity entity = new ProjectTagEntity();
            entity.setProjectInstanceId(request.getProjectInstanceId());
            entity.setTagName(request.getTagName());
            entity.setTagColor(request.getTagColor());
            // 设置创建时间为当前时间
            entity.setCreateTime(now);
            return entity;
        }).collect(Collectors.toList());
        
        boolean saved = projectTagDao.saveBatch(entities);
        
        return entities.stream().map(entity -> {
            PostProjectTagEntityResponse response = new PostProjectTagEntityResponse();
            response.setProjectTagId(entity.getProjectTagId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量更新标签，返回更新的ID列表
     */
    public List<PostProjectTagEntityResponse> updateBatch(List<PutProjectTagEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectTagEntity> entities = requests.stream().map(request -> {
            ProjectTagEntity entity = new ProjectTagEntity();
            entity.setProjectTagId(request.getProjectTagId());
            entity.setTagName(request.getTagName());
            entity.setTagColor(request.getTagColor());
            // 设置更新时间为当前时间
            entity.setUpdateTime(now);
            
            // 如果 request 中没有提供 revision，从数据库查询当前的 revision 值
            if (request.getRevision() != null) {
                entity.setRevision(request.getRevision());
            } else {
                ProjectTagEntity existingEntity = projectTagDao.getById(request.getProjectTagId());
                if (existingEntity != null && existingEntity.getRevision() != null) {
                    entity.setRevision(existingEntity.getRevision());
                }
            }
            
            return entity;
        }).collect(Collectors.toList());
        
        projectTagDao.updateBatch(entities);
        
        return entities.stream().map(entity -> {
            PostProjectTagEntityResponse response = new PostProjectTagEntityResponse();
            response.setProjectTagId(entity.getProjectTagId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 分页查询项目标签
     */
    public Page<GetProjectTagPageResponse> getPage(PageRequest pageRequest, GetProjectTagPageRequest request) {
        // 创建分页对象
        Page<GetProjectTagPageResponse> objectPage = Page.of(pageRequest.getPageNum(), pageRequest.getPageSize());
        
        // 创建查询条件
        QueryWrapper queryWrapper = QueryWrapper.create()
                .from(ProjectTagEntity.class);
        
        // 过滤已删除的记录（deleteTime 为空的记录）
        queryWrapper.where(PROJECT_TAG_ENTITY.DELETE_TIME.isNull());
        
        // 根据 request 参数拼接查询条件
        if (request.getProjectInstanceId() != null) {
            queryWrapper.where(PROJECT_TAG_ENTITY.PROJECT_INSTANCE_ID.eq(request.getProjectInstanceId()));
        }
        if (request.getTagName() != null && !request.getTagName().isEmpty()) {
            queryWrapper.where(PROJECT_TAG_ENTITY.TAG_NAME.like(request.getTagName()));
        }
        
        // 添加排序（使用 PageRequest 的排序方法，如果没有则使用默认排序）
        if (pageRequest.getOrderBys(ProjectTagEntity.class) != null && 
            !pageRequest.getOrderBys(ProjectTagEntity.class).isEmpty()) {
            queryWrapper.orderBy(pageRequest.getOrderBys(ProjectTagEntity.class));
        } else {
            // 默认按创建时间倒序
            queryWrapper.orderBy(PROJECT_TAG_ENTITY.CREATE_TIME.desc());
        }
        
        // 执行分页查询
        pageAs(objectPage, queryWrapper, GetProjectTagPageResponse.class);
        
        return objectPage;
    }

    /**
     * 根据ID查询标签
     */
    public GetProjectTagEntityResponse getById(GetProjectTagEntityRequest request) {
        QueryWrapper queryWrapper = QueryWrapper.create();
        queryWrapper.where(PROJECT_TAG_ENTITY.PROJECT_TAG_ID.eq(request.getProjectTagId()));
        // 过滤已删除的记录（deleteTime 为空的记录）
        queryWrapper.where(PROJECT_TAG_ENTITY.DELETE_TIME.isNull());
        
        List<ProjectTagEntity> entities = projectTagDao.list(queryWrapper);
        if (entities == null || entities.isEmpty()) {
            return null;
        }
        ProjectTagEntity entity = entities.get(0);
        GetProjectTagEntityResponse response = new GetProjectTagEntityResponse();
        response.setProjectTagId(entity.getProjectTagId());
        response.setTagName(entity.getTagName());
        response.setTagColor(entity.getTagColor());
        return response;
    }

    /**
     * 列表查询标签
     */
    public List<GetProjectTagListResponse> list(GetProjectTagListRequest request) {
        QueryWrapper queryWrapper = QueryWrapper.create();
        // 过滤已删除的记录（deleteTime 为空的记录）
        queryWrapper.where(PROJECT_TAG_ENTITY.DELETE_TIME.isNull());
        
        if (request.getProjectInstanceId() != null) {
            queryWrapper.where(PROJECT_TAG_ENTITY.PROJECT_INSTANCE_ID.eq(request.getProjectInstanceId()));
        }
        if (request.getTagName() != null && !request.getTagName().isEmpty()) {
            queryWrapper.where(PROJECT_TAG_ENTITY.TAG_NAME.like(request.getTagName()));
        }
        List<ProjectTagEntity> entities = projectTagDao.list(queryWrapper);
        
        return entities.stream().map(entity -> {
            GetProjectTagListResponse response = new GetProjectTagListResponse();
            response.setProjectTagId(entity.getProjectTagId());
            response.setTagName(entity.getTagName());
            response.setTagColor(entity.getTagColor());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量删除标签（逻辑删除），返回删除的ID列表
     */
    public List<PostProjectTagEntityResponse> removeById(List<DeleteProjectTagEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectTagEntity> entities = requests.stream().map(request -> {
            ProjectTagEntity entity = new ProjectTagEntity();
            entity.setProjectTagId(request.getProjectTagId());
            // 设置删除时间为当前时间
            entity.setDeleteTime(now);
            // 查询当前实体的 revision 值
            ProjectTagEntity existingEntity = projectTagDao.getById(request.getProjectTagId());
            if (existingEntity != null && existingEntity.getRevision() != null) {
                entity.setRevision(existingEntity.getRevision());
            }
            return entity;
        }).collect(Collectors.toList());

        projectTagDao.updateBatch(entities);

        return entities.stream().map(entity -> {
            PostProjectTagEntityResponse response = new PostProjectTagEntityResponse();
            response.setProjectTagId(entity.getProjectTagId());
            return response;
        }).collect(Collectors.toList());
    }
}