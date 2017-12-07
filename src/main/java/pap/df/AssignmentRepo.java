package main.java.pap.df;

import java.util.List;

import main.java.pap.df.model.Project;
import main.java.pap.df.model.Student;

public interface AssignmentRepo {

	/**
	 * Add a new student
	 * 
	 * @param student
	 */
	void insertStudent(Student student);

	/**
	 * Add a new project
	 * 
	 * @param project
	 */
	void insertProject(Project project);

	/**
	 * Edit a project
	 * 
	 * @param project
	 */
	void updateProject(Project project);

	/**
	 * Edit a student
	 * 
	 * @param student
	 */
	void updateStudent(Student student);

	/**
	 * Retrieve all students from database
	 * 
	 * @return
	 */
	List<Student> findAllStudents();

	/**
	 * Retrieve all projects from database
	 * 
	 * @return
	 */
	List<Project> findAllProjects();

	/**
	 * Retrieve students by email
	 * 
	 * @param name
	 * @return
	 */
	List<Student> findStudentsByEmail(String email);

}
