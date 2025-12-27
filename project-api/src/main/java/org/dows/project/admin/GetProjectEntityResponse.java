package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectEntityResponse 对象")
public class GetProjectEntityResponse {

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

    @Schema(description = "可见范围(项目成员，全公司)")
    private Integer scope;

    @Schema(description = "项目开始时间")
    private Object startTime;

    @Schema(description = "项目截止时间")
    private Object endTime;

    @Schema(description = "应用id")
    private String app_id;

    @Schema(description = "时间戳")
    private Object createTime;

    @Schema(description = "更新时间")
    private Object updateTime;

    @Schema(description = "删除时间")
    private Object deleteTime;

    @Schema(description = "创建者ID")
    private Long createId;

    @Schema(description = "更新者ID")
    private Long updateId;

}