/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.bolsatrabajo.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 
 */
@Entity
@Table(name = "EMPRESA")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
@NamedQuery(name = "Empresa.findByIdempresa", query = "SELECT e FROM Empresa e WHERE e.idempresa = :idempresa"),
@NamedQuery(name = "Empresa.findByNombre", query = "SELECT e FROM Empresa e WHERE e.nombre = :nombre"),
@NamedQuery(name = "Empresa.findByDireccion", query = "SELECT e FROM Empresa e WHERE e.direccion = :direccion"),
@NamedQuery(name = "Empresa.findByDistrito", query = "SELECT e FROM Empresa e WHERE e.distrito = :distrito"),
@NamedQuery(name = "Empresa.findByContacto", query = "SELECT e FROM Empresa e WHERE e.contacto = :contacto"),
@NamedQuery(name = "Empresa.findByRubro", query = "SELECT e FROM Empresa e WHERE e.rubro = :rubro"),
@NamedQuery(name = "Empresa.findByTelefono", query = "SELECT e FROM Empresa e WHERE e.telefono = :telefono"),
@NamedQuery(name = "Empresa.findByRuc", query = "SELECT e FROM Empresa e WHERE e.ruc = :ruc"),
@NamedQuery(name = "Empresa.findByCorreo", query = "SELECT e FROM Empresa e WHERE e.correo = :correo"),
@NamedQuery(name = "Empresa.findByUsuario", query = "SELECT e FROM Empresa e WHERE e.usuario = :usuario"),
@NamedQuery(name = "Empresa.findByClave", query = "SELECT e FROM Empresa e WHERE e.clave = :clave")})

public class Empresa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEMPRESA")
    private Integer idempresa;
    
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Size(max = 100)
    @Column(name = "DIRECCION")
    private String direccion;
   
    @Size(max = 50)
    @Column(name = "DISTRITO")
    private String distrito;
    
    @Size(max = 30)
    @Column(name = "CONTACTO")
    private String contacto;
    
    @Size(max = 30)
    @Column(name = "RUBRO")
    private String rubro;
    
    @Size(max = 15)
    @Column(name = "TELEFONO")
    private String telefono;
    
    @Size(max = 15)
    @Column(name = "RUC")
    private String ruc;
    
    @Size(max = 30)
    @Column(name = "CORREO")
    private String correo;
    
    @Size(max = 25)
    @Column(name = "USUARIO")
    private String usuario;
    
    @Size(max = 10)
    @Column(name = "CLAVE")
    private String clave;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idempresa")
    private List<Oferta> ofertaList;

    public Empresa() {
    }

    public Empresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public Integer getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @XmlTransient
    public List<Oferta> getOfertaList() {
        return ofertaList;
    }

    public void setOfertaList(List<Oferta> ofertaList) {
        this.ofertaList = ofertaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempresa != null ? idempresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idempresa == null && other.idempresa != null) || (this.idempresa != null && !this.idempresa.equals(other.idempresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.upc.bolsatrabajo.modelo.Empresa[ idempresa=" + idempresa + " ]";
    }
    
}
