package main.gsystems.pap.df;

import java.util.List;

import main.gsystems.pap.df.model.Project;
import main.gsystems.pap.df.model.Skill;
import main.gsystems.pap.df.model.Student;

public interface AssignmentRepo {

	/**
	 * Add a new student
	 * 
	 * @param student
	 */
	void insertStudent(Student student);

	/**
	 * Add a new skill
	 * 
	 * @param skillFromDTO
	 */
	void insertSkill(Skill skill);

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

}
