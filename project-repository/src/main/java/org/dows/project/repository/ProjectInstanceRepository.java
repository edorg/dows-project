package org.dows.project.repository;

import org.dows.rade.crud.CrudRepository;
import org.springframework.stereotype.Component;

import org.dows.project.entity.ProjectInstanceEntity;
import org.dows.project.dao.ProjectInstanceDao;

@Component
public class ProjectInstanceRepository  extends CrudRepository<ProjectInstanceDao,ProjectInstanceEntity> {

}