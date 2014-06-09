package pe.edu.upc.bolsatrabajo.negocio;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import pe.edu.upc.bolsatrabajo.dao.PostulanteDAO;
import pe.edu.upc.bolsatrabajo.modelo.Postulante;

@Stateless
public class PostulanteManager {
    
    @EJB
    PostulanteDAO  postulanteDAO ;

    public Postulante loginPostulante(String id , String pwd) {
        return postulanteDAO.loginPostulante(id, pwd);
    }
    
    public Postulante registrarPostulante(Postulante postulante) {
        return postulanteDAO.registrarPostulante(postulante);
    }
    
    public Postulante modificarPostulante(Postulante postulante){
        return postulanteDAO.modificarPostulante(postulante);
    }
    
    public void eliminarPostulante(int idpostulante){
       
    }
    
    public List<Postulante> consultarPostulantes(){
        return postulanteDAO.consultarPostulantes();
    }
    public List<Postulante> listarPostulantes(){
        return postulanteDAO.listarPostulantes();
    }        
     
     
}
