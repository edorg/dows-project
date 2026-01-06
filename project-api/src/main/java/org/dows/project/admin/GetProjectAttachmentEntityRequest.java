package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectAttachmentEntityRequest 对象")
public class GetProjectAttachmentEntityRequest {

    @Schema(description = "项目附件ID")
    private Long projectAttachmentId;

}

