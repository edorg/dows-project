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
@Table("project_demand")
public class ProjectDemandEntity extends CrudEntity<ProjectDemandEntity> {

    @Schema(title = "项目需求ID")
    private Long projectDemandId;
    @Schema(title = "项目ID")
    private Long projectInstanceId;
    @Schema(title = "提出者ID")
    private Long accountInstanceId;
    @Schema(title = "昵称")
    private String nickname;
    @Schema(title = "文档链接")
    private String docLink;
    @Schema(title = "对象存储码[db,local,cos,oss,qiuniu...]")
    private String ossCode;
    @Schema(title = "需求描述文档")
    private Object content;
    @Schema(title = "优先级")
    private Integer priority;
    @Schema(title = "价值")
    private Integer worth;
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