package org.dows.project.entity;

import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dows.rade.crud.CrudEntity;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Table("project_task")
public class ProjectTaskEntity extends CrudEntity<ProjectTaskEntity> {

    @Schema(title = "项目任务ID")
    private Long projectTaskId;
    @Schema(title = "项目里程碑ID")
    private Long projectMilestoneId;
    @Schema(title = "项目需求ID")
    private Long projectDemandId;
    @Schema(title = "项目ID")
    private Long projectInstanceId;
    @Schema(title = "预算成本")
    private Object budget;
    @Schema(title = "任务标题")
    private String taskTitle;
    @Schema(title = "提示")
    private String prompt;
    @Schema(title = "进度")
    private Integer progress;
    @Schema(title = "步骤")
    private Integer step;
    @Schema(title = "优先级")
    private Integer priority;
    @Schema(title = "难度系数")
    private Integer factor;
    @Schema(title = "版本号")
    private Integer revision;
    @Schema(title = "应用id")
    private String appId;
    @Schema(title = "时间戳")
    private LocalDateTime createTime;
    @Schema(title = "更新时间")
    private LocalDateTime updateTime;
    @Schema(title = "删除时间")
    private LocalDateTime deleteTime;
    @Schema(title = "创建者ID")
    private Long createId;
    @Schema(title = "更新者ID")
    private Long updateId;
}