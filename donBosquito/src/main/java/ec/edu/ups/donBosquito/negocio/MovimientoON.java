package ec.edu.ups.donBosquito.negocio;

import java.sql.SQLException;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.donBosquito.DAO.MovimientoDAO;
import ec.edu.ups.donBosquito.core.FacesUtils;
import ec.edu.ups.donBosquito.modelo.Cuenta;
import ec.edu.ups.donBosquito.modelo.Movimiento;

@Stateless
public class MovimientoON implements MovimientoONLocal {

	@Inject
	private MovimientoDAO daoMovimiento;

	private Movimiento movimiento = new Movimiento();
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

}
