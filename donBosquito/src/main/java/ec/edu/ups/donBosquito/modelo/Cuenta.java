package ec.edu.ups.donBosquito.modelo;

import java.util.Date;

public class Cuenta {

	private int cuenta_id;
	private String tipo_cuenta;
	private Date fecha_apertura;
	private Double saldo;
	private Registro registro;

	public int getCuenta_id() {
		return cuenta_id;
	}

	public void setCuenta_id(int cuenta_id) {
		this.cuenta_id = cuenta_id;
	}

	public String getTipo_cuenta() {
		return tipo_cuenta;
	}

	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

	public Date getFecha_apertura() {
		return fecha_apertura;
	}

	public void setFecha_apertura(Date fecha_apertura) {
		this.fecha_apertura = fecha_apertura;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	@Override
	public String toString() {
		return "Cuenta [cuenta_id=" + cuenta_id + ", tipo_cuenta=" + tipo_cuenta + ", fecha_apertura=" + fecha_apertura
				+ ", saldo=" + saldo + ", registro=" + registro + "]";
	}

}
