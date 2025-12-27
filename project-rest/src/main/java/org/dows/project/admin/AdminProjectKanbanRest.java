package org.dows.project.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.dows.project.admin.PostProjectKanbanEntityRequest;
import org.dows.project.admin.PostProjectKanbanEntityResponse;
import org.dows.project.admin.PutProjectKanbanEntityRequest;
import org.dows.project.admin.PutProjectKanbanEntityResponse;
import org.dows.project.admin.GetProjectKanbanListRequest;
import org.dows.project.admin.GetProjectKanbanListResponse;
import org.dows.project.admin.DeleteProjectKanbanEntityRequest;
import org.dows.project.admin.DeleteProjectKanbanEntityResponse;

@RequiredArgsConstructor
@Tag(name = "AdminProjectKanbanRest", description = "项目看板")
@RestController
public class AdminProjectKanbanRest{

    @PostMapping("admin/project/kanban/entity")
    @Operation(summary = "新建项目看板")
    public PostProjectKanbanEntityResponse postEntity(@RequestBody PostProjectKanbanEntityRequest postProjectKanbanEntityRequest){
        return null;
    }

    @PutMapping("admin/project/kanban/entity")
    @Operation(summary = "更新项目看板")
    public PutProjectKanbanEntityResponse putEntity(@RequestBody PutProjectKanbanEntityRequest putProjectKanbanEntityRequest){
        return null;
    }

    @GetMapping("admin/project/kanban/list")
    @Operation(summary = "获取项目看板")
    public GetProjectKanbanListResponse getList( GetProjectKanbanListRequest getProjectKanbanListRequest){
        return null;
    }

    @DeleteMapping("admin/project/kanban/entity")
    @Operation(summary = "删除项目看板")
    public void deleteEntity(@RequestBody DeleteProjectKanbanEntityRequest deleteProjectKanbanEntityRequest){
        
    }

}