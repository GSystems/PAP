package main.java.pap.bf.transformer;

import java.util.ArrayList;
import java.util.List;

import main.java.pap.bfcl.dto.ProjectDTO;
import main.java.pap.bfcl.dto.StudentDTO;
import main.java.pap.df.model.Project;
import main.java.pap.df.model.Student;

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
		project.setSkills(dto.getSkills());
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
		studentDTO.setSkills(student.getSkills());
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
		projectDTO.setSkills(project.getSkills());
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
		student.setPreferences(getStudentPreferences(dto.getPreferences()));
		student.setSkills(dto.getSkills());
		return student;
	}
	
	public static List<Project> getStudentPreferences(List<ProjectDTO> projectsDTO) {
		List<Project> projects = new ArrayList<>();
		for(ProjectDTO projectDTO : projectsDTO) {
			Project project = new Project();
			project.setCapacity(projectDTO.getCapacity());
			project.setCoordinator(projectDTO.getCoordinator());
			project.setId(projectDTO.getId());
			project.setName(projectDTO.getName());
			projects.add(project);
		}
		return projects;
	}

}
