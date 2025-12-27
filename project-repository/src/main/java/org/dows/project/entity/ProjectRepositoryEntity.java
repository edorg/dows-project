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
@Table("project_repository")
public class ProjectRepositoryEntity extends CrudEntity<ProjectRepositoryEntity> {

    @Schema(title = "项目仓库ID")
    private Long projectRepositoryId;
    @Schema(title = "项目ID")
    private Long projectInstanceId;
    @Schema(title = "仓库地址")
    private String gitUrl;
    @Schema(title = "仓库http地址")
    private String httpUrl;
    @Schema(title = "仓库token")
    private String token;
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