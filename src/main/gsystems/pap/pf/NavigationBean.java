package main.gsystems.pap.pf;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "navigationBean")
@RequestScoped
public class NavigationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private transient AssignmentModel model;

	@PostConstruct
	public void init() {
		model = new AssignmentModel();
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(model.getLocale()));
	}
	
	public AssignmentModel getModel() {
		return model;
	}

	public void setModel(AssignmentModel model) {
		this.model = model;
	}

	public void subjectSelector() {
		String subject = model.getSubject();
		if ("student".equals(subject)) {
			model.setStudentPanelFlag(true);
			model.setProjectPanelFlag(false);
		} else if("project".equals(subject)) {
			model.setStudentPanelFlag(false);
			model.setProjectPanelFlag(true);
		}
	}

}
