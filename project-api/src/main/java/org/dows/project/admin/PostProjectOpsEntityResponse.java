package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "PostProjectOpsEntityResponse 对象")
public class PostProjectOpsEntityResponse {

    @Schema(description = "项目运维ID")
    private Long projectOpsId;

}

