package org.dows.project.dao;

import org.dows.rade.crud.CrudDaoImpl;
import org.springframework.stereotype.Component;
import org.dows.project.entity.ProjectKanbanEntity;
import org.dows.project.mapper.ProjectKanbanMapper;

@Component
public class ProjectKanbanDao extends CrudDaoImpl<ProjectKanbanMapper,ProjectKanbanEntity>{

}