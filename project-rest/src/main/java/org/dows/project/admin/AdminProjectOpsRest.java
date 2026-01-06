package org.dows.project.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.dows.project.repository.ProjectOpsRepository;

import java.util.List;

@RequiredArgsConstructor
@Tag(name = "AdminProjectOpsRest", description = "项目运维")
@RestController
public class AdminProjectOpsRest {

    private final ProjectOpsRepository projectOpsRepository;

    @PostMapping("admin/project/ops/entity")
    @Operation(summary = "批量创建项目运维")
    public List<PostProjectOpsEntityResponse> postEntity(@RequestBody List<PostProjectOpsEntityRequest> requests) {
        return projectOpsRepository.saveBatch(requests);
    }

    @PutMapping("admin/project/ops/entity")
    @Operation(summary = "批量更新项目运维")
    public List<PostProjectOpsEntityResponse> putEntity(@RequestBody List<PutProjectOpsEntityRequest> requests) {
        return projectOpsRepository.updateBatch(requests);
    }

    @GetMapping("admin/project/ops/list")
    @Operation(summary = "获取项目运维列表")
    public List<GetProjectOpsListResponse> getList(GetProjectOpsListRequest request) {
        return projectOpsRepository.list(request);
    }

    @GetMapping("admin/project/ops/entity")
    @Operation(summary = "获取项目运维详情")
    public GetProjectOpsEntityResponse getEntity(GetProjectOpsEntityRequest request) {
        return projectOpsRepository.getById(request);
    }

    @DeleteMapping("admin/project/ops/entity")
    @Operation(summary = "批量删除项目运维")
    public List<PostProjectOpsEntityResponse> deleteEntity(@RequestBody List<DeleteProjectOpsEntityRequest> requests) {
        return projectOpsRepository.removeById(requests);
    }

}

