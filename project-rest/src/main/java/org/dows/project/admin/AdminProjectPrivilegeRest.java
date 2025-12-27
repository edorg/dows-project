package org.dows.project.admin;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.dows.project.admin.PostProjectPrivilegeEntityResponse;
import org.dows.project.admin.GetProjectPrivilegeListRequest;
import org.dows.project.admin.GetProjectPrivilegePageRequest;
import org.dows.project.admin.PutProjectPrivilegeEntityResponse;

@RequiredArgsConstructor
@Tag(name = "AdminProjectPrivilegeRest", description = "项目授权")
@RestController
public class AdminProjectPrivilegeRest{

}