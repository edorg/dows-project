package org.dows.project.repository;

import org.dows.rade.crud.CrudRepository;
import org.springframework.stereotype.Component;

import org.dows.project.entity.ProjectMemberEntity;
import org.dows.project.dao.ProjectMemberDao;

@Component
public class ProjectMemberRepository  extends CrudRepository<ProjectMemberDao,ProjectMemberEntity> {

}