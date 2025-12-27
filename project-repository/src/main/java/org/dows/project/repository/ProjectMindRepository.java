package org.dows.project.repository;

import org.dows.rade.crud.CrudRepository;
import org.springframework.stereotype.Component;

import org.dows.project.entity.ProjectMindEntity;
import org.dows.project.dao.ProjectMindDao;

@Component
public class ProjectMindRepository  extends CrudRepository<ProjectMindDao,ProjectMindEntity> {

}