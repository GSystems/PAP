package main.java.pap.pf.converter;

import java.util.List;

import javax.el.ELContext;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import main.gsystems.pap.pf.AssignmentBean;
import main.java.pap.bfcl.dto.ProjectDTO;

@FacesConverter("ProjectConverter")
public class ProjectConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				List<ProjectDTO> projects;
				ELContext elContext = FacesContext.getCurrentInstance().getELContext();
				AssignmentBean bean = (AssignmentBean) elContext.getELResolver().getValue(elContext, null, "assignmentBean");
				projects = bean.getModel().getProjects();
				if (projects != null) {
					for (ProjectDTO p : projects) {
						if (p.getName().equalsIgnoreCase(value)) {
							return p;
						}
					}
					return null;
				} else {
					return null;
				}
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !"".equals(value) && !"null".equals(value)) {
			return String.valueOf(((ProjectDTO) value).getName());
		} else {
			return null;
		}
	}

}
