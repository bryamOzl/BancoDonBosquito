package ec.edu.ups.donBosquito.negocio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.donBosquito.DAO.CuentaDAO;
import ec.edu.ups.donBosquito.DAO.HistorialAccesosDAO;
import ec.edu.ups.donBosquito.DAO.MovimientoDAO;
import ec.edu.ups.donBosquito.DAO.PersonaDAO;
import ec.edu.ups.donBosquito.DAO.RegistroDAO;
import ec.edu.ups.donBosquito.core.FacesUtils;
import ec.edu.ups.donBosquito.modelo.Cuenta;
import ec.edu.ups.donBosquito.modelo.Historial_Acceso;
import ec.edu.ups.donBosquito.modelo.Movimiento;
import ec.edu.ups.donBosquito.modelo.Persona;
import ec.edu.ups.donBosquito.modelo.Registro;

@Stateless
public class MovimientoON implements MovimientoONLocal {

	@Inject
	private MovimientoDAO daoMovimiento;
	
	@Inject
	private CuentaDAO cuentaDAO;
	
	@Inject
	private RegistroDAO daoRegistro;

	@Inject
	private HistorialAccesosDAO daoHAcceso;
	


	private Cuenta cuenta = new Cuenta();

	public boolean movimiento(Movimiento movimiento) throws Exception {
		if (movimiento == null)
			throw new Exception("Error en el Objeto Movimiento");
		try {
			daoMovimiento.insertMovimiento(movimiento);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al Ingresar Movimiento");
		}
		return true;
	}
	
	public int movimientoN () throws SQLException {
		int id= daoMovimiento.contarMovimiento();
		return id;
	}
	
	public Cuenta cuenta(String nCuenta) throws SQLException {
		cuenta = cuentaDAO.buscarCuenta(nCuenta);
		return cuenta;
	}
	
	public void login(String user, String pass) throws SQLException {
		
		
		boolean login = false;
		java.util.Date fecha = new Date();
		Registro registro = null;
		Historial_Acceso HAcceso = new Historial_Acceso();
		String contraAux = "";
		String rol = "";
		String estado = "";
		
		
		try {
			registro = daoRegistro.leerNombre(user);
			contraAux = registro.getContrasenia();
			estado = registro.getEstado();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (registro != null && estado.equals("Habilitado")) {
			System.out.println(contraAux);

			System.out.println(pass);
			System.out.println(registro);

			if (contraAux.equals(pass)) {
				try {
					HAcceso.setHist_acceso_id(daoHAcceso.contarHistorial());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				HAcceso.setFecha_acceso(fecha);
				HAcceso.setRegistro(registro);
				HAcceso.setTipo_acceso("Satisfactorio");
				System.out.println(HAcceso);
				try {
					daoHAcceso.insertHistorial(HAcceso);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				registro.setIntento(0);
				registro.setEstado("Habilitado");
				try {
					daoRegistro.updateRegistro(registro);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rol = registro.getRol();
				login = true;
			} else {

				try {
					HAcceso.setHist_acceso_id(daoHAcceso.contarHistorial());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				HAcceso.setFecha_acceso(fecha);
				HAcceso.setRegistro(registro);
				HAcceso.setTipo_acceso("Fallido");
				System.out.println(HAcceso);
				try {
					daoHAcceso.insertHistorial(HAcceso);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if((registro.getIntento() + 1) >= 3) {
					registro.setIntento(3);
					registro.setEstado("Bloqueado");
					try {
						daoRegistro.updateRegistro(registro);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					registro.setIntento(registro.getIntento() + 1);
					try {
						daoRegistro.updateRegistro(registro);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				login = false;
				

			}

		} else if ( registro == null && estado.equals("Habilitado")){
			login = false;
		} else if (registro != null && estado.equals("Bloqueado")){
			login = false;
			FacesUtils.msgError(null, "Usuario Bloqueado");
		}
		
	}
	
	@Inject
	private PersonaDAO daoPersona;

	public boolean registrarPersona(Persona persona) throws Exception {
		if (persona == null)
			throw new Exception("Error en el Objeto Persona");
		try {
			daoPersona.insertPersona(persona);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al Ingresar Persona");
		}
		return true;
	}

	public Persona leerPersona(String cedula) throws Exception {
		if (cedula.length() != 10 || cedula.equals(""))
			throw new Exception("Cedula es Incorrecta o Vacia");
		Persona persona = daoPersona.buscarCedula(cedula);
		return persona;
	}

	public boolean actualizarPersona(Persona persona) throws Exception {
		if (persona == null)
			throw new Exception("Error en el Objeto Persona");
		try {
			daoPersona.updatePersona(persona);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al Ingresar Persona");
		}
		return true;
	}

	public boolean eliminarPersona(String cedula) throws Exception {
		if (cedula.length() != 10 || cedula.equals(""))
			throw new Exception("Cedula es Incorrecta o Vacia");
		try {
			daoPersona.deletePersona(cedula);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Error al eliminar la Persona");
		}
		return true;
	}
	
	
	

}
