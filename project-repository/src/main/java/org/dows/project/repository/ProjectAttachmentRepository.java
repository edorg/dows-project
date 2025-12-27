package org.dows.project.repository;

import org.dows.rade.crud.CrudRepository;
import org.springframework.stereotype.Component;

import org.dows.project.entity.ProjectAttachmentEntity;
import org.dows.project.dao.ProjectAttachmentDao;

@Component
public class ProjectAttachmentRepository  extends CrudRepository<ProjectAttachmentDao,ProjectAttachmentEntity> {

}