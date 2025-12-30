package org.dows.project.admin;

import com.mybatisflex.core.paginate.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.dows.rade.crud.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.dows.project.repository.ProjectSettingRepository;

import java.util.List;

@RequiredArgsConstructor
@Tag(name = "AdminProjectSettingRest", description = "项目设置")
@RestController
public class AdminProjectSettingRest {

    private final ProjectSettingRepository projectSettingRepository;

    @PostMapping("admin/project/setting/entity")
    @Operation(summary = "批量创建项目设置")
    public List<PostProjectSettingEntityResponse> postEntity(@RequestBody List<PostProjectSettingEntityRequest> requests) {
        return projectSettingRepository.saveBatch(requests);
    }

    @PutMapping("admin/project/setting/entity")
    @Operation(summary = "批量更新项目设置")
    public List<PostProjectSettingEntityResponse> putEntity(@RequestBody List<PutProjectSettingEntityRequest> requests) {
        return projectSettingRepository.updateBatch(requests);
    }

    @GetMapping("admin/project/setting/page")
    @Operation(summary = "根据查询条件分页")
    public Page<GetProjectSettingPageResponse> getPage(PageRequest pageRequest, GetProjectSettingPageRequest request) {
        return projectSettingRepository.getPage(pageRequest, request);
    }

    @PostMapping("admin/project/setting/list")
    @Operation(summary = "项目设置信息列表")
    public List<PostProjectSettingListResponse> postList(@RequestBody PostProjectSettingListRequest request) {
        return projectSettingRepository.list(request);
    }

    @GetMapping("admin/project/setting/entity")
    @Operation(summary = "获取项目设置详情")
    public GetProjectSettingEntityResponse getEntity(GetProjectSettingEntityRequest request) {
        return projectSettingRepository.getById(request);
    }

    @DeleteMapping("admin/project/setting/entity")
    @Operation(summary = "批量删除项目设置")
    public List<PostProjectSettingEntityResponse> deleteEntity(@RequestBody List<DeleteProjectSettingEntityRequest> requests) {
        return projectSettingRepository.removeById(requests);
    }

}
