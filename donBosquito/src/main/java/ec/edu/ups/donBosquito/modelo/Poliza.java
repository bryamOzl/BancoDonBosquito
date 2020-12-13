package ec.edu.ups.donBosquito.modelo;

import java.awt.Image;
import java.util.Date;

public class Poliza {

	private int poliza_id;
	private double capital;
	private Date fecha_creacion;
	private String plazo;
	private double tasa_interez;
	private Date fecha_vencimiento;
	private Double interes;
	private Double valor_neto;
	private String estado;
	private Image imagen_cedula;
	private Image imagen_plantilla;
	private Cuenta cuenta;

	public int getPoliza_id() {
		return poliza_id;
	}

	public void setPoliza_id(int poliza_id) {
		this.poliza_id = poliza_id;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getPlazo() {
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	public double getTasa_interez() {
		return tasa_interez;
	}

	public void setTasa_interez(double tasa_interez) {
		this.tasa_interez = tasa_interez;
	}

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public Double getInteres() {
		return interes;
	}

	public void setInteres(Double interes) {
		this.interes = interes;
	}

	public Double getValor_neto() {
		return valor_neto;
	}

	public void setValor_neto(Double valor_neto) {
		this.valor_neto = valor_neto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Image getImagen_cedula() {
		return imagen_cedula;
	}

	public void setImagen_cedula(Image imagen_cedula) {
		this.imagen_cedula = imagen_cedula;
	}

	public Image getImagen_plantilla() {
		return imagen_plantilla;
	}

	public void setImagen_plantilla(Image imagen_plantilla) {
		this.imagen_plantilla = imagen_plantilla;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "Poliza [poliza_id=" + poliza_id + ", capital=" + capital + ", fecha_creacion=" + fecha_creacion
				+ ", plazo=" + plazo + ", tasa_interez=" + tasa_interez + ", fecha_vencimiento=" + fecha_vencimiento
				+ ", interes=" + interes + ", valor_neto=" + valor_neto + ", estado=" + estado + ", imagen_cedula="
				+ imagen_cedula + ", imagen_plantilla=" + imagen_plantilla + ", cuenta=" + cuenta + "]";
	}

}
