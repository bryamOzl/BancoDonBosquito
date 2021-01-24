package ec.edu.ups.donBosquito.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.donBosquito.DAO.CuentaDAO;
import ec.edu.ups.donBosquito.DAO.MovimientoDAO;
import ec.edu.ups.donBosquito.DAO.PersonaDAO;
import ec.edu.ups.donBosquito.DAO.RegistroDAO;
import ec.edu.ups.donBosquito.core.FacesUtils;
import ec.edu.ups.donBosquito.modelo.Cuenta;
import ec.edu.ups.donBosquito.modelo.Movimiento;
import ec.edu.ups.donBosquito.modelo.Persona;
import ec.edu.ups.donBosquito.modelo.Registro;

@ManagedBean
@ViewScoped
public class CajeroBean {

	private Persona persona = new Persona();
	private Registro registro = new Registro();
	private Cuenta cuenta = new Cuenta();
	private Movimiento movimiento = new Movimiento();
	private List<Cuenta> listaCuenta = new ArrayList<>();

	@Inject
	private PersonaDAO daoPersona;

	@Inject
	private RegistroDAO daoRegistro;

	@Inject
	private CuentaDAO daoCuenta;

	@Inject
	private MovimientoDAO daoMovimiento;

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

	public void buscarCuenta() {
		Cuenta cue = null;
		listaCuenta.clear();
		try {
			cue = daoCuenta.buscarCuenta(cuenta.getNumero_cuenta());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			cue = null;
			listaCuenta.clear();
			cuenta = new Cuenta();
		}
		if (cue == null) {
			FacesUtils.msgError("Error", "No se encontro la cuenta");
			listaCuenta.clear();
			cuenta = new Cuenta();
		} else {
			cuenta = cue;
			listaCuenta.add(cue);
		}
	}

	public void deposito() {

		try {
			if (movimiento.getCantidad() == null || movimiento.getCantidad().equals("")) {
				FacesUtils.msgError("Error", "Debe llenar los campos de la cantidad");
				return;
			}

			int idMovimiento = daoMovimiento.contarMovimiento();
			movimiento.setMovimiento_id(idMovimiento);
			movimiento.setFecha(new Date());
			movimiento.setTipo_movimiento("Deposito");
			movimiento.setCuenta(cuenta);
			movimiento.setSaldo(cuenta.getSaldo()+movimiento.getCantidad());
			daoMovimiento.insertMovimiento(movimiento);
			FacesUtils.msgInfo("Exito", "Deposito Realizado");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void retiro() {

		try {
			if (movimiento.getCantidad() == null || movimiento.getCantidad().equals("")) {
				FacesUtils.msgError("Error", "Debe llenar los campos de la cantidad");
				return;
			}

			if (cuenta.getSaldo() < movimiento.getCantidad()) {
				FacesUtils.msgError("Error", "La cantidad no esta disponiblle");

			} else {
				int idMovimiento = daoMovimiento.contarMovimiento();
				movimiento.setMovimiento_id(idMovimiento);
				movimiento.setFecha(new Date());
				movimiento.setTipo_movimiento("Retiro");
				movimiento.setCuenta(cuenta);
				movimiento.setSaldo(cuenta.getSaldo()-movimiento.getCantidad());
				daoMovimiento.insertMovimiento(movimiento);
				FacesUtils.msgInfo("Exito", "Retiro Realizado");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public List<Cuenta> getListaCuenta() {
		return listaCuenta;
	}

	public void setListaCuenta(List<Cuenta> listaCuenta) {
		this.listaCuenta = listaCuenta;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

}
