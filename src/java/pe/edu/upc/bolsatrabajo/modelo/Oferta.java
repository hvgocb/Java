/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.bolsatrabajo.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ROGER
 */
@Entity
@Table(name = "OFERTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o"),
    @NamedQuery(name = "Oferta.findByIdoferta", query = "SELECT o FROM Oferta o WHERE o.idoferta = :idoferta"),
    @NamedQuery(name = "Oferta.findByCargo", query = "SELECT o FROM Oferta o WHERE o.cargo = :cargo"),
    @NamedQuery(name = "Oferta.findByAniosExperiencia", query = "SELECT o FROM Oferta o WHERE o.aniosExperiencia = :aniosExperiencia"),
    @NamedQuery(name = "Oferta.findByConocimientosBasico", query = "SELECT o FROM Oferta o WHERE o.conocimientosBasico = :conocimientosBasico"),
    @NamedQuery(name = "Oferta.findByEdad", query = "SELECT o FROM Oferta o WHERE o.edad = :edad"),
    @NamedQuery(name = "Oferta.findBySexo", query = "SELECT o FROM Oferta o WHERE o.sexo = :sexo"),
    @NamedQuery(name = "Oferta.findBySueldo", query = "SELECT o FROM Oferta o WHERE o.sueldo = :sueldo"),
    @NamedQuery(name = "Oferta.findByDisponibilidad", query = "SELECT o FROM Oferta o WHERE o.disponibilidad = :disponibilidad"),
    @NamedQuery(name = "Oferta.findByTurno", query = "SELECT o FROM Oferta o WHERE o.turno = :turno"),
    @NamedQuery(name = "Oferta.findByDistrito", query = "SELECT o FROM Oferta o WHERE o.distrito = :distrito"),
    @NamedQuery(name = "Oferta.findByFechaLimite", query = "SELECT o FROM Oferta o WHERE o.fechaLimite = :fechaLimite"),
    @NamedQuery(name = "Oferta.findByCantLimitePostulantes", query = "SELECT o FROM Oferta o WHERE o.cantLimitePostulantes = :cantLimitePostulantes")})
public class Oferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDOFERTA")
    private Integer idoferta;
    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 30)
    @Column(name = "CARGO")
    private String cargo;
    @Column(name = "ANIOS_EXPERIENCIA")
    private Short aniosExperiencia;
    @Size(max = 100)
    @Column(name = "CONOCIMIENTOS_BASICO")
    private String conocimientosBasico;
    @Column(name = "EDAD")
    private Short edad;
    @Size(max = 1)
    @Column(name = "SEXO")
    private String sexo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SUELDO")
    private BigDecimal sueldo;
    @Size(max = 30)
    @Column(name = "DISPONIBILIDAD")
    private String disponibilidad;
    @Size(max = 10)
    @Column(name = "TURNO")
    private String turno;
    @Size(max = 30)
    @Column(name = "DISTRITO")
    private String distrito;
    @Column(name = "FECHA_LIMITE")
    @Temporal(TemporalType.DATE)
    private Date fechaLimite;
    @Column(name = "CANT_LIMITE_POSTULANTES")
    private Integer cantLimitePostulantes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oferta")
    private List<RegistroPostulaciones> registroPostulacionesList;
    @JoinColumn(name = "IDGRADO", referencedColumnName = "IDGRADO")
    @ManyToOne
    private GradoEstudio idgrado;
    @JoinColumn(name = "IDEMPRESA", referencedColumnName = "IDEMPRESA")
    @ManyToOne(optional = false)
    private Empresa idempresa;
    @JoinColumn(name = "IDCATEGORIA", referencedColumnName = "IDCATEGORIA")
    @ManyToOne
    private Categoria idcategoria;

    public Oferta() {
    }

    public Oferta(Integer idoferta) {
        this.idoferta = idoferta;
    }

    public Integer getIdoferta() {
        return idoferta;
    }

    public void setIdoferta(Integer idoferta) {
        this.idoferta = idoferta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Short getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(Short aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getConocimientosBasico() {
        return conocimientosBasico;
    }

    public void setConocimientosBasico(String conocimientosBasico) {
        this.conocimientosBasico = conocimientosBasico;
    }

    public Short getEdad() {
        return edad;
    }

    public void setEdad(Short edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Integer getCantLimitePostulantes() {
        return cantLimitePostulantes;
    }

    public void setCantLimitePostulantes(Integer cantLimitePostulantes) {
        this.cantLimitePostulantes = cantLimitePostulantes;
    }

    @XmlTransient
    public List<RegistroPostulaciones> getRegistroPostulacionesList() {
        return registroPostulacionesList;
    }

    public void setRegistroPostulacionesList(List<RegistroPostulaciones> registroPostulacionesList) {
        this.registroPostulacionesList = registroPostulacionesList;
    }

    public GradoEstudio getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(GradoEstudio idgrado) {
        this.idgrado = idgrado;
    }

    public Empresa getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Empresa idempresa) {
        this.idempresa = idempresa;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categoria idcategoria) {
        this.idcategoria = idcategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idoferta != null ? idoferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.idoferta == null && other.idoferta != null) || (this.idoferta != null && !this.idoferta.equals(other.idoferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.upc.bolsatrabajo.modelo.Oferta[ idoferta=" + idoferta + " ]";
    }
    
}
