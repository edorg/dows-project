package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;


import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "PutProjectFlowEntityRequest 对象")
public class PutProjectFlowEntityRequest {

    @Schema(description = "项目流程看板ID")
    private Long projectFlowId;

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "阶段名称[一周任ddf务，待测试，待修复，待验收，已完成]")
    private String stageName;

    @Schema(description = "阶段序列[0:一周任务，1:待测试，2:待修复，3:待验收，4:已完成]")
    private Integer sequence;

}