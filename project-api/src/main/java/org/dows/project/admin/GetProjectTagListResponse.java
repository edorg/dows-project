package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectTagListResponse 对象")
public class GetProjectTagListResponse {

    @Schema(description = "项目标签ID")
    private Long projectTagId;

    @Schema(description = "标签名称")
    private String tagName;

    @Schema(description = "标签颜色")
    private String tagColor;

}