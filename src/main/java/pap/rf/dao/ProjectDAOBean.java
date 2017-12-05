package main.java.pap.rf.dao;

import java.util.List;

import main.java.pap.rf.BaseDAOBean;
import main.java.pap.rf.entity.ProjectEntity;

public class ProjectDAOBean extends BaseDAOBean<ProjectEntity, Long> implements ProjectDAO {

	@Override
	public void insertProject(ProjectEntity project) {
		insert(project);
	}

	@Override
	public ProjectEntity findByProjectId(long projectId) {
		return findById(projectId);
	}

	@Override
	public void updateProject(ProjectEntity project) {
		update(project);
	}

	@Override
	public List<ProjectEntity> findAllProjects() {
		return findAll();
	}

}
