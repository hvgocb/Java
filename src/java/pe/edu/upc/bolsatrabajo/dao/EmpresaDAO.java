package pe.edu.upc.bolsatrabajo.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pe.edu.upc.bolsatrabajo.modelo.Empresa;

/**
 *
 * @author jpantojar
 */
@Stateless
public class EmpresaDAO {

    @PersistenceContext(unitName = "BolsaTrabajoWSPU")
    private EntityManager em;

    private EntityManager getEntityManager() {
        return em;
    }

    public Empresa registrarEmpresa(Empresa empresa) {
        try {
            //generando correlativo
            Query query = getEntityManager().createQuery("select max(p.idempresa) from Empresa p");
            Integer maxIdempresa = (Integer) query.getSingleResult();
            System.out.println(" cant de elementos " + maxIdempresa);
            if (maxIdempresa == null) {
                maxIdempresa = 1;
            } else {
                maxIdempresa++;
            }

            empresa.setIdempresa(maxIdempresa);

            //insertando en bd
            em.persist(empresa);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return empresa;
    }

    public Empresa modificarEmpresa(Empresa empresa) {
        try {
            em.getTransaction().begin();
            em.merge(empresa);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
        }
        return empresa;
    }

    public void eliminarEmpresa(int idempresa) {
        try {

            Empresa emp = em.find(Empresa.class, idempresa);

            em.getTransaction().begin();
            em.remove(emp);
            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
        }
    }

    public List<Empresa> listarEmpresas() {

        // CriteriaQuery  cq = getEntityManager().getCriteriaBuilder().createQuery();
        // cq.select(cq.from(Empresa.class));
        // return getEntityManager().createQuery(cq).getResultList();
        List<Empresa> lista = null;
        try {

            String jpql = "SELECT a FROM EMPRESA a ORDER BY a.IDEMPRESA DESC";
            Query q = em.createQuery(jpql);
            lista = q.getResultList();
            return lista;

        } catch (Exception e) {

        } finally {
            em.close();
        }
        return lista;
    }

    public Empresa getEmpresa(Empresa empresa) {

        Empresa _empresa = null;
        try {
            Query query = getEntityManager().createQuery("SELECT e  FROM Empresa e WHERE UPPER(e.usuario) =:usuario and UPPER(e.clave) =:clave ");
            query.setParameter("usuario", empresa.getUsuario().toUpperCase());
            query.setParameter("clave", empresa.getClave().toUpperCase());
            _empresa = (Empresa) query.getSingleResult();
        } catch (Exception e) {
            // e.printStackTrace();
            return null;
        }

        return _empresa;

    }

}
