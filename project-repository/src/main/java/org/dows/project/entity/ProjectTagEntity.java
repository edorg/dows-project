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
@Table("project_tag")
public class ProjectTagEntity extends CrudEntity<ProjectTagEntity> {
    @Id(keyType = KeyType.Generator, value = KeyGenerators.snowFlakeId)
    @Schema(title = "项目标签ID")
    private Long projectTagId;
    @Schema(title = "项目ID")
    private Long projectInstanceId;
    @Schema(title = "标签名称")
    private String tagName;
    @Schema(title = "标签颜色")
    private String tagColor;
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