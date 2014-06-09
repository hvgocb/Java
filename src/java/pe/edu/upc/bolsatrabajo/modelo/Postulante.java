/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.bolsatrabajo.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "POSTULANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postulante.findAll", query = "SELECT p FROM Postulante p"),
    @NamedQuery(name = "Postulante.findByIdpostulante", query = "SELECT p FROM Postulante p WHERE p.idpostulante = :idpostulante"),
    @NamedQuery(name = "Postulante.findByNombres", query = "SELECT p FROM Postulante p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Postulante.findByFechaNacimiento", query = "SELECT p FROM Postulante p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Postulante.findByEdad", query = "SELECT p FROM Postulante p WHERE p.edad = :edad"),
    @NamedQuery(name = "Postulante.findBySexo", query = "SELECT p FROM Postulante p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Postulante.findByLugarNacimiento", query = "SELECT p FROM Postulante p WHERE p.lugarNacimiento = :lugarNacimiento"),
    @NamedQuery(name = "Postulante.findByDescripcionPersonal", query = "SELECT p FROM Postulante p WHERE p.descripcionPersonal = :descripcionPersonal"),
    @NamedQuery(name = "Postulante.findByTelefono", query = "SELECT p FROM Postulante p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Postulante.findByCorreo", query = "SELECT p FROM Postulante p WHERE p.correo = :correo"),
    @NamedQuery(name = "Postulante.findByDocumentoIdentidad", query = "SELECT p FROM Postulante p WHERE p.documentoIdentidad = :documentoIdentidad"),
    @NamedQuery(name = "Postulante.findByUsuario", query = "SELECT p FROM Postulante p WHERE p.usuario = :usuario"),
    @NamedQuery(name = "Postulante.findByClave", query = "SELECT p FROM Postulante p WHERE p.clave = :clave")})
public class Postulante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPOSTULANTE")
    private Integer idpostulante;
    @Size(max = 50)
    @Column(name = "NOMBRES")
    private String nombres;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "EDAD")
    private Short edad;
    @Size(max = 1)
    @Column(name = "SEXO")
    private String sexo;
    @Lob
    @Column(name = "FOTO")
    private String foto;
    @Size(max = 25)
    @Column(name = "LUGAR_NACIMIENTO")
    private String lugarNacimiento;
    @Size(max = 500)
    @Column(name = "DESCRIPCION_PERSONAL")
    private String descripcionPersonal;
    @Size(max = 15)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 30)
    @Column(name = "CORREO")
    private String correo;
    @Size(max = 15)
    @Column(name = "DOCUMENTO_IDENTIDAD")
    private String documentoIdentidad;
    @Lob
    @Column(name = "ESTUDIOS_SUPERIORES")
    private String estudiosSuperiores;
    @Lob
    @Column(name = "IDIOMAS")
    private String idiomas;
    @Lob
    @Column(name = "EXPERIENCIA_LABORAL")
    private String experienciaLaboral;
    @Lob
    @Column(name = "CERTIFICACIONES")
    private String certificaciones;
    @Size(max = 25)
    @Column(name = "USUARIO")
    private String usuario;
    @Size(max = 15)
    @Column(name = "CLAVE")
    private String clave;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postulante")
    private List<RegistroPostulaciones> registroPostulacionesList;

    public Postulante() {
    }

    public Postulante(Integer idpostulante) {
        this.idpostulante = idpostulante;
    }

    public Integer getIdpostulante() {
        return idpostulante;
    }

    public void setIdpostulante(Integer idpostulante) {
        this.idpostulante = idpostulante;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getDescripcionPersonal() {
        return descripcionPersonal;
    }

    public void setDescripcionPersonal(String descripcionPersonal) {
        this.descripcionPersonal = descripcionPersonal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getEstudiosSuperiores() {
        return estudiosSuperiores;
    }

    public void setEstudiosSuperiores(String estudiosSuperiores) {
        this.estudiosSuperiores = estudiosSuperiores;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(String experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public String getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(String certificaciones) {
        this.certificaciones = certificaciones;
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
    public List<RegistroPostulaciones> getRegistroPostulacionesList() {
        return registroPostulacionesList;
    }

    public void setRegistroPostulacionesList(List<RegistroPostulaciones> registroPostulacionesList) {
        this.registroPostulacionesList = registroPostulacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpostulante != null ? idpostulante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postulante)) {
            return false;
        }
        Postulante other = (Postulante) object;
        if ((this.idpostulante == null && other.idpostulante != null) || (this.idpostulante != null && !this.idpostulante.equals(other.idpostulante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.edu.upc.bolsatrabajo.modelo.Postulante[ idpostulante=" + idpostulante + " ]";
    }
    
}
