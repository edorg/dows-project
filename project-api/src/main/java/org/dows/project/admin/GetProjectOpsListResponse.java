package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectOpsListResponse 对象")
public class GetProjectOpsListResponse {

    @Schema(description = "项目运维ID")
    private Long projectOpsId;

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "脚本")
    private String script;

    @Schema(description = "脚本名称[mvn-build,mvn-deploy,docker-build]")
    private String scriptName;

    @Schema(description = "阶段")
    private Integer stage;

    @Schema(description = "版本号")
    private Integer revision;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

}

