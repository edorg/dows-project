package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "DeleteProjectRepoEntityRequest 对象")
public class DeleteProjectRepoEntityRequest {

    @Schema(description = "项目仓库ID")
    private Long projectRepositoryId;

}

