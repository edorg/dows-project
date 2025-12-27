package org.dows.project.dao;

import org.dows.rade.crud.CrudDaoImpl;
import org.springframework.stereotype.Component;
import org.dows.project.entity.ProjectFlowEntity;
import org.dows.project.mapper.ProjectFlowMapper;

@Component
public class ProjectFlowDao extends CrudDaoImpl<ProjectFlowMapper,ProjectFlowEntity>{

}