package ec.edu.ups.donBosquito.negocio;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.donBosquito.DAO.PersonaDAO;
import ec.edu.ups.donBosquito.modelo.Persona;

@Stateless
public class GestionPersonaON implements GestionPersonaONRemoto{

	@Inject
	private PersonaDAO daoPersona;

	public boolean registrarPersona(Persona persona) throws Exception {
		//if (persona == null)
		//	throw new Exception("Error en el Objeto Persona");
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
		try {
			Persona persona = daoPersona.readPersona(cedula);
			return persona;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Error al leer la Persona");
		}
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
