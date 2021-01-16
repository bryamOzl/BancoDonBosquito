package ec.edu.ups.donBosquito.core;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;

/**
 *
 * @author Bryam 
 */
@ManagedBean
@SessionScoped
public class CtrSession {

    private String usuario;

    public CtrSession() {
    }

    public void logout() throws ServletException {
        FacesUtils.getExternalContext().invalidateSession();
        FacesUtils.redirect("/blue-ice-813371382/Ssesion.jsf");
    }

    public String getExternalContext() {
        return FacesUtils.getExternalContext().getRequestContextPath();
    }

    public String getUsuario() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String user = (String) facesContext.getExternalContext().getSessionMap().get("usuario");
        return user;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
