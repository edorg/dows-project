package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "PutProjectMilestoneEntityRequest 对象")
public class PutProjectMilestoneEntityRequest {

    @Schema(description = "项目里程碑ID")
    private Long projectMilestoneId;

    @Schema(description = "里程碑名称")
    private String milestoneName;

    @Schema(description = "里程碑描述")
    private String description;

    @Schema(description = "阶段预算")
    private Object phaseBudget;

    @Schema(description = "阶段成本")
    private Object phaseCost;

    @Schema(description = "时间单位 [Year，Month，Day，Hour]")
    private String timeUnit;

    @Schema(description = "相对时间长")
    private Integer duration;

    @Schema(description = "开始时间")
    private Object startTime;

    @Schema(description = "结束时间")
    private Object endTime;

}