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
@Schema(description = "GetProjectTaskPageResponse 对象")
public class GetProjectTaskPageResponse {

    @Schema(description = "项目任务ID")
    private Long projectTaskId;

    @Schema(description = "项目里程碑ID")
    private Long projectMilestoneId;

    @Schema(description = "项目需求ID")
    private Long ProjectDemandId;

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "预算成本")
    private BigDecimal budget;

    @Schema(description = "任务标题")
    private String taskTitle;

    @Schema(description = "提示")
    private String prompt;

    @Schema(description = "进度")
    private Integer progress;

    @Schema(description = "步骤")
    private Integer step;

    @Schema(description = "难度系数")
    private Integer factor;

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