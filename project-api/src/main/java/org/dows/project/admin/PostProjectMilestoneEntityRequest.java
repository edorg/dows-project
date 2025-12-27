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
@Schema(description = "PostProjectMilestoneEntityRequest 对象")
public class PostProjectMilestoneEntityRequest {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "里程碑名称")
    private String milestoneName;

    @Schema(description = "里程碑描述")
    private String description;

    @Schema(description = "时间单位 [Year，Month，Day，Hour]")
    private String timeUnit;

    @Schema(description = "相对时间长")
    private Integer duration;

}