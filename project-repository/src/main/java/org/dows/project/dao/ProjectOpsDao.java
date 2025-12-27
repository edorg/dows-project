package org.dows.project.dao;

import org.dows.rade.crud.CrudDaoImpl;
import org.springframework.stereotype.Component;
import org.dows.project.entity.ProjectOpsEntity;
import org.dows.project.mapper.ProjectOpsMapper;

@Component
public class ProjectOpsDao extends CrudDaoImpl<ProjectOpsMapper,ProjectOpsEntity>{

}