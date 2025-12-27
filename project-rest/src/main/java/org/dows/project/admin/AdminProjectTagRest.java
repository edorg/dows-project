package org.dows.project.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.dows.project.admin.PostProjectTagEntityRequest;
import org.dows.project.admin.PostProjectTagEntityResponse;
import org.dows.project.admin.PutProjectTagEntityRequest;
import org.dows.project.admin.PutProjectTagEntityResponse;
import org.dows.project.admin.GetProjectTagListRequest;
import org.dows.project.admin.GetProjectTagListResponse;
import org.dows.project.admin.GetProjectTagEntityRequest;
import org.dows.project.admin.GetProjectTagEntityResponse;
import org.dows.project.admin.DeleteProjectTagEntityRequest;
import org.dows.project.admin.DeleteProjectTagEntityResponse;

@RequiredArgsConstructor
@Tag(name = "AdminProjectTagRest", description = "项目标签")
@RestController
public class AdminProjectTagRest{

    @PostMapping("admin/project/tag/entity")
    @Operation(summary = "保存")
    public PostProjectTagEntityResponse postEntity(@RequestBody PostProjectTagEntityRequest postProjectTagEntityRequest){
        return null;
    }
    @PutMapping("admin/project/tag/entity")
    @Operation(summary = "更新")
    public void putEntity(@RequestBody PutProjectTagEntityRequest putProjectTagEntityRequest){
        
    }
    @GetMapping("admin/project/tag/list")
    @Operation(summary = "查询项目下的标签信息")
    public GetProjectTagListResponse getList( GetProjectTagListRequest getProjectTagListRequest){
        return null;
    }
    @GetMapping("admin/project/tag/entity")
    @Operation(summary = "详情")
    public GetProjectTagEntityResponse getEntity( GetProjectTagEntityRequest getProjectTagEntityRequest){
        return null;
    }
    @DeleteMapping("admin/project/tag/entity")
    @Operation(summary = "删除")
    public void deleteEntity(@RequestBody DeleteProjectTagEntityRequest deleteProjectTagEntityRequest){
        
    }
}