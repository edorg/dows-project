package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectRepoListRequest 对象")
public class GetProjectRepoListRequest {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

}

