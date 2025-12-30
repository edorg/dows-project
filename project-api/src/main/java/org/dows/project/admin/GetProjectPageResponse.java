package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectPageResponse 对象")
public class GetProjectPageResponse {

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
    private LocalDateTime startTime;

    @Schema(description = "项目截止时间")
    private LocalDateTime endTime;

}