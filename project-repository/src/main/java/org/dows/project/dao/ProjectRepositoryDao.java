package org.dows.project.dao;

import org.dows.rade.crud.CrudDaoImpl;
import org.springframework.stereotype.Component;
import org.dows.project.entity.ProjectRepositoryEntity;
import org.dows.project.mapper.ProjectRepositoryMapper;

@Component
public class ProjectRepositoryDao extends CrudDaoImpl<ProjectRepositoryMapper,ProjectRepositoryEntity>{

}