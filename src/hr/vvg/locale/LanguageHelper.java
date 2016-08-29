package hr.vvg.locale;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "language")
@SessionScoped
public class LanguageHelper implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String localeCode;
	//http://stackoverflow.com/questions/30653945/facescontextgetviewroot-returns-null-while-setting-fview-locale-for-first
	private Locale locale;
	
	
	@PostConstruct
	public void init() {
		
	locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	
	}
	
	public String getLocaleCode() {
		
		//http://docs.oracle.com/javase/7/docs/api/java/util/Locale.html#toString%28%29
		//http://stackoverflow.com/questions/9536018/java-locale-to-string
		localeCode = locale.toString();
		
		return localeCode;
		
	}
	
	public void setLocaleCode(String localeCode) {
		
		changeLang(localeCode);
		
	}
	
	public String changeLang(String langCode) {
		
		localeCode = langCode;
		
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale (langCode));
		
		return null;
		
	}

}
