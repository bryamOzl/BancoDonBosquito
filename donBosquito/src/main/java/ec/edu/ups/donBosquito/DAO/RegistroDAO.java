package ec.edu.ups.donBosquito.DAO;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.donBosquito.modelo.Registro;

@Stateless
public class RegistroDAO {

	@Inject
	private EntityManager em;
	
	public boolean insertRegistro(Registro registro) throws SQLException {
		em.persist(registro);
		return true;
	}
	

}
