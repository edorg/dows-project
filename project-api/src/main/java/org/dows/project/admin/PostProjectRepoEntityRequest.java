package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "PostProjectRepoEntityRequest 对象")
public class PostProjectRepoEntityRequest {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "仓库地址")
    private String gitUrl;

    @Schema(description = "仓库http地址")
    private String httpUrl;

    @Schema(description = "仓库token")
    private String token;

}

