package hr.vvg.controller;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@ManagedBean
@SessionScoped
public class LogoutController {
	
	public String logout() {
		
	HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	
	session.invalidate();
	
	return"/jsf/createTask.xhtml?faces-redirect=true";
	
	}

}
