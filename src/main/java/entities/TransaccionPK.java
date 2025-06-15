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
public class TransaccionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idTransaccion")
    private int idTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suscripcion_idestado_suscripcion")
    private int suscripcionIdestadoSuscripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suscripcion_usuario_idusuario")
    private int suscripcionUsuarioIdusuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suscripcion_usuario_pais_idpais")
    private int suscripcionUsuarioPaisIdpais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suscripcion_usuario_rol_idrol")
    private int suscripcionUsuarioRolIdrol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suscripcion_plan_suscripcion_idplan_suscripcion")
    private int suscripcionPlanSuscripcionIdplanSuscripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suscripcion_estado_suscripcion_idestado_suscripcion")
    private int suscripcionEstadoSuscripcionIdestadoSuscripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_Transaccion_idTipo_Transaccion")
    private int tipoTransaccionidTipoTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "metodo_de_Pago_idmetodo_de_Pago")
    private int metododePagoidmetododePago;

    public TransaccionPK() {
    }

    public TransaccionPK(int idTransaccion, int suscripcionIdestadoSuscripcion, int suscripcionUsuarioIdusuario, int suscripcionUsuarioPaisIdpais, int suscripcionUsuarioRolIdrol, int suscripcionPlanSuscripcionIdplanSuscripcion, int suscripcionEstadoSuscripcionIdestadoSuscripcion, int tipoTransaccionidTipoTransaccion, int metododePagoidmetododePago) {
        this.idTransaccion = idTransaccion;
        this.suscripcionIdestadoSuscripcion = suscripcionIdestadoSuscripcion;
        this.suscripcionUsuarioIdusuario = suscripcionUsuarioIdusuario;
        this.suscripcionUsuarioPaisIdpais = suscripcionUsuarioPaisIdpais;
        this.suscripcionUsuarioRolIdrol = suscripcionUsuarioRolIdrol;
        this.suscripcionPlanSuscripcionIdplanSuscripcion = suscripcionPlanSuscripcionIdplanSuscripcion;
        this.suscripcionEstadoSuscripcionIdestadoSuscripcion = suscripcionEstadoSuscripcionIdestadoSuscripcion;
        this.tipoTransaccionidTipoTransaccion = tipoTransaccionidTipoTransaccion;
        this.metododePagoidmetododePago = metododePagoidmetododePago;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getSuscripcionIdestadoSuscripcion() {
        return suscripcionIdestadoSuscripcion;
    }

    public void setSuscripcionIdestadoSuscripcion(int suscripcionIdestadoSuscripcion) {
        this.suscripcionIdestadoSuscripcion = suscripcionIdestadoSuscripcion;
    }

    public int getSuscripcionUsuarioIdusuario() {
        return suscripcionUsuarioIdusuario;
    }

    public void setSuscripcionUsuarioIdusuario(int suscripcionUsuarioIdusuario) {
        this.suscripcionUsuarioIdusuario = suscripcionUsuarioIdusuario;
    }

    public int getSuscripcionUsuarioPaisIdpais() {
        return suscripcionUsuarioPaisIdpais;
    }

    public void setSuscripcionUsuarioPaisIdpais(int suscripcionUsuarioPaisIdpais) {
        this.suscripcionUsuarioPaisIdpais = suscripcionUsuarioPaisIdpais;
    }

    public int getSuscripcionUsuarioRolIdrol() {
        return suscripcionUsuarioRolIdrol;
    }

    public void setSuscripcionUsuarioRolIdrol(int suscripcionUsuarioRolIdrol) {
        this.suscripcionUsuarioRolIdrol = suscripcionUsuarioRolIdrol;
    }

    public int getSuscripcionPlanSuscripcionIdplanSuscripcion() {
        return suscripcionPlanSuscripcionIdplanSuscripcion;
    }

    public void setSuscripcionPlanSuscripcionIdplanSuscripcion(int suscripcionPlanSuscripcionIdplanSuscripcion) {
        this.suscripcionPlanSuscripcionIdplanSuscripcion = suscripcionPlanSuscripcionIdplanSuscripcion;
    }

    public int getSuscripcionEstadoSuscripcionIdestadoSuscripcion() {
        return suscripcionEstadoSuscripcionIdestadoSuscripcion;
    }

    public void setSuscripcionEstadoSuscripcionIdestadoSuscripcion(int suscripcionEstadoSuscripcionIdestadoSuscripcion) {
        this.suscripcionEstadoSuscripcionIdestadoSuscripcion = suscripcionEstadoSuscripcionIdestadoSuscripcion;
    }

    public int getTipoTransaccionidTipoTransaccion() {
        return tipoTransaccionidTipoTransaccion;
    }

    public void setTipoTransaccionidTipoTransaccion(int tipoTransaccionidTipoTransaccion) {
        this.tipoTransaccionidTipoTransaccion = tipoTransaccionidTipoTransaccion;
    }

    public int getMetododePagoidmetododePago() {
        return metododePagoidmetododePago;
    }

    public void setMetododePagoidmetododePago(int metododePagoidmetododePago) {
        this.metododePagoidmetododePago = metododePagoidmetododePago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTransaccion;
        hash += (int) suscripcionIdestadoSuscripcion;
        hash += (int) suscripcionUsuarioIdusuario;
        hash += (int) suscripcionUsuarioPaisIdpais;
        hash += (int) suscripcionUsuarioRolIdrol;
        hash += (int) suscripcionPlanSuscripcionIdplanSuscripcion;
        hash += (int) suscripcionEstadoSuscripcionIdestadoSuscripcion;
        hash += (int) tipoTransaccionidTipoTransaccion;
        hash += (int) metododePagoidmetododePago;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionPK)) {
            return false;
        }
        TransaccionPK other = (TransaccionPK) object;
        if (this.idTransaccion != other.idTransaccion) {
            return false;
        }
        if (this.suscripcionIdestadoSuscripcion != other.suscripcionIdestadoSuscripcion) {
            return false;
        }
        if (this.suscripcionUsuarioIdusuario != other.suscripcionUsuarioIdusuario) {
            return false;
        }
        if (this.suscripcionUsuarioPaisIdpais != other.suscripcionUsuarioPaisIdpais) {
            return false;
        }
        if (this.suscripcionUsuarioRolIdrol != other.suscripcionUsuarioRolIdrol) {
            return false;
        }
        if (this.suscripcionPlanSuscripcionIdplanSuscripcion != other.suscripcionPlanSuscripcionIdplanSuscripcion) {
            return false;
        }
        if (this.suscripcionEstadoSuscripcionIdestadoSuscripcion != other.suscripcionEstadoSuscripcionIdestadoSuscripcion) {
            return false;
        }
        if (this.tipoTransaccionidTipoTransaccion != other.tipoTransaccionidTipoTransaccion) {
            return false;
        }
        if (this.metododePagoidmetododePago != other.metododePagoidmetododePago) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TransaccionPK[ idTransaccion=" + idTransaccion + ", suscripcionIdestadoSuscripcion=" + suscripcionIdestadoSuscripcion + ", suscripcionUsuarioIdusuario=" + suscripcionUsuarioIdusuario + ", suscripcionUsuarioPaisIdpais=" + suscripcionUsuarioPaisIdpais + ", suscripcionUsuarioRolIdrol=" + suscripcionUsuarioRolIdrol + ", suscripcionPlanSuscripcionIdplanSuscripcion=" + suscripcionPlanSuscripcionIdplanSuscripcion + ", suscripcionEstadoSuscripcionIdestadoSuscripcion=" + suscripcionEstadoSuscripcionIdestadoSuscripcion + ", tipoTransaccionidTipoTransaccion=" + tipoTransaccionidTipoTransaccion + ", metododePagoidmetododePago=" + metododePagoidmetododePago + " ]";
    }
    
}
