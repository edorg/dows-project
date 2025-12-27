package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "PutProjectEntityRequest 对象")
public class PutProjectEntityRequest {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "项目名")
    private String projectName;

    @Schema(description = "项目code")
    private String projectCode;

    @Schema(description = "项目描述")
    private String description;

    @Schema(description = "项目icon")
    private String icon;

    @Schema(description = "可见范围(0:成员可见，1:组织可见,2...)")
    private Integer scope;

    @Schema(description = "项目开始时间")
    private LocalDateTime startTime;

    @Schema(description = "项目截止时间")
    private LocalDateTime endTime;

    @Schema(description = "版本号")
    private Integer revision;

    @Schema(description = "应用id")
    private String app_id;

    @Schema(description = "时间戳")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "删除时间")
    private LocalDateTime deleteTime;

    @Schema(description = "创建者ID")
    private Long createId;

    @Schema(description = "更新者ID")
    private Long updateId;

}