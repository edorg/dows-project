package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectOpsListRequest 对象")
public class GetProjectOpsListRequest {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

}

