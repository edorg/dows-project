package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "PostProjectAttachmentEntityResponse 对象")
public class PostProjectAttachmentEntityResponse {

    @Schema(description = "项目附件ID")
    private Long projectAttachmentId;

}

