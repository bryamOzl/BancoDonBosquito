package ec.edu.ups.donBosquito.negocio;

import java.sql.SQLException;

import javax.ejb.Local;

import ec.edu.ups.donBosquito.modelo.Cuenta;
import ec.edu.ups.donBosquito.modelo.Movimiento;

@Local
public interface MovimientoONLocal {

	public boolean movimiento(Movimiento movimiento) throws Exception;
	public int movimientoN () throws SQLException;
	public Cuenta cuenta(String nCuenta) throws SQLException;
	
	
	
}
