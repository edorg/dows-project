package org.dows.project.repository;

import org.dows.rade.crud.CrudRepository;
import org.springframework.stereotype.Component;

import org.dows.project.entity.ProjectFlowEntity;
import org.dows.project.dao.ProjectFlowDao;

@Component
public class ProjectFlowRepository  extends CrudRepository<ProjectFlowDao,ProjectFlowEntity> {

}