package ec.edu.ups.donBosquito.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.wildfly.security.manager.action.GetModuleClassLoaderAction;

import ec.edu.ups.donBosquito.modelo.Cuenta;
import ec.edu.ups.donBosquito.modelo.Movimiento;
import ec.edu.ups.donBosquito.modelo.Persona;

@Stateless
public class MovimientoDAO {

	@Inject
	private EntityManager em;

	@Inject
	private Connection con;

	public boolean insertMovimiento(Movimiento movimiento) throws SQLException {
		String sql = "UPDATE Cuenta SET saldo = ? WHERE  cuenta_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDouble(1,movimiento.getSaldo());
		ps.setInt(2, movimiento.getCuenta().getCuenta_id());
		ps.executeUpdate();
		ps.close();
		em.persist(movimiento);
		return true;
	}

	public Movimiento readMovimiento(int movimiento_id) throws SQLException {
		Movimiento movimiento = em.find(Movimiento.class, movimiento_id);
		return movimiento;
	}
	
	/**
	 * Metodo para actualizar el campo saldo del objeto movimiento con JPA
	 * 
	 * @param movimiento
	 * @return
	 * @throws SQLException
	 */
	public boolean updateMovimiento(Movimiento movimiento) throws SQLException {
		em.merge(movimiento);
		return true;
	}

	public int contarMovimiento() throws SQLException {
		int s;
		String sql = "SELECT MAX (movimiento_id) FROM Movimiento";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet res = ps.executeQuery();
		res.next();
		s = res.getInt(1) + 1;
		ps.execute();
		ps.close();
		return s;
	}

	public Movimiento leerMovimiento(int cuenta_id) throws SQLException {
		Movimiento movimiento = new Movimiento();
		String sql = "SELECT * FROM Movimiento WHERE  cuenta_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, cuenta_id);
		ResultSet res = ps.executeQuery();
		res.next();
		movimiento.setMovimiento_id(res.getInt("movimiento_id"));
		movimiento.setCantidad(res.getDouble("cantidad"));
		movimiento.setFecha(res.getDate("fecha"));
		movimiento.setTipo_movimiento(res.getString("tipo_movimiento"));
		movimiento.setSaldo(res.getDouble("saldo"));
		movimiento.setCuenta(em.find(Cuenta.class, cuenta_id));
		ps.execute();
		ps.close();
		return movimiento;
	}

	public List<Movimiento> listarMovimiento(int cuenta_id) {

		List<Movimiento> listarMovimiento = new ArrayList<>();
		String sql = "SELECT * FROM Movimiento WHERE cuenta_id=? ORDER BY cuenta_id ASC";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cuenta_id);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Movimiento movimiento = new Movimiento();
				movimiento.setMovimiento_id(res.getInt("movimiento_id"));
				movimiento.setCantidad(res.getDouble("cantidad"));
				movimiento.setFecha(res.getDate("fecha"));
				movimiento.setTipo_movimiento(res.getString("tipo_movimiento"));
				movimiento.setSaldo(res.getDouble("saldo"));
				movimiento.setCuenta(em.find(Cuenta.class, cuenta_id));
				listarMovimiento.add(movimiento);
			}
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro al listar los movimientos " + e.getMessage());
		}
		return listarMovimiento;
	}


}
