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
public class AdministradorPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idAdministrador")
    private int idAdministrador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_idUsuario")
    private int usuarioidUsuario;

    public AdministradorPK() {
    }

    public AdministradorPK(int idAdministrador, int usuarioidUsuario) {
        this.idAdministrador = idAdministrador;
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public int getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(int usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAdministrador;
        hash += (int) usuarioidUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdministradorPK)) {
            return false;
        }
        AdministradorPK other = (AdministradorPK) object;
        if (this.idAdministrador != other.idAdministrador) {
            return false;
        }
        if (this.usuarioidUsuario != other.usuarioidUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AdministradorPK[ idAdministrador=" + idAdministrador + ", usuarioidUsuario=" + usuarioidUsuario + " ]";
    }
    
}
