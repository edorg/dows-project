package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectRepoEntityRequest 对象")
public class GetProjectRepoEntityRequest {

    @Schema(description = "项目仓库ID")
    private Long projectRepositoryId;

}

