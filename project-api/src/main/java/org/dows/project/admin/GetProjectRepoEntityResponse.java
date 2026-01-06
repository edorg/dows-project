package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectRepoEntityResponse 对象")
public class GetProjectRepoEntityResponse {

    @Schema(description = "项目仓库ID")
    private Long projectRepositoryId;

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "仓库地址")
    private String gitUrl;

    @Schema(description = "仓库http地址")
    private String httpUrl;

    @Schema(description = "仓库token")
    private String token;

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

