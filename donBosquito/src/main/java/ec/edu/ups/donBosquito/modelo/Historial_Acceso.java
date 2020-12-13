package ec.edu.ups.donBosquito.modelo;

import java.util.Date;

public class Historial_Acceso {

	private int hist_acceso;
	private Date fecha_acceso;
	private String tipo_acceso;
	private Registro registro;

	public int getHist_acceso() {
		return hist_acceso;
	}

	public void setHist_acceso(int hist_acceso) {
		this.hist_acceso = hist_acceso;
	}

	public Date getFecha_acceso() {
		return fecha_acceso;
	}

	public void setFecha_acceso(Date fecha_acceso) {
		this.fecha_acceso = fecha_acceso;
	}

	public String getTipo_acceso() {
		return tipo_acceso;
	}

	public void setTipo_acceso(String tipo_acceso) {
		this.tipo_acceso = tipo_acceso;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	@Override
	public String toString() {
		return "historial_acceso [hist_acceso=" + hist_acceso + ", fecha_acceso=" + fecha_acceso + ", tipo_acceso="
				+ tipo_acceso + ", registro=" + registro + "]";
	}

}
