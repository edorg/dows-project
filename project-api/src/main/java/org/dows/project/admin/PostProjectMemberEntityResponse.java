package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;


import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "PostProjectMemberEntityResponse 对象")
public class PostProjectMemberEntityResponse {

    @Schema(description = "项目成员ID")
    private Long ProjectMemberId;

}