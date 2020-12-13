package ec.edu.ups.donBosquito.modelo;

public class Entidad_Externa {

	private int entidad_id;
	private String nombre_entidad;
	private String numero_cuenta_entidad;
	private Persona persona;

	public int getEntidad_id() {
		return entidad_id;
	}

	public void setEntidad_id(int entidad_id) {
		this.entidad_id = entidad_id;
	}

	public String getNombre_entidad() {
		return nombre_entidad;
	}

	public void setNombre_entidad(String nombre_entidad) {
		this.nombre_entidad = nombre_entidad;
	}

	public String getNumero_cuenta_entidad() {
		return numero_cuenta_entidad;
	}

	public void setNumero_cuenta_entidad(String numero_cuenta_entidad) {
		this.numero_cuenta_entidad = numero_cuenta_entidad;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Entidad_Externa [entidad_id=" + entidad_id + ", nombre_entidad=" + nombre_entidad
				+ ", numero_cuenta_entidad=" + numero_cuenta_entidad + ", persona=" + persona + "]";
	}

}
