package org.dows.project.repository;

import org.dows.rade.crud.CrudRepository;
import org.springframework.stereotype.Component;

import org.dows.project.entity.ProjectTaskEntity;
import org.dows.project.dao.ProjectTaskDao;

@Component
public class ProjectTaskRepository  extends CrudRepository<ProjectTaskDao,ProjectTaskEntity> {

}