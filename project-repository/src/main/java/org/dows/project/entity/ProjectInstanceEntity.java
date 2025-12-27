package org.dows.project.entity;

import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dows.rade.crud.CrudEntity;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Table("project_instance")
public class ProjectInstanceEntity extends CrudEntity<ProjectInstanceEntity> {

    @Schema(title = "项目ID")
    private Long projectInstanceId;
    @Schema(title = "项目名")
    private String projectName;
    @Schema(title = "项目code")
    private String projectCode;
    @Schema(title = "项目描述")
    private String description;
    @Schema(title = "项目icon")
    private String icon;
    @Schema(title = "可见范围(0:成员可见，1:组织可见,2...)")
    private Integer scope;
    @Schema(title = "项目开始时间")
    private LocalDateTime startTime;
    @Schema(title = "项目截止时间")
    private LocalDateTime endTime;
    @Schema(title = "预算成本")
    private Object budget;
    @Schema(title = "实际成本")
    private Object cost;
    @Schema(title = "奖金")
    private Object bonus;
    @Schema(title = "项目进度")
    private Integer progress;
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