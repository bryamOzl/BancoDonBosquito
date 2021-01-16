package ec.edu.ups.donBosquito.negocio;

import ec.edu.ups.donBosquito.modelo.Persona;

public interface GestionPersonaONRemoto {

	public boolean registrarPersona(Persona persona) throws Exception;
	public Persona leerPersona(String cedula) throws Exception;
	public boolean actualizarPersona(Persona persona) throws Exception;
	public boolean eliminarPersona(String cedula) throws Exception;
}
