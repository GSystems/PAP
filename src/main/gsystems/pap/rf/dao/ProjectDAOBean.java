package main.gsystems.pap.rf.dao;

import main.gsystems.pap.rf.BaseDAOBean;
import main.gsystems.pap.rf.entity.ProjectEntity;

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

}
