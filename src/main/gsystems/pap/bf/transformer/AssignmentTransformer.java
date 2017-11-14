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
		if(dto.getPreferences() != null) {
			project.setPreferences(toStudentsListFromDTO(dto.getPreferences()));	
		}
		if(dto.getSkills() != null) {
			project.setSkills(toSkillListFromDTO(dto.getSkills()));
		}
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
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setEmail(student.getEmail());
		studentDTO.setFirstname(student.getFirstname());
		studentDTO.setId(student.getId());
		studentDTO.setLastname(student.getLastname());
		if(student.getPreferences() != null) {
			studentDTO.setPreferences(fromProjectListToDTO(student.getPreferences()));
		}
		if(student.getSkills() != null) {
			studentDTO.setSkills(fromSkillListToDTO(student.getSkills()));
		}
		return studentDTO;
	}

	private static ProjectDTO fromProjectToDTO(Project project) {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setCapacity(project.getCapacity());
		projectDTO.setCoordinator(project.getCoordinator());
		projectDTO.setId(project.getId());
		projectDTO.setName(project.getName());
		if(project.getPreferences() != null) {
			projectDTO.setPreferences(fromStudentListToDTO(project.getPreferences()));
		}
		if(project.getSkills() != null) {
			projectDTO.setSkills(fromSkillListToDTO(project.getSkills()));
		}
		return projectDTO;
	}

	public static List<Student> toStudentsListFromDTO(List<StudentDTO> dtoList) {
		List<Student> students = new ArrayList<>();
		for (StudentDTO studentDTO : dtoList) {
			students.add(toStudentFromDTO(studentDTO));
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
