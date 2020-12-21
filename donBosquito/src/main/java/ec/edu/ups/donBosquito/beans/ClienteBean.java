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
import ec.edu.ups.donBosquito.DAO.RegistroDAO;
import ec.edu.ups.donBosquito.core.FacesUtils;
import ec.edu.ups.donBosquito.modelo.Cuenta;
import ec.edu.ups.donBosquito.modelo.Registro;

@ManagedBean
@ViewScoped
public class ClienteBean {

	private List<Cuenta> listaCuentas = new ArrayList<>();
	public Cuenta select;

	@Inject
	private CuentaDAO daoCuenta;

	@Inject
	private RegistroDAO daoRegistro;

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String user = (String) facesContext.getExternalContext().getSessionMap().get("usuario");
		if (user.equals("")) {
			FacesUtils.msgError("Error", "Usuario no cargado");
		} else {
			try {
				Registro registro = daoRegistro.leerNombre(user);
				if (registro == null) {
					FacesUtils.msgError("Error", "Usuario no existe");
				} else {
					listaCuentas = daoCuenta.listarCuenta(registro.getRegistro_id());

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

}
