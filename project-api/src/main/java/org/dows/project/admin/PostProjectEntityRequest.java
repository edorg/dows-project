package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "PostProjectEntityRequest 对象")
public class PostProjectEntityRequest {

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
    private Object startTime;

    @Schema(description = "项目截止时间")
    private Object endTime;

}