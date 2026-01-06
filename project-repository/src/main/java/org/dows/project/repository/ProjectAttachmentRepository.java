package org.dows.project.repository;

import com.mybatisflex.core.query.QueryWrapper;
import org.dows.rade.crud.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.dows.project.admin.PostProjectAttachmentEntityRequest;
import org.dows.project.admin.PostProjectAttachmentEntityResponse;
import org.dows.project.admin.PutProjectAttachmentEntityRequest;
import org.dows.project.admin.GetProjectAttachmentListRequest;
import org.dows.project.admin.GetProjectAttachmentListResponse;
import org.dows.project.admin.GetProjectAttachmentEntityRequest;
import org.dows.project.admin.GetProjectAttachmentEntityResponse;
import org.dows.project.admin.DeleteProjectAttachmentEntityRequest;
import org.dows.project.entity.ProjectAttachmentEntity;
import org.dows.project.dao.ProjectAttachmentDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectAttachmentRepository extends CrudRepository<ProjectAttachmentDao, ProjectAttachmentEntity> {

    @Autowired
    private ProjectAttachmentDao projectAttachmentDao;

    /**
     * 批量保存项目附件
     */
    public List<PostProjectAttachmentEntityResponse> saveBatch(List<PostProjectAttachmentEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectAttachmentEntity> entities = requests.stream().map(request -> {
            ProjectAttachmentEntity entity = new ProjectAttachmentEntity();
            entity.setProjectInstanceId(request.getProjectInstanceId());
            entity.setAccountInstanceId(request.getAccountInstanceId());
            entity.setProjectSourceId(request.getProjectSourceId());
            entity.setProjectSource(request.getProjectSource());
            entity.setDocTitle(request.getDocTitle());
            entity.setDescription(request.getDescription());
            entity.setOssCode(request.getOssCode());
            entity.setDocLink(request.getDocLink());
            entity.setMd5(request.getMd5());
            entity.setFormat(request.getFormat());
            entity.setDocType(request.getDocType());
            // 设置创建时间为当前时间
            entity.setCreateTime(now);
            return entity;
        }).collect(Collectors.toList());
        
        boolean saved = projectAttachmentDao.saveBatch(entities);
        if (!saved) {
            throw new RuntimeException("批量创建项目附件失败");
        }
        
        return entities.stream().map(entity -> {
            PostProjectAttachmentEntityResponse response = new PostProjectAttachmentEntityResponse();
            response.setProjectAttachmentId(entity.getProjectAttachmentId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量更新项目附件，返回更新的ID列表
     */
    public List<PostProjectAttachmentEntityResponse> updateBatch(List<PutProjectAttachmentEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectAttachmentEntity> entities = requests.stream().map(request -> {
            ProjectAttachmentEntity entity = new ProjectAttachmentEntity();
            entity.setProjectAttachmentId(request.getProjectAttachmentId());
            entity.setDocTitle(request.getDocTitle());
            entity.setDescription(request.getDescription());
            entity.setOssCode(request.getOssCode());
            entity.setDocLink(request.getDocLink());
            entity.setMd5(request.getMd5());
            entity.setFormat(request.getFormat());
            entity.setDocType(request.getDocType());
            // 设置更新时间为当前时间
            entity.setUpdateTime(now);
            
            // 如果 request 中没有提供 revision，从数据库查询当前的 revision 值
            if (request.getRevision() != null) {
                entity.setRevision(request.getRevision());
            } else {
                ProjectAttachmentEntity existingEntity = projectAttachmentDao.getById(request.getProjectAttachmentId());
                if (existingEntity != null && existingEntity.getRevision() != null) {
                    entity.setRevision(existingEntity.getRevision());
                }
            }
            
            return entity;
        }).collect(Collectors.toList());
        
        boolean updated = projectAttachmentDao.updateBatch(entities);
        if (!updated) {
            throw new RuntimeException("批量更新项目附件失败");
        }
        
        return entities.stream().map(entity -> {
            PostProjectAttachmentEntityResponse response = new PostProjectAttachmentEntityResponse();
            response.setProjectAttachmentId(entity.getProjectAttachmentId());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 根据ID查询项目附件
     */
    public GetProjectAttachmentEntityResponse getById(GetProjectAttachmentEntityRequest request) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .from(ProjectAttachmentEntity.class)
                .where("project_attachment_id = ?", request.getProjectAttachmentId())
                .and("delete_time is null");
        
        List<ProjectAttachmentEntity> entities = projectAttachmentDao.list(queryWrapper);
        if (entities == null || entities.isEmpty()) {
            return null;
        }
        ProjectAttachmentEntity entity = entities.get(0);
        GetProjectAttachmentEntityResponse response = new GetProjectAttachmentEntityResponse();
        response.setProjectAttachmentId(entity.getProjectAttachmentId());
        response.setProjectInstanceId(entity.getProjectInstanceId());
        response.setAccountInstanceId(entity.getAccountInstanceId());
        response.setProjectSourceId(entity.getProjectSourceId());
        response.setProjectSource(entity.getProjectSource());
        response.setDocTitle(entity.getDocTitle());
        response.setDescription(entity.getDescription());
        response.setOssCode(entity.getOssCode());
        response.setDocLink(entity.getDocLink());
        response.setMd5(entity.getMd5());
        response.setFormat(entity.getFormat());
        response.setDocType(entity.getDocType());
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
     * 列表查询项目附件
     */
    public List<GetProjectAttachmentListResponse> list(GetProjectAttachmentListRequest request) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .from(ProjectAttachmentEntity.class)
                .where("delete_time is null");
        
        if (request.getProjectInstanceId() != null) {
            queryWrapper.and("project_instance_id = ?", request.getProjectInstanceId());
        }
        if (request.getProjectSourceId() != null) {
            queryWrapper.and("project_source_id = ?", request.getProjectSourceId());
        }
        if (request.getProjectSource() != null && !request.getProjectSource().isEmpty()) {
            queryWrapper.and("project_source = ?", request.getProjectSource());
        }
        if (request.getDocType() != null) {
            queryWrapper.and("doc_type = ?", request.getDocType());
        }
        queryWrapper.orderBy("create_time", false);
        List<ProjectAttachmentEntity> entities = projectAttachmentDao.list(queryWrapper);
        
        return entities.stream().map(entity -> {
            GetProjectAttachmentListResponse response = new GetProjectAttachmentListResponse();
            response.setProjectAttachmentId(entity.getProjectAttachmentId());
            response.setProjectInstanceId(entity.getProjectInstanceId());
            response.setAccountInstanceId(entity.getAccountInstanceId());
            response.setProjectSourceId(entity.getProjectSourceId());
            response.setProjectSource(entity.getProjectSource());
            response.setDocTitle(entity.getDocTitle());
            response.setDescription(entity.getDescription());
            response.setOssCode(entity.getOssCode());
            response.setDocLink(entity.getDocLink());
            response.setMd5(entity.getMd5());
            response.setFormat(entity.getFormat());
            response.setDocType(entity.getDocType());
            response.setRevision(entity.getRevision());
            response.setCreateTime(entity.getCreateTime());
            response.setUpdateTime(entity.getUpdateTime());
            return response;
        }).collect(Collectors.toList());
    }

    /**
     * 批量删除项目附件（逻辑删除），返回删除的ID列表
     */
    public List<PostProjectAttachmentEntityResponse> removeById(List<DeleteProjectAttachmentEntityRequest> requests) {
        LocalDateTime now = LocalDateTime.now();
        List<ProjectAttachmentEntity> entities = requests.stream().map(request -> {
            ProjectAttachmentEntity entity = new ProjectAttachmentEntity();
            entity.setProjectAttachmentId(request.getProjectAttachmentId());
            // 设置删除时间为当前时间
            entity.setDeleteTime(now);
            // 查询当前实体的 revision 值
            ProjectAttachmentEntity existingEntity = projectAttachmentDao.getById(request.getProjectAttachmentId());
            if (existingEntity != null && existingEntity.getRevision() != null) {
                entity.setRevision(existingEntity.getRevision());
            }
            return entity;
        }).collect(Collectors.toList());

        boolean updated = projectAttachmentDao.updateBatch(entities);
        if (!updated) {
            throw new RuntimeException("批量删除项目附件失败");
        }

        return entities.stream().map(entity -> {
            PostProjectAttachmentEntityResponse response = new PostProjectAttachmentEntityResponse();
            response.setProjectAttachmentId(entity.getProjectAttachmentId());
            return response;
        }).collect(Collectors.toList());
    }
}
