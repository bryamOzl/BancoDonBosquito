package ec.edu.ups.donBosquito.beans;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.donBosquito.DAO.RegistroDAO;
import ec.edu.ups.donBosquito.core.FacesUtils;
import ec.edu.ups.donBosquito.modelo.Registro;

@ManagedBean
@ViewScoped
public class CuentaBean {
	
	@Inject
	private RegistroDAO daoRegistro;
	
	public Registro registro = new Registro();
	
	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String user = (String) facesContext.getExternalContext().getSessionMap().get("usuario");
		if (user.equals("")) {
			FacesUtils.msgError("Error", "Usuario no cargado");
		} else {
			try {
				System.out.println(user);
				registro = daoRegistro.leerNombre(user);
				
				if (registro == null) {
					FacesUtils.msgError("Error", "Usuario no existe");
				} else {
					registro = daoRegistro.leerRegistro(registro.getRegistro_id());
					System.out.println(registro);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	@Override
	public String toString() {
		return "CuentaBean [registro=" + registro + "]";
	}
	
	

}
