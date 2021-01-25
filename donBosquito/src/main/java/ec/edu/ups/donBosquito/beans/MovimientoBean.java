package ec.edu.ups.donBosquito.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import ec.edu.ups.donBosquito.DAO.CuentaDAO;
import ec.edu.ups.donBosquito.DAO.MovimientoDAO;
import ec.edu.ups.donBosquito.DAO.RegistroDAO;
import ec.edu.ups.donBosquito.modelo.Cuenta;
import ec.edu.ups.donBosquito.modelo.Movimiento;
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
	
	
	private List<Cuenta> listaCuentas = new ArrayList<>();

	private List<Movimiento> listaMovimiento = new ArrayList<>();

	@PostConstruct
	public void init() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String cuenta = request.getParameter("cuenta");
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String user = (String) facesContext.getExternalContext().getSessionMap().get("usuario");
		try {
			Registro registro = daoRegistro.leerNombre(user);
			listaCuentas = daoCuenta.listarCuenta(registro.getRegistro_id());
			listarMovimientos(Integer.valueOf(cuenta));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void listarMovimientos(int cuenta_id) {
		listaMovimiento = daoMovimiento.listarMovimiento(cuenta_id);

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

}
