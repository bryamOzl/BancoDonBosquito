package ec.edu.ups.donBosquito.core;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Bryam
 */
@ManagedBean
@RequestScoped
public class CtrLogout {

    private String _mensaje = "Espere un momento por favor...";

    public CtrLogout() {
        FacesUtils.getExternalContext().invalidateSession();
        FacesUtils.redirect("/login.jsf");
    }

    public String getMensaje() {
        return _mensaje;
    }

    public void setMensaje(String _mensaje) {
        this._mensaje = _mensaje;
    }

}
