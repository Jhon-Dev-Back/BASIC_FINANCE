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
@Table(name = "reporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporte.findAll", query = "SELECT r FROM Reporte r"),
    @NamedQuery(name = "Reporte.findByIdreporte", query = "SELECT r FROM Reporte r WHERE r.reportePK.idreporte = :idreporte"),
    @NamedQuery(name = "Reporte.findByMonto", query = "SELECT r FROM Reporte r WHERE r.monto = :monto"),
    @NamedQuery(name = "Reporte.findByFecha", query = "SELECT r FROM Reporte r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Reporte.findByTipoReporteIdtipoReporte", query = "SELECT r FROM Reporte r WHERE r.reportePK.tipoReporteIdtipoReporte = :tipoReporteIdtipoReporte"),
    @NamedQuery(name = "Reporte.findByUsuarioIdusuario", query = "SELECT r FROM Reporte r WHERE r.reportePK.usuarioIdusuario = :usuarioIdusuario"),
    @NamedQuery(name = "Reporte.findByUsuarioPaisIdpais", query = "SELECT r FROM Reporte r WHERE r.reportePK.usuarioPaisIdpais = :usuarioPaisIdpais"),
    @NamedQuery(name = "Reporte.findByUsuarioRolIdrol", query = "SELECT r FROM Reporte r WHERE r.reportePK.usuarioRolIdrol = :usuarioRolIdrol"),
    @NamedQuery(name = "Reporte.findByPeriodoIdperiodo", query = "SELECT r FROM Reporte r WHERE r.reportePK.periodoIdperiodo = :periodoIdperiodo")})
public class Reporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReportePK reportePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private long monto;
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

    public Reporte() {
    }

    public Reporte(ReportePK reportePK) {
        this.reportePK = reportePK;
    }

    public Reporte(ReportePK reportePK, long monto, Date fecha, String descripcion) {
        this.reportePK = reportePK;
        this.monto = monto;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Reporte(int idreporte, int tipoReporteIdtipoReporte, int usuarioIdusuario, int usuarioPaisIdpais, int usuarioRolIdrol, int periodoIdperiodo) {
        this.reportePK = new ReportePK(idreporte, tipoReporteIdtipoReporte, usuarioIdusuario, usuarioPaisIdpais, usuarioRolIdrol, periodoIdperiodo);
    }

    public ReportePK getReportePK() {
        return reportePK;
    }

    public void setReportePK(ReportePK reportePK) {
        this.reportePK = reportePK;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
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
        hash += (reportePK != null ? reportePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reporte)) {
            return false;
        }
        Reporte other = (Reporte) object;
        if ((this.reportePK == null && other.reportePK != null) || (this.reportePK != null && !this.reportePK.equals(other.reportePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reporte[ reportePK=" + reportePK + " ]";
    }
    
}
