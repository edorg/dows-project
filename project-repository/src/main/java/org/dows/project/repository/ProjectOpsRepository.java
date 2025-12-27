package org.dows.project.repository;

import org.dows.rade.crud.CrudRepository;
import org.springframework.stereotype.Component;

import org.dows.project.entity.ProjectOpsEntity;
import org.dows.project.dao.ProjectOpsDao;

@Component
public class ProjectOpsRepository  extends CrudRepository<ProjectOpsDao,ProjectOpsEntity> {

}