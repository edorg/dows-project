package org.dows.project.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.dows.project.repository.ProjectFlowRepository;

import java.util.List;

@RequiredArgsConstructor
@Tag(name = "AdminProjectFlowRest", description = "项目流程")
@RestController
public class AdminProjectFlowRest {

    private final ProjectFlowRepository projectFlowRepository;

    @PostMapping("admin/project/flow/entity")
    @Operation(summary = "批量新建项目流程")
    public List<PostProjectFlowEntityResponse> postEntity(@RequestBody List<PostProjectFlowEntityRequest> requests) {
        return projectFlowRepository.saveBatch(requests);
    }

    @PutMapping("admin/project/flow/entity")
    @Operation(summary = "批量更新项目流程")
    public List<PostProjectFlowEntityResponse> putEntity(@RequestBody List<PutProjectFlowEntityRequest> requests) {
        return projectFlowRepository.updateBatch(requests);
    }

    @GetMapping("admin/project/flow/list")
    @Operation(summary = "获取项目流程")
    public List<GetProjectFlowListResponse> getList(GetProjectFlowListRequest request) {
        return projectFlowRepository.list(request);
    }

    @DeleteMapping("admin/project/flow/entity")
    @Operation(summary = "批量删除项目流程")
    public List<PostProjectFlowEntityResponse> deleteEntity(@RequestBody List<DeleteProjectFlowEntityRequest> requests) {
        return projectFlowRepository.removeById(requests);
    }

}
