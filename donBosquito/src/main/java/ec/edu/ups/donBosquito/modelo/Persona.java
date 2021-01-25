package ec.edu.ups.donBosquito.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "Persona", schema ="public", uniqueConstraints = @UniqueConstraint(columnNames = {"id","cedula"}) )
public class Persona implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name= "persona_id")
	private int persona_id;
	
	@Column(name= "cedula")
	private String cedula;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private Date fecha_nacimiento;
	private String correo;
	


	public int getPersona_id() {
		return persona_id;
	}

	public void setPersona_id(int persona_id) {
		this.persona_id = persona_id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}



	@Override
	public String toString() {
		return "Persona [persona_id=" + persona_id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido="
				+ apellido + ", direccion=" + direccion + ", telefono=" + telefono + ", fecha_nacimiento="
				+ fecha_nacimiento + ", correo=" + correo + "]";
	}

	

}
