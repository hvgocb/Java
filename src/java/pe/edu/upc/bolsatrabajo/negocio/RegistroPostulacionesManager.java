/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.bolsatrabajo.negocio;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import pe.edu.upc.bolsatrabajo.dao.RegistroPostulacionesDAO;
import pe.edu.upc.bolsatrabajo.modelo.Empresa;
import pe.edu.upc.bolsatrabajo.modelo.Oferta;
import pe.edu.upc.bolsatrabajo.modelo.RegistroPostulaciones;

/**
 *
 * @author ROGER
 */

@Stateless
public class RegistroPostulacionesManager {
    
    @EJB
    RegistroPostulacionesDAO registroPostulacionesDAO;

    public RegistroPostulaciones registrarPostulacion(RegistroPostulaciones registroPostulacion) {
        return registroPostulacionesDAO.registrarPostulacion (registroPostulacion);
    }

    public List<RegistroPostulaciones> consultarPostulaciones(Oferta oferta) {
         return registroPostulacionesDAO.consultarPostulaciones(oferta);
    }

}
