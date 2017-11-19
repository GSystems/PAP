package main.gsystems.pap.pf;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import main.gsystems.pap.bfcl.AssignmentFacade;
import main.gsystems.pap.bfcl.dto.ProjectDTO;
import main.gsystems.pap.bfcl.dto.StudentDTO;

@ManagedBean(name = "projectBean")
@ViewScoped
public class ProjectBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private AssignmentModel model;

	@EJB
	private transient AssignmentFacade facade;

	@PostConstruct
	public void init() {
		model = new AssignmentModel();
		model.setStudent(new StudentDTO());
		model.setProject(new ProjectDTO());

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

	public void proccessOperation() {
		facade.insertProject(model.getProject());
	}

}
