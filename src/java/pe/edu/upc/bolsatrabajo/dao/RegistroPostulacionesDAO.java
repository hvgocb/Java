/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.bolsatrabajo.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pe.edu.upc.bolsatrabajo.modelo.Empresa;
import pe.edu.upc.bolsatrabajo.modelo.Oferta;
import pe.edu.upc.bolsatrabajo.modelo.RegistroPostulaciones;

/**
 *
 * @author ROGER
 */
@Stateless
public class RegistroPostulacionesDAO {

    @PersistenceContext(unitName = "BolsaTrabajoWSPU")
    private EntityManager em;

    private EntityManager getEntityManager() {
        return em;
    }

    public RegistroPostulaciones registrarPostulacion(RegistroPostulaciones registroPostulacion) {
        try {
            getEntityManager().persist(registroPostulacion);

        } catch (Exception e) {
            return null;
        }
        return registroPostulacion;
    }

    public List<RegistroPostulaciones> consultarPostulaciones(Oferta oferta) {
        
       String sql = "SELECT o FROM RegistroPostulaciones o Where o.oferta.idoferta=:idoferta";
        Query q = getEntityManager().createQuery(sql);
        q.setParameter("idoferta", oferta.getIdoferta());
        List<RegistroPostulaciones> registroList = q.getResultList();
        System.out.println(" filas :"+registroList.size());
        
        return registroList;
        
    
    }

}
