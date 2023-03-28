package oving_jpa;

import java.util.List;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


public class AnsattDAO {
	private EntityManagerFactory emf;

    public AnsattDAO() {
        emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
    }
    
    public Ansatt hentAnsatt(int id) {
        
        EntityManager em = emf.createEntityManager();
        try {
        	
        	return em.find(Ansatt.class, id);
        	
        } finally {
            em.close();
        }
    }
    public Ansatt hentAnsattBrukernavn(String brukernavn) {
        
    	EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT t FROM Ansatt t WHERE t.brukernavn LIKE :brukernavn", Ansatt.class);
			query.setParameter("brukernavn", brukernavn);

			return query.getSingleResult();
			
		} finally {
			em.close();
		}
    }
    public List<Ansatt> finnAlleAnsatte() {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<Ansatt> query = em.createQuery("SELECT t FROM Ansatt t", Ansatt.class);

			return query.getResultList();

		} finally {
			em.close();
		}
	}
    public void oppdaterStilling(int id, String stilling) {
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction tx = em.getTransaction();
    	
    	try {
    		tx.begin();
    		Ansatt aktuell = em.find(Ansatt.class, id);
        	aktuell.setStilling(stilling);
        	
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
    public void oppdaterLonn(int id, int lonn) {
    	EntityManager em = emf.createEntityManager();
    	EntityTransaction tx = em.getTransaction();
    	
    	try {
    		tx.begin();
    		Ansatt aktuell = em.find(Ansatt.class, id);
        	aktuell.setMaanedslonn(lonn);
        	
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
    public void lagreNyAnsatt(Ansatt ny) {
		
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
