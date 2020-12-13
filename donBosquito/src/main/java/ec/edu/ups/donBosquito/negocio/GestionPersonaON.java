package ec.edu.ups.donBosquito.negocio;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.donBosquito.DAO.PersonaDAO;
import ec.edu.ups.donBosquito.modelo.Persona;

@Stateless
public class GestionPersonaON {

	@Inject
	private PersonaDAO daoPersona;
	
	public boolean registrarCliente(Persona persona) throws Exception {
		if (persona == null) 
			throw new Exception("Error en el Objeto Persona");
		try {
			daoPersona.insertPersona(persona);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al Ingresar Persona");
		}
		return true;	
	}
	
	
	
	
}
