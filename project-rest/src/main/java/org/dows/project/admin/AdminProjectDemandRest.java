package org.dows.project.admin;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.dows.project.entity.ProjectDemandEntity;
import org.dows.project.repository.ProjectDemandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Tag(name = "AdminProjectDemandRest", description = "项目需求")
@RestController
public class AdminProjectDemandRest {

    private final ProjectDemandRepository projectDemandRepository;

    @PostMapping("admin/project/demand/entity")
    @Operation(summary = "创建")
    public void postEntity(@RequestBody List<PostProjectDemandEntityRequest> postProjectDemandEntityRequest) {
        projectDemandRepository.saveBatch(postProjectDemandEntityRequest);
    }

    @PutMapping("admin/project/demand/entity")
    @Operation(summary = "更新")
    public void putEntity(@RequestBody List<PutProjectDemandEntityRequest> putProjectDemandEntityRequest) {
        projectDemandRepository.updateBatch(putProjectDemandEntityRequest);
    }

    @GetMapping("admin/project/demand/list")
    @Operation(summary = "查询项目需求")
    public GetProjectDemandListResponse getList(GetProjectDemandListRequest getProjectDemandListRequest) {
        return null;
    }

    @GetMapping("admin/project/demand/page")
    @Operation(summary = "项目需求分页")
    public Page<GetProjectDemandPageResponse> getPage(GetProjectDemandPageRequest getProjectDemandPageRequest) {
        Page<GetProjectDemandPageResponse> objectPage = Page.of(1, 10, 20);
        objectPage.setRecords(projectDemandRepository
                .listAs(QueryWrapper.create().from(ProjectDemandEntity.class), GetProjectDemandPageResponse.class));
        return objectPage;
    }

    @GetMapping("admin/project/demand/entity")
    @Operation(summary = "详情")
    public GetProjectDemandEntityResponse getEntity(GetProjectDemandEntityRequest getProjectDemandEntityRequest) {
        return null;
    }

    @DeleteMapping("admin/project/demand/entity")
    @Operation(summary = "删除")
    public void deleteEntity(@RequestBody DeleteProjectDemandEntityRequest deleteProjectDemandEntityRequest) {

    }

}