package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "PutProjectRepoEntityRequest 对象")
public class PutProjectRepoEntityRequest {

    @Schema(description = "项目仓库ID")
    private Long projectRepositoryId;

    @Schema(description = "仓库地址")
    private String gitUrl;

    @Schema(description = "仓库http地址")
    private String httpUrl;

    @Schema(description = "仓库token")
    private String token;

    @Schema(description = "版本号")
    private Integer revision;

}

