package ec.edu.ups.donBosquito.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.donBosquito.DAO.CuentaDAO;
import ec.edu.ups.donBosquito.core.FacesUtils;
import ec.edu.ups.donBosquito.modelo.Cuenta;
import ec.edu.ups.donBosquito.modelo.Movimiento;
import ec.edu.ups.donBosquito.modelo.Registro;
import ec.edu.ups.donBosquito.negocio.MovimientoONLocal;

@WebService
public class ClienteServiceSOAP {
	
	@Inject
	private MovimientoONLocal onMovimiento;
	
	@Inject
	private CuentaDAO daoCuenta;
	
	@Inject
	private Connection con;

	private Movimiento movimiento = new Movimiento();
	private Cuenta cuenta = new Cuenta();
		
	
	@WebMethod
	public String saludar (String nombre) {
		return "hola " + nombre;
	}
	
	@WebMethod
	public int suma(int a, int b) {
		return a + b;
	}
	
	
	@WebMethod
	public Cuenta buscarCuenta(String nCuenta) {
		Cuenta cue = null;
		
		try {
			cue = onMovimiento.cuenta(nCuenta);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			cue = null;
			cuenta = new Cuenta();
		}
		if (cue == null) {
			FacesUtils.msgError("Error", "No se encontro la cuenta");
			cuenta = new Cuenta();
		} else {
			cuenta = cue;
		}
		return cuenta;
	}
	
	@WebMethod
	public String deposito(int cuentaid, String fecha, double cantidad,  double saldo) throws Exception {
		cuenta.setCuenta_id(cuentaid);
		int idMovimiento = onMovimiento.movimientoN();
		
		movimiento.setMovimiento_id(idMovimiento);
		movimiento.setFecha(ParseFecha(fecha));
		movimiento.setCantidad(cantidad);
		movimiento.setTipo_movimiento("Deposito");
		movimiento.setCuenta(cuenta);
		movimiento.setSaldo(saldo);
		onMovimiento.movimiento(movimiento);
		return "OK";
	}
	
	@WebMethod
	public String retiro(int cuentaid, String fecha, double cantidad,  double saldo) throws Exception {
		cuenta.setCuenta_id(cuentaid);
		int idMovimiento = onMovimiento.movimientoN();
		
		movimiento.setMovimiento_id(idMovimiento);
		movimiento.setFecha(ParseFecha(fecha));
		movimiento.setCantidad(cantidad);
		movimiento.setTipo_movimiento("Retiro");
		movimiento.setCuenta(cuenta);
		movimiento.setSaldo(saldo);
		onMovimiento.movimiento(movimiento);
		return "OK";
	}
	
	/**
     * Permite convertir un String en fecha (Date).
     * @param fecha Cadena de fecha dd/MM/yyyy
     * @return Objeto Date
     */
    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
	

}
