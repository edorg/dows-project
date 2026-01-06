package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "PostProjectOpsEntityRequest 对象")
public class PostProjectOpsEntityRequest {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "脚本")
    private String script;

    @Schema(description = "脚本名称[mvn-build,mvn-deploy,docker-build]")
    private String scriptName;

    @Schema(description = "阶段")
    private Integer stage;

}

