package main.gsystems.pap.df.mapper;

import java.util.ArrayList;
import java.util.List;

import main.gsystems.pap.df.model.Project;
import main.gsystems.pap.df.model.Skill;
import main.gsystems.pap.df.model.Student;
import main.gsystems.pap.rf.entity.ProjectEntity;
import main.gsystems.pap.rf.entity.SkillEntity;
import main.gsystems.pap.rf.entity.StudentEntity;

public class AssignmentMapper {

	private AssignmentMapper() {
	}

	public static List<StudentEntity> fromStudentListToEntity(List<Student> students) {
		List<StudentEntity> entityList = new ArrayList<>();
		for (Student student : students) {
			entityList.add(fromStudentToEntity(student));
		}
		return entityList;
	}

	public static StudentEntity fromStudentToEntity(Student student) {
		StudentEntity entity = new StudentEntity();
		entity.setEmail(student.getEmail());
		entity.setFirstname(student.getFirstname());
		entity.setId(student.getId());
		entity.setLastname(student.getLastname());
		entity.setPreferences(fromProjectListToEntity(student.getPreferences()));
		entity.setSkills(fromSkillListToEntity(student.getSkills()));
		return entity;
	}

	public static List<Student> toStudentFromEntityList(List<StudentEntity> entityList) {
		List<Student> students = new ArrayList<>();
		for (StudentEntity entity : entityList) {
			students.add(toStudentFromEntity(entity));
		}
		return students;
	}

	private static Student toStudentFromEntity(StudentEntity entity) {
		Student student = new Student();
		student.setEmail(entity.getEmail());
		student.setFirstname(entity.getFirstname());
		student.setId(entity.getId());
		student.setLastname(entity.getLastname());
		student.setPreferences(toProjectListFromEntity(entity.getPreferences()));
		student.setSkills(toSkillListFromEntity(entity.getSkills()));
		return student;
	}

	private static List<ProjectEntity> fromProjectListToEntity(List<Project> preferences) {
		List<ProjectEntity> entityList = new ArrayList<>();
		for (Project preference : preferences) {
			entityList.add(fromProjectToEntity(preference));
		}
		return entityList;
	}

	public static List<Project> toProjectListFromEntity(List<ProjectEntity> entityList) {
		List<Project> projects = new ArrayList<>();
		for (ProjectEntity entity : entityList) {
			projects.add(toProjectFromEntity(entity));
		}
		return projects;
	}

	public static ProjectEntity fromProjectToEntity(Project project) {
		ProjectEntity entity = new ProjectEntity();
		entity.setCapacity(project.getCapacity());
		entity.setCoordinator(project.getCoordinator());
		entity.setId(project.getId());
		entity.setName(project.getName());
		entity.setPreferences(fromStudentListToEntity(project.getPreferences()));
		entity.setSkills(fromSkillListToEntity(project.getSkills()));
		return entity;
	}

	public static Project toProjectFromEntity(ProjectEntity entity) {
		Project project = new Project();
		project.setCapacity(entity.getCapacity());
		project.setCoordinator(entity.getCoordinator());
		project.setId(entity.getId());
		project.setName(entity.getName());
		project.setPreferences(toStudentFromEntityList(entity.getPreferences()));
		return project;
	}

	public static List<SkillEntity> fromSkillListToEntity(List<Skill> skills) {
		List<SkillEntity> entityList = new ArrayList<>();
		for (Skill skill : skills) {
			entityList.add(new SkillEntity(null, skill.getName()));
		}
		return entityList;
	}

	public static SkillEntity fromSkillToEntity(Skill skill) {
		return new SkillEntity(null, skill.getName());
	}
	
	public static List<Skill> toSkillListFromEntity(List<SkillEntity> entityList) {
		List<Skill> skills = new ArrayList<>();
		for (SkillEntity entity : entityList) {
			skills.add(new Skill(entity.getName()));
		}
		return skills;
	}

}
