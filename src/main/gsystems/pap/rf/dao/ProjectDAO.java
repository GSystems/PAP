package main.gsystems.pap.rf.dao;

import java.util.List;

import main.gsystems.pap.rf.BaseDAO;
import main.gsystems.pap.rf.entity.ProjectEntity;

public interface ProjectDAO extends BaseDAO<ProjectEntity, Long> {

	/**
	 * Add a new project
	 * 
	 * @param project
	 */
	void insertProject(ProjectEntity project);

	/**
	 * Find a project by id
	 * 
	 * @param projectId
	 * @return
	 */
	ProjectEntity findByProjectId(long projectId);

	/**
	 * Edit a project
	 * 
	 * @param project
	 */
	void updateProject(ProjectEntity project);

	/**
	 * Retrieve all projects
	 * 
	 * @return
	 */
	List<ProjectEntity> findAllProjects();

}
