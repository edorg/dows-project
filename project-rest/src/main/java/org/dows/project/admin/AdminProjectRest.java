package org.dows.project.admin;

import com.mybatisflex.core.paginate.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.dows.rade.crud.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.dows.project.repository.ProjectInstanceRepository;

import java.util.List;

@RequiredArgsConstructor
@Tag(name = "AdminProjectRest", description = "项目实例接口")
@RestController
public class AdminProjectRest{

    private final ProjectInstanceRepository projectInstanceRepository;

    @PostMapping("admin/project/entity")
    @Operation(summary = "批量创建项目实例")
    public List<PostProjectEntityResponse> postEntity(@RequestBody List<PostProjectEntityRequest> requests){
        return projectInstanceRepository.saveBatch(requests);
    }

    @PutMapping("admin/project/entity")
    @Operation(summary = "批量更新项目实例")
    public List<PostProjectEntityResponse> putEntity(@RequestBody List<PutProjectEntityRequest> requests){
        return projectInstanceRepository.updateBatch(requests);
    }

    @GetMapping("admin/project/page")
    @Operation(summary = "根据查询条件分页")
    public Page<GetProjectPageResponse> getPage(PageRequest pageRequest, GetProjectPageRequest request){
        return projectInstanceRepository.getPage(pageRequest, request);
    }

    @GetMapping("admin/project/entity")
    @Operation(summary = "获取项目实例详情")
    public GetProjectEntityResponse getEntity(GetProjectEntityRequest request){
        return projectInstanceRepository.getById(request);
    }

    @DeleteMapping("admin/project/entity")
    @Operation(summary = "批量删除项目实例")
    public List<PostProjectEntityResponse> deleteEntity(@RequestBody List<DeleteProjectEntityRequest> requests){
        return projectInstanceRepository.removeById(requests);
    }

    @PostMapping("admin/project/member")
    @Operation(summary = "增加项目成员")
    public PostProjectMemberResponse postMember(@RequestBody PostProjectMemberRequest request){
        return null;
    }

    @GetMapping("admin/project/member")
    @Operation(summary = "项目成员列表")
    public GetProjectMemberResponse getMember(GetProjectMemberRequest request){
        return null;
    }

    @DeleteMapping("admin/project/member")
    @Operation(summary = "删除项目成员")
    public void deleteMember(@RequestBody DeleteProjectMemberRequest request){
        
    }
}