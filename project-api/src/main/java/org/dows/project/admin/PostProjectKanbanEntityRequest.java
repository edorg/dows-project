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
@Schema(description = "PostProjectKanbanEntityRequest 对象")
public class PostProjectKanbanEntityRequest {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "项目流程ID")
    private Long projectFlowId;

    @Schema(description = "项目任务ID")
    private Long projectTaskId;

    @Schema(description = "成员账号ID")
    private Long accountInstanceId;

    @Schema(description = "账号昵称")
    private String nickname;

    @Schema(description = "任务进度")
    private Integer taskProgress;

}