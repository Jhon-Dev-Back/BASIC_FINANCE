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
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByIdAdministrador", query = "SELECT a FROM Administrador a WHERE a.administradorPK.idAdministrador = :idAdministrador"),
    @NamedQuery(name = "Administrador.findByCorreoAdministrador", query = "SELECT a FROM Administrador a WHERE a.correoAdministrador = :correoAdministrador"),
    @NamedQuery(name = "Administrador.findByContrase\u00f1aAdministrador", query = "SELECT a FROM Administrador a WHERE a.contrase\u00f1aAdministrador = :contrase\u00f1aAdministrador"),
    @NamedQuery(name = "Administrador.findByUsuarioidUsuario", query = "SELECT a FROM Administrador a WHERE a.administradorPK.usuarioidUsuario = :usuarioidUsuario")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdministradorPK administradorPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correoAdministrador")
    private String correoAdministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contrase\u00f1aAdministrador")
    private String contraseñaAdministrador;
    @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Administrador() {
    }

    public Administrador(AdministradorPK administradorPK) {
        this.administradorPK = administradorPK;
    }

    public Administrador(AdministradorPK administradorPK, String correoAdministrador, String contraseñaAdministrador) {
        this.administradorPK = administradorPK;
        this.correoAdministrador = correoAdministrador;
        this.contraseñaAdministrador = contraseñaAdministrador;
    }

    public Administrador(int idAdministrador, int usuarioidUsuario) {
        this.administradorPK = new AdministradorPK(idAdministrador, usuarioidUsuario);
    }

    public AdministradorPK getAdministradorPK() {
        return administradorPK;
    }

    public void setAdministradorPK(AdministradorPK administradorPK) {
        this.administradorPK = administradorPK;
    }

    public String getCorreoAdministrador() {
        return correoAdministrador;
    }

    public void setCorreoAdministrador(String correoAdministrador) {
        this.correoAdministrador = correoAdministrador;
    }

    public String getContraseñaAdministrador() {
        return contraseñaAdministrador;
    }

    public void setContraseñaAdministrador(String contraseñaAdministrador) {
        this.contraseñaAdministrador = contraseñaAdministrador;
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
        hash += (administradorPK != null ? administradorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.administradorPK == null && other.administradorPK != null) || (this.administradorPK != null && !this.administradorPK.equals(other.administradorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Administrador[ administradorPK=" + administradorPK + " ]";
    }
    
}
