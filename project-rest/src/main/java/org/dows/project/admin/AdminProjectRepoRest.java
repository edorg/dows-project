package org.dows.project.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.dows.project.repository.ProjectRepositoryRepository;

import java.util.List;

@RequiredArgsConstructor
@Tag(name = "AdminProjectRepoRest", description = "项目仓库")
@RestController
public class AdminProjectRepoRest {

    private final ProjectRepositoryRepository projectRepositoryRepository;

    @PostMapping("admin/project/repo/entity")
    @Operation(summary = "批量创建项目仓库")
    public List<PostProjectRepoEntityResponse> postEntity(@RequestBody List<PostProjectRepoEntityRequest> requests) {
        return projectRepositoryRepository.saveBatch(requests);
    }

    @PutMapping("admin/project/repo/entity")
    @Operation(summary = "批量更新项目仓库")
    public List<PostProjectRepoEntityResponse> putEntity(@RequestBody List<PutProjectRepoEntityRequest> requests) {
        return projectRepositoryRepository.updateBatch(requests);
    }

    @GetMapping("admin/project/repo/list")
    @Operation(summary = "获取项目仓库列表")
    public List<GetProjectRepoListResponse> getList(GetProjectRepoListRequest request) {
        return projectRepositoryRepository.list(request);
    }

    @GetMapping("admin/project/repo/entity")
    @Operation(summary = "获取项目仓库详情")
    public GetProjectRepoEntityResponse getEntity(GetProjectRepoEntityRequest request) {
        return projectRepositoryRepository.getById(request);
    }

    @DeleteMapping("admin/project/repo/entity")
    @Operation(summary = "批量删除项目仓库")
    public List<PostProjectRepoEntityResponse> deleteEntity(@RequestBody List<DeleteProjectRepoEntityRequest> requests) {
        return projectRepositoryRepository.removeById(requests);
    }

}

