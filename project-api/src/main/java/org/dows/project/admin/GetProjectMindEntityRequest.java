package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectMindEntityRequest 对象")
public class GetProjectMindEntityRequest {

    @Schema(description = "项目脑图ID")
    private Long projectMindId;

}

