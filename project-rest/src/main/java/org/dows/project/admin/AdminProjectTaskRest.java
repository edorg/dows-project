package org.dows.project.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Tag(name = "AdminProjectTaskRest", description = "项目任务")
@RestController
public class AdminProjectTaskRest{

    @PostMapping("admin/project/task/entity")
    @Operation(summary = "关联项目任务")
    public PostProjectTaskEntityResponse postEntity(@RequestBody PostProjectTaskEntityRequest postProjectTaskEntityRequest){
        return null;
    }

    @PutMapping("admin/project/task/entity")
    @Operation(summary = "更新任务关联")
    public void putEntity(@RequestBody PutProjectTaskEntityRequest putProjectTaskEntityRequest){
        
    }

    @GetMapping("admin/project/task/list")
    @Operation(summary = "项目任务列表")
    public GetProjectTaskListResponse getList( ProjectIDRequest 项目IDRequest){
        return null;
    }

    @GetMapping("admin/project/task/page")
    @Operation(summary = "项目任务分页")
    public GetProjectTaskPageResponse getPage( ProjectIDRequest 项目IDRequest){
        return null;
    }

    @DeleteMapping("admin/project/task/entity")
    @Operation(summary = "删除")
    public void deleteEntity(@RequestBody DeleteProjectTaskEntityRequest deleteProjectTaskEntityRequest){
        
    }

}