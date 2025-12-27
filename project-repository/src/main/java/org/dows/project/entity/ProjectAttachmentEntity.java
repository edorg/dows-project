package org.dows.project.entity;

import com.mybatisflex.annotation.Table;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dows.rade.crud.CrudEntity;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Table("project_attachment")
public class ProjectAttachmentEntity extends CrudEntity<ProjectAttachmentEntity> {

    @Schema(title = "项目附件ID")
    private Long projectAttachmentId;
    @Schema(title = "项目ID")
    private Long projectInstanceId;
    @Schema(title = "账号ID")
    private Long accountInstanceId;
    @Schema(title = "项目源表ID")
    private Long projectSourceId;
    @Schema(title = "项目源表(表名)[demand,document,task...]")
    private String projectSource;
    @Schema(title = "文档标题")
    private String docTitle;
    @Schema(title = "文档描述")
    private String description;
    @Schema(title = "存储器编码[db|local|cos|oss|s3..]")
    private String ossCode;
    @Schema(title = "文档链接地址")
    private String docLink;
    @Schema(title = "md5")
    private String md5;
    @Schema(title = "格式[txt,doc,pdf]")
    private String format;
    @Schema(title = "文档类容")
    private Object content;
    @Schema(title = "文档类型[0:需求，1:汇报[日|周|月|年],2.....]")
    private Integer docType;
    @Schema(title = "版本号")
    private Integer revision;
    @Schema(title = "应用id")
    private String appId;
    @Schema(title = "时间戳")
    private LocalDateTime createTime;
    @Schema(title = "更新时间")
    private LocalDateTime updateTime;
    @Schema(title = "删除时间")
    private LocalDateTime deleteTime;
    @Schema(title = "创建者ID")
    private Long createId;
    @Schema(title = "更新者ID")
    private Long updateId;
}