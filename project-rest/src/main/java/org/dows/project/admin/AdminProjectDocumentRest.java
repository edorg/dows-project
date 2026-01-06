package org.dows.project.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.dows.project.admin.PostProjectDocumentEntityRequest;
import org.dows.project.admin.PostProjectDocumentEntityResponse;
import org.dows.project.admin.GetProjectDocumentListRequest;
import org.dows.project.admin.GetProjectDocumentListResponse;
import org.dows.project.admin.GetProjectDocumentPageRequest;
import org.dows.project.admin.GetProjectDocumentPageResponse;
import org.dows.project.admin.PutProjectDocumentEntityRequest;
import org.dows.project.admin.PutProjectDocumentEntityResponse;

@RequiredArgsConstructor
@Tag(name = "AdminProjectDocumentRest", description = "项目文档")
@RestController
public class AdminProjectDocumentRest{

    @PostMapping("admin/project/document/entity")
    @Operation(summary = "项目文档")
    public PostProjectDocumentEntityResponse postEntity(@RequestBody PostProjectDocumentEntityRequest postProjectDocumentEntityRequest){
        return null;
    }

    @GetMapping("admin/project/document/list")
    @Operation(summary = "列出文档列表")
    public GetProjectDocumentListResponse getList( GetProjectDocumentListRequest getProjectDocumentListRequest){
        return null;
    }

    @GetMapping("admin/project/document/page")
    @Operation(summary = "文档分页")
    public GetProjectDocumentPageResponse getPage( GetProjectDocumentPageRequest getProjectDocumentPageRequest){
        return null;
    }

    @PutMapping("admin/project/document/entity")
    @Operation(summary = "更新项目文档")
    public void putEntity(@RequestBody PutProjectDocumentEntityRequest putProjectDocumentEntityRequest){
        
    }

}