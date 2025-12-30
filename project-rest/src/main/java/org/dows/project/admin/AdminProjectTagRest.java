package org.dows.project.admin;

import com.mybatisflex.core.paginate.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.dows.rade.crud.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.dows.project.repository.ProjectTagRepository;

import java.util.List;

@RequiredArgsConstructor
@Tag(name = "AdminProjectTagRest", description = "项目标签")
@RestController
public class AdminProjectTagRest {

    private final ProjectTagRepository projectTagRepository;

    @PostMapping("admin/project/tag/entity")
    @Operation(summary = "批量创建项目标签")
    public List<PostProjectTagEntityResponse> postEntity(@RequestBody List<PostProjectTagEntityRequest> requests) {
        return projectTagRepository.saveBatch(requests);
    }

    @PutMapping("admin/project/tag/entity")
    @Operation(summary = "批量更新项目标签")
    public List<PostProjectTagEntityResponse> putEntity(@RequestBody List<PutProjectTagEntityRequest> requests) {
        return projectTagRepository.updateBatch(requests);
    }

    @GetMapping("admin/project/tag/page")
    @Operation(summary = "根据查询条件分页")
    public Page<GetProjectTagPageResponse> getPage(PageRequest pageRequest, GetProjectTagPageRequest request) {
        return projectTagRepository.getPage(pageRequest, request);
    }

    @GetMapping("admin/project/tag/list")
    @Operation(summary = "查询项目下的标签信息")
    public List<GetProjectTagListResponse> getList(GetProjectTagListRequest request) {
        return projectTagRepository.list(request);
    }

    @GetMapping("admin/project/tag/entity")
    @Operation(summary = "获取项目标签详情")
    public GetProjectTagEntityResponse getEntity(GetProjectTagEntityRequest request) {
        return projectTagRepository.getById(request);
    }

    @DeleteMapping("admin/project/tag/entity")
    @Operation(summary = "批量删除项目标签")
    public List<PostProjectTagEntityResponse> deleteEntity(@RequestBody List<DeleteProjectTagEntityRequest> requests) {
        return projectTagRepository.removeById(requests);
    }

}