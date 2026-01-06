package org.dows.project.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.dows.project.repository.ProjectMilestoneRepository;

import java.util.List;

@RequiredArgsConstructor
@Tag(name = "AdminProjectMilestoneRest", description = "项目里程碑")
@RestController
public class AdminProjectMilestoneRest {

    private final ProjectMilestoneRepository projectMilestoneRepository;

    @PostMapping("admin/project/milestone/entity")
    @Operation(summary = "批量创建项目里程碑")
    public List<PostProjectMilestoneEntityResponse> postEntity(@RequestBody List<PostProjectMilestoneEntityRequest> requests) {
        return projectMilestoneRepository.saveBatch(requests);
    }

    @PutMapping("admin/project/milestone/entity")
    @Operation(summary = "批量更新项目里程碑")
    public List<PostProjectMilestoneEntityResponse> putEntity(@RequestBody List<PutProjectMilestoneEntityRequest> requests) {
        return projectMilestoneRepository.updateBatch(requests);
    }

    @GetMapping("admin/project/milestone/entity")
    @Operation(summary = "获取项目里程碑详情")
    public GetProjectMilestoneEntityResponse getEntity(GetProjectMilestoneEntityRequest request) {
        return projectMilestoneRepository.getById(request);
    }

    @GetMapping("admin/project/milestone/list")
    @Operation(summary = "项目里程碑列表")
    public List<GetProjectMilestoneListResponse> getList(GetProjectMilestoneListRequest request) {
        return projectMilestoneRepository.list(request);
    }

    @DeleteMapping("admin/project/milestone/entity")
    @Operation(summary = "批量删除项目里程碑")
    public List<PostProjectMilestoneEntityResponse> deleteEntity(@RequestBody List<DeleteProjectMilestoneEntityRequest> requests) {
        return projectMilestoneRepository.removeById(requests);
    }

}
