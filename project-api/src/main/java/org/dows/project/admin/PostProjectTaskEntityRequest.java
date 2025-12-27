package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "PostProjectTaskEntityRequest 对象")
public class PostProjectTaskEntityRequest {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "项目需求ID")
    private Long ProjectDemandId;

    @Schema(description = "项目里程碑ID")
    private Long projectMilestoneId;

    @Schema(description = "预算成本")
    private Object budget;

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

}