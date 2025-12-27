package org.dows.project.entity;

import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dows.rade.crud.CrudEntity;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Table("project_kanban")
public class ProjectKanbanEntity extends CrudEntity<ProjectKanbanEntity> {

    @Schema(title = "项目看板Id")
    private Long projectKanbanId;
    @Schema(title = "项目ID")
    private Long projectInstanceId;
    @Schema(title = "项目流程ID")
    private Long projectFlowId;
    @Schema(title = "成员账号ID")
    private Long accountInstanceId;
    @Schema(title = "账号昵称")
    private String nickname;
    @Schema(title = "个人奖金百分比")
    private Object personalBonusPercent;
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