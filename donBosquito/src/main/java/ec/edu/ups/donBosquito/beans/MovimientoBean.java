package ec.edu.ups.donBosquito.beans;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.sun.xml.messaging.saaj.packaging.mime.internet.ParseException;

import ec.edu.ups.donBosquito.DAO.CuentaDAO;
import ec.edu.ups.donBosquito.DAO.MovimientoDAO;
import ec.edu.ups.donBosquito.DAO.PolizaDAO;
import ec.edu.ups.donBosquito.DAO.RegistroDAO;
import ec.edu.ups.donBosquito.modelo.Cuenta;
import ec.edu.ups.donBosquito.modelo.Movimiento;
import ec.edu.ups.donBosquito.modelo.Poliza;
import ec.edu.ups.donBosquito.modelo.Registro;

@ManagedBean
@ViewScoped
public class MovimientoBean {

	@Inject
	private CuentaDAO daoCuenta;

	@Inject
	private RegistroDAO daoRegistro;

	@Inject
	private MovimientoDAO daoMovimiento;
	
	@Inject
	private PolizaDAO polizaDAO;
	
	private Date fechaInicial;
	private Date fechaFinaL;
	
	@Inject
	private Registro registro;
	
	
	private List<Cuenta> listaCuentas = new ArrayList<>();

	private List<Movimiento> listaMovimiento = new ArrayList<>();
	
	private List<Poliza> listarPoliza = new ArrayList<Poliza>();

	@PostConstruct
	public void init(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String user = (String) facesContext.getExternalContext().getSessionMap().get("usuario");
		try {
			registro = daoRegistro.leerNombre(user);
			listaCuentas = daoCuenta.listarCuenta(registro.getRegistro_id());
			java.util.Date fecha1 = new Date();
			fechaFinaL = daoMovimiento.restarDias(fecha1);
			fechaInicial = fecha1;
			
			listarMovimientos();
			listarPoliza();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void listarMovimientos() throws SQLException {
		Cuenta cuent = new Cuenta();
		cuent = (Cuenta) daoCuenta.leerCuenta(registro.getRegistro_id());
		listaMovimiento = daoMovimiento.listarMovimientoF(cuent.getCuenta_id(),fechaInicial,fechaFinaL);

	}
	
	private void listarPoliza() throws SQLException {
		Cuenta cuent = new Cuenta();
		cuent = (Cuenta) daoCuenta.leerCuenta(registro.getRegistro_id());
		listarPoliza = polizaDAO.listarPoliza(cuent.getCuenta_id());

	}
	
	public void listarMovimient() throws SQLException {
		Cuenta cuent = new Cuenta();
		cuent = (Cuenta) daoCuenta.leerCuenta(registro.getRegistro_id());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fech1 = sdf.format(fechaInicial);
		fechaInicial = ParseFecha(fech1);
		String fech2 = sdf.format(fechaFinaL);
		fechaFinaL = ParseFecha(fech2);
		listaMovimiento = daoMovimiento.listarMovimientoF(cuent.getCuenta_id(),fechaInicial,fechaFinaL);

	}
	
	
	
	public List<Cuenta> getListaCuentas() {
		return listaCuentas;
	}

	public void setListaCuentas(List<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}

	public List<Movimiento> getListaMovimiento() {
		return listaMovimiento;
	}

	public void setListaMovimiento(List<Movimiento> listaMovimiento) {
		this.listaMovimiento = listaMovimiento;
	}
	
	

	public List<Poliza> getListarPoliza() {
		return listarPoliza;
	}

	public void setListarPoliza(List<Poliza> listarPoliza) {
		this.listarPoliza = listarPoliza;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinaL() {
		return fechaFinaL;
	}

	public void setFechaFinaL(Date fechaFinaL) {
		this.fechaFinaL = fechaFinaL;
	}

	@Override
	public String toString() {
		return "MovimientoBean [fechaInicial=" + fechaInicial + ", fechaFinaL=" + fechaFinaL + "]";
	}

	/**
     * Permite convertir un String en fecha (Date).
     * @param fecha Cadena de fecha dd/MM/yyyy
     * @return Objeto Date
	 * @throws java.text.ParseException 
     */
    public static Date ParseFecha(String fecha) 
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
			fechaDate = formato.parse(fecha);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return fechaDate;
    }
}
