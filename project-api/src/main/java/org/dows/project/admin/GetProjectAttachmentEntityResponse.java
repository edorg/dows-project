package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectAttachmentEntityResponse 对象")
public class GetProjectAttachmentEntityResponse {

    @Schema(description = "项目附件ID")
    private Long projectAttachmentId;

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "账号ID")
    private Long accountInstanceId;

    @Schema(description = "项目源表ID")
    private Long projectSourceId;

    @Schema(description = "项目源表(表名)[demand,document,task...]")
    private String projectSource;

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

    @Schema(description = "应用id")
    private String appId;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "删除时间")
    private LocalDateTime deleteTime;

    @Schema(description = "创建者ID")
    private Long createId;

    @Schema(description = "更新者ID")
    private Long updateId;

}

