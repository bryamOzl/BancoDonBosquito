package ec.edu.ups.donBosquito.core;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ing Diego
 */
@ManagedBean
@RequestScoped
public class CtrTimeout {

    private String _mensaje = "Espere un momento por favor...";

    public CtrTimeout() {
        FacesUtils.getExternalContext().invalidateSession();
        FacesUtils.redirect("/login.jsf?timeout=1");
    }

    public String getMensaje() {
        return _mensaje;
    }

    public void setMensaje(String _mensaje) {
        this._mensaje = _mensaje;
    }

}
