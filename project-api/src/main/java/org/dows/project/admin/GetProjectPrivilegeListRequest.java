package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectPrivilegeListRequest 对象")
public class GetProjectPrivilegeListRequest {

    @Schema(description = "项目资源ID")
    private Long projectResourceId;

    @Schema(description = "项目资源(表名)[all,document,task...]")
    private String projectResource;

}