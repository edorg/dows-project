package org.dows.project.repository;

import org.dows.rade.crud.CrudRepository;
import org.springframework.stereotype.Component;

import org.dows.project.entity.ProjectRepositoryEntity;
import org.dows.project.dao.ProjectRepositoryDao;

@Component
public class ProjectRepositoryRepository  extends CrudRepository<ProjectRepositoryDao,ProjectRepositoryEntity> {

}