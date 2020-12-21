package ec.edu.ups.donBosquito.beans;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.donBosquito.DAO.CuentaDAO;
import ec.edu.ups.donBosquito.DAO.PersonaDAO;
import ec.edu.ups.donBosquito.DAO.RegistroDAO;
import ec.edu.ups.donBosquito.core.FacesUtils;
import ec.edu.ups.donBosquito.modelo.Cuenta;
import ec.edu.ups.donBosquito.modelo.Persona;
import ec.edu.ups.donBosquito.modelo.Registro;

@ManagedBean
@ViewScoped
public class CajeroBean {

	private Persona persona = new Persona();
	private Registro registro = new Registro();
	private Cuenta cuenta = new Cuenta();

	@Inject
	private PersonaDAO daoPersona;

	@Inject
	private RegistroDAO daoRegistro;

	@Inject
	private CuentaDAO daoCuenta;

	public void buscarCedula() {
		Persona per = null;
		per = daoPersona.buscarCedula(persona.getCedula());
		if (per == null) {
			FacesUtils.msgError("Error", "No se encontro la persona");
		} else {
			persona = per;
		}
	}

	public void registraPersona() {
		try {
			if (registro.getUsuario() == null && registro.getContrasenia() == null && cuenta.getNumero_cuenta() == null
					&& cuenta.getFecha_apertura() == null) {
				FacesUtils.msgError("Error", "Debe llenar los campos de usuario y contrasenaia");
				return;
			}

			int idPersona = daoPersona.contarPersona();
			persona.setPersona_id(idPersona);
			daoPersona.insertPersona(persona);
			registrar();
			registrarCuenta();
			persona = null;
			registro = null;
			FacesUtils.msgInfo("Exito", "Usuario Guardado Exitosamente");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void registrar() throws SQLException {
		int idRegistro = daoRegistro.contarRegistro();
		registro.setRegistro_id(idRegistro);
		registro.setEstado("Habilitado");
		registro.setRol("Cliente");
		registro.setPersona(persona);
		daoRegistro.insertRegistro(registro);

	}

	private void registrarCuenta() throws SQLException {
		int idCuenta = daoCuenta.contarCuenta();
		cuenta.setCuenta_id(idCuenta);
		cuenta.setRegistro(registro);
		daoCuenta.insertCuenta(cuenta);
		cuenta = null;

	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

}
