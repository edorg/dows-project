package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectSettingPageResponse 对象")
public class GetProjectSettingPageResponse {

    @Schema(description = "项目设置ID")
    private Long projectSettingId;

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "设置key")
    private String settingKey;

    @Schema(description = "设置json值")
    private String settingJson;

}

