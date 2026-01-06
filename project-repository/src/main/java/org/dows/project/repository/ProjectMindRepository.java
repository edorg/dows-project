package org.dows.project.repository;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.dows.rade.crud.CrudRepository;
import org.dows.rade.crud.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.dows.project.admin.PostProjectMindEntityRequest;
import org.dows.project.admin.PostProjectMindEntityResponse;
import org.dows.project.admin.PutProjectMindEntityRequest;
import org.dows.project.admin.GetProjectMindListRequest;
import org.dows.project.admin.GetProjectMindListResponse;
import org.dows.project.admin.GetProjectMindPageRequest;
import org.dows.project.admin.GetProjectMindPageResponse;
import org.dows.project.admin.GetProjectMindEntityRequest;
import org.dows.project.admin.GetProjectMindEntityResponse;
import org.dows.project.admin.DeleteProjectMindEntityRequest;
import org.dows.project.entity.ProjectMindEntity;
import org.dows.project.dao.ProjectMindDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.dows.project.entity.table.ProjectMindEntityTableDef.PROJECT_MIND_ENTITY;

@Component
public class ProjectMindRepository extends CrudRepository<ProjectMindDao, ProjectMindEntity> {

    @Autowired
    private ProjectMindDao projectMindDao;

    /**
     * 批量保存脑图
     */
    public List<PostProjectMindEntityResponse> saveBatch(List<PostProjectMindEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectMindEntity> entities = requests.stream().map(request -> {
            ProjectMindEntity entity = new ProjectMindEntity();
            entity.setProjectInstanceId(request.getProjectInstanceId());
            entity.setMindUrl(request.getMindUrl());
            entity.setMindVersion(request.getMindVersion());
            entity.setMindJson(request.getMindJson());
            // 设置创建时间为当前时间
            entity.setCreateTime(now);
            return entity;
        }).collect(Collectors.toList());
        
        boolean saved = projectMindDao.saveBatch(entities);
        if (!saved) {
            throw new RuntimeException("批量创建项目脑图失败");
        }
        
        return entities.stream().map(entity -> {
            PostProjectMindEntityResponse response = new PostProjectMindEntityResponse();
            response.setProjectMindId(entity.getProjectMindId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量更新脑图，返回更新的ID列表
     */
    public List<PostProjectMindEntityResponse> updateBatch(List<PutProjectMindEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectMindEntity> entities = requests.stream().map(request -> {
            ProjectMindEntity entity = new ProjectMindEntity();
            entity.setProjectMindId(request.getProjectMindId());
            entity.setMindUrl(request.getMindUrl());
            entity.setMindVersion(request.getMindVersion());
            entity.setMindJson(request.getMindJson());
            // 设置更新时间为当前时间
            entity.setUpdateTime(now);
            
            // 如果 request 中没有提供 revision，从数据库查询当前的 revision 值
            if (request.getRevision() != null) {
                entity.setRevision(request.getRevision());
            } else {
                ProjectMindEntity existingEntity = projectMindDao.getById(request.getProjectMindId());
                if (existingEntity != null && existingEntity.getRevision() != null) {
                    entity.setRevision(existingEntity.getRevision());
                }
            }
            
            return entity;
        }).collect(Collectors.toList());
        
        boolean updated = projectMindDao.updateBatch(entities);
        if (!updated) {
            throw new RuntimeException("批量更新项目脑图失败");
        }
        
        return entities.stream().map(entity -> {
            PostProjectMindEntityResponse response = new PostProjectMindEntityResponse();
            response.setProjectMindId(entity.getProjectMindId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 分页查询项目脑图
     */
    public Page<GetProjectMindPageResponse> getPage(PageRequest pageRequest, GetProjectMindPageRequest request) {
        // 创建分页对象
        Page<GetProjectMindPageResponse> objectPage = Page.of(pageRequest.getPageNum(), pageRequest.getPageSize());
        
        // 创建查询条件
        QueryWrapper queryWrapper = QueryWrapper.create()
                .from(ProjectMindEntity.class);
        
        // 过滤已删除的记录（deleteTime 为空的记录）
        queryWrapper.where(PROJECT_MIND_ENTITY.DELETE_TIME.isNull());
        
        // 根据 request 参数拼接查询条件
        if (request.getProjectInstanceId() != null) {
            queryWrapper.where(PROJECT_MIND_ENTITY.PROJECT_INSTANCE_ID.eq(request.getProjectInstanceId()));
        }
        if (request.getMindUrl() != null && !request.getMindUrl().isEmpty()) {
            queryWrapper.where(PROJECT_MIND_ENTITY.MIND_URL.like(request.getMindUrl()));
        }
        
        // 添加排序（使用 PageRequest 的排序方法，如果没有则使用默认排序）
        if (pageRequest.getOrderBys(ProjectMindEntity.class) != null && 
            !pageRequest.getOrderBys(ProjectMindEntity.class).isEmpty()) {
            queryWrapper.orderBy(pageRequest.getOrderBys(ProjectMindEntity.class));
        } else {
            // 默认按创建时间倒序
            queryWrapper.orderBy(PROJECT_MIND_ENTITY.CREATE_TIME.desc());
        }
        
        // 执行分页查询
        pageAs(objectPage, queryWrapper, GetProjectMindPageResponse.class);
        
        return objectPage;
    }

    /**
     * 根据ID查询脑图
     */
    public GetProjectMindEntityResponse getById(GetProjectMindEntityRequest request) {
        QueryWrapper queryWrapper = QueryWrapper.create();
        queryWrapper.where(PROJECT_MIND_ENTITY.PROJECT_MIND_ID.eq(request.getProjectMindId()));
        // 过滤已删除的记录（deleteTime 为空的记录）
        queryWrapper.where(PROJECT_MIND_ENTITY.DELETE_TIME.isNull());
        
        List<ProjectMindEntity> entities = projectMindDao.list(queryWrapper);
        if (entities == null || entities.isEmpty()) {
            return null;
        }
        ProjectMindEntity entity = entities.get(0);
        GetProjectMindEntityResponse response = new GetProjectMindEntityResponse();
        response.setProjectMindId(entity.getProjectMindId());
        response.setProjectInstanceId(entity.getProjectInstanceId());
        response.setMindUrl(entity.getMindUrl());
        response.setMindVersion(entity.getMindVersion());
        response.setMindJson(entity.getMindJson());
        return response;
    }

    /**
     * 列表查询脑图
     */
    public List<GetProjectMindListResponse> list(GetProjectMindListRequest request) {
        QueryWrapper queryWrapper = QueryWrapper.create();
        // 过滤已删除的记录（deleteTime 为空的记录）
        queryWrapper.where(PROJECT_MIND_ENTITY.DELETE_TIME.isNull());
        
        if (request.getProjectInstanceId() != null) {
            queryWrapper.where(PROJECT_MIND_ENTITY.PROJECT_INSTANCE_ID.eq(request.getProjectInstanceId()));
        }
        List<ProjectMindEntity> entities = projectMindDao.list(queryWrapper);
        
        return entities.stream().map(entity -> {
            GetProjectMindListResponse response = new GetProjectMindListResponse();
            response.setProjectMindId(entity.getProjectMindId());
            response.setProjectInstanceId(entity.getProjectInstanceId());
            response.setMindUrl(entity.getMindUrl());
            response.setMindVersion(entity.getMindVersion());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量删除脑图（逻辑删除），返回删除的ID列表
     */
    public List<PostProjectMindEntityResponse> removeById(List<DeleteProjectMindEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectMindEntity> entities = requests.stream().map(request -> {
            ProjectMindEntity entity = new ProjectMindEntity();
            entity.setProjectMindId(request.getProjectMindId());
            // 设置删除时间为当前时间
            entity.setDeleteTime(now);
            // 查询当前实体的 revision 值
            ProjectMindEntity existingEntity = projectMindDao.getById(request.getProjectMindId());
            if (existingEntity != null && existingEntity.getRevision() != null) {
                entity.setRevision(existingEntity.getRevision());
            }
            return entity;
        }).collect(Collectors.toList());

        boolean updated = projectMindDao.updateBatch(entities);
        if (!updated) {
            throw new RuntimeException("批量删除项目脑图失败");
        }

        return entities.stream().map(entity -> {
            PostProjectMindEntityResponse response = new PostProjectMindEntityResponse();
            response.setProjectMindId(entity.getProjectMindId());
            return response;
        }).collect(Collectors.toList());
    }
}