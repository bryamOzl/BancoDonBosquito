package ec.edu.ups.donBosquito.beans;

import ec.edu.ups.donBosquito.DAO.HistorialAccesosDAO;
import ec.edu.ups.donBosquito.DAO.RegistroDAO;
import ec.edu.ups.donBosquito.core.CtrSession;
import ec.edu.ups.donBosquito.core.FacesUtils;
import ec.edu.ups.donBosquito.modelo.Historial_Acceso;
import ec.edu.ups.donBosquito.modelo.Registro;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;

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

	@Inject
	private HistorialAccesosDAO daoHAcceso;

	public LoginBean() {
	}

	/**
	 * Metodo para realzar el logue mediante las credenciales del registro
	 * 
	 * @throws SQLException
	 */
	public void login() throws SQLException {
		boolean login = false;
		java.util.Date fecha = new Date();
		Registro registro = null;
		Historial_Acceso HAcceso = new Historial_Acceso();
		String contraAux = "";
		String rol = "";
		String estado = "";
		try {
			registro = daoRegistro.leerNombre(username);
			contraAux = registro.getContrasenia();
			estado = registro.getEstado();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (registro != null && estado.equals("Habilitado")) {
			System.out.println(contraAux);

			System.out.println(password);
			System.out.println(registro);

			if (contraAux.equals(password)) {
				HAcceso.setHist_acceso_id(daoHAcceso.contarHistorial());
				HAcceso.setFecha_acceso(fecha);
				HAcceso.setRegistro(registro);
				HAcceso.setTipo_acceso("Satisfactorio");
				System.out.println(HAcceso);
				daoHAcceso.insertHistorial(HAcceso);
				registro.setIntento(0);
				registro.setEstado("Habilitado");
				daoRegistro.updateRegistro(registro);
				rol = registro.getRol();
				login = true;
			} else {

				HAcceso.setHist_acceso_id(daoHAcceso.contarHistorial());
				HAcceso.setFecha_acceso(fecha);
				HAcceso.setRegistro(registro);
				HAcceso.setTipo_acceso("Fallido");
				System.out.println(HAcceso);
				daoHAcceso.insertHistorial(HAcceso);
				if((registro.getIntento() + 1) >= 3) {
					registro.setIntento(3);
					registro.setEstado("Bloqueado");
					daoRegistro.updateRegistro(registro);
				}else {
					registro.setIntento(registro.getIntento() + 1);
					daoRegistro.updateRegistro(registro);
				}
				
				login = false;
				

			}

		} else if ( registro == null && estado.equals("Habilitado")){
			login = false;
		} else if (registro != null && estado.equals("Bloqueado")){
			login = false;
			FacesUtils.msgError(null, "Usuario Bloqueado");
		}

		if (login) {
			CtrSession bean = (CtrSession) FacesUtils.getManagedBean("ctrSession");
			if (bean != null) {
				FacesContext facesContext = FacesContext.getCurrentInstance();
				facesContext.getExternalContext().getSessionMap().put("usuario", username);

				if (rol.equals("Cajero")) {
					FacesUtils.redirect("/blue-ice-813371382/PrincipalCajero.jsf");
				} else if (rol.equals("Admin")) {
					FacesUtils.redirect("/blue-ice-813371382/PrincipalAdministrador.jsf");
				} else if (rol.equals("Cajero")) {
					FacesUtils.redirect("/blue-ice-813371382/PrincipalCajero.jsf");
				} else if (rol.equals("Cliente")) {
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
