package main.java.pap.pf;

import java.util.List;

import main.java.pap.bfcl.dto.ProjectDTO;
import main.java.pap.bfcl.dto.StudentDTO;

public class AssignmentModel {

	private ProjectDTO project;
	private StudentDTO student;
	private String skills;

	private List<StudentDTO> allStudents;
	private List<ProjectDTO> allProjects;

	private String subject;
	private String operation;

	private boolean studentPanelFlag;
	private boolean projectPanelFlag;
	private boolean assignmentsPanelFlag;
	private boolean searchPanelFlag;
	private String searchValue;

	private String locale = "en_us";
	
	private List<String> operations;

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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Boolean getStudentPanelFlag() {
		return studentPanelFlag;
	}

	public void setStudentPanelFlag(boolean studentPanelFlag) {
		this.studentPanelFlag = studentPanelFlag;
	}

	public boolean getProjectPanelFlag() {
		return projectPanelFlag;
	}

	public void setProjectPanelFlag(boolean projectPanelFlag) {
		this.projectPanelFlag = projectPanelFlag;
	}

	public boolean getAssignmentsPanelFlag() {
		return assignmentsPanelFlag;
	}

	public void setAssignmentsPanelFlag(boolean assignmentsPanelFlag) {
		this.assignmentsPanelFlag = assignmentsPanelFlag;
	}

	public boolean isSearchPanelFlag() {
		return searchPanelFlag;
	}

	public void setSearchPanelFlag(boolean searchPanelFlag) {
		this.searchPanelFlag = searchPanelFlag;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public List<String> getOperations() {
		return operations;
	}

	public void setOperations(List<String> operations) {
		this.operations = operations;
	}

}
