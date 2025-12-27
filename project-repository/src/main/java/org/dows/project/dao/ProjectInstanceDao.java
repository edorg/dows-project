package org.dows.project.dao;

import org.dows.rade.crud.CrudDaoImpl;
import org.springframework.stereotype.Component;
import org.dows.project.entity.ProjectInstanceEntity;
import org.dows.project.mapper.ProjectInstanceMapper;

@Component
public class ProjectInstanceDao extends CrudDaoImpl<ProjectInstanceMapper,ProjectInstanceEntity>{

}