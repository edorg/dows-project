package org.dows.project.dao;

import org.dows.rade.crud.CrudDaoImpl;
import org.springframework.stereotype.Component;
import org.dows.project.entity.ProjectMemberEntity;
import org.dows.project.mapper.ProjectMemberMapper;

@Component
public class ProjectMemberDao extends CrudDaoImpl<ProjectMemberMapper,ProjectMemberEntity>{

}