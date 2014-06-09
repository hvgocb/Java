package pe.edu.upc.bolsatrabajo.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import pe.edu.upc.bolsatrabajo.modelo.Postulante;

@Stateless
public class PostulanteDAO {

    @PersistenceContext(unitName = "BolsaTrabajoWSPU")
    private EntityManager em;

    private EntityManager getEntityManager() {
        return em;
    }

    public Postulante loginPostulante(String usuario, String clave) {
        Postulante c = null;
        try {

            String sql = "SELECT c FROM Postulante c WHERE c.usuario = :usuario  and c.clave =:clave";
            Query q = getEntityManager().createQuery(sql);
            q.setParameter("usuario", usuario);
            q.setParameter("clave", clave);

            c = (Postulante) q.getSingleResult();
            System.out.println(c);

        } catch (NoResultException noResultException) {
            noResultException.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return c;
    }

    public Postulante registrarPostulante(Postulante postulante) {
        try {
            //generando correlativo
            Query query = getEntityManager().createQuery("select count(1) from Postulante p");
            Long count = (Long) query.getSingleResult();
            
            System.out.println(" count "+(count.intValue() + 1));
            postulante.setIdpostulante(count.intValue() + 1);

            //insertando en bd
            getEntityManager().persist(postulante);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return postulante;
    }

    public Postulante modificarPostulante(Postulante postulante) {
        try {
            em.getTransaction().begin();
            em.merge(postulante);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
        }
        return postulante;
    }

    public void eliminarPostulante(int idPostulante) {
        try {

            Postulante pos = em.find(Postulante.class, idPostulante);

            em.getTransaction().begin();
            em.remove(pos);
            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
        }
    }

    public List<Postulante> consultarPostulantes() {

        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Postulante.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<Postulante> listarPostulantes() {
        List<Postulante> lista = null;

        String jpql = "SELECT a FROM POSTULANTE a ORDER BY ";
        Query q = getEntityManager().createQuery(jpql);
        lista = q.getResultList();
        return lista;


    }
}
