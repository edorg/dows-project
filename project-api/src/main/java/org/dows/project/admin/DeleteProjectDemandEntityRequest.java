package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;


import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "DeleteProjectDemandEntityRequest 对象")
public class DeleteProjectDemandEntityRequest {

    @Schema(description = "项目需求ID")
    private Long ProjectDemandId;

}