package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;


import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "PostProjectSettingEntityRequest 对象")
public class PostProjectSettingEntityRequest {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "设置key[如gitlab,mysl.report[0:日报，1:周报，2:月报，3：季度报，4，年报...]cron表达式,..]")
    private String settingKey;

    @Schema(description = "设置的详情")
    private String settingJson;

}