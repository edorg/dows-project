package org.dows.project.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.dows.project.admin.PostProjectMemberEntityRequest;
import org.dows.project.admin.PostProjectMemberEntityResponse;
import org.dows.project.admin.GetProjectMemberEntityRequest;
import org.dows.project.admin.GetProjectMemberEntityResponse;
import org.dows.project.admin.GetProjectMemberListRequest;
import org.dows.project.admin.GetProjectMemberListResponse;
import org.dows.project.admin.GetProjectMemberPageRequest;
import org.dows.project.admin.GetProjectMemberPageResponse;
import org.dows.project.admin.DeleteProjectMemberEntityRequest;
import org.dows.project.admin.DeleteProjectMemberEntityResponse;

@RequiredArgsConstructor
@Tag(name = "AdminProjectMemberRest", description = "项目成员")
@RestController
public class AdminProjectMemberRest{

    @PostMapping("admin/project/member/entity")
    @Operation(summary = "新增项目成员")
    public PostProjectMemberEntityResponse postEntity(@RequestBody PostProjectMemberEntityRequest postProjectMemberEntityRequest){
        return null;
    }

    @GetMapping("admin/project/member/entity")
    @Operation(summary = "查询项目成员")
    public GetProjectMemberEntityResponse getEntity( GetProjectMemberEntityRequest getProjectMemberEntityRequest){
        return null;
    }

    @GetMapping("admin/project/member/list")
    @Operation(summary = "项目成员列表")
    public GetProjectMemberListResponse getList( GetProjectMemberListRequest getProjectMemberListRequest){
        return null;
    }

    @GetMapping("admin/project/member/page")
    @Operation(summary = "项目成员分页")
    public GetProjectMemberPageResponse getPage( GetProjectMemberPageRequest getProjectMemberPageRequest){
        return null;
    }

    @DeleteMapping("admin/project/member/entity")
    @Operation(summary = "删除项目成员")
    public void deleteEntity(@RequestBody DeleteProjectMemberEntityRequest deleteProjectMemberEntityRequest){
        
    }

}