/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhon Deibys Torres
 */
@Entity
@Table(name = "rol_has_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolHasUsuario.findAll", query = "SELECT r FROM RolHasUsuario r"),
    @NamedQuery(name = "RolHasUsuario.findByRolIdrol", query = "SELECT r FROM RolHasUsuario r WHERE r.rolHasUsuarioPK.rolIdrol = :rolIdrol"),
    @NamedQuery(name = "RolHasUsuario.findByUsuarioIdusuario", query = "SELECT r FROM RolHasUsuario r WHERE r.rolHasUsuarioPK.usuarioIdusuario = :usuarioIdusuario"),
    @NamedQuery(name = "RolHasUsuario.findByUsuarioPaisIdpais", query = "SELECT r FROM RolHasUsuario r WHERE r.rolHasUsuarioPK.usuarioPaisIdpais = :usuarioPaisIdpais"),
    @NamedQuery(name = "RolHasUsuario.findByUsuarioRolIdrol", query = "SELECT r FROM RolHasUsuario r WHERE r.rolHasUsuarioPK.usuarioRolIdrol = :usuarioRolIdrol")})
public class RolHasUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolHasUsuarioPK rolHasUsuarioPK;

    public RolHasUsuario() {
    }

    public RolHasUsuario(RolHasUsuarioPK rolHasUsuarioPK) {
        this.rolHasUsuarioPK = rolHasUsuarioPK;
    }

    public RolHasUsuario(int rolIdrol, int usuarioIdusuario, int usuarioPaisIdpais, int usuarioRolIdrol) {
        this.rolHasUsuarioPK = new RolHasUsuarioPK(rolIdrol, usuarioIdusuario, usuarioPaisIdpais, usuarioRolIdrol);
    }

    public RolHasUsuarioPK getRolHasUsuarioPK() {
        return rolHasUsuarioPK;
    }

    public void setRolHasUsuarioPK(RolHasUsuarioPK rolHasUsuarioPK) {
        this.rolHasUsuarioPK = rolHasUsuarioPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolHasUsuarioPK != null ? rolHasUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolHasUsuario)) {
            return false;
        }
        RolHasUsuario other = (RolHasUsuario) object;
        if ((this.rolHasUsuarioPK == null && other.rolHasUsuarioPK != null) || (this.rolHasUsuarioPK != null && !this.rolHasUsuarioPK.equals(other.rolHasUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RolHasUsuario[ rolHasUsuarioPK=" + rolHasUsuarioPK + " ]";
    }
    
}
