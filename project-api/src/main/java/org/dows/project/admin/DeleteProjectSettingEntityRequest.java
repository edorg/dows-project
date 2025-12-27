package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;


import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "DeleteProjectSettingEntityRequest 对象")
public class DeleteProjectSettingEntityRequest {

    @Schema(description = "项目设置ID")
    private Long projectSettingId;

}