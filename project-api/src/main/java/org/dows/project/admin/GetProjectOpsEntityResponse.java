package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectOpsEntityResponse 对象")
public class GetProjectOpsEntityResponse {

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

    @Schema(description = "应用id")
    private String appId;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "删除时间")
    private LocalDateTime deleteTime;

    @Schema(description = "创建者ID")
    private Long createId;

    @Schema(description = "更新者ID")
    private Long updateId;

}

