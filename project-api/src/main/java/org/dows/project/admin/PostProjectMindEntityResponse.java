package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "PostProjectMindEntityResponse 对象")
public class PostProjectMindEntityResponse {

    @Schema(description = "项目脑图ID")
    private Long projectMindId;

}

