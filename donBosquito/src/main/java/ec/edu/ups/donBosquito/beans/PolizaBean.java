package ec.edu.ups.donBosquito.beans;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;

import ec.edu.ups.donBosquito.DAO.CuentaDAO;
import ec.edu.ups.donBosquito.DAO.MovimientoDAO;
import ec.edu.ups.donBosquito.DAO.PolizaDAO;
import ec.edu.ups.donBosquito.DAO.RegistroDAO;
import ec.edu.ups.donBosquito.core.FacesUtils;
import ec.edu.ups.donBosquito.modelo.Poliza;
import ec.edu.ups.donBosquito.modelo.Registro;
import ec.edu.ups.donBosquito.modelo.Valor_Poliza;

@ManagedBean
@ViewScoped
public class PolizaBean {

	@Inject
	public PolizaDAO polizaDAO;

	@Inject
	private MovimientoDAO daoMovimiento;

	@Inject
	private CuentaDAO cuentaDAO;
	
	@Inject
	private RegistroDAO daoRegistro;

	private List<Valor_Poliza> listarValor_Polizas = new ArrayList<Valor_Poliza>();

	public InputStream ceduCliente;
	public InputStream planiCliente;

	private Poliza poliza = new Poliza();
	
	private Valor_Poliza valor_Poliza = new Valor_Poliza();
	
	public Registro registro = new Registro();
	
	private String aux = "";

	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String user = (String) facesContext.getExternalContext().getSessionMap().get("usuario");
		if (user.equals("")) {
			FacesUtils.msgError("Error", "Usuario no cargado");
		} else {
			try {
				registro = daoRegistro.leerNombre(user);	
				//listarValor_Polizas = polizaDAO.listarPoliz();
				//listarPoliz();
				listarValor_Polizas = polizaDAO.listarPoliz();
				buscarIntere();

				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

	public void crearPoliza() throws Exception {
		java.util.Date fecha1 = new Date();

		try {

			if (poliza == null) {
				FacesUtils.msgError("Error", "al guardar poliza");
			}

			poliza.setPoliza_id(polizaDAO.contarPoliza());
			poliza.setCapital(200.0);
			poliza.setEstado("Aprobado");
			poliza.setFecha_creacion(fecha1);
			poliza.setFecha_vencimiento(daoMovimiento.sumarDias(fecha1));
			poliza.setInteres(12.3);
			poliza.setValor_neto(200.00);
			poliza.setCuenta(cuentaDAO.readCueta(1));
			poliza.setImagen_cedula(convertirArchivos(ceduCliente));
			poliza.setImagen_plantilla(convertirArchivos(planiCliente));
			polizaDAO.insertPoliza(poliza);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

	public void archivo1(FileUploadEvent event) throws IOException {
		FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		planiCliente = event.getFile().getInputStream();

	}

	public void archivo2(FileUploadEvent event) throws IOException {
		FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		ceduCliente = event.getFile().getInputStream();

	}

	public byte[] convertirArchivos(InputStream in) throws Exception {

		if (in != null) {
			try {
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				byte[] buffer = new byte[5000000];
				int len;
				while ((len = in.read(buffer)) != -1) {
					os.write(buffer, 0, len);

				}
				return os.toByteArray();
			} catch (Exception e) {
				throw new Exception("Error en convertir archivo" + e.getLocalizedMessage());
			}

		} else {
			System.err.println("erro, archivo nulo");
		}
		return null;
	}



	public void buscarIntere() throws SQLException {
		System.out.println("-----------------------------");
		System.out.println(aux);
		System.out.println("-----------------------------");
		valor_Poliza=polizaDAO.buscarInteres(aux);

	}

	public List<Valor_Poliza> getListarValor_Polizas() {
		return listarValor_Polizas;
	}

	public void setListarValor_Polizas(List<Valor_Poliza> listarValor_Polizas) {
		this.listarValor_Polizas = listarValor_Polizas;
	}

	public InputStream getCeduCliente() {
		return ceduCliente;
	}

	public void setCeduCliente(InputStream ceduCliente) {
		this.ceduCliente = ceduCliente;
	}

	public InputStream getPlaniCliente() {
		return planiCliente;
	}

	public void setPlaniCliente(InputStream planiCliente) {
		this.planiCliente = planiCliente;
	}

	public Poliza getPoliza() {
		return poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

	public Valor_Poliza getValor_Poliza() {
		return valor_Poliza;
	}

	public void setValor_Poliza(Valor_Poliza valor_Poliza) {
		this.valor_Poliza = valor_Poliza;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public String getAux() {
		return aux;
	}

	public void setAux(String aux) {
		this.aux = aux;
	}
	
	
	

	
}
