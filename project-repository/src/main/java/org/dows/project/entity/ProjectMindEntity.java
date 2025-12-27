package org.dows.project.entity;

import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dows.rade.crud.CrudEntity;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Table("project_mind")
public class ProjectMindEntity extends CrudEntity<ProjectMindEntity> {

    @Schema(title = "项目脑图ID")
    private Long projectMindId;
    @Schema(title = "项目ID")
    private Long projectInstanceId;
    @Schema(title = "脑图地址")
    private String mindUrl;
    @Schema(title = "脑图版本号")
    private String mindVersion;
    @Schema(title = "json配置")
    private String mindJson;
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