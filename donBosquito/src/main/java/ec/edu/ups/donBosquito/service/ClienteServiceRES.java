package ec.edu.ups.donBosquito.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.donBosquito.DAO.CuentaDAO;
import ec.edu.ups.donBosquito.core.FacesUtils;
import ec.edu.ups.donBosquito.modelo.Cuenta;
import ec.edu.ups.donBosquito.modelo.Movimiento;
import ec.edu.ups.donBosquito.modelo.Persona;
import ec.edu.ups.donBosquito.negocio.GestionPersonaON;
import ec.edu.ups.donBosquito.negocio.MovimientoONLocal;

@Path("movimientos")
public class ClienteServiceRES {

	
	
	@Inject
	private MovimientoONLocal onMovimiento;

	@Inject
	private CuentaDAO daoCuenta;

	@Inject
	private Connection con;

	private Movimiento movimiento = new Movimiento();
	private Cuenta cuenta = new Cuenta();


	//@GET
	public String saludar(String nombre) {
		return "hola " + nombre;
	}
	

	@GET
	@Path("suma")
	public int suma(@QueryParam("a") int a, @QueryParam("b") int b) {
		return a + b;
	}
	
	@GET
	@Path("multiplicacion/{a}/{b}")
	public int multiplicacion(@PathParam("a") int a, @PathParam("b") int b) {
		return a * b;
	}
	
	@GET
	@Path("inciarSesison/{user}/{pass}")
	public Mensaje inciarSesison(@PathParam("user") String user, @PathParam("pass") String pass) {
		Mensaje mensaje = new Mensaje();
		
		try {
			onMovimiento.login(user, pass);
			mensaje.setCode("OK");
			mensaje.setMessage("Iniciar Session");
			return mensaje;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mensaje.setCode("OK");
			mensaje.setMessage("Iniciar Session");
			return mensaje;
		}
			
		
		
	}

	@GET
	@Produces("application/json")
	@Path("cuenta")
	public Cuenta buscarCuenta(@QueryParam ("nCuenta") String nCuenta) {
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

	/**
	 * Tipos de Invocacion
	 * 
	 * GET Consultar algo cuando me devuelve algo
	 * POST Se utiliza cuando se crea algo por detras
	 * PUT	Se utiliza cuando se actualiza recursos
	 * DELETE Se utiliza cuando se elimina recursos
	 * @throws Exception
	 */
		
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("deposito")
	public Mensaje insertDeposito(Movimiento movimiento) {
		Mensaje mensaje = new Mensaje();
		try {
			Date fecha;
			movimiento.setMovimiento_id(onMovimiento.movimientoN());
			movimiento.setTipo_movimiento("Deposito");
			movimiento.setFecha(fecha = new Date());
			onMovimiento.movimiento(movimiento);
			mensaje.setCode("OK");
			mensaje.setMessage("Deposito realizado");
			return mensaje;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mensaje.setCode("ERROR");
			mensaje.setMessage(e.getMessage());
			return mensaje;
		}
	}
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("retiro")
	public Mensaje insertRetiro(Movimiento movimiento) {
		Mensaje mensaje = new Mensaje();
		try {
			Date fecha;
			movimiento.setMovimiento_id(onMovimiento.movimientoN());
			movimiento.setTipo_movimiento("Retiro");
			movimiento.setFecha(fecha = new Date());
			onMovimiento.movimiento(movimiento);
			mensaje.setCode("OK");
			mensaje.setMessage("Retiro realizado");
			return mensaje;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mensaje.setCode("ERROR");
			mensaje.setMessage(e.getMessage());
			return mensaje;
		}
	}

	/**
	 * Permite convertir un String en fecha (Date).
	 * 
	 * @param fecha Cadena de fecha dd/MM/yyyy
	 * @return Objeto Date
	 */
	public static Date ParseFecha(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaDate = null;
		try {
			fechaDate = formato.parse(fecha);
		} catch (ParseException ex) {
			System.out.println(ex);
		}
		return fechaDate;
	}
}
