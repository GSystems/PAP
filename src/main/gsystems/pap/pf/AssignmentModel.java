package main.gsystems.pap.pf;

import java.util.List;

import main.gsystems.pap.bfcl.dto.ProjectDTO;
import main.gsystems.pap.bfcl.dto.StudentDTO;

public class AssignmentModel {

	private ProjectDTO project;
	private StudentDTO student;
	private String skills;

	private List<StudentDTO> allStudents;
	private List<ProjectDTO> allProjects;
	private List<StudentDTO> selectedProjectPreferences;
	private List<ProjectDTO> selectedStudentPreferences;

	private String operation;
	private String subject;

	private Boolean addOperation;
	private Boolean updateOperation;
	private Boolean studentSubject;
	private Boolean projectSubject;
	private Boolean submitBtnDisabled;
	private Boolean studentSelector;

	public ProjectDTO getProject() {
		return project;
	}

	public void setProject(ProjectDTO project) {
		this.project = project;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public List<StudentDTO> getAllStudents() {
		return allStudents;
	}

	public void setAllStudents(List<StudentDTO> allStudents) {
		this.allStudents = allStudents;
	}

	public List<ProjectDTO> getAllProjects() {
		return allProjects;
	}

	public void setAllProjects(List<ProjectDTO> allProjects) {
		this.allProjects = allProjects;
	}

	public List<StudentDTO> getSelectedProjectPreferences() {
		return selectedProjectPreferences;
	}

	public void setSelectedProjectPreferences(List<StudentDTO> selectedProjectPreferences) {
		this.selectedProjectPreferences = selectedProjectPreferences;
	}

	public List<ProjectDTO> getSelectedStudentPreferences() {
		return selectedStudentPreferences;
	}

	public void setSelectedStudentPreferences(List<ProjectDTO> selectedStudentPreferences) {
		this.selectedStudentPreferences = selectedStudentPreferences;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Boolean getUpdateOperation() {
		return updateOperation;
	}

	public void setUpdateOperation(Boolean updateOperation) {
		this.updateOperation = updateOperation;
	}

	public Boolean getAddOperation() {
		return addOperation;
	}

	public void setAddOperation(Boolean addOperation) {
		this.addOperation = addOperation;
	}

	public Boolean getStudentSubject() {
		return studentSubject;
	}

	public void setStudentSubject(Boolean studentSubject) {
		this.studentSubject = studentSubject;
	}

	public Boolean getProjectSubject() {
		return projectSubject;
	}

	public Boolean getSubmitBtnDisabled() {
		return submitBtnDisabled;
	}

	public void setSubmitBtnDisabled(Boolean submitBtnDisabled) {
		this.submitBtnDisabled = submitBtnDisabled;
	}

	public void setProjectSubject(Boolean projectSubject) {
		this.projectSubject = projectSubject;
	}

	public Boolean getStudentSelector() {
		return studentSelector;
	}

	public void setStudentSelector(Boolean studentSelector) {
		this.studentSelector = studentSelector;
	}

	// TODO remove this method when database returns real data
	public void generateProjects() {
		StudentDTO student1 = new StudentDTO();
		StudentDTO student2 = new StudentDTO();
		StudentDTO student3 = new StudentDTO();

		student1.setEmail("john.smith@gmail.com");
		student1.setFirstname("John");
		student1.setLastname("Smith");

		student2.setEmail("sam.adams@gmail.com");
		student2.setFirstname("Sam");
		student2.setLastname("Adams");

		student3.setEmail("roby.carter@gmail.com");
		student3.setFirstname("Roby");
		student3.setLastname("Carter");

		allStudents.add(student1);
		allStudents.add(student2);
		allStudents.add(student3);
	}

	// TODO remove this method when database returns real data
	public void generateStudents() {
		ProjectDTO project1 = new ProjectDTO();
		ProjectDTO project2 = new ProjectDTO();
		ProjectDTO project3 = new ProjectDTO();

		project1.setCapacity(2);
		project1.setCoordinator("Thomas Mitchel");
		project1.setName("BiMr");
		project1.setPreferences(null);

		project2.setCapacity(3);
		project2.setCoordinator("Johny Lexter");
		project2.setName("PAP");
		project2.setPreferences(null);

		project3.setCapacity(2);
		project3.setCoordinator("Samuel Noland");
		project3.setName("FIImDB");
		project3.setPreferences(null);

		allProjects.add(project1);
		allProjects.add(project2);
		allProjects.add(project3);
	}

}
