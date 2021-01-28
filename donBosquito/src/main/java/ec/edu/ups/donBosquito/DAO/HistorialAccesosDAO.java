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

import ec.edu.ups.donBosquito.modelo.Historial_Acceso;
import ec.edu.ups.donBosquito.modelo.Registro;

@Stateless
public class HistorialAccesosDAO {

	@Inject
	private Connection con;

	@Inject
	private EntityManager em;

	public boolean insertHistorial(Historial_Acceso historial) throws SQLException {
		em.persist(historial);
		return true;
	}

	public Historial_Acceso leerHistorial(int usuario_id) throws SQLException {
		Historial_Acceso historial = new Historial_Acceso();
		String sql = "SELECT * FROM Historial_Acceso WHERE  usuario_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, usuario_id);
		ResultSet res = ps.executeQuery();
		historial.setHist_acceso_id(res.getInt("hist_acceso_id"));
		historial.setFecha_acceso(res.getDate("fecha_acceso"));
		historial.setTipo_acceso(res.getString("tipo_acceso"));
		historial.setRegistro(em.find(Registro.class, usuario_id));
		res.next();
		ps.execute();
		ps.close();
		return historial;
	}

	public Historial_Acceso readHistorial(int hist_acceso_id) throws SQLException {
		Historial_Acceso historial = em.find(Historial_Acceso.class, hist_acceso_id);
		return historial;
	}

	public boolean updateHistorial(Historial_Acceso historial) throws SQLException {
		em.merge(historial);
		return true;
	}

	public boolean deleteHistorial(int hist_acceso_id) throws SQLException {
		em.remove(hist_acceso_id);
		return true;
	}
	
	public List<Historial_Acceso> listarHAcceso(int registro_id) {

		List<Historial_Acceso> listarCuenta = new ArrayList<>();
		String sql = "Select * from Historial_Acceso WHERE registro_id =?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, registro_id);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Historial_Acceso hAcceso = new Historial_Acceso();
				hAcceso.setHist_acceso_id(res.getInt("hist_acceso_id"));
				hAcceso.setFecha_acceso(res.getDate("fecha_acceso"));
				hAcceso.setTipo_acceso(res.getString("tipo_acceso"));
				hAcceso.setRegistro(em.find(Registro.class, registro_id));
				listarCuenta.add(hAcceso);
			}
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro al listar a el historial " + e.getMessage());
		}
		return listarCuenta;
	}
	
	public int contarHistorial() throws SQLException {
		int s;
		String sql = "SELECT MAX (hist_acceso_id) FROM Historial_Acceso";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet res = ps.executeQuery();
		res.next();
		s = res.getInt(1) + 1;
		ps.execute();
		ps.close();
		return s;
	}
}
