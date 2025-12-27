package org.dows.project.entity;

import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dows.rade.crud.CrudEntity;

import java.time.LocalDateTime;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@Table("project_ops")
public class ProjectOpsEntity extends CrudEntity<ProjectOpsEntity> {

    @Schema(title = "项目运维ID")
    private Long projectOpsId;
    @Schema(title = "项目ID")
    private Long projectInstanceId;
    @Schema(title = "脚本")
    private String script;
    @Schema(title = "脚本名称[mvn-build,mvn-deploy,docker-build]")
    private String scriptName;
    @Schema(title = "阶段")
    private Integer stage;
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