package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectAttachmentListRequest 对象")
public class GetProjectAttachmentListRequest {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "项目源表ID")
    private Long projectSourceId;

    @Schema(description = "项目源表(表名)[demand,document,task...]")
    private String projectSource;

    @Schema(description = "文档类型[0:需求，1:汇报[日|周|月|年],2.....]")
    private Integer docType;

}

