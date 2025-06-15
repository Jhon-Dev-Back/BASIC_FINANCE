/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhon Deibys Torres
 */
@Entity
@Table(name = "transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t"),
    @NamedQuery(name = "Transaccion.findByIdTransaccion", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.idTransaccion = :idTransaccion"),
    @NamedQuery(name = "Transaccion.findByMonto", query = "SELECT t FROM Transaccion t WHERE t.monto = :monto"),
    @NamedQuery(name = "Transaccion.findByFecha", query = "SELECT t FROM Transaccion t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "Transaccion.findBySuscripcionIdestadoSuscripcion", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.suscripcionIdestadoSuscripcion = :suscripcionIdestadoSuscripcion"),
    @NamedQuery(name = "Transaccion.findBySuscripcionUsuarioIdusuario", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.suscripcionUsuarioIdusuario = :suscripcionUsuarioIdusuario"),
    @NamedQuery(name = "Transaccion.findBySuscripcionUsuarioPaisIdpais", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.suscripcionUsuarioPaisIdpais = :suscripcionUsuarioPaisIdpais"),
    @NamedQuery(name = "Transaccion.findBySuscripcionUsuarioRolIdrol", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.suscripcionUsuarioRolIdrol = :suscripcionUsuarioRolIdrol"),
    @NamedQuery(name = "Transaccion.findBySuscripcionPlanSuscripcionIdplanSuscripcion", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.suscripcionPlanSuscripcionIdplanSuscripcion = :suscripcionPlanSuscripcionIdplanSuscripcion"),
    @NamedQuery(name = "Transaccion.findBySuscripcionEstadoSuscripcionIdestadoSuscripcion", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.suscripcionEstadoSuscripcionIdestadoSuscripcion = :suscripcionEstadoSuscripcionIdestadoSuscripcion"),
    @NamedQuery(name = "Transaccion.findByTipoTransaccionidTipoTransaccion", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.tipoTransaccionidTipoTransaccion = :tipoTransaccionidTipoTransaccion"),
    @NamedQuery(name = "Transaccion.findByMetododePagoidmetododePago", query = "SELECT t FROM Transaccion t WHERE t.transaccionPK.metododePagoidmetododePago = :metododePagoidmetododePago")})
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransaccionPK transaccionPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;

    public Transaccion() {
    }

    public Transaccion(TransaccionPK transaccionPK) {
        this.transaccionPK = transaccionPK;
    }

    public Transaccion(TransaccionPK transaccionPK, BigDecimal monto, Date fecha) {
        this.transaccionPK = transaccionPK;
        this.monto = monto;
        this.fecha = fecha;
    }

    public Transaccion(int idTransaccion, int suscripcionIdestadoSuscripcion, int suscripcionUsuarioIdusuario, int suscripcionUsuarioPaisIdpais, int suscripcionUsuarioRolIdrol, int suscripcionPlanSuscripcionIdplanSuscripcion, int suscripcionEstadoSuscripcionIdestadoSuscripcion, int tipoTransaccionidTipoTransaccion, int metododePagoidmetododePago) {
        this.transaccionPK = new TransaccionPK(idTransaccion, suscripcionIdestadoSuscripcion, suscripcionUsuarioIdusuario, suscripcionUsuarioPaisIdpais, suscripcionUsuarioRolIdrol, suscripcionPlanSuscripcionIdplanSuscripcion, suscripcionEstadoSuscripcionIdestadoSuscripcion, tipoTransaccionidTipoTransaccion, metododePagoidmetododePago);
    }

    public TransaccionPK getTransaccionPK() {
        return transaccionPK;
    }

    public void setTransaccionPK(TransaccionPK transaccionPK) {
        this.transaccionPK = transaccionPK;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transaccionPK != null ? transaccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.transaccionPK == null && other.transaccionPK != null) || (this.transaccionPK != null && !this.transaccionPK.equals(other.transaccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Transaccion[ transaccionPK=" + transaccionPK + " ]";
    }
    
}
