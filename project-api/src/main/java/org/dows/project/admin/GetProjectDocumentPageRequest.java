package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;


import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectDocumentPageRequest 对象")
public class GetProjectDocumentPageRequest {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "账号ID")
    private Long accountInstanceId;

    @Schema(description = "项目源表ID")
    private Long projectSourceId;

    @Schema(description = "项目源表(表名)[demand,document,task...]")
    private String projectSource;

    @Schema(description = "存储器编码[db|local|cos|oss...]")
    private String ossCode;

    @Schema(description = "文档标题")
    private String docTitle;

    @Schema(description = "文档类型[0:需求，1:汇报[日|周|月|年],2.....]")
    private Integer docType;

}