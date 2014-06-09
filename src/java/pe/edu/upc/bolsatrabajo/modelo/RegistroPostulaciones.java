/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.bolsatrabajo.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ROGER
 */
@Entity
@Table(name = "REGISTRO_POSTULACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroPostulaciones.findAll", query = "SELECT r FROM RegistroPostulaciones r"),
    @NamedQuery(name = "RegistroPostulaciones.findByIdoferta", query = "SELECT r FROM RegistroPostulaciones r WHERE r.registroPostulacionesPK.idoferta = :idoferta"),
    @NamedQuery(name = "RegistroPostulaciones.findByIdpostulante", query = "SELECT r FROM RegistroPostulaciones r WHERE r.registroPostulacionesPK.idpostulante = :idpostulante"),
    @NamedQuery(name = "RegistroPostulaciones.findByFechaPostulacion", query = "SELECT r FROM RegistroPostulaciones r WHERE r.fechaPostulacion = :fechaPostulacion")})
public class RegistroPostulaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RegistroPostulacionesPK registroPostulacionesPK;
    @Column(name = "FECHA_POSTULACION")
    @Temporal(TemporalType.DATE)
    private Date fechaPostulacion;
    @JoinColumn(name = "IDPOSTULANTE", referencedColumnName = "IDPOSTULANTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Postulante postulante;
    @JoinColumn(name = "IDOFERTA", referencedColumnName = "IDOFERTA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Oferta oferta;

    public RegistroPostulaciones() {
    }

    public RegistroPostulaciones(RegistroPostulacionesPK registroPostulacionesPK) {
        this.registroPostulacionesPK = registroPostulacionesPK;
    }

    public RegistroPostulaciones(int idoferta, int idpostulante) {
        this.registroPostulacionesPK = new RegistroPostulacionesPK(idoferta, idpostulante);
    }

    public RegistroPostulacionesPK getRegistroPostulacionesPK() {
        return registroPostulacionesPK;
    }

    public void setRegistroPostulacionesPK(RegistroPostulacionesPK registroPostulacionesPK) {
        this.registroPostulacionesPK = registroPostulacionesPK;
    }

    public Date getFechaPostulacion() {
        return fechaPostulacion;
    }

    public void setFechaPostulacion(Date fechaPostulacion) {
        this.fechaPostulacion = fechaPostulacion;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registroPostulacionesPK != null ? registroPostulacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroPostulaciones)) {
            return false;
        }
        RegistroPostulaciones other = (RegistroPostulaciones) object;
        if ((this.registroPostulacionesPK == null && other.registroPostulacionesPK != null) || (this.registroPostulacionesPK != null && !this.registroPostulacionesPK.equals(other.registroPostulacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.upc.bolsatrabajo.modelo.RegistroPostulaciones[ registroPostulacionesPK=" + registroPostulacionesPK + " ]";
    }
    
}
