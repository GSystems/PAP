package main.gsystems.pap.bfcl;

import java.util.List;

import main.gsystems.pap.bfcl.dto.ProjectDTO;
import main.gsystems.pap.bfcl.dto.StudentDTO;

public interface AssignmentFacade {

	/**
	 * Add a new student
	 * 
	 * @param student
	 */
	void insertStudent(StudentDTO student);

	/**
	 * Add a new project
	 * 
	 * @param project
	 */
	void insertProject(ProjectDTO project);

	/**
	 * Edit a project
	 * 
	 * @param project
	 */
	void updateProject(ProjectDTO project);

	/**
	 * Edit a student
	 * 
	 * @param student
	 */
	void updateStudent(StudentDTO student);

	/**
	 * Retrieve all students from database
	 * 
	 * @return
	 */
	List<StudentDTO> findAllStudents();

	/**
	 * Retrieve all projects from database
	 * 
	 * @return
	 */
	List<ProjectDTO> findAllProjects();

}
