package ec.edu.ups.donBosquito.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.donBosquito.modelo.Poliza;

@Stateless
public class PolizaDAO {

	@Inject
	private EntityManager em;

	@Inject
	private Connection con;

	public boolean insertPoliza(Poliza poliza) throws SQLException {
		em.persist(poliza);
		return true;
	}

	public Poliza readPoliza(int poliza_id) throws SQLException {
		Poliza poliza = em.find(Poliza.class, poliza_id);
		return poliza;
	}

	public boolean updatePoliza(Poliza poliza) throws SQLException {
		em.merge(poliza);
		return true;
	}

	public boolean deleteRegistro(int poliza_id) throws SQLException {
		em.remove(em.find(Poliza.class, poliza_id));
		return true;
	}

	public int contarPoliza() throws SQLException {
		int s;
		String sql = "SELECT MAX (poliza_id) FROM Poliza";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet res = ps.executeQuery();
		res.next();
		s = res.getInt(1) + 1;
		ps.execute();
		ps.close();
		return s;
	}
}
