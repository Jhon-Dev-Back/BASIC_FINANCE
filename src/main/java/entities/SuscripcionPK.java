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
    @Column(name = "idestado_suscripcion")
    private int idestadoSuscripcion;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "plan_suscripcion_idplan_suscripcion")
    private int planSuscripcionIdplanSuscripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_suscripcion_idestado_suscripcion")
    private int estadoSuscripcionIdestadoSuscripcion;

    public SuscripcionPK() {
    }

    public SuscripcionPK(int idestadoSuscripcion, int usuarioIdusuario, int usuarioPaisIdpais, int usuarioRolIdrol, int planSuscripcionIdplanSuscripcion, int estadoSuscripcionIdestadoSuscripcion) {
        this.idestadoSuscripcion = idestadoSuscripcion;
        this.usuarioIdusuario = usuarioIdusuario;
        this.usuarioPaisIdpais = usuarioPaisIdpais;
        this.usuarioRolIdrol = usuarioRolIdrol;
        this.planSuscripcionIdplanSuscripcion = planSuscripcionIdplanSuscripcion;
        this.estadoSuscripcionIdestadoSuscripcion = estadoSuscripcionIdestadoSuscripcion;
    }

    public int getIdestadoSuscripcion() {
        return idestadoSuscripcion;
    }

    public void setIdestadoSuscripcion(int idestadoSuscripcion) {
        this.idestadoSuscripcion = idestadoSuscripcion;
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

    public int getPlanSuscripcionIdplanSuscripcion() {
        return planSuscripcionIdplanSuscripcion;
    }

    public void setPlanSuscripcionIdplanSuscripcion(int planSuscripcionIdplanSuscripcion) {
        this.planSuscripcionIdplanSuscripcion = planSuscripcionIdplanSuscripcion;
    }

    public int getEstadoSuscripcionIdestadoSuscripcion() {
        return estadoSuscripcionIdestadoSuscripcion;
    }

    public void setEstadoSuscripcionIdestadoSuscripcion(int estadoSuscripcionIdestadoSuscripcion) {
        this.estadoSuscripcionIdestadoSuscripcion = estadoSuscripcionIdestadoSuscripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idestadoSuscripcion;
        hash += (int) usuarioIdusuario;
        hash += (int) usuarioPaisIdpais;
        hash += (int) usuarioRolIdrol;
        hash += (int) planSuscripcionIdplanSuscripcion;
        hash += (int) estadoSuscripcionIdestadoSuscripcion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SuscripcionPK)) {
            return false;
        }
        SuscripcionPK other = (SuscripcionPK) object;
        if (this.idestadoSuscripcion != other.idestadoSuscripcion) {
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
        if (this.planSuscripcionIdplanSuscripcion != other.planSuscripcionIdplanSuscripcion) {
            return false;
        }
        if (this.estadoSuscripcionIdestadoSuscripcion != other.estadoSuscripcionIdestadoSuscripcion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SuscripcionPK[ idestadoSuscripcion=" + idestadoSuscripcion + ", usuarioIdusuario=" + usuarioIdusuario + ", usuarioPaisIdpais=" + usuarioPaisIdpais + ", usuarioRolIdrol=" + usuarioRolIdrol + ", planSuscripcionIdplanSuscripcion=" + planSuscripcionIdplanSuscripcion + ", estadoSuscripcionIdestadoSuscripcion=" + estadoSuscripcionIdestadoSuscripcion + " ]";
    }
    
}
