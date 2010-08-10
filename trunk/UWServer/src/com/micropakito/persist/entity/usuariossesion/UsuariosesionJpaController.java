/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.micropakito.persist.entity.usuariossesion;

import com.micropakito.persist.entity.usuariossesion.exceptions.NonexistentEntityException;
import com.micropakito.persist.entity.usuariossesion.exceptions.PreexistingEntityException;
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
public class UsuariosesionJpaController {

    public UsuariosesionJpaController() {
        emf = Persistence.createEntityManagerFactory("UWServerPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuariosesion usuariosesion) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuariosesion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuariosesion(usuariosesion.getIdUsuarioSesion()) != null) {
                throw new PreexistingEntityException("Usuariosesion " + usuariosesion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuariosesion usuariosesion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuariosesion = em.merge(usuariosesion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuariosesion.getIdUsuarioSesion();
                if (findUsuariosesion(id) == null) {
                    throw new NonexistentEntityException("The usuariosesion with id " + id + " no longer exists.");
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
            Usuariosesion usuariosesion;
            try {
                usuariosesion = em.getReference(Usuariosesion.class, id);
                usuariosesion.getIdUsuarioSesion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuariosesion with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuariosesion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuariosesion> findUsuariosesionEntities() {
        return findUsuariosesionEntities(true, -1, -1);
    }

    public List<Usuariosesion> findUsuariosesionEntities(int maxResults, int firstResult) {
        return findUsuariosesionEntities(false, maxResults, firstResult);
    }

    private List<Usuariosesion> findUsuariosesionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuariosesion.class));
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

    public Usuariosesion findUsuariosesion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuariosesion.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuariosesionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuariosesion> rt = cq.from(Usuariosesion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
