package main.gsystems.pap.df;

import java.util.List;

import javax.ejb.EJB;

import main.gsystems.pap.df.mapper.AssignmentMapper;
import main.gsystems.pap.df.model.Project;
import main.gsystems.pap.df.model.Skill;
import main.gsystems.pap.df.model.Student;
import main.gsystems.pap.rf.dao.ProjectDAO;
import main.gsystems.pap.rf.dao.SkillDAO;
import main.gsystems.pap.rf.dao.StudentDAO;

public class AssignmentRepoBean implements AssignmentRepo {

	@EJB
	StudentDAO studentDAO;

	@EJB
	SkillDAO skillDAO;

	@EJB
	ProjectDAO projectDAO;

	@Override
	public void insertStudent(Student student) {
		studentDAO.insertStudent(AssignmentMapper.fromStudentToEntity(student));
	}

	@Override
	public void insertSkill(Skill skill) {
		skillDAO.insertSkill(AssignmentMapper.fromSkillToEntity(skill));
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
		return AssignmentMapper.toStudentFromEntityList(studentDAO.findAll());
	}

	@Override
	public List<Project> findAllProjects() {
		return AssignmentMapper.toProjectListFromEntity(projectDAO.findAll());
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public SkillDAO getSkillDAO() {
		return skillDAO;
	}

	public void setSkillDAO(SkillDAO skillDAO) {
		this.skillDAO = skillDAO;
	}

	public ProjectDAO getProjectDAO() {
		return projectDAO;
	}

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

}
