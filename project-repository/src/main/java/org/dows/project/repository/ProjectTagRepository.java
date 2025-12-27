package org.dows.project.repository;

import org.dows.rade.crud.CrudRepository;
import org.springframework.stereotype.Component;

import org.dows.project.entity.ProjectTagEntity;
import org.dows.project.dao.ProjectTagDao;

@Component
public class ProjectTagRepository  extends CrudRepository<ProjectTagDao,ProjectTagEntity> {

}