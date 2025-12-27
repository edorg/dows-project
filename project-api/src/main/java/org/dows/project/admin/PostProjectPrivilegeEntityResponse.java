package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "PostProjectPrivilegeEntityResponse 对象")
public class PostProjectPrivilegeEntityResponse {

    @Schema(description = "项目权限ID")
    private Long projectPrivilegeId;

}