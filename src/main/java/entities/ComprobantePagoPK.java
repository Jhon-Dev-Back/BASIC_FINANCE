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
public class ComprobantePagoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idComprobante")
    private int idComprobante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "encabezado_codigoPago")
    private int encabezadocodigoPago;

    public ComprobantePagoPK() {
    }

    public ComprobantePagoPK(int idComprobante, int encabezadocodigoPago) {
        this.idComprobante = idComprobante;
        this.encabezadocodigoPago = encabezadocodigoPago;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public int getEncabezadocodigoPago() {
        return encabezadocodigoPago;
    }

    public void setEncabezadocodigoPago(int encabezadocodigoPago) {
        this.encabezadocodigoPago = encabezadocodigoPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idComprobante;
        hash += (int) encabezadocodigoPago;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobantePagoPK)) {
            return false;
        }
        ComprobantePagoPK other = (ComprobantePagoPK) object;
        if (this.idComprobante != other.idComprobante) {
            return false;
        }
        if (this.encabezadocodigoPago != other.encabezadocodigoPago) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ComprobantePagoPK[ idComprobante=" + idComprobante + ", encabezadocodigoPago=" + encabezadocodigoPago + " ]";
    }
    
}
