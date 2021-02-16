package ec.edu.ups.donBosquito.negocio;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.ejb.Local;

import ec.edu.ups.donBosquito.modelo.Cuenta;
import ec.edu.ups.donBosquito.modelo.Movimiento;
import ec.edu.ups.donBosquito.modelo.Persona;

@Local
public interface MovimientoONLocal {

	public boolean movimiento(Movimiento movimiento) throws Exception;
	public int movimientoN () throws SQLException;
	public Cuenta cuenta(String nCuenta) throws SQLException;
	public boolean registrarPersona(Persona persona) throws Exception;
	public Persona leerPersona(String cedula) throws Exception;
	public boolean actualizarPersona(Persona persona) throws Exception;
	public boolean eliminarPersona(String cedula) throws Exception;
	public void login(String user, String pass) throws SQLException ;
	
	
	
}
