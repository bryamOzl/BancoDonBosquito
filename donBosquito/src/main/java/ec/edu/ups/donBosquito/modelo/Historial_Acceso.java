package ec.edu.ups.donBosquito.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Historial_Acceso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "hist_acceso_id")
	private int hist_acceso_id;
	private Date fecha_acceso;
	private String tipo_acceso;
	
	@ManyToOne
	@JoinColumn(name="registro_id")
	private Registro registro;

	public int getHist_acceso_id() {
		return hist_acceso_id;
	}

	public void setHist_acceso_id(int hist_acceso_id) {
		this.hist_acceso_id = hist_acceso_id;
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
		return "Historial_Acceso [hist_acceso_id=" + hist_acceso_id + ", fecha_acceso=" + fecha_acceso
				+ ", tipo_acceso=" + tipo_acceso + ", registro=" + registro + "]";
	}

}
