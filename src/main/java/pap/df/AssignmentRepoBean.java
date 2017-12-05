package main.java.pap.df;

import java.util.List;

import javax.inject.Inject;

import main.java.pap.df.mapper.AssignmentMapper;
import main.java.pap.df.model.Project;
import main.java.pap.df.model.Student;
import main.java.pap.rf.dao.ProjectDAO;
import main.java.pap.rf.dao.StudentDAO;

public class AssignmentRepoBean implements AssignmentRepo {

	@Inject
	StudentDAO studentDAO;

	@Inject
	ProjectDAO projectDAO;

	@Override
	public void insertStudent(Student student) {
		studentDAO.insertStudent(AssignmentMapper.fromStudentToEntity(student));
	}

	@Override
	public void insertProject(Project project) {
		projectDAO.insert(AssignmentMapper.fromProjectToEntity(project));
	}

	@Override
	public void updateProject(Project project) {
		projectDAO.update(AssignmentMapper.fromProjectToEntity(project));
	}

	@Override
	public void updateStudent(Student student) {
		studentDAO.update(AssignmentMapper.fromStudentToEntity(student));
	}

	@Override
	public List<Student> findAllStudents() {
		return AssignmentMapper.toStudentFromEntityList(studentDAO.findAllStudents());
	}

	@Override
	public List<Project> findAllProjects() {
		return AssignmentMapper.toProjectListFromEntity(projectDAO.findAllProjects());
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public ProjectDAO getProjectDAO() {
		return projectDAO;
	}

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

}
