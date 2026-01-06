package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "PutProjectMindEntityRequest 对象")
public class PutProjectMindEntityRequest {

    @Schema(description = "项目脑图ID")
    private Long projectMindId;

    @Schema(description = "脑图地址")
    private String mindUrl;

    @Schema(description = "脑图版本号")
    private String mindVersion;

    @Schema(description = "json配置")
    private String mindJson;

    @Schema(description = "版本号")
    private Integer revision;

}

