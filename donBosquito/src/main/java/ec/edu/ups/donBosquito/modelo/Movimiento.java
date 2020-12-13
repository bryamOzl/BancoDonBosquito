package ec.edu.ups.donBosquito.modelo;

import java.util.Date;

public class Movimiento {

	private int movimiento_id;
	private String tipo_movimiento;
	private Double cantidad;
	private Date fecha;
	private Cuenta cuenta;

	public int getMovimiento_id() {
		return movimiento_id;
	}

	public void setMovimiento_id(int movimiento_id) {
		this.movimiento_id = movimiento_id;
	}

	public String getTipo_movimiento() {
		return tipo_movimiento;
	}

	public void setTipo_movimiento(String tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "Movimiento [movimiento_id=" + movimiento_id + ", tipo_movimiento=" + tipo_movimiento + ", cantidad="
				+ cantidad + ", fecha=" + fecha + ", cuenta=" + cuenta + "]";
	}

}
