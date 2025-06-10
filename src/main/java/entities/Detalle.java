/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
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
@Table(name = "detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d"),
    @NamedQuery(name = "Detalle.findByIdDetalle", query = "SELECT d FROM Detalle d WHERE d.detallePK.idDetalle = :idDetalle"),
    @NamedQuery(name = "Detalle.findByCantidadProducto", query = "SELECT d FROM Detalle d WHERE d.cantidadProducto = :cantidadProducto"),
    @NamedQuery(name = "Detalle.findByValorUnitario", query = "SELECT d FROM Detalle d WHERE d.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "Detalle.findByValorTotal", query = "SELECT d FROM Detalle d WHERE d.valorTotal = :valorTotal"),
    @NamedQuery(name = "Detalle.findByTransaccionesidTransaccion", query = "SELECT d FROM Detalle d WHERE d.detallePK.transaccionesidTransaccion = :transaccionesidTransaccion"),
    @NamedQuery(name = "Detalle.findByTransaccionesusuarioidUsuario", query = "SELECT d FROM Detalle d WHERE d.detallePK.transaccionesusuarioidUsuario = :transaccionesusuarioidUsuario")})
public class Detalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetallePK detallePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadProducto")
    private int cantidadProducto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorUnitario")
    private BigDecimal valorUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorTotal")
    private BigDecimal valorTotal;
   @JoinColumns({
    @JoinColumn(name = "transacciones_idTransaccion", referencedColumnName = "idTransaccion", insertable = false, updatable = false),
    @JoinColumn(name = "transacciones_usuario_idUsuario", referencedColumnName = "usuario_idUsuario", insertable = false, updatable = false),
    @JoinColumn(name = "transacciones_suscripcion_idsuscripcion", referencedColumnName = "suscripcion_idsuscripcion", insertable = false, updatable = false),
    @JoinColumn(name = "transacciones_comprobante_pago_idComprobante", referencedColumnName = "comprobante_pago_idComprobante", insertable = false, updatable = false),
    @JoinColumn(name = "transacciones_comprobante_pago_encabezado_codigoPago", referencedColumnName = "comprobante_pago_encabezado_codigoPago", insertable = false, updatable = false)
})
@ManyToOne(optional = false)
private Transacciones transacciones;

    public Detalle() {
    }

    public Detalle(DetallePK detallePK) {
        this.detallePK = detallePK;
    }

    public Detalle(DetallePK detallePK, int cantidadProducto, String descripcion, BigDecimal valorUnitario, BigDecimal valorTotal) {
        this.detallePK = detallePK;
        this.cantidadProducto = cantidadProducto;
        this.descripcion = descripcion;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    public Detalle(int idDetalle, int transaccionesidTransaccion, int transaccionesusuarioidUsuario) {
        this.detallePK = new DetallePK(idDetalle, transaccionesidTransaccion, transaccionesusuarioidUsuario);
    }

    public DetallePK getDetallePK() {
        return detallePK;
    }

    public void setDetallePK(DetallePK detallePK) {
        this.detallePK = detallePK;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Transacciones getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(Transacciones transacciones) {
        this.transacciones = transacciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallePK != null ? detallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if ((this.detallePK == null && other.detallePK != null) || (this.detallePK != null && !this.detallePK.equals(other.detallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Detalle[ detallePK=" + detallePK + " ]";
    }

}
