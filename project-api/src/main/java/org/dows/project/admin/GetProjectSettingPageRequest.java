package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectSettingPageRequest 对象")
public class GetProjectSettingPageRequest {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "设置key")
    private String settingKey;

}

