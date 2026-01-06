package org.dows.project.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.dows.project.repository.ProjectAttachmentRepository;

import java.util.List;

@RequiredArgsConstructor
@Tag(name = "AdminProjectAttachmentRest", description = "项目附件")
@RestController
public class AdminProjectAttachmentRest {

    private final ProjectAttachmentRepository projectAttachmentRepository;

    @PostMapping("admin/project/attachment/entity")
    @Operation(summary = "批量创建项目附件")
    public List<PostProjectAttachmentEntityResponse> postEntity(@RequestBody List<PostProjectAttachmentEntityRequest> requests) {
        return projectAttachmentRepository.saveBatch(requests);
    }

    @PutMapping("admin/project/attachment/entity")
    @Operation(summary = "批量更新项目附件")
    public List<PostProjectAttachmentEntityResponse> putEntity(@RequestBody List<PutProjectAttachmentEntityRequest> requests) {
        return projectAttachmentRepository.updateBatch(requests);
    }

    @GetMapping("admin/project/attachment/list")
    @Operation(summary = "获取项目附件列表")
    public List<GetProjectAttachmentListResponse> getList(GetProjectAttachmentListRequest request) {
        return projectAttachmentRepository.list(request);
    }

    @GetMapping("admin/project/attachment/entity")
    @Operation(summary = "获取项目附件详情")
    public GetProjectAttachmentEntityResponse getEntity(GetProjectAttachmentEntityRequest request) {
        return projectAttachmentRepository.getById(request);
    }

    @DeleteMapping("admin/project/attachment/entity")
    @Operation(summary = "批量删除项目附件")
    public List<PostProjectAttachmentEntityResponse> deleteEntity(@RequestBody List<DeleteProjectAttachmentEntityRequest> requests) {
        return projectAttachmentRepository.removeById(requests);
    }

}

