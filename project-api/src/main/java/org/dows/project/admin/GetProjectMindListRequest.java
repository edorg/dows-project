package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectMindListRequest 对象")
public class GetProjectMindListRequest {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

}

