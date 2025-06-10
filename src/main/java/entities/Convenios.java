/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhon Deibys Torres
 */
@Entity
@Table(name = "convenios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convenios.findAll", query = "SELECT c FROM Convenios c"),
    @NamedQuery(name = "Convenios.findByIdConvenio", query = "SELECT c FROM Convenios c WHERE c.conveniosPK.idConvenio = :idConvenio"),
    @NamedQuery(name = "Convenios.findByIdentificacion", query = "SELECT c FROM Convenios c WHERE c.identificacion = :identificacion"),
    @NamedQuery(name = "Convenios.findByNombres", query = "SELECT c FROM Convenios c WHERE c.nombres = :nombres"),
    @NamedQuery(name = "Convenios.findByApellidos", query = "SELECT c FROM Convenios c WHERE c.apellidos = :apellidos"),
    @NamedQuery(name = "Convenios.findByUsuarioidUsuario", query = "SELECT c FROM Convenios c WHERE c.conveniosPK.usuarioidUsuario = :usuarioidUsuario")})
public class Convenios implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConveniosPK conveniosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "identificacion")
    private String identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcionConvenio")
    private String descripcionConvenio;
    @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Convenios() {
    }

    public Convenios(ConveniosPK conveniosPK) {
        this.conveniosPK = conveniosPK;
    }

    public Convenios(ConveniosPK conveniosPK, String identificacion, String nombres, String apellidos, String descripcionConvenio) {
        this.conveniosPK = conveniosPK;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.descripcionConvenio = descripcionConvenio;
    }

    public Convenios(int idConvenio, int usuarioidUsuario) {
        this.conveniosPK = new ConveniosPK(idConvenio, usuarioidUsuario);
    }

    public ConveniosPK getConveniosPK() {
        return conveniosPK;
    }

    public void setConveniosPK(ConveniosPK conveniosPK) {
        this.conveniosPK = conveniosPK;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDescripcionConvenio() {
        return descripcionConvenio;
    }

    public void setDescripcionConvenio(String descripcionConvenio) {
        this.descripcionConvenio = descripcionConvenio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conveniosPK != null ? conveniosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Convenios)) {
            return false;
        }
        Convenios other = (Convenios) object;
        if ((this.conveniosPK == null && other.conveniosPK != null) || (this.conveniosPK != null && !this.conveniosPK.equals(other.conveniosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Convenios[ conveniosPK=" + conveniosPK + " ]";
    }
    
}
