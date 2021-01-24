package ec.edu.ups.donBosquito.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.donBosquito.DAO.CuentaDAO;
import ec.edu.ups.donBosquito.core.FacesUtils;
import ec.edu.ups.donBosquito.modelo.Cuenta;
import ec.edu.ups.donBosquito.modelo.Movimiento;
import ec.edu.ups.donBosquito.negocio.MovimientoONLocal;

@Path("clientes")
public class ClienteServiceREST {
	
	@Inject
	private MovimientoONLocal onMovimiento;
	
	@Inject
	private CuentaDAO daoCuenta;
	
	@Inject
	private Connection con;

	private Movimiento movimiento = new Movimiento();
	private Cuenta cuenta = new Cuenta();
	
	private List<Cuenta> listaCuenta = new ArrayList<>();
	
	
	/**
	 * Tipos de invocacion
	 * GET Consultar
	 * POST Transacciones / Crear Recursos
	 * PUT	Transacciones de tipos actualizacion/ actualizar recursos
	 * DELETE Transacciones de tipo eliminar/ eliminar recursos
	 * @param nombre
	 * @return
	 */
	public String saludar (String nombre) {
		return "hola " + nombre;
	}
	
	@GET
	@Produces("application/json")
	@Path("suma")
	public int suma(@QueryParam("a")int a,@QueryParam("b") int b) {
		return a + b;
	}
	
	@GET
	@Path("multiplicacion/{a}/{b}")
	public int multiplicar(@javax.ws.rs.PathParam("a") int a,@javax.ws.rs.PathParam("b") int b) {
		return a * b;
	}
	
	
	@GET
	@Produces("application/json")
	@Path("buscarCuenta")
	public Cuenta buscarCuenta(@QueryParam("nCuenta") String nCuenta) {
		Cuenta cue = null;
		//nCuenta = "3";
		
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
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("deposito")
	public Mensaje deposito(Movimiento movimiento) throws Exception {
		Mensaje men = new Mensaje();
		cuenta.setCuenta_id(movimiento.getCuenta().getCuenta_id());
		int idMovimiento = onMovimiento.movimientoN();
		
		movimiento.setMovimiento_id(idMovimiento);
		movimiento.setFecha(movimiento.getFecha());
		movimiento.setCantidad(movimiento.getCantidad());
		movimiento.setTipo_movimiento("Deposito");
		movimiento.setCuenta(movimiento.getCuenta());
		movimiento.setSaldo(movimiento.getSaldo());
		onMovimiento.movimiento(movimiento);
		men.setCode("OK");
		men.setCode("Desposito Realizado");
		return men;
		
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("retiro")
	public Mensaje retiro(Movimiento movimiento) throws Exception {
		Mensaje men = new Mensaje();
		cuenta.setCuenta_id(movimiento.getCuenta().getCuenta_id());
		int idMovimiento = onMovimiento.movimientoN();
		
		movimiento.setMovimiento_id(idMovimiento);
		movimiento.setFecha(movimiento.getFecha());
		movimiento.setCantidad(movimiento.getCantidad());
		movimiento.setTipo_movimiento("Deposito");
		movimiento.setCuenta(movimiento.getCuenta());
		movimiento.setSaldo(movimiento.getSaldo());
		onMovimiento.movimiento(movimiento);
		men.setCode("OK");
		men.setCode("Desposito Realizado");
		return men;
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
