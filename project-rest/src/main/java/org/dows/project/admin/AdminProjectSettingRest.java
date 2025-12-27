package org.dows.project.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.dows.project.admin.PostProjectSettingEntityRequest;
import org.dows.project.admin.PostProjectSettingEntityResponse;
import org.dows.project.admin.PutProjectSettingEntityResponse;
import org.dows.project.admin.PostProjectSettingListRequest;
import org.dows.project.admin.PostProjectSettingListResponse;
import org.dows.project.admin.GetProjectSettingEntityRequest;
import org.dows.project.admin.GetProjectSettingEntityResponse;
import org.dows.project.admin.DeleteProjectSettingEntityRequest;
import org.dows.project.admin.DeleteProjectSettingEntityResponse;

@RequiredArgsConstructor
@Tag(name = "AdminProjectSettingRest", description = "项目设置")
@RestController
public class AdminProjectSettingRest{

    @PostMapping("admin/project/setting/entity")
    @Operation(summary = "保存")
    public void postEntity(@RequestBody PostProjectSettingEntityRequest postProjectSettingEntityRequest){
        
    }
    @PostMapping("admin/project/setting/list")
    @Operation(summary = "项目设置信息列表")
    public PostProjectSettingListResponse postList(@RequestBody PostProjectSettingListRequest postProjectSettingListRequest){
        return null;
    }
    @GetMapping("admin/project/setting/entity")
    @Operation(summary = "详情")
    public GetProjectSettingEntityResponse getEntity( GetProjectSettingEntityRequest getProjectSettingEntityRequest){
        return null;
    }
    @DeleteMapping("admin/project/setting/entity")
    @Operation(summary = "删除")
    public void deleteEntity(@RequestBody DeleteProjectSettingEntityRequest deleteProjectSettingEntityRequest){
        
    }
}