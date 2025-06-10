/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "suscripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suscripcion.findAll", query = "SELECT s FROM Suscripcion s"),
    @NamedQuery(name = "Suscripcion.findByIdsuscripcion", query = "SELECT s FROM Suscripcion s WHERE s.suscripcionPK.idsuscripcion = :idsuscripcion"),
    @NamedQuery(name = "Suscripcion.findByFechaInicio", query = "SELECT s FROM Suscripcion s WHERE s.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Suscripcion.findByFechaFinalizacion", query = "SELECT s FROM Suscripcion s WHERE s.fechaFinalizacion = :fechaFinalizacion"),
    @NamedQuery(name = "Suscripcion.findByEstado", query = "SELECT s FROM Suscripcion s WHERE s.estado = :estado"),
    @NamedQuery(name = "Suscripcion.findByUsuarioidUsuario", query = "SELECT s FROM Suscripcion s WHERE s.suscripcionPK.usuarioidUsuario = :usuarioidUsuario")})
public class Suscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SuscripcionPK suscripcionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFinalizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suscripcion")
    private Collection<Transacciones> transaccionesCollection;

    public Suscripcion() {
    }

    public Suscripcion(SuscripcionPK suscripcionPK) {
        this.suscripcionPK = suscripcionPK;
    }

    public Suscripcion(SuscripcionPK suscripcionPK, Date fechaInicio, Date fechaFinalizacion, String descripcion, String estado) {
        this.suscripcionPK = suscripcionPK;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Suscripcion(int idsuscripcion, int usuarioidUsuario) {
        this.suscripcionPK = new SuscripcionPK(idsuscripcion, usuarioidUsuario);
    }

    public SuscripcionPK getSuscripcionPK() {
        return suscripcionPK;
    }

    public void setSuscripcionPK(SuscripcionPK suscripcionPK) {
        this.suscripcionPK = suscripcionPK;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public Collection<Transacciones> getTransaccionesCollection() {
        return transaccionesCollection;
    }

    public void setTransaccionesCollection(Collection<Transacciones> transaccionesCollection) {
        this.transaccionesCollection = transaccionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (suscripcionPK != null ? suscripcionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suscripcion)) {
            return false;
        }
        Suscripcion other = (Suscripcion) object;
        if ((this.suscripcionPK == null && other.suscripcionPK != null) || (this.suscripcionPK != null && !this.suscripcionPK.equals(other.suscripcionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Suscripcion[ suscripcionPK=" + suscripcionPK + " ]";
    }
    
}
