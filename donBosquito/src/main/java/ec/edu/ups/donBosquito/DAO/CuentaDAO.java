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

import ec.edu.ups.donBosquito.modelo.Cuenta;
import ec.edu.ups.donBosquito.modelo.Registro;

@Stateless
public class CuentaDAO {

	@Inject
	private EntityManager em;

	@Inject
	private Connection con;

	public boolean insertCuenta(Cuenta cuenta) throws SQLException {
		em.persist(cuenta);
		return true;
	}

	public Cuenta leerCuenta(int registro_id) throws SQLException {
		Cuenta cuenta = new Cuenta();
		String sql = "SELECT * FROM Cuenta WHERE  registro_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, registro_id);
		ResultSet res = ps.executeQuery();
		res.next();
		cuenta.setCuenta_id(res.getInt("cuenta_id"));
		cuenta.setFecha_apertura(res.getDate("fecha_apertura"));
		cuenta.setNumero_cuenta(res.getString("numero_cuenta"));
		cuenta.setSaldo(res.getDouble("saldo"));
		cuenta.setTipo_cuenta(res.getString("tipo_cuenta"));
		cuenta.setRegistro(em.find(Registro.class, registro_id));
		ps.execute();
		ps.close();
		return cuenta;
	}

	public Cuenta readCueta(int cuenta_id) throws SQLException {
		Cuenta cuenta = em.find(Cuenta.class, cuenta_id);
		return cuenta;
	}

	public boolean update(Cuenta cuenta) throws SQLException {
		em.merge(cuenta);
		return true;
	}

	public boolean deleteCuenta(int cuenta_id) throws SQLException {
		em.remove(em.find(Cuenta.class, cuenta_id));
		return true;
	}

	public List<Cuenta> listarCuenta(int registro_id) {

		List<Cuenta> listarCuenta = new ArrayList<>();
		String sql = "SELECT * FROM Cuenta WHERE resgistro_id=? ORDER BY cuenta_id ASC";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, registro_id);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Cuenta cuenta = new Cuenta();
				cuenta.setCuenta_id(res.getInt("cuenta_id"));
				cuenta.setFecha_apertura(res.getDate("fecha_apertura"));
				cuenta.setNumero_cuenta(res.getString("numero_cuenta"));
				cuenta.setSaldo(res.getDouble("saldo"));
				cuenta.setTipo_cuenta(res.getString("tipo_cuenta"));
				cuenta.setRegistro(em.find(Registro.class, registro_id));
				listarCuenta.add(cuenta);
			}
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro al listar a la las cuenntas " + e.getMessage());
		}
		return listarCuenta;
	}

	public int contarCuenta() throws SQLException {
		int s;
		String sql = "SELECT MAX (cuenta_id) FROM Cuenta";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet res = ps.executeQuery();
		res.next();
		s = res.getInt(1) + 1;
		ps.execute();
		ps.close();
		return s;
	}
}
