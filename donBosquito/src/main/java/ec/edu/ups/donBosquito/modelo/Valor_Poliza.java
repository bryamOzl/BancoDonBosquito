package ec.edu.ups.donBosquito.modelo;

public class Valor_Poliza {

	private int valor_id;
	private String tiempo;
	private int tasa_interes;

	public int getValor_id() {
		return valor_id;
	}

	public void setValor_id(int valor_id) {
		this.valor_id = valor_id;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public int getTasa_interes() {
		return tasa_interes;
	}

	public void setTasa_interes(int tasa_interes) {
		this.tasa_interes = tasa_interes;
	}

	@Override
	public String toString() {
		return "Valor_Poliza [valor_id=" + valor_id + ", tiempo=" + tiempo + ", tasa_interes=" + tasa_interes + "]";
	}

}
