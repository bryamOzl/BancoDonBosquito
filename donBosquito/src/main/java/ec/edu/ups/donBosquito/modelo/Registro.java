package ec.edu.ups.donBosquito.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Registro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name= "registro_id")
	private int registro_id;
	private String usuario;
	private String contrasenia;
	private String rol;
	private String estado;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="persona_id")
	private Persona persona;

	public int getRegistro_id() {
		return registro_id;
	}

	public void setRegistro_id(int registro_id) {
		this.registro_id = registro_id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Registro [registro_id=" + registro_id + ", usuario=" + usuario + ", contrasenia=" + contrasenia
				+ ", rol=" + rol + ", estado=" + estado + ", persona=" + persona + "]";
	}

}
