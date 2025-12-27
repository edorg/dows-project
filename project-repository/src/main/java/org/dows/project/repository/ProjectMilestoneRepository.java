package org.dows.project.repository;

import org.dows.rade.crud.CrudRepository;
import org.springframework.stereotype.Component;

import org.dows.project.entity.ProjectMilestoneEntity;
import org.dows.project.dao.ProjectMilestoneDao;

@Component
public class ProjectMilestoneRepository  extends CrudRepository<ProjectMilestoneDao,ProjectMilestoneEntity> {

}