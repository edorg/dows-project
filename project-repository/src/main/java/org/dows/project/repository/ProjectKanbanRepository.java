package org.dows.project.repository;

import org.dows.rade.crud.CrudRepository;
import org.springframework.stereotype.Component;

import org.dows.project.entity.ProjectKanbanEntity;
import org.dows.project.dao.ProjectKanbanDao;

@Component
public class ProjectKanbanRepository  extends CrudRepository<ProjectKanbanDao,ProjectKanbanEntity> {

}