package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectTagListRequest 对象")
public class GetProjectTagListRequest {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "标签名称")
    private String tagName;

}