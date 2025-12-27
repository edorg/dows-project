package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectPageRequest 对象")
public class GetProjectPageRequest {

    @Schema(description = "项目名")
    private String name;

    @Schema(description = "项目code")
    private String code;

    @Schema(description = "开始时间")
    private Object startTime;

    @Schema(description = "截止时间")
    private Object endTime;

}