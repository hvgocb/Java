/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.bolsatrabajo.ws;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pe.edu.upc.bolsatrabajo.modelo.Empresa;
import pe.edu.upc.bolsatrabajo.modelo.Oferta;
import pe.edu.upc.bolsatrabajo.modelo.Postulante;
import pe.edu.upc.bolsatrabajo.modelo.RegistroPostulaciones;
import pe.edu.upc.bolsatrabajo.negocio.EmpresaManager;
import pe.edu.upc.bolsatrabajo.negocio.OfertaManager;
import pe.edu.upc.bolsatrabajo.negocio.PostulanteManager;
import pe.edu.upc.bolsatrabajo.negocio.RegistroPostulacionesManager;

/**
 *
 * @author ROGER
 */

@Path("/bolsatrabajo")
public class BolsaTrabajoREST {
    
    
    @EJB
    PostulanteManager postulanteManager;
    
    @EJB
    EmpresaManager empresaManager;    
    
    @EJB
    OfertaManager ofertaManager;
    
    @EJB
    RegistroPostulacionesManager registroPostulacionesManager;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON })
    @Path("/consultarpostulantes")
    public List<Postulante> consultarPostulantes() {
        return postulanteManager.consultarPostulantes();
    }
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/registrarpostulante")
    public Postulante registrarPostulante( Postulante postulante) {
        System.out.println("******   registrarPostulante ******");
        System.out.println(" usuario " + postulante.getNombres());
        return postulanteManager.registrarPostulante(postulante);
    }
    
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/registrarempresa")
     public Empresa registrarEmpresa(Empresa empresa) {
         System.out.println("******   registrarempresa ******");
         System.out.println("Nombre " + empresa.getNombre());
        return empresaManager.registrarEmpresa(empresa);
    }
     
     
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/loginpostulante")
     public Postulante loginPostulante ( Postulante  postulante) {
         
         System.out.println("******  Login REST ******");
         //System.out.println("Nombre " + Postulante());
         return postulanteManager.loginPostulante(postulante.getUsuario(), postulante.getClave());
   
    }
     
     
     @POST
     @Consumes({MediaType.APPLICATION_JSON})
     @Produces({MediaType.APPLICATION_JSON})
     @Path("/loginempresa")
     public Empresa loginEmpresa(Empresa empresa){
        System.out.println(" ****  login Empresa ****");
        Empresa _empresa =   empresaManager.loginEmpresa(empresa);
        //System.out.println(" _empresa usuario  :  "+_empresa.getUsuario());
        return _empresa ;

     }

     
     @POST
     @Consumes({MediaType.APPLICATION_JSON})
     @Produces({MediaType.APPLICATION_JSON})
     @Path("/registraroferta")
     public Oferta registrarOferta( Oferta oferta){
     System.out.println(" **** registrarOferta ****");
         return ofertaManager.registarOferta(oferta);
     }
     
     
   
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/buscarofertas")
    public List<Oferta> consultarOfertas(Oferta oferta) {
        
         System.out.println(" **** consultarOfertas ****");
         
         System.err.println("  oferta :"+oferta.getIdcategoria());
        
        List<Oferta>  ofertasList = ofertaManager.consultarOfertas(oferta);
        for (Oferta oferta1 : ofertasList) {
            System.out.println(" oferta :"+oferta1.getDescripcion());
        }
        return ofertasList;
    } 
    
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/registrarpostulacion")
    public RegistroPostulaciones registrarPostulacion(RegistroPostulaciones registroPostulacion) {
        System.out.println(" **** registrarPostulacion ****");
        System.out.println(" oferta : "+registroPostulacion.getOferta().getIdoferta());
        System.out.println(" postulantes : "+registroPostulacion.getPostulante().getIdpostulante());
        RegistroPostulaciones _regisPostulaciones = new RegistroPostulaciones(registroPostulacion.getOferta().getIdoferta(), registroPostulacion.getPostulante().getIdpostulante());
        _regisPostulaciones.setFechaPostulacion(new Date());
        return registroPostulacionesManager.registrarPostulacion(_regisPostulaciones);
    } 
    
    
    
     @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/consultarpostulaciones")
    public List<RegistroPostulaciones> consultarPostulaciones(Oferta oferta) {
        System.out.println(" **** consultarpostulaciones ****");
        
      List<RegistroPostulaciones> lista =  registroPostulacionesManager.consultarPostulaciones(oferta);
        return lista;
        //return registroPostulacionesManager.consultarPostulaciones(oferta);
    } 
    
    
    
}
