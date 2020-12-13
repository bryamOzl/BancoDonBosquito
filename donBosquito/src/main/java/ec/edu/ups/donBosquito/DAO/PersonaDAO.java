package ec.edu.ups.donBosquito.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.donBosquito.modelo.Persona;

@Stateless
public class PersonaDAO {

	@Inject
	private Connection con;

	@Inject
	private EntityManager em;

	/**
	 * Metodo para crear una Persona utilizando JPA
	 * 
	 * @param entity
	 * @return
	 * @throws SQLException
	 */
	public boolean insertPersona(Persona entity) throws SQLException {
		em.persist(entity);
		return true;
	}

	/**
	 * Metodo para leer una Persona mediante la cedula con JPA
	 * 
	 * @param cedula
	 * @return
	 * @throws SQLException
	 */
	public Persona readPersona(String cedula) throws SQLException {
		Persona persona = em.find(Persona.class, cedula);
		return persona;
	}

	/**
	 * Metodo para actualizar una persona con JPA
	 * 
	 * @param persona
	 * @return
	 * @throws SQLException
	 */
	public boolean updatePersona(Persona persona) throws SQLException {
		em.merge(persona);
		return true;
	}

	/**
	 * Metodo para eliminar una persona mediante la cedula
	 * 
	 * @param cedula
	 * @return
	 * @throws SQLException
	 */
	public boolean deletePersona(String cedula) throws SQLException {
		em.remove(readPersona(cedula));
		return true;
	}
}
