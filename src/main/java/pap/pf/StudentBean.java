package main.java.pap.pf;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import main.java.pap.bfcl.AssignmentFacade;
import main.java.pap.bfcl.dto.StudentDTO;

@ManagedBean(name = "studentBean")
@ViewScoped
public class StudentBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private transient AssignmentModel model;

	@EJB
	private transient AssignmentFacade facade;

	@PostConstruct
	public void init() {
		model = new AssignmentModel();
		model.setStudent(new StudentDTO());

		model.setAllProjects(facade.findAllProjects());
		
		//Locale locale = new Locale("en_US");
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(model.getLocale()));
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

}
