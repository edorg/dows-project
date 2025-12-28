package org.dows.project.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.core.keygen.KeyGenerators;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dows.rade.crud.CrudEntity;

import java.time.LocalDateTime;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@Table("project_milestone")
public class ProjectMilestoneEntity extends CrudEntity<ProjectMilestoneEntity> {
    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    @Schema(title = "项目里程碑ID")
    private Long projectMilestoneId;
    @Schema(title = "项目ID")
    private Long projectInstanceId;
    @Schema(title = "里程碑名称")
    private String milestoneName;
    @Schema(title = "里程碑描述")
    private String description;
    @Schema(title = "阶段预算")
    private Object phaseBudget;
    @Schema(title = "阶段成本")
    private Object phaseCost;
    @Schema(title = "时间单位 [Year，Month，Day，Hour]")
    private String timeUnit;
    @Schema(title = "相对时间长")
    private Integer duration;
    @Schema(title = "开始时间")
    private LocalDateTime startTime;
    @Schema(title = "结束时间")
    private LocalDateTime endTime;
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