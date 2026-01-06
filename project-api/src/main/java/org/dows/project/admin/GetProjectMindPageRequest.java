package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectMindPageRequest 对象")
public class GetProjectMindPageRequest {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "脑图地址")
    private String mindUrl;

}

