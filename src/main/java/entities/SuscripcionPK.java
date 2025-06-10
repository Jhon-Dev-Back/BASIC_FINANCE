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
public class SuscripcionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idsuscripcion")
    private int idsuscripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_idUsuario")
    private int usuarioidUsuario;

    public SuscripcionPK() {
    }

    public SuscripcionPK(int idsuscripcion, int usuarioidUsuario) {
        this.idsuscripcion = idsuscripcion;
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public int getIdsuscripcion() {
        return idsuscripcion;
    }

    public void setIdsuscripcion(int idsuscripcion) {
        this.idsuscripcion = idsuscripcion;
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
        hash += (int) idsuscripcion;
        hash += (int) usuarioidUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuscripcionPK)) {
            return false;
        }
        SuscripcionPK other = (SuscripcionPK) object;
        if (this.idsuscripcion != other.idsuscripcion) {
            return false;
        }
        if (this.usuarioidUsuario != other.usuarioidUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SuscripcionPK[ idsuscripcion=" + idsuscripcion + ", usuarioidUsuario=" + usuarioidUsuario + " ]";
    }
    
}
