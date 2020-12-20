package ec.edu.ups.donBosquito.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.donBosquito.modelo.Persona;
import ec.edu.ups.donBosquito.modelo.Registro;

@Stateless
public class RegistroDAO {

	@Inject
	private Connection con;

	@Inject
	private EntityManager em;

	public boolean insertRegistro(Registro registro) throws SQLException {
		em.persist(registro);
		return true;
	}

	public Registro leerRegistro(int persona_id) throws SQLException {
		Registro registro = new Registro();
		String sql = "SELECT * FROM Registro WHERE  persona_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, persona_id);
		ResultSet res = ps.executeQuery();
		res.next();
		registro.setRegistro_id(res.getInt("registro_id"));
		registro.setContrasenia(res.getString("contrasenia"));
		registro.setEstado(res.getString("estado"));
		registro.setRol(res.getString("rol"));
		registro.setUsuario(res.getString("usuario"));
		registro.setPersona(em.find(Persona.class, persona_id));
		ps.execute();
		ps.close();
		return registro;
	}

	
	public Registro login(String usuario , String contrasenia, String rol) throws SQLException {
		Registro registro = new Registro();
		String sql = "SELECT * FROM registro r WHERE r.usuario = ? AND r.contrasenia = ? AND r.rol = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, usuario);
		ps.setString(2, contrasenia);
		ps.setString(3, rol);
		ResultSet res = ps.executeQuery();
		res.next();
		registro.setRegistro_id(res.getInt("registro_id"));
		registro.setContrasenia(res.getString("contrasenia"));
		registro.setEstado(res.getString("estado"));
		registro.setRol(res.getString("rol"));
		registro.setUsuario(res.getString("usuario"));
		
		ps.execute();
		ps.close();
		return registro;
	}
	
	public Registro readRegistro(int registro_id) throws SQLException {
		Registro registro = em.find(Registro.class, registro_id);
		return registro;
	}

	public boolean updateRegistro(Registro registro) throws SQLException {
		em.merge(registro);
		return true;
	}

	public boolean deleteRegistro(int registro_id) throws SQLException {
		em.remove(readRegistro(registro_id));
		return true;
	}

	public int contarRegistro() throws SQLException {
		int s;
		String sql = "SELECT MAX (registro_id) FROM Registro";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet res = ps.executeQuery();
		res.next();
		s = res.getInt(1) + 1;
		ps.execute();
		ps.close();
		return s;
	}
}
