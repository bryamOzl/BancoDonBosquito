package ec.edu.ups.donBosquito.modelo;

import java.util.Date;

public class Transferencia_Local {

	private int transferencial_id;
	private Double monto;
	private Date fecha;
	private Cuenta cuenta_destino;
	private Cuenta cuenta_origen;

	public int getTransferencial_id() {
		return transferencial_id;
	}

	public void setTransferencial_id(int transferencial_id) {
		this.transferencial_id = transferencial_id;
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

	public Cuenta getCuenta_destino() {
		return cuenta_destino;
	}

	public void setCuenta_destino(Cuenta cuenta_destino) {
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
		return "Transferencia_Local [transferencial_id=" + transferencial_id + ", monto=" + monto + ", fecha=" + fecha
				+ ", cuenta_destino=" + cuenta_destino + ", cuenta_origen=" + cuenta_origen + "]";
	}

}
