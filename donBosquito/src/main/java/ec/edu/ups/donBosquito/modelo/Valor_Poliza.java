package ec.edu.ups.donBosquito.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Valor_Poliza implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "valor_id")
	private int valor_id;
	private String plazo;
	private Double tasa_interes;

	public int getValor_id() {
		return valor_id;
	}

	public void setValor_id(int valor_id) {
		this.valor_id = valor_id;
	}

	public String getPlazo() {
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	public Double getTasa_interes() {
		return tasa_interes;
	}

	public void setTasa_interes(Double tasa_interes) {
		this.tasa_interes = tasa_interes;
	}

	@Override
	public String toString() {
		return "Valor_Poliza [valor_id=" + valor_id + ", plazo=" + plazo + ", tasa_interes=" + tasa_interes + "]";
	}

}
