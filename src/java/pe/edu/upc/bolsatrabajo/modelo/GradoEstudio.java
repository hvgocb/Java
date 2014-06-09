/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.bolsatrabajo.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
 * @author ROGER
 */
@Entity
@Table(name = "GRADO_ESTUDIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GradoEstudio.findAll", query = "SELECT g FROM GradoEstudio g"),
    @NamedQuery(name = "GradoEstudio.findByIdgrado", query = "SELECT g FROM GradoEstudio g WHERE g.idgrado = :idgrado"),
    @NamedQuery(name = "GradoEstudio.findByNombre", query = "SELECT g FROM GradoEstudio g WHERE g.nombre = :nombre")})
public class GradoEstudio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDGRADO")
    private Short idgrado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "idgrado")
    private List<Oferta> ofertaList;

    public GradoEstudio() {
    }

    public GradoEstudio(Short idgrado) {
        this.idgrado = idgrado;
    }

    public GradoEstudio(Short idgrado, String nombre) {
        this.idgrado = idgrado;
        this.nombre = nombre;
    }

    public Short getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(Short idgrado) {
        this.idgrado = idgrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idgrado != null ? idgrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradoEstudio)) {
            return false;
        }
        GradoEstudio other = (GradoEstudio) object;
        if ((this.idgrado == null && other.idgrado != null) || (this.idgrado != null && !this.idgrado.equals(other.idgrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.upc.bolsatrabajo.modelo.GradoEstudio[ idgrado=" + idgrado + " ]";
    }
    
}
