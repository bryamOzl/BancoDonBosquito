package ec.edu.ups.donBosquito.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.executable.ValidateOnExecution;

import org.primefaces.event.FileUploadEvent;

import ec.edu.ups.donBosquito.modelo.Cuenta;
import ec.edu.ups.donBosquito.modelo.Movimiento;
import ec.edu.ups.donBosquito.modelo.Persona;
import ec.edu.ups.donBosquito.modelo.Poliza;
import ec.edu.ups.donBosquito.modelo.Registro;
import ec.edu.ups.donBosquito.modelo.Valor_Poliza;

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
	
	public List<Poliza> listarPoliza(int cuenta_id) {

		List<Poliza> listarPoliza = new ArrayList<>();
		String sql = "SELECT p.poliza_id, p.plazo, p.capital, p.interes, p.fecha_vencimiento FROM Poliza p WHERE p.cuenta_id = ? AND p.estado = 'Aprobado'";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cuenta_id);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Poliza poliza = new Poliza();
				poliza.setPoliza_id(res.getInt("poliza_id"));
				poliza.setPlazo(res.getString("plazo"));
				poliza.setCapital(res.getDouble("capital"));
				poliza.setInteres(res.getDouble("interes"));
				poliza.setFecha_vencimiento(res.getDate("fecha_vencimiento"));
				poliza.setCuenta(em.find(Cuenta.class, cuenta_id));
				listarPoliza.add(poliza);
			}
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro al listar a la las cuenntas " + e.getMessage());
		}
		return listarPoliza;
	}
	
	public List<Valor_Poliza> listarPoliz() {

		List<Valor_Poliza> listarPoliza = new ArrayList<>();
		String sql = "SELECT * FROM Valor_Poliza p ORDER BY p.tasa_interes DESC";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Valor_Poliza valor_poliza = new Valor_Poliza();
				valor_poliza.setValor_id(res.getInt("valor_id"));
				valor_poliza.setPlazo(res.getString("plazo"));
				valor_poliza.setTasa_interes(res.getDouble("tasa_interes"));
				valor_poliza.setTiempoInicio(res.getInt("tiempoinicio"));
				valor_poliza.setTiempoFinal(res.getInt("tiempofinal"));
				listarPoliza.add(valor_poliza);
			}
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro al listar a la las cuenntas " + e.getMessage());
		}
		return listarPoliza;
	}
	
		
	public Valor_Poliza buscarInteres(String dias) {

		System.out.println(dias);
		Valor_Poliza valor_Poliza = new Valor_Poliza();
		String sql = "SELECT * FROM Valor_Poliza WHERE plazo=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dias);
			ResultSet res = ps.executeQuery();
			res.next();
			valor_Poliza.setValor_id(res.getInt("valor_id"));
			valor_Poliza.setPlazo(res.getString("plazo"));
			valor_Poliza.setTasa_interes(res.getDouble("tasa_interes"));
			valor_Poliza.setTiempoInicio(res.getInt("tiempoinicio"));
			valor_Poliza.setTiempoFinal(res.getInt("tiempofinal"));
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al buscar el interes por la dias " + e.getMessage());
		}
		return valor_Poliza;
	}
	
}
