package org.dows.project.dao;

import org.dows.rade.crud.CrudDaoImpl;
import org.springframework.stereotype.Component;
import org.dows.project.entity.ProjectMindEntity;
import org.dows.project.mapper.ProjectMindMapper;

@Component
public class ProjectMindDao extends CrudDaoImpl<ProjectMindMapper,ProjectMindEntity>{

}