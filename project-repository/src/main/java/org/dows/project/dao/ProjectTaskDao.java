package org.dows.project.dao;

import org.dows.rade.crud.CrudDaoImpl;
import org.springframework.stereotype.Component;
import org.dows.project.entity.ProjectTaskEntity;
import org.dows.project.mapper.ProjectTaskMapper;

@Component
public class ProjectTaskDao extends CrudDaoImpl<ProjectTaskMapper,ProjectTaskEntity>{

}