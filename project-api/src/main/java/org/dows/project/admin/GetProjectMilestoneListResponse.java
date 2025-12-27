package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectMilestoneListResponse 对象")
public class GetProjectMilestoneListResponse {

    @Schema(description = "项目里程碑ID")
    private Long projectMilestoneId;

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "里程碑名称")
    private String milestoneName;

    @Schema(description = "里程碑描述")
    private String description;

    @Schema(description = "阶段预算")
    private BigDecimal phaseBudget;

    @Schema(description = "阶段成本")
    private BigDecimal phaseCost;

    @Schema(description = "时间单位 [Year，Month，Day，Hour]")
    private String timeUnit;

    @Schema(description = "相对时间长")
    private Integer duration;

    @Schema(description = "开始时间")
    private LocalDateTime startTime;

    @Schema(description = "结束时间")
    private LocalDateTime endTime;

    @Schema(description = "版本号")
    private Integer revision;

    @Schema(description = "应用id")
    private String app_id;

    @Schema(description = "时间戳")
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