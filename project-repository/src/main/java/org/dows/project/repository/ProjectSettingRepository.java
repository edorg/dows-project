package org.dows.project.repository;

import org.dows.rade.crud.CrudRepository;
import org.springframework.stereotype.Component;

import org.dows.project.entity.ProjectSettingEntity;
import org.dows.project.dao.ProjectSettingDao;

@Component
public class ProjectSettingRepository  extends CrudRepository<ProjectSettingDao,ProjectSettingEntity> {

}