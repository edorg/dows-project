package org.dows.project.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.dows.project.repository.ProjectKanbanRepository;

import java.util.List;

@RequiredArgsConstructor
@Tag(name = "AdminProjectKanbanRest", description = "项目看板")
@RestController
public class AdminProjectKanbanRest {

    private final ProjectKanbanRepository projectKanbanRepository;

    @PostMapping("admin/project/kanban/entity")
    @Operation(summary = "批量新建项目看板")
    public List<PostProjectKanbanEntityResponse> postEntity(@RequestBody List<PostProjectKanbanEntityRequest> requests) {
        return projectKanbanRepository.saveBatch(requests);
    }

    @PutMapping("admin/project/kanban/entity")
    @Operation(summary = "批量更新项目看板")
    public List<PostProjectKanbanEntityResponse> putEntity(@RequestBody List<PutProjectKanbanEntityRequest> requests) {
        return projectKanbanRepository.updateBatch(requests);
    }

    @GetMapping("admin/project/kanban/list")
    @Operation(summary = "获取项目看板")
    public List<GetProjectKanbanListResponse> getList(GetProjectKanbanListRequest request) {
        return projectKanbanRepository.list(request);
    }

    @DeleteMapping("admin/project/kanban/entity")
    @Operation(summary = "批量删除项目看板")
    public List<PostProjectKanbanEntityResponse> deleteEntity(@RequestBody List<DeleteProjectKanbanEntityRequest> requests) {
        return projectKanbanRepository.removeById(requests);
    }

}
