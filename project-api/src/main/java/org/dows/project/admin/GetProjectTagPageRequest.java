package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectTagPageRequest 对象")
public class GetProjectTagPageRequest {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "标签名称")
    private String tagName;

}

