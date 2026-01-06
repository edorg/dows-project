package org.dows.project.repository;

import com.mybatisflex.core.query.QueryWrapper;
import org.dows.rade.crud.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.dows.project.admin.PostProjectRepoEntityRequest;
import org.dows.project.admin.PostProjectRepoEntityResponse;
import org.dows.project.admin.PutProjectRepoEntityRequest;
import org.dows.project.admin.GetProjectRepoListRequest;
import org.dows.project.admin.GetProjectRepoListResponse;
import org.dows.project.admin.GetProjectRepoEntityRequest;
import org.dows.project.admin.GetProjectRepoEntityResponse;
import org.dows.project.admin.DeleteProjectRepoEntityRequest;
import org.dows.project.entity.ProjectRepositoryEntity;
import org.dows.project.dao.ProjectRepositoryDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectRepositoryRepository extends CrudRepository<ProjectRepositoryDao, ProjectRepositoryEntity> {

    @Autowired
    private ProjectRepositoryDao projectRepositoryDao;

    /**
     * 批量保存项目仓库
     */
    public List<PostProjectRepoEntityResponse> saveBatch(List<PostProjectRepoEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectRepositoryEntity> entities = requests.stream().map(request -> {
            ProjectRepositoryEntity entity = new ProjectRepositoryEntity();
            entity.setProjectInstanceId(request.getProjectInstanceId());
            entity.setGitUrl(request.getGitUrl());
            entity.setHttpUrl(request.getHttpUrl());
            entity.setToken(request.getToken());
            // 设置创建时间为当前时间
            entity.setCreateTime(now);
            return entity;
        }).collect(Collectors.toList());
        
        boolean saved = projectRepositoryDao.saveBatch(entities);
        if (!saved) {
            throw new RuntimeException("批量创建项目仓库失败");
        }
        
        return entities.stream().map(entity -> {
            PostProjectRepoEntityResponse response = new PostProjectRepoEntityResponse();
            response.setProjectRepositoryId(entity.getProjectRepositoryId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量更新项目仓库，返回更新的ID列表
     */
    public List<PostProjectRepoEntityResponse> updateBatch(List<PutProjectRepoEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectRepositoryEntity> entities = requests.stream().map(request -> {
            ProjectRepositoryEntity entity = new ProjectRepositoryEntity();
            entity.setProjectRepositoryId(request.getProjectRepositoryId());
            entity.setGitUrl(request.getGitUrl());
            entity.setHttpUrl(request.getHttpUrl());
            entity.setToken(request.getToken());
            // 设置更新时间为当前时间
            entity.setUpdateTime(now);
            
            // 如果 request 中没有提供 revision，从数据库查询当前的 revision 值
            if (request.getRevision() != null) {
                entity.setRevision(request.getRevision());
            } else {
                ProjectRepositoryEntity existingEntity = projectRepositoryDao.getById(request.getProjectRepositoryId());
                if (existingEntity != null && existingEntity.getRevision() != null) {
                    entity.setRevision(existingEntity.getRevision());
                }
            }
            
            return entity;
        }).collect(Collectors.toList());
        
        boolean updated = projectRepositoryDao.updateBatch(entities);
        if (!updated) {
            throw new RuntimeException("批量更新项目仓库失败");
        }
        
        return entities.stream().map(entity -> {
            PostProjectRepoEntityResponse response = new PostProjectRepoEntityResponse();
            response.setProjectRepositoryId(entity.getProjectRepositoryId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 根据ID查询项目仓库
     */
    public GetProjectRepoEntityResponse getById(GetProjectRepoEntityRequest request) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .from(ProjectRepositoryEntity.class)
                .where("project_repository_id = ?", request.getProjectRepositoryId())
                .and("delete_time is null");
        
        List<ProjectRepositoryEntity> entities = projectRepositoryDao.list(queryWrapper);
        if (entities == null || entities.isEmpty()) {
            return null;
        }
        ProjectRepositoryEntity entity = entities.get(0);
        GetProjectRepoEntityResponse response = new GetProjectRepoEntityResponse();
        response.setProjectRepositoryId(entity.getProjectRepositoryId());
        response.setProjectInstanceId(entity.getProjectInstanceId());
        response.setGitUrl(entity.getGitUrl());
        response.setHttpUrl(entity.getHttpUrl());
        response.setToken(entity.getToken());
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
     * 列表查询项目仓库
     */
    public List<GetProjectRepoListResponse> list(GetProjectRepoListRequest request) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .from(ProjectRepositoryEntity.class)
                .where("delete_time is null");
        
        if (request.getProjectInstanceId() != null) {
            queryWrapper.and("project_instance_id = ?", request.getProjectInstanceId());
        }
        queryWrapper.orderBy("create_time", false);
        List<ProjectRepositoryEntity> entities = projectRepositoryDao.list(queryWrapper);
        
        return entities.stream().map(entity -> {
            GetProjectRepoListResponse response = new GetProjectRepoListResponse();
            response.setProjectRepositoryId(entity.getProjectRepositoryId());
            response.setProjectInstanceId(entity.getProjectInstanceId());
            response.setGitUrl(entity.getGitUrl());
            response.setHttpUrl(entity.getHttpUrl());
            response.setToken(entity.getToken());
            response.setRevision(entity.getRevision());
            response.setCreateTime(entity.getCreateTime());
            response.setUpdateTime(entity.getUpdateTime());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量删除项目仓库（逻辑删除），返回删除的ID列表
     */
    public List<PostProjectRepoEntityResponse> removeById(List<DeleteProjectRepoEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectRepositoryEntity> entities = requests.stream().map(request -> {
            ProjectRepositoryEntity entity = new ProjectRepositoryEntity();
            entity.setProjectRepositoryId(request.getProjectRepositoryId());
            // 设置删除时间为当前时间
            entity.setDeleteTime(now);
            // 查询当前实体的 revision 值
            ProjectRepositoryEntity existingEntity = projectRepositoryDao.getById(request.getProjectRepositoryId());
            if (existingEntity != null && existingEntity.getRevision() != null) {
                entity.setRevision(existingEntity.getRevision());
            }
            return entity;
        }).collect(Collectors.toList());

        boolean updated = projectRepositoryDao.updateBatch(entities);
        if (!updated) {
            throw new RuntimeException("批量删除项目仓库失败");
        }

        return entities.stream().map(entity -> {
            PostProjectRepoEntityResponse response = new PostProjectRepoEntityResponse();
            response.setProjectRepositoryId(entity.getProjectRepositoryId());
            return response;
        }).collect(Collectors.toList());
    }
}
