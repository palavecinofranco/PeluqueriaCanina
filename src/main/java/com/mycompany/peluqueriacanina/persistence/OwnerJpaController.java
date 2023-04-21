
package com.mycompany.peluqueriacanina.persistence;

import com.mycompany.peluqueriacanina.logic.Owner;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class OwnerJpaController {
        private EntityManagerFactory emf = null;

    public OwnerJpaController() {
        emf = Persistence.createEntityManagerFactory("PeluqueriaCaninaPU"); // Nombre de la unidad de persistencia en persistence.xml
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Owner owner) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(owner);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Owner owner) throws EntityNotFoundException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            owner = em.merge(owner);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                throw new EntityNotFoundException("La persona con id " + owner.getId()+ " no existe.");
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void delete(Integer id) throws EntityNotFoundException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Owner owner;
            try {
                owner = em.getReference(Owner.class, id);
                owner.getId();
            } catch (EntityNotFoundException enfe) {
                throw new EntityNotFoundException("La persona con id " + id + " no existe.");
            }
            em.remove(owner);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Owner> findPetEntities() {
        return findOwnerEntities(true, -1, -1);
    }

    public List<Owner> findOwnerEntities(int maxResults, int firstResult) {
        return findOwnerEntities(false, maxResults, firstResult);
    }

    private List<Owner> findOwnerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT p FROM Owner p");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Owner findOwner(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Owner.class, id);
        } finally {
            em.close();
        }
    }

    public int getOwnerCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT COUNT(p) FROM Owner p");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
