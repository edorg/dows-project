package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "PostProjectMemberRequest 对象")
public class PostProjectMemberRequest {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "成员账号ID")
    private Long accountInstanceId;

    @Schema(description = "成员用户ID")
    private Long userInstanceId;

    @Schema(description = "账号昵称")
    private String nickname;

    @Schema(description = "参与者角色[h5，java，test...]")
    private String memberRole;

}