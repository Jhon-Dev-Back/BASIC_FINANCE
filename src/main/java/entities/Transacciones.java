/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jhon Deibys Torres
 */
@Entity
@Table(name = "transacciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacciones.findAll", query = "SELECT t FROM Transacciones t"),
    @NamedQuery(name = "Transacciones.findByIdTransaccion", query = "SELECT t FROM Transacciones t WHERE t.transaccionesPK.idTransaccion = :idTransaccion"),
    @NamedQuery(name = "Transacciones.findByFecha", query = "SELECT t FROM Transacciones t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "Transacciones.findByMonto", query = "SELECT t FROM Transacciones t WHERE t.monto = :monto"),
    @NamedQuery(name = "Transacciones.findByEstado", query = "SELECT t FROM Transacciones t WHERE t.estado = :estado"),
    @NamedQuery(name = "Transacciones.findByMetodoPago", query = "SELECT t FROM Transacciones t WHERE t.metodoPago = :metodoPago"),
    @NamedQuery(name = "Transacciones.findByUsuarioidUsuario", query = "SELECT t FROM Transacciones t WHERE t.transaccionesPK.usuarioidUsuario = :usuarioidUsuario"),
    @NamedQuery(name = "Transacciones.findBySuscripcionIdsuscripcion", query = "SELECT t FROM Transacciones t WHERE t.transaccionesPK.suscripcionIdsuscripcion = :suscripcionIdsuscripcion"),
    @NamedQuery(name = "Transacciones.findByComprobantepagoidComprobante", query = "SELECT t FROM Transacciones t WHERE t.transaccionesPK.comprobantepagoidComprobante = :comprobantepagoidComprobante")})
public class Transacciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransaccionesPK transaccionesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "metodoPago")
    private String metodoPago;
    @JoinColumns({
    @JoinColumn(name = "comprobante_pago_idComprobante", referencedColumnName = "idComprobante", insertable = false, updatable = false),
    @JoinColumn(name = "comprobante_pago_encabezado_codigoPago", referencedColumnName = "encabezado_codigoPago", insertable = false, updatable = false)
})
@ManyToOne(optional = false)
private ComprobantePago comprobantePago;
    @JoinColumns({
    @JoinColumn(name = "suscripcion_idsuscripcion", referencedColumnName = "idsuscripcion", insertable = false, updatable = false),
    @JoinColumn(name = "suscripcion_usuario_idUsuario", referencedColumnName = "usuario_idUsuario", insertable = false, updatable = false)
})
@ManyToOne(optional = false)
private Suscripcion suscripcion;
    @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transacciones")
    private Collection<Detalle> detalleCollection;

    public Transacciones() {
    }

    public Transacciones(TransaccionesPK transaccionesPK) {
        this.transaccionesPK = transaccionesPK;
    }

    public Transacciones(TransaccionesPK transaccionesPK, Date fecha, String descripcion, BigDecimal monto, String estado, String metodoPago) {
        this.transaccionesPK = transaccionesPK;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
        this.estado = estado;
        this.metodoPago = metodoPago;
    }

    public Transacciones(int idTransaccion, int usuarioidUsuario, int suscripcionIdsuscripcion, int comprobantepagoidComprobante) {
        this.transaccionesPK = new TransaccionesPK(idTransaccion, usuarioidUsuario, suscripcionIdsuscripcion, comprobantepagoidComprobante);
    }

    public TransaccionesPK getTransaccionesPK() {
        return transaccionesPK;
    }

    public void setTransaccionesPK(TransaccionesPK transaccionesPK) {
        this.transaccionesPK = transaccionesPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public ComprobantePago getComprobantePago() {
        return comprobantePago;
    }

    public void setComprobantePago(ComprobantePago comprobantePago) {
        this.comprobantePago = comprobantePago;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public Collection<Detalle> getDetalleCollection() {
        return detalleCollection;
    }

    public void setDetalleCollection(Collection<Detalle> detalleCollection) {
        this.detalleCollection = detalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transaccionesPK != null ? transaccionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacciones)) {
            return false;
        }
        Transacciones other = (Transacciones) object;
        if ((this.transaccionesPK == null && other.transaccionesPK != null) || (this.transaccionesPK != null && !this.transaccionesPK.equals(other.transaccionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Transacciones[ transaccionesPK=" + transaccionesPK + " ]";
    }
    
}
