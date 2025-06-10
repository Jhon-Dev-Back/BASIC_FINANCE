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
public class DetallePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idDetalle")
    private int idDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "transacciones_idTransaccion")
    private int transaccionesidTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "transacciones_usuario_idUsuario")
    private int transaccionesusuarioidUsuario;

    public DetallePK() {
    }

    public DetallePK(int idDetalle, int transaccionesidTransaccion, int transaccionesusuarioidUsuario) {
        this.idDetalle = idDetalle;
        this.transaccionesidTransaccion = transaccionesidTransaccion;
        this.transaccionesusuarioidUsuario = transaccionesusuarioidUsuario;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getTransaccionesidTransaccion() {
        return transaccionesidTransaccion;
    }

    public void setTransaccionesidTransaccion(int transaccionesidTransaccion) {
        this.transaccionesidTransaccion = transaccionesidTransaccion;
    }

    public int getTransaccionesusuarioidUsuario() {
        return transaccionesusuarioidUsuario;
    }

    public void setTransaccionesusuarioidUsuario(int transaccionesusuarioidUsuario) {
        this.transaccionesusuarioidUsuario = transaccionesusuarioidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDetalle;
        hash += (int) transaccionesidTransaccion;
        hash += (int) transaccionesusuarioidUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePK)) {
            return false;
        }
        DetallePK other = (DetallePK) object;
        if (this.idDetalle != other.idDetalle) {
            return false;
        }
        if (this.transaccionesidTransaccion != other.transaccionesidTransaccion) {
            return false;
        }
        if (this.transaccionesusuarioidUsuario != other.transaccionesusuarioidUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DetallePK[ idDetalle=" + idDetalle + ", transaccionesidTransaccion=" + transaccionesidTransaccion + ", transaccionesusuarioidUsuario=" + transaccionesusuarioidUsuario + " ]";
    }
    
}
