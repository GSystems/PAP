package main.java.pap.df.mapper;

import java.util.ArrayList;
import java.util.List;

import main.java.pap.df.model.Project;
import main.java.pap.df.model.Skill;
import main.java.pap.df.model.Student;
import main.java.pap.rf.entity.ProjectEntity;
import main.java.pap.rf.entity.SkillEntity;
import main.java.pap.rf.entity.StudentEntity;

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
		if (student.getPreferences() != null) {
			entity.setPreferences(fromProjectListToEntity(student.getPreferences()));
		}
		entity.setSkills(student.getSkills());
		return entity;
	}

	public static List<Student> toStudentFromEntityList(List<StudentEntity> entityList) {
		List<Student> students = new ArrayList<>();
		for (StudentEntity entity : entityList) {
			students.add(toStudentFromEntity(entity));
		}
		return students;
	}

	public static Student toStudentFromEntity(StudentEntity entity) {
		Student student = new Student();
		student.setEmail(entity.getEmail());
		student.setFirstname(entity.getFirstname());
		student.setId(entity.getId());
		student.setLastname(entity.getLastname());
		if (entity.getPreferences() != null) {
			student.setPreferences(getStudentPreferences(entity.getPreferences()));
		}
		if (entity.getSkills() != null) {
			student.setSkills(entity.getSkills());
		}
		return student;
	}

	private static List<Project> getStudentPreferences(List<ProjectEntity> projectEntities) {
		List<Project> projects = new ArrayList<>();
		for (ProjectEntity projectEntity : projectEntities) {
			Project project = new Project();
			project.setCapacity(projectEntity.getCapacity());
			project.setCoordinator(projectEntity.getCoordinator());
			project.setId(projectEntity.getId());
			project.setName(projectEntity.getName());
			project.setSkills(projectEntity.getSkills());
			projects.add(project);
		}
		return projects;
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
			if (entity != null) {
				projects.add(toProjectFromEntity(entity));
			}
		}
		return projects;
	}

	public static ProjectEntity fromProjectToEntity(Project project) {
		ProjectEntity entity = new ProjectEntity();
		entity.setCapacity(project.getCapacity());
		entity.setCoordinator(project.getCoordinator());
		entity.setId(project.getId());
		entity.setName(project.getName());
		if (project.getPreferences() != null) {
			entity.setPreferences(fromStudentListToEntity(project.getPreferences()));
		}
		entity.setSkills(project.getSkills());
		return entity;
	}

	public static Project toProjectFromEntity(ProjectEntity entity) {
		Project project = new Project();
		project.setCapacity(entity.getCapacity());
		project.setCoordinator(entity.getCoordinator());
		project.setId(entity.getId());
		project.setName(entity.getName());
		if (entity.getPreferences() != null) {
			project.setPreferences(getProjectPreferences(entity.getPreferences()));
		}
		project.setSkills(entity.getSkills());
		return project;
	}

	private static List<Student> getProjectPreferences(List<StudentEntity> studentEntities) {
		List<Student> students = new ArrayList<>();
		for (StudentEntity studentEntity : studentEntities) {
			Student student = new Student();
			student.setEmail(studentEntity.getEmail());
			student.setFirstname(studentEntity.getEmail());
			student.setLastname(studentEntity.getLastname());
			students.add(student);
		}
		return students;
	}

	public static SkillEntity fromSkillToEntity(Skill skill) {
		SkillEntity skillEntity = new SkillEntity();
		skillEntity.setId(skill.getId());
		skillEntity.setName(skill.getName());
		return skillEntity;
	}

	public static Skill toSkillFromEntity(SkillEntity entity) {
		return null;
	}

}
