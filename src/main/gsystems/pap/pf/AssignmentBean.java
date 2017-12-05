package main.gsystems.pap.pf;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import main.java.pap.bfcl.AssignmentFacade;
import main.java.pap.bfcl.dto.ProjectDTO;
import main.java.pap.bfcl.dto.StudentDTO;
import main.java.pap.pf.AssignmentModel;

@ManagedBean
@RequestScoped
public class AssignmentBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private transient AssignmentModel model;

	@EJB
	private transient AssignmentFacade facade;

	@PostConstruct
	public void init() {
		model = new AssignmentModel();
		model.setStudent(new StudentDTO());
		model.setProject(new ProjectDTO());

		model.setAllProjects(facade.findAllProjects());
		model.setAllStudents(facade.findAllStudents());

		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(model.getLocale()));
	}

	public void subjectSelector() {
		String subject = model.getSubject();
		if (subject == null) {
			return;
		}
		switch (subject) {
		case "student":
			panelController(true, false, false);
			break;
		case "project":
			panelController(false, true, false);
			break;
		case "assignment":
			panelController(false, false, true);
			break;
		default:
			panelController(false, false, false);
			break;
		}
	}

	private void panelController(boolean studentPanelFlag, boolean projectPanelFlag, boolean assignmentPanelFlag) {
		model.setStudentPanelFlag(studentPanelFlag);
		model.setProjectPanelFlag(projectPanelFlag);
		model.setAssignmentPanelFlag(assignmentPanelFlag);
	}

	public void processOperation() {
		addOperation();
	}

	public void addOperation() {
		facade.insertStudent(model.getStudent());
		showMessage("Operation successful", FacesMessage.SEVERITY_INFO);
	}

	public void setLocale() {
		Locale locale = new Locale(model.getLocale());
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	private void showMessage(String message, FacesMessage.Severity severity) {
		FacesContext.getCurrentInstance().addMessage(message, new FacesMessage(severity, "", ""));
	}

	public AssignmentModel getModel() {
		return model;
	}

	public void setModel(AssignmentModel model) {
		this.model = model;
	}

	public AssignmentFacade getFacade() {
		return facade;
	}

	public void setFacade(AssignmentFacade facade) {
		this.facade = facade;
	}
}
