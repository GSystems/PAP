package main.java.pap.pf;

import java.util.List;

import main.java.pap.bfcl.dto.ProjectDTO;
import main.java.pap.bfcl.dto.StudentDTO;

public class AssignmentModel {

	private ProjectDTO project;
	private StudentDTO student;
	private String skills;

	private List<StudentDTO> students;
	private List<ProjectDTO> projects;

	private ProjectDTO projectForEdit;
	private StudentDTO studentForEdit;

	private String selectedSubject;
	private String selectedOperation;
	private String searchedValue;

	private boolean studentPanelFlag;
	private boolean projectPanelFlag;
	private boolean searchPanelFlag;
	private boolean assignmentsPanelFlag;

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

	public ProjectDTO getProjectForEdit() {
		return projectForEdit;
	}

	public void setProjectForEdit(ProjectDTO projectForEdit) {
		this.projectForEdit = projectForEdit;
	}

	public StudentDTO getStudentForEdit() {
		return studentForEdit;
	}

	public void setStudentForEdit(StudentDTO studentForEdit) {
		this.studentForEdit = studentForEdit;
	}

	public List<StudentDTO> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDTO> students) {
		this.students = students;
	}

	public List<ProjectDTO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	}

	public String getSelectedSubject() {
		return selectedSubject;
	}

	public void setSelectedSubject(String selectedSubject) {
		this.selectedSubject = selectedSubject;
	}

	public String getSelectedOperation() {
		return selectedOperation;
	}

	public void setSelectedOperation(String selectedOperation) {
		this.selectedOperation = selectedOperation;
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

	public String getSearchedValue() {
		return searchedValue;
	}

	public void setSearchedValue(String searchedValue) {
		this.searchedValue = searchedValue;
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
