package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "PutProjectAttachmentEntityRequest 对象")
public class PutProjectAttachmentEntityRequest {

    @Schema(description = "项目附件ID")
    private Long projectAttachmentId;

    @Schema(description = "文档标题")
    private String docTitle;

    @Schema(description = "文档描述")
    private String description;

    @Schema(description = "存储器编码[db|local|cos|oss|s3..]")
    private String ossCode;

    @Schema(description = "文档链接地址")
    private String docLink;

    @Schema(description = "md5")
    private String md5;

    @Schema(description = "格式[txt,doc,pdf]")
    private String format;

    @Schema(description = "文档类型[0:需求，1:汇报[日|周|月|年],2.....]")
    private Integer docType;

    @Schema(description = "版本号")
    private Integer revision;

}

