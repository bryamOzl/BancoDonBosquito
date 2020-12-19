package ec.edu.ups.donBosquito.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.donBosquito.modelo.Movimiento;

@Stateless
public class MovimientoDAO {
	
	@Inject
	private EntityManager em;
	
	@Inject
	private Connection con;
	
	public boolean insertMovimiento(Movimiento movimiento) throws SQLException{
		em.persist(movimiento);
		return true;
	}
	
	public  Movimiento readMovimiento(int movimiento_id) throws SQLException{
		Movimiento movimiento = em.find(Movimiento.class, movimiento_id);
		return movimiento;
	}
	
	

}
