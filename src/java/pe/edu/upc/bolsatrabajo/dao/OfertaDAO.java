package pe.edu.upc.bolsatrabajo.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pe.edu.upc.bolsatrabajo.modelo.Categoria;
import pe.edu.upc.bolsatrabajo.modelo.Empresa;
import pe.edu.upc.bolsatrabajo.modelo.Oferta;

/**
 *
 * @author UPC
 */
@Stateless
public class OfertaDAO {

    @PersistenceContext(unitName = "BolsaTrabajoWSPU")
    private EntityManager em;

    private EntityManager getEntityManager() {
        return em;
    }

    public List<Oferta> consultarOfertasByCategoria(Categoria categoria) {

        String sql = "SELECT o FROM Oferta o Where o.idcategoria.idcategoria=:idcategoria";
        
        Query q = getEntityManager().createQuery(sql);
        q.setParameter("idcategoria", categoria.getIdcategoria());
        List<Oferta> ofertalist = q.getResultList();

        System.out.println(" filas :"+ofertalist.size());
        return ofertalist;
    }

     public List<Oferta> consultarOfertas() {

        String sql = "SELECT o FROM Oferta o ";
        Query q = getEntityManager().createQuery(sql);
        List<Oferta> ofertalist = q.getResultList();

        return ofertalist;
    }
    
    public Oferta registrarOferta(Oferta oferta) {

        try {
            
            Query query = getEntityManager().createQuery("SELECT max(o.idoferta)  FROM Oferta o ");
            Integer maxOferta = (Integer) query.getSingleResult();
             if (maxOferta == null) {
                maxOferta = 1;
            } else {
                maxOferta++;
            }
            oferta.setIdoferta(maxOferta);
            
            getEntityManager().persist(oferta);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return oferta;
    }

    public List<Oferta> consultarOfertasByCategoriaEmpresa(Categoria categoria, Empresa  empresa) {
       
        String sql = "SELECT o FROM Oferta o Where o.idcategoria.idcategoria=:idcategoria and o.idempresa.idempresa=:idempresa ";
        Query q = getEntityManager().createQuery(sql);
        q.setParameter("idcategoria", categoria.getIdcategoria());
        q.setParameter("idempresa", empresa.getIdempresa());
        List<Oferta> ofertalist = q.getResultList();
        System.out.println(" filas :"+ofertalist.size());
        
        return ofertalist;
    }

    public List<Oferta> consultarOfertasByEmpresa(Empresa empresa) {
        
        String sql = "SELECT o FROM Oferta o Where  o.idempresa.idempresa=:idempresa ";
        Query q = getEntityManager().createQuery(sql);
        q.setParameter("idempresa", empresa.getIdempresa());
        List<Oferta> ofertalist = q.getResultList();
        System.out.println(" filas :"+ofertalist.size());
        
        return ofertalist;
        
    }
}
