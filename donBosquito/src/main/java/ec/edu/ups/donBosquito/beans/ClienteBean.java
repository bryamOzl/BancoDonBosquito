package ec.edu.ups.donBosquito.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.donBosquito.DAO.CuentaDAO;
import ec.edu.ups.donBosquito.DAO.HistorialAccesosDAO;
import ec.edu.ups.donBosquito.DAO.PolizaDAO;
import ec.edu.ups.donBosquito.DAO.RegistroDAO;
import ec.edu.ups.donBosquito.core.FacesUtils;
import ec.edu.ups.donBosquito.modelo.Cuenta;
import ec.edu.ups.donBosquito.modelo.Historial_Acceso;
import ec.edu.ups.donBosquito.modelo.Poliza;
import ec.edu.ups.donBosquito.modelo.Registro;

@ManagedBean
@ViewScoped
public class ClienteBean {

	private List<Cuenta> listaCuentas = new ArrayList<>();
	private List<Historial_Acceso> listaHistorial_Accesos = new ArrayList<>();
	public Cuenta select;
	public Registro registro = new Registro();

	@Inject
	private CuentaDAO daoCuenta;

	@Inject
	private RegistroDAO daoRegistro;
	
	@Inject
	private HistorialAccesosDAO daoHAcceso;


	
	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String user = (String) facesContext.getExternalContext().getSessionMap().get("usuario");
		if (user.equals("")) {
			FacesUtils.msgError("Error", "Usuario no cargado");
		} else {
			try {
				System.out.println("-----------------------");
				System.out.println(user);
				System.out.println("-----------------------");
				registro = daoRegistro.leerNombre(user);
				
				if (registro == null) {
					FacesUtils.msgError("Error", "Usuario no existe");
				} else {
					
					listaCuentas = daoCuenta.listarCuenta(registro.getRegistro_id());
					listaHistorial_Accesos = daoHAcceso.listarHAcceso(registro.getRegistro_id());
					registro = daoRegistro.leerRegistro(registro.getRegistro_id());
					System.out.println(registro);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void movimiento(Cuenta cuenta) {
		FacesUtils.redirect("/blue-ice-813371382/InformacionCuentasCliente.jsf?cuenta=" + cuenta.getCuenta_id());
	}

	public List<Cuenta> getListaCuentas() {
		return listaCuentas;
	}

	public void setListaCuentas(List<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}

	public Cuenta getSelect() {
		return select;
	}

	public void setSelect(Cuenta select) {
		this.select = select;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public List<Historial_Acceso> getListaHistorial_Accesos() {
		return listaHistorial_Accesos;
	}

	public void setListaHistorial_Accesos(List<Historial_Acceso> listaHistorial_Accesos) {
		this.listaHistorial_Accesos = listaHistorial_Accesos;
	}

	

	
}
