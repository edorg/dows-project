package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "PostProjectDocumentEntityResponse 对象")
public class PostProjectDocumentEntityResponse {

    @Schema(description = "项目文档ID")
    private Long projectDocumentId;

}