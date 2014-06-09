/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.bolsatrabajo.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ROGER
 */
@Embeddable
public class RegistroPostulacionesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDOFERTA")
    private int idoferta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPOSTULANTE")
    private int idpostulante;

    public RegistroPostulacionesPK() {
    }

    public RegistroPostulacionesPK(int idoferta, int idpostulante) {
        this.idoferta = idoferta;
        this.idpostulante = idpostulante;
    }

    public int getIdoferta() {
        return idoferta;
    }

    public void setIdoferta(int idoferta) {
        this.idoferta = idoferta;
    }

    public int getIdpostulante() {
        return idpostulante;
    }

    public void setIdpostulante(int idpostulante) {
        this.idpostulante = idpostulante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idoferta;
        hash += (int) idpostulante;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroPostulacionesPK)) {
            return false;
        }
        RegistroPostulacionesPK other = (RegistroPostulacionesPK) object;
        if (this.idoferta != other.idoferta) {
            return false;
        }
        if (this.idpostulante != other.idpostulante) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.upc.bolsatrabajo.modelo.RegistroPostulacionesPK[ idoferta=" + idoferta + ", idpostulante=" + idpostulante + " ]";
    }
    
}
