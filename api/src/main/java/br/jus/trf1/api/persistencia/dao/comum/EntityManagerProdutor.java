package br.jus.trf1.api.persistencia.dao.comum;



import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.jus.trf1.api.utilitarios.Constantes;


@ApplicationScoped
public class EntityManagerProdutor {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory( Constantes.PERSISTENCE_UNIT );
	
	private Logger log = Logger.getLogger(getClass().getSimpleName());
    
	@Produces 
    @RequestScoped
	public EntityManager createEntityManager() {
	  log.info("criando em");
	  return emf.createEntityManager();
	}

	/**
	 * @return
	 */
	protected String getPersistenceUnit() {
		return Constantes.PERSISTENCE_UNIT;
	}
	
	public void close(@Disposes EntityManager em) {
		 log.info("fechando em");
	     em.close();
	}	
}
