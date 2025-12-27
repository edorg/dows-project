package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectMemberEntityRequest 对象")
public class GetProjectMemberEntityRequest {

    @Schema(description = "项目成员ID")
    private Long ProjectMemberId;

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "成员账号ID")
    private Long accountInstanceId;

}