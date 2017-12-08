package main.java.pap.bfcl;

import java.util.List;

import main.java.pap.bfcl.dto.ProjectDTO;
import main.java.pap.bfcl.dto.SkillDTO;
import main.java.pap.bfcl.dto.StudentDTO;

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

	/**
	 * Retrieve students by email
	 * 
	 * @param name
	 * @return
	 */
	List<StudentDTO> findStudentsByEmail(String email);

	/**
	 * Add a new skill
	 * 
	 * @param skill
	 */
	void insertSkill(SkillDTO skill);

}
