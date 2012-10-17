/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.micropakito.persist.entity.noticias;

import com.micropakito.persist.entity.noticias.exceptions.NonexistentEntityException;
import com.micropakito.persist.entity.noticias.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author PascuaS
 */
public class NoticiasJpaController {

    public NoticiasJpaController() {
        emf = Persistence.createEntityManagerFactory("UWServerPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Noticias noticias) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(noticias);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNoticias(noticias.getIdNoticias()) != null) {
                throw new PreexistingEntityException("Noticias " + noticias + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Noticias noticias) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            noticias = em.merge(noticias);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = noticias.getIdNoticias();
                if (findNoticias(id) == null) {
                    throw new NonexistentEntityException("The noticias with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Noticias noticias;
            try {
                noticias = em.getReference(Noticias.class, id);
                noticias.getIdNoticias();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The noticias with id " + id + " no longer exists.", enfe);
            }
            em.remove(noticias);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Noticias> findNoticiasEntities() {
        return findNoticiasEntities(true, -1, -1);
    }

    public List<Noticias> findNoticiasEntities(int maxResults, int firstResult) {
        return findNoticiasEntities(false, maxResults, firstResult);
    }

    private List<Noticias> findNoticiasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Noticias.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Noticias findNoticias(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Noticias.class, id);
        } finally {
            em.close();
        }
    }

    public int getNoticiasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Noticias> rt = cq.from(Noticias.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
