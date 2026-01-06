package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectMindListResponse 对象")
public class GetProjectMindListResponse {

    @Schema(description = "项目脑图ID")
    private Long projectMindId;

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "脑图地址")
    private String mindUrl;

    @Schema(description = "脑图版本号")
    private String mindVersion;

}

