package main.gsystems.pap.pf;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import main.gsystems.pap.bfcl.AssignmentFacade;
import main.gsystems.pap.bfcl.dto.StudentDTO;
import main.gsystems.pap.util.GeneralConstants;
import main.gsystems.pap.util.LocalizedEn;

@ManagedBean(name = "studentBean")
@ViewScoped
public class StudentBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private AssignmentModel model;

	@EJB
	private transient AssignmentFacade facade;

	@PostConstruct
	public void init() {
		model = new AssignmentModel();
		model.setStudent(new StudentDTO());
		model.setSubmitBtnDisabled(true);

		model.setAllProjects(facade.findAllProjects());
		model.setAllStudents(facade.findAllStudents());
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

	public void subjectSelector() {
		switch (model.getSubject()) {
		case GeneralConstants.PROJECT_SUBJECT:
			model.setProjectSubject(true);
			model.setStudentSubject(false);
			break;
		case GeneralConstants.SKILL_SUBJECT:
			model.setStudentSubject(false);
			model.setProjectSubject(false);
			break;
		case GeneralConstants.STUDENT_SUBJECT:
			model.setStudentSubject(true);
			model.setProjectSubject(false);
			break;
		default:
			model.setProjectSubject(false);
			model.setStudentSubject(false);
		}
	}

	public void detectOperation() {
		String operation = model.getOperation();
		if (GeneralConstants.ADD_OPERATION.equals(operation)) {
			model.setAddOperation(true);
			model.setSubmitBtnDisabled(false);
			model.setStudentSelector(false);
		} else if (GeneralConstants.EDIT_OPERATION.equals(operation)) {
			model.setUpdateOperation(true);
			model.setSubmitBtnDisabled(false);
			model.setStudentSelector(true);
		} else {
			model.setAddOperation(false);
			model.setUpdateOperation(false);
			model.setSubmitBtnDisabled(true);
			model.setStudentSelector(false);
		}
	}

	public void processOperation() {
		if (model.getAddOperation()) {
			addOperation();
		} else if (model.getUpdateOperation()) {
			updateOperation();
		}
	}

	public void addOperation() {
//		 if (model.getProjectSubject()) {
		 facade.insertProject(model.getProject());
//		 } else if (model.getStudentSubject()) {
			 facade.insertStudent(model.getStudent());
			showMessage("Operation successful", FacesMessage.SEVERITY_INFO);
//		} else {
			showMessage(LocalizedEn.UNEXPECTED_ERROR, FacesMessage.SEVERITY_ERROR);
//		}
	}

	public void updateOperation() {
		if (model.getProjectSubject()) {
			facade.updateProject(model.getProject());
		} else if (model.getStudentSubject()) {
			facade.updateStudent(model.getStudent());
		} else {
			showMessage(LocalizedEn.UNEXPECTED_ERROR, FacesMessage.SEVERITY_ERROR);
		}
	}

	private void showMessage(String message, FacesMessage.Severity severity) {
		FacesContext.getCurrentInstance().addMessage(message, new FacesMessage(severity, " ", ""));
	}

}
