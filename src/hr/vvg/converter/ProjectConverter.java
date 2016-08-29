package hr.vvg.converter;

import java.io.IOException;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.NamingException;

import hr.vvg.entiteti.Project;
import hr.vvg.task.service.TaskServiceDatabase;


@ManagedBean(name = "projectConverterBean")
@FacesConverter(value = "projectConverter")
public class ProjectConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
	String value) {
		if(value instanceof String && "".equals(value)) {
			
			return "";
			
		}
		return findProjectById(Integer.parseInt(value));
		
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component,
	Object value) {
		if(value instanceof String && "".equals(value)) {
			
			return "";
			
		}
		Project project = (Project) value;
		return String.valueOf(project.getProjectId());
	}
	
	private Project findProjectById(Integer id) {
		
		Project project = null;
		
		try {
			for(Project temp : TaskServiceDatabase.fetchProjectList()) {
				if(temp.getProjectId() == id) {
					
					project = temp;
					break;
				}
				
			}
		} catch (SQLException | IOException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return project;
	}

}
