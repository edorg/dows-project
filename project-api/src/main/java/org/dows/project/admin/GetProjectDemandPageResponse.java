package org.dows.project.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;


import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "GetProjectDemandPageResponse 对象")
public class GetProjectDemandPageResponse {

    @Schema(description = "项目ID")
    private Long projectInstanceId;

    @Schema(description = "项目需求ID")
    private Long ProjectDemandId;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "文档链接")
    private String docLink;

    @Schema(description = "对象存储码[db,local,cos,oss,qiuniu...]")
    private String ossCode;

    @Schema(description = "需求描述文档")
    private String docment;

    @Schema(description = "优先级")
    private Integer priority;

    @Schema(description = "价值")
    private Integer worth;

}