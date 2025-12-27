package org.dows.project.entity;

import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dows.rade.crud.CrudEntity;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Table("project_flow")
public class ProjectFlowEntity extends CrudEntity<ProjectFlowEntity> {

    @Schema(title = "项目流程ID")
    private Long projectFlowId;
    @Schema(title = "项目ID")
    private Long projectInstanceId;
    @Schema(title = "阶段名称[一周任ddf务，待测试，待修复，待验收，已完成]")
    private String stageName;
    @Schema(title = "阶段序列[0:一周任务，1:待测试，2:待修复，3:待验收，4:已完成]")
    private Integer seq;
    @Schema(title = "流程奖金百分比")
    private Object flowBonusPercent;
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