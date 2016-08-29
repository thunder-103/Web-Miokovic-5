package hr.vvg.converter;

import java.io.IOException;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.NamingException;

import hr.vvg.entiteti.User;
import hr.vvg.task.service.TaskServiceDatabase;

@ManagedBean(name = "userConverterBean")
@FacesConverter(value = "userConverter")
public class UserConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
	String value) {
		if(value instanceof String && "".equals(value)) {
			
			return "";
			
		}
		return findUserById(Integer.parseInt(value));
		
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component,
	Object value) {
		if(value instanceof String && "".equals(value)) {
			
			return "";
			
		}
		User user = (User) value;
		return String.valueOf(user.getUserId());
	}
	
	private User findUserById(Integer id) {
		
		User user = null;
		
		try {
			for(User temp : TaskServiceDatabase.fetchUserList()) {
				if(temp.getUserId() == id) {
					
					user = temp;
					break;
				}
				
			}
		} catch (SQLException | IOException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}


}
