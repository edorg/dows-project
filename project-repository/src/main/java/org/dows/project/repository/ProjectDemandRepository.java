package org.dows.project.repository;

import org.dows.rade.crud.CrudRepository;
import org.springframework.stereotype.Component;

import org.dows.project.entity.ProjectDemandEntity;
import org.dows.project.dao.ProjectDemandDao;

@Component
public class ProjectDemandRepository  extends CrudRepository<ProjectDemandDao,ProjectDemandEntity> {

}