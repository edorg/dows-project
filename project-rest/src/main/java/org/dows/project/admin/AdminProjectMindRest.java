package org.dows.project.admin;

import com.mybatisflex.core.paginate.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.dows.rade.crud.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.dows.project.repository.ProjectMindRepository;

import java.util.List;

@RequiredArgsConstructor
@Tag(name = "AdminProjectMindRest", description = "项目脑图")
@RestController
public class AdminProjectMindRest {

    private final ProjectMindRepository projectMindRepository;

    @PostMapping("admin/project/mind/entity")
    @Operation(summary = "批量创建项目脑图")
    public List<PostProjectMindEntityResponse> postEntity(@RequestBody List<PostProjectMindEntityRequest> requests) {
        return projectMindRepository.saveBatch(requests);
    }

    @PutMapping("admin/project/mind/entity")
    @Operation(summary = "批量更新项目脑图")
    public List<PostProjectMindEntityResponse> putEntity(@RequestBody List<PutProjectMindEntityRequest> requests) {
        return projectMindRepository.updateBatch(requests);
    }

    @GetMapping("admin/project/mind/page")
    @Operation(summary = "根据查询条件分页")
    public Page<GetProjectMindPageResponse> getPage(PageRequest pageRequest, GetProjectMindPageRequest request) {
        return projectMindRepository.getPage(pageRequest, request);
    }

    @GetMapping("admin/project/mind/list")
    @Operation(summary = "查询项目下的脑图信息")
    public List<GetProjectMindListResponse> getList(GetProjectMindListRequest request) {
        return projectMindRepository.list(request);
    }

    @GetMapping("admin/project/mind/entity")
    @Operation(summary = "获取项目脑图详情")
    public GetProjectMindEntityResponse getEntity(GetProjectMindEntityRequest request) {
        return projectMindRepository.getById(request);
    }

    @DeleteMapping("admin/project/mind/entity")
    @Operation(summary = "批量删除项目脑图")
    public List<PostProjectMindEntityResponse> deleteEntity(@RequestBody List<DeleteProjectMindEntityRequest> requests) {
        return projectMindRepository.removeById(requests);
    }

}

