package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectOpsEntityRequest 对象")
public class GetProjectOpsEntityRequest {

    @Schema(description = "项目运维ID")
    private Long projectOpsId;

}

