/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jhon Deibys Torres
 */
@Entity
@Table(name = "suscripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suscripcion.findAll", query = "SELECT s FROM Suscripcion s"),
    @NamedQuery(name = "Suscripcion.findByIdestadoSuscripcion", query = "SELECT s FROM Suscripcion s WHERE s.suscripcionPK.idestadoSuscripcion = :idestadoSuscripcion"),
    @NamedQuery(name = "Suscripcion.findByFechaInicio", query = "SELECT s FROM Suscripcion s WHERE s.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Suscripcion.findByFechaFin", query = "SELECT s FROM Suscripcion s WHERE s.fechaFin = :fechaFin"),
    @NamedQuery(name = "Suscripcion.findByUsuarioIdusuario", query = "SELECT s FROM Suscripcion s WHERE s.suscripcionPK.usuarioIdusuario = :usuarioIdusuario"),
    @NamedQuery(name = "Suscripcion.findByUsuarioPaisIdpais", query = "SELECT s FROM Suscripcion s WHERE s.suscripcionPK.usuarioPaisIdpais = :usuarioPaisIdpais"),
    @NamedQuery(name = "Suscripcion.findByUsuarioRolIdrol", query = "SELECT s FROM Suscripcion s WHERE s.suscripcionPK.usuarioRolIdrol = :usuarioRolIdrol"),
    @NamedQuery(name = "Suscripcion.findByPlanSuscripcionIdplanSuscripcion", query = "SELECT s FROM Suscripcion s WHERE s.suscripcionPK.planSuscripcionIdplanSuscripcion = :planSuscripcionIdplanSuscripcion"),
    @NamedQuery(name = "Suscripcion.findByEstadoSuscripcionIdestadoSuscripcion", query = "SELECT s FROM Suscripcion s WHERE s.suscripcionPK.estadoSuscripcionIdestadoSuscripcion = :estadoSuscripcionIdestadoSuscripcion")})
public class Suscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SuscripcionPK suscripcionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    public Suscripcion() {
    }

    public Suscripcion(SuscripcionPK suscripcionPK) {
        this.suscripcionPK = suscripcionPK;
    }

    public Suscripcion(SuscripcionPK suscripcionPK, Date fechaInicio, Date fechaFin) {
        this.suscripcionPK = suscripcionPK;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Suscripcion(int idestadoSuscripcion, int usuarioIdusuario, int usuarioPaisIdpais, int usuarioRolIdrol, int planSuscripcionIdplanSuscripcion, int estadoSuscripcionIdestadoSuscripcion) {
        this.suscripcionPK = new SuscripcionPK(idestadoSuscripcion, usuarioIdusuario, usuarioPaisIdpais, usuarioRolIdrol, planSuscripcionIdplanSuscripcion, estadoSuscripcionIdestadoSuscripcion);
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

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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
