package ec.edu.ups.donBosquito.service;

import java.sql.SQLException;
import java.util.Date;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.donBosquito.modelo.Cuenta;
import ec.edu.ups.donBosquito.modelo.Movimiento;
import ec.edu.ups.donBosquito.negocio.MovimientoONLocal;

@WebService
public class MovimientoServiceSOAP {
	

	@Inject
	private MovimientoONLocal onMovimiento;

	private Movimiento movimiento = new Movimiento();
	private Cuenta cuenta = new Cuenta();

	@WebMethod
	public String saludar (String nombre) {
		return "hola" + nombre;
	}
	
	@WebMethod
	public int suma(int a, int b) {
		return a + b;
	}
	
	@WebMethod
	public void deposito(int cuentaid, Date fecha, double cantidad,  double saldo) throws Exception {
		cuenta.setCuenta_id(cuentaid);
		int idMovimiento = onMovimiento.movimientoN();
		
		movimiento.setMovimiento_id(idMovimiento);
		movimiento.setFecha(fecha);
		movimiento.setCantidad(cantidad);
		movimiento.setTipo_movimiento("Deposito");
		movimiento.setCuenta(cuenta);
		movimiento.setSaldo(saldo);
		onMovimiento.movimiento(movimiento);
	}
	
	@WebMethod
	public void retiro(int cuentaid, Date fecha, double cantidad,  double saldo) throws Exception {
		cuenta.setCuenta_id(cuentaid);
		int idMovimiento = onMovimiento.movimientoN();
		
		movimiento.setMovimiento_id(idMovimiento);
		movimiento.setFecha(fecha);
		movimiento.setCantidad(cantidad);
		movimiento.setTipo_movimiento("Retiro");
		movimiento.setCuenta(cuenta);
		movimiento.setSaldo(saldo);
		onMovimiento.movimiento(movimiento);
	}
	
	
}
