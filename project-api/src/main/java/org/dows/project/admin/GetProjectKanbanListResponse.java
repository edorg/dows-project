package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectKanbanListResponse 对象")
public class GetProjectKanbanListResponse {

    @Schema(description = "项目看板Id")
    private Long projectKanbanId;

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

    @Schema(description = "任务数")
    private Integer taskCount;

}