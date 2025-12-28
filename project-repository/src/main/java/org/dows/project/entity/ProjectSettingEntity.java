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
@Table("project_setting")
public class ProjectSettingEntity extends CrudEntity<ProjectSettingEntity> {
    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    @Schema(title = "项目设置ID")
    private Long projectSettingId;
    @Schema(title = "项目ID")
    private Long projectInstanceId;
    @Schema(title = "项目源表ID")
    private Long projectSourceId;
    @Schema(title = "项目源表(表名)[demand,document,task...]")
    private String projectSource;
    @Schema(title = "设置key[如gitlab,mysl.report[0:日报，1:周报，2:月报，3：季度报，4，年报...]，cron表达式,..]")
    private String settingKey;
    @Schema(title = "设置json值")
    private String settingJson;
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