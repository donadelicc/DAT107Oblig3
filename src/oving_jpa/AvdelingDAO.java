package oving_jpa;

import java.util.List;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


public class AvdelingDAO {
	private EntityManagerFactory emf;

    public AvdelingDAO() {
        emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
    }
    
    public Avdeling hentAvdeling(int id) {
        
        EntityManager em = emf.createEntityManager();
        try {
        	
        	return em.find(Avdeling.class, id);
        	
        } finally {
            em.close();
        }
    }

    public List<Avdeling> finnAlleAvdelinger() {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<Avdeling> query = em.createQuery("SELECT t FROM avdeling t", Avdeling.class);

			return query.getResultList();
			

		} finally {
			em.close();
		}
	}
    public void oppdaterAvdelingsnavn(int id, String navn) {
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction tx = em.getTransaction();
    	
    	try {
    		tx.begin();
    		Avdeling aktuell = em.find(Avdeling.class, id);
        	aktuell.setNavn(navn);
        	
        	tx.commit();
        	
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
		}
		} finally {
			em.close();
			
		}
    	
    	
    }
    public void oppdaterSjef(int id, String avdeling) {
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction tx = em.getTransaction();
    	
    	try {
    		tx.begin();
 
    		Avdeling avd = em.find(Avdeling.class, avdeling);
    		
        	avd.setSjef_Id(id);
        	
        	tx.commit();
        	
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
		}
		} finally {
			em.close();
			
		}
    }
    public void lagNyAvdeling(Avdeling ny) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			
			em.persist(ny);
			
			tx.commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}

}
