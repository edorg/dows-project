package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "PostProjectRepoEntityResponse 对象")
public class PostProjectRepoEntityResponse {

    @Schema(description = "项目仓库ID")
    private Long projectRepositoryId;

}

