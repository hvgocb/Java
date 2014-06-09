/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.bolsatrabajo.negocio;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import pe.edu.upc.bolsatrabajo.dao.EmpresaDAO;
import pe.edu.upc.bolsatrabajo.modelo.Empresa;
import pe.edu.upc.bolsatrabajo.modelo.Oferta;


/**
 *
 * @author jpantojar
 */

@Stateless
public class EmpresaManager {
    
    @EJB
    EmpresaDAO  empresaDAO ;
    
    public Empresa registrarEmpresa(Empresa empresa){
        
        Empresa  _empresa  = empresaDAO.registrarEmpresa(empresa);
       /* if(_empresa!=null && _empresa.getCorreo()!=null){
             Util.enviarEmail(_empresa.getCorreo(), "Notificación de Registro", "Bienvenido !!! "+_empresa.getNombre()+" ud se ha registrado a bolsa trabajo UPC");
        }*/

        return _empresa;
    }
    
    public Empresa modificarEmpresa(Empresa empresa){
        return empresaDAO.modificarEmpresa(empresa);
    }
    
    public void eliminarEmpresa(int idempresa){
       
    }
    
    public List<Empresa> listarEmpresas(){
        return empresaDAO.listarEmpresas();
    }

    public Empresa loginEmpresa(Empresa empresa) {

        Empresa _empresa = empresaDAO.getEmpresa(empresa);
        System.out.println(" inetnto usuario :"+empresa.getUsuario()+ new Date());
        return  _empresa;
    }


                     
}
