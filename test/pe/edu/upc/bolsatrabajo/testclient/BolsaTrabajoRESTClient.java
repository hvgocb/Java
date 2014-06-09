
package pe.edu.upc.bolsatrabajo.testclient;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.Assert;
import org.junit.Test;
import pe.edu.upc.bolsatrabajo.modelo.Empresa;
import pe.edu.upc.bolsatrabajo.modelo.Oferta;
import pe.edu.upc.bolsatrabajo.modelo.Postulante;
import pe.edu.upc.bolsatrabajo.negocio.Util;

/**
 *
 * @author ROGER
 */
public class BolsaTrabajoRESTClient {
    //este es un cambio..Gaby

    
    public static final String URL_BOLSATRABAJO_WS= "http://localhost:8080/BolsaTrabajoWS/rest/bolsatrabajo/";
    public static final String URL_CONSULTAR_POSTULANTES = URL_BOLSATRABAJO_WS+"consultarpostulantes";
    public static final String URL_LOGIN_POSTULANTE = URL_BOLSATRABAJO_WS+"loginpostulante";
    public static final String URL_REGISTRAR_EMPRESA = URL_BOLSATRABAJO_WS+"registrarempresa";
    public static final String URL_CONSULTAR_OFERTA =  URL_BOLSATRABAJO_WS+"buscarofertas";
    public static final String URL_REGISTRAR_OFERTA =  URL_BOLSATRABAJO_WS+"registraroferta";
    public static final String URL_LOGIN_EMPRESA = URL_BOLSATRABAJO_WS+"loginempresa";
    public static final String URL_REGISTRAR_POSTULANTE = URL_BOLSATRABAJO_WS+"registrarpostulante";
   
   

    public static void main(String[] args) {
  
    }
        
    //@Test
    public void consultarPostulantes(){
    
         Postulante _postulante = new Postulante();
        _postulante.setNombres("Roger");
        Client client = ClientBuilder.newClient();
        Response response = client.target(URL_CONSULTAR_POSTULANTES)
                .request(MediaType.APPLICATION_JSON)
                .get();
        System.out.println(response.getStatus());
        List<Postulante> lista = response.readEntity(new GenericType<List<Postulante>>() {
        });
        for (Postulante postulante : lista) {
            System.out.println(" postulante :" + postulante.getNombres());
        }  
        Assert.assertTrue(lista.size()>0);
    }
    
    //@Test
    public void registrarEmpresa(){
    
        System.out.println(URL_REGISTRAR_EMPRESA);
        Empresa _empresa = new Empresa();
        _empresa.setNombre("Hacker Mate Solutions.");
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(URL_REGISTRAR_EMPRESA)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(_empresa, MediaType.APPLICATION_JSON));
        System.out.println(response.getStatus());
        
        Empresa empresa = response.readEntity(new GenericType<Empresa>(){});
        
        Assert.assertNotNull(empresa);
        System.out.println(empresa.getNombre());
    }

    
    //@Test
    public void enviarEmilio() {
        Util.enviarEmail("roggerchangg@gmail.com", "El asunto","El mensaje"); 
    }
    
    //@Test
    public void loginPostulante(){
    
         Postulante _postulante = new Postulante();
        _postulante.setUsuario("RCHANAME");
        _postulante.setClave("123456");
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(URL_LOGIN_POSTULANTE)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(_postulante, MediaType.APPLICATION_JSON));
        System.out.println(response.getStatus());
        Postulante postulante = response.readEntity(new GenericType<Postulante>(){});

        Assert.assertTrue(postulante!=null);
    }
    

    
    @Test

    public void loginEmpresa(){
        
        
        Empresa empresa  = new Empresa();
        empresa.setIdempresa(1);
        empresa.setUsuario("empresaromulo");
        empresa.setClave("123456");
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(URL_LOGIN_EMPRESA)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(empresa, MediaType.APPLICATION_JSON));
        System.out.println(response.getStatus());
        Empresa _empresa = response.readEntity(new GenericType<Empresa>(){});
        
       Assert.assertNotNull(_empresa);
    
    
    }
    
    
    
    
    
    //@Test
    public void consultarOfertas(){
        
        Oferta oferta = new Oferta();
        Client client = ClientBuilder.newClient();
        Response response = client.target(URL_CONSULTAR_OFERTA)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(oferta, MediaType.APPLICATION_JSON));
        System.out.println(response.getStatus());
        
        List<Oferta> ofertalist = response.readEntity(new GenericType<List<Oferta>>(){});
        
        Assert.assertTrue(ofertalist.size()>0);
        for (Oferta oferta1 : ofertalist) {
            System.out.println("oferta" + oferta1.getDescripcion()); 
        }
    }
    
     @Test
    public void registrarOferta(){
        
        
        Oferta oferta = new Oferta();
        
        oferta.setDescripcion("Analista de Sistemas con metodolgias agiles");
     
        
        oferta.setIdempresa(new Empresa(1));
        Client client = ClientBuilder.newClient();
        Response response = client.target(URL_REGISTRAR_OFERTA)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(oferta, MediaType.APPLICATION_JSON));
        System.out.println(response.getStatus());
        Oferta _oferta = response.readEntity(new GenericType<Oferta>(){});
        Assert.assertNotNull(_oferta);
    
    }
    
    
    @Test
    public void registrarPostulante() {

        System.out.println(URL_REGISTRAR_POSTULANTE);
        Empresa _empresa = new Empresa();
        _empresa.setNombre("Hacker Mate Solutions.");

        Client client = ClientBuilder.newClient();
        Response response = client.target(URL_REGISTRAR_EMPRESA)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(_empresa, MediaType.APPLICATION_JSON));
        System.out.println(response.getStatus());

        Empresa empresa = response.readEntity(new GenericType<Empresa>() {
        });

        Assert.assertNotNull(empresa);
        System.out.println(empresa.getNombre());
    }
}
