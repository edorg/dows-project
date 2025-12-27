package org.dows.project.dao;

import org.dows.rade.crud.CrudDaoImpl;
import org.springframework.stereotype.Component;
import org.dows.project.entity.ProjectMilestoneEntity;
import org.dows.project.mapper.ProjectMilestoneMapper;

@Component
public class ProjectMilestoneDao extends CrudDaoImpl<ProjectMilestoneMapper,ProjectMilestoneEntity>{

}