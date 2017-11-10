package main.gsystems.pap.bf.transformer;

import java.util.ArrayList;
import java.util.List;

import main.gsystems.pap.bfcl.dto.ProjectDTO;
import main.gsystems.pap.bfcl.dto.SkillDTO;
import main.gsystems.pap.bfcl.dto.StudentDTO;
import main.gsystems.pap.df.model.Project;
import main.gsystems.pap.df.model.Skill;
import main.gsystems.pap.df.model.Student;

public class AssignmentTransformer {

	private AssignmentTransformer() {
	}

	public static List<ProjectDTO> fromProjectListToDTO(List<Project> projects) {
		List<ProjectDTO> projectsDTO = new ArrayList<>();
		for (Project project : projects) {
			projectsDTO.add(fromProjectToDTO(project));
		}
		return projectsDTO;
	}

	public static Project toProjectFromDTO(ProjectDTO dto) {
		Project project = new Project();
		project.setCapacity(dto.getCapacity());
		project.setCoordinator(dto.getCoordinator());
		project.setId(dto.getId());
		project.setName(dto.getName());
		project.setPreferences(toStudentsListFromDTO(dto.getPreferences()));
		project.setSkills(toSkillListFromDTO(dto.getSkills()));
		return project;
	}

	public static List<StudentDTO> fromStudentListToDTO(List<Student> students) {
		List<StudentDTO> dtoList = new ArrayList<>();
		for (Student student : students) {
			dtoList.add(fromStudentToDTO(student));
		}
		return dtoList;
	}

	public static StudentDTO fromStudentToDTO(Student student) {
		StudentDTO dto = new StudentDTO();
		dto.setEmail(student.getEmail());
		dto.setFirstname(student.getFirstname());
		dto.setId(student.getId());
		dto.setLastname(student.getLastname());
		dto.setPreferences(fromProjectListToDTO(student.getPreferences()));
		dto.setSkills(fromSkillListToDTO(student.getSkills()));
		return dto;
	}

	private static ProjectDTO fromProjectToDTO(Project preference) {
		ProjectDTO dto = new ProjectDTO();
		dto.setCapacity(preference.getCapacity());
		dto.setCoordinator(preference.getCoordinator());
		dto.setId(preference.getId());
		dto.setName(preference.getName());
		dto.setPreferences(fromStudentListToDTO(preference.getPreferences()));
		dto.setSkills(fromSkillListToDTO(preference.getSkills()));
		return dto;
	}

	public static List<Student> toStudentsListFromDTO(List<StudentDTO> dtoList) {
		List<Student> students = new ArrayList<>();
		for (StudentDTO student : dtoList) {
			students.add(toStudentFromDTO(student));
		}
		return students;
	}

	public static Student toStudentFromDTO(StudentDTO dto) {
		Student student = new Student();
		student.setEmail(dto.getEmail());
		student.setFirstname(dto.getFirstname());
		student.setId(dto.getId());
		student.setLastname(dto.getLastname());
		return student;
	}

	public static List<Skill> toSkillListFromDTO(List<SkillDTO> skillsDTO) {
		List<Skill> skills = new ArrayList<>();
		for (SkillDTO skill : skillsDTO) {
			skills.add(new Skill(skill.getName()));
		}
		return skills;
	}

	public static List<SkillDTO> fromSkillListToDTO(List<Skill> skills) {
		List<SkillDTO> dtoList = new ArrayList<>();
		for (Skill skill : skills) {
			dtoList.add(new SkillDTO(skill.getName()));
		}
		return dtoList;
	}
	
	public static Skill toSkillFromDTO(SkillDTO skill) {
		return new Skill(skill.getName());
	}

}
