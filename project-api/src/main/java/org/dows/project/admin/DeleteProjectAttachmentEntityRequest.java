package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "DeleteProjectAttachmentEntityRequest 对象")
public class DeleteProjectAttachmentEntityRequest {

    @Schema(description = "项目附件ID")
    private Long projectAttachmentId;

}

