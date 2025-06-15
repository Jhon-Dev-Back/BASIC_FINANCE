/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jhon Deibys Torres
 */
@Embeddable
public class RolHasUsuarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "rol_idrol")
    private int rolIdrol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_idusuario")
    private int usuarioIdusuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_pais_idpais")
    private int usuarioPaisIdpais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_rol_idrol")
    private int usuarioRolIdrol;

    public RolHasUsuarioPK() {
    }

    public RolHasUsuarioPK(int rolIdrol, int usuarioIdusuario, int usuarioPaisIdpais, int usuarioRolIdrol) {
        this.rolIdrol = rolIdrol;
        this.usuarioIdusuario = usuarioIdusuario;
        this.usuarioPaisIdpais = usuarioPaisIdpais;
        this.usuarioRolIdrol = usuarioRolIdrol;
    }

    public int getRolIdrol() {
        return rolIdrol;
    }

    public void setRolIdrol(int rolIdrol) {
        this.rolIdrol = rolIdrol;
    }

    public int getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(int usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    public int getUsuarioPaisIdpais() {
        return usuarioPaisIdpais;
    }

    public void setUsuarioPaisIdpais(int usuarioPaisIdpais) {
        this.usuarioPaisIdpais = usuarioPaisIdpais;
    }

    public int getUsuarioRolIdrol() {
        return usuarioRolIdrol;
    }

    public void setUsuarioRolIdrol(int usuarioRolIdrol) {
        this.usuarioRolIdrol = usuarioRolIdrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rolIdrol;
        hash += (int) usuarioIdusuario;
        hash += (int) usuarioPaisIdpais;
        hash += (int) usuarioRolIdrol;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolHasUsuarioPK)) {
            return false;
        }
        RolHasUsuarioPK other = (RolHasUsuarioPK) object;
        if (this.rolIdrol != other.rolIdrol) {
            return false;
        }
        if (this.usuarioIdusuario != other.usuarioIdusuario) {
            return false;
        }
        if (this.usuarioPaisIdpais != other.usuarioPaisIdpais) {
            return false;
        }
        if (this.usuarioRolIdrol != other.usuarioRolIdrol) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RolHasUsuarioPK[ rolIdrol=" + rolIdrol + ", usuarioIdusuario=" + usuarioIdusuario + ", usuarioPaisIdpais=" + usuarioPaisIdpais + ", usuarioRolIdrol=" + usuarioRolIdrol + " ]";
    }
    
}
