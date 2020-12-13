package ec.edu.ups.donBosquito.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transferencia_Externa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "transferencia_id")
	private int transferenciae_id;
	private Double monto;
	private Date fecha;

	@ManyToOne
	@JoinColumn(name = "entidad_id")
	private Entidad_Externa cuenta_destino;

	@ManyToOne
	@JoinColumn(name = "cuenta_id")
	private Cuenta cuenta_origen;

	public int getTransferenciae_id() {
		return transferenciae_id;
	}

	public void setTransferenciae_id(int transferenciae_id) {
		this.transferenciae_id = transferenciae_id;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Entidad_Externa getCuenta_destino() {
		return cuenta_destino;
	}

	public void setCuenta_destino(Entidad_Externa cuenta_destino) {
		this.cuenta_destino = cuenta_destino;
	}

	public Cuenta getCuenta_origen() {
		return cuenta_origen;
	}

	public void setCuenta_origen(Cuenta cuenta_origen) {
		this.cuenta_origen = cuenta_origen;
	}

	@Override
	public String toString() {
		return "Transferencia_Externa [transferenciae_id=" + transferenciae_id + ", monto=" + monto + ", fecha=" + fecha
				+ ", cuenta_destino=" + cuenta_destino + ", cuenta_origen=" + cuenta_origen + "]";
	}

}
