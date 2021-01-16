package ec.edu.ups.donBosquito.beans;

import ec.edu.ups.donBosquito.DAO.RegistroDAO;
import ec.edu.ups.donBosquito.core.CtrSession;
import ec.edu.ups.donBosquito.core.FacesUtils;
import ec.edu.ups.donBosquito.modelo.Registro;

import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public String username;
	private String password;

	@Inject
	private RegistroDAO daoRegistro;

	public LoginBean() {
	}

	/**
	 * Metodo para realzar el logue mediante las credenciales del registro
	 */
	public void login() {
		boolean login = false;
		Registro registro = null;
		try {
			registro = daoRegistro.login(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (registro != null) {
			login = true;
		}

		String rol = registro.getRol();

//		if (username.equals("admin") && password.equals("admin")) {
//			login = true;
//		}

		if (login) {
			CtrSession bean = (CtrSession) FacesUtils.getManagedBean("ctrSession");
			if (bean != null) {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.getExternalContext().getSessionMap().put("usuario", username);
				//ruta por carperas
				if (rol.equals("Cajero")) {
					FacesUtils.redirect("/blue-ice-813371382/PrincipalCajero.jsf");
				} else if (rol.equals("Admin")) {
					FacesUtils.redirect("/blue-ice-813371382/PrincipalAdministrador.jsf");
				}else if (rol.equals("Cajero")) {
					FacesUtils.redirect("/blue-ice-813371382/PrincipalCajero.jsf");
				}else if (rol.equals("Cliente")){
					FacesUtils.redirect("/blue-ice-813371382/ClienteCuentas.jsf");
				}
			}
		} else {
			FacesUtils.msgError(null, "El usuario o contraseña son incorrectos");
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
