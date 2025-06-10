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
public class TransaccionesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idTransaccion")
    private int idTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_idUsuario")
    private int usuarioidUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "suscripcion_idsuscripcion")
    private int suscripcionIdsuscripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comprobante_pago_idComprobante")
    private int comprobantepagoidComprobante;

    @Basic(optional = false)
    @NotNull
    @Column(name = "comprobante_pago_encabezado_codigoPago")
    private int comprobantePagoEncabezadoCodigoPago;

    public TransaccionesPK() {
    }

    public TransaccionesPK(int idTransaccion1, int usuarioidUsuario1, int suscripcionIdsuscripcion1, int comprobantepagoidComprobante1) {
    }

    public TransaccionesPK(int idTransaccion, int usuarioidUsuario, int suscripcionIdsuscripcion,
            int comprobantepagoidComprobante, int comprobantePagoEncabezadoCodigoPago) {
        this.idTransaccion = idTransaccion;
        this.usuarioidUsuario = usuarioidUsuario;
        this.suscripcionIdsuscripcion = suscripcionIdsuscripcion;
        this.comprobantepagoidComprobante = comprobantepagoidComprobante;
        this.comprobantePagoEncabezadoCodigoPago = comprobantePagoEncabezadoCodigoPago;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(int usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public int getSuscripcionIdsuscripcion() {
        return suscripcionIdsuscripcion;
    }

    public void setSuscripcionIdsuscripcion(int suscripcionIdsuscripcion) {
        this.suscripcionIdsuscripcion = suscripcionIdsuscripcion;
    }

    public int getComprobantepagoidComprobante() {
        return comprobantepagoidComprobante;
    }

    public void setComprobantepagoidComprobante(int comprobantepagoidComprobante) {
        this.comprobantepagoidComprobante = comprobantepagoidComprobante;
    }

    public int getComprobantePagoEncabezadoCodigoPago() {
        return comprobantePagoEncabezadoCodigoPago;
    }

    public void setComprobantePagoEncabezadoCodigoPago(int comprobantePagoEncabezadoCodigoPago) {
        this.comprobantePagoEncabezadoCodigoPago = comprobantePagoEncabezadoCodigoPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTransaccion;
        hash += (int) usuarioidUsuario;
        hash += (int) suscripcionIdsuscripcion;
        hash += (int) comprobantepagoidComprobante;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransaccionesPK)) {
            return false;
        }
        TransaccionesPK other = (TransaccionesPK) object;
        if (this.idTransaccion != other.idTransaccion) {
            return false;
        }
        if (this.usuarioidUsuario != other.usuarioidUsuario) {
            return false;
        }
        if (this.suscripcionIdsuscripcion != other.suscripcionIdsuscripcion) {
            return false;
        }
        if (this.comprobantepagoidComprobante != other.comprobantepagoidComprobante) {
            return false;
        }
        if (this.comprobantePagoEncabezadoCodigoPago != other.comprobantePagoEncabezadoCodigoPago) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TransaccionesPK[ idTransaccion=" + idTransaccion + ", usuarioidUsuario=" + usuarioidUsuario + ", suscripcionIdsuscripcion=" + suscripcionIdsuscripcion + ", comprobantepagoidComprobante=" + comprobantepagoidComprobante + " ]";
    }

}
