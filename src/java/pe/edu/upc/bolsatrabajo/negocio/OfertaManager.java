package pe.edu.upc.bolsatrabajo.negocio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import pe.edu.upc.bolsatrabajo.dao.OfertaDAO;
import pe.edu.upc.bolsatrabajo.dao.PostulanteDAO;
import pe.edu.upc.bolsatrabajo.modelo.Oferta;
import pe.edu.upc.bolsatrabajo.modelo.Postulante;

/**
 *
 * @author UPC
 */
@Stateless
public class OfertaManager {

    @EJB
    OfertaDAO ofertaDAO;
    
    @EJB
    PostulanteDAO postulanteDAO;

    public List<Oferta> consultarOfertas(Oferta oferta) {
        
        if(oferta.getIdcategoria()==null && oferta.getIdempresa()==null){
           
            return ofertaDAO.consultarOfertas();
            
        }else if (oferta.getIdcategoria()!=null &&  oferta.getIdempresa()==null   ){
            
          return ofertaDAO.consultarOfertasByCategoria(oferta.getIdcategoria());
          
        }else if (   oferta.getIdempresa().getIdempresa()!=null    ) {
            
            if(oferta.getIdcategoria()==null){
                return ofertaDAO.consultarOfertasByEmpresa(oferta.getIdempresa());
            
            }else{
                return ofertaDAO.consultarOfertasByCategoriaEmpresa(oferta.getIdcategoria(), oferta.getIdempresa());
            }
            
        }else{
            return new ArrayList<Oferta>();
        }

      
    }

    public Oferta registarOferta(Oferta oferta) {



        Oferta _oferta = ofertaDAO.registrarOferta(oferta);

        // regla de negocio

        /*if (_oferta != null) {
            List<Postulante> postulantes = postulanteDAO.consultarPostulantes();
            for (Postulante postulante : postulantes) {
                try {
                    if(postulante.getCorreo()!=null){
                        Util.enviarEmail(postulante.getCorreo(), "Oferta que te puede interesar", "Estimado " + postulante.getNombres() + " tenemos esta oferta para ti "+oferta.getDescripcion());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }*/


        return _oferta;

    }
}
