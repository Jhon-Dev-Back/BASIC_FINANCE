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
public class ReportePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idreporte")
    private int idreporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_reporte_idtipo_reporte")
    private int tipoReporteIdtipoReporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_idusuario")
    private int usuarioIdusuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_pais_idpais")
    private int usuarioPaisIdpais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_rol_idrol")
    private int usuarioRolIdrol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "periodo_idperiodo")
    private int periodoIdperiodo;

    public ReportePK() {
    }

    public ReportePK(int idreporte, int tipoReporteIdtipoReporte, int usuarioIdusuario, int usuarioPaisIdpais, int usuarioRolIdrol, int periodoIdperiodo) {
        this.idreporte = idreporte;
        this.tipoReporteIdtipoReporte = tipoReporteIdtipoReporte;
        this.usuarioIdusuario = usuarioIdusuario;
        this.usuarioPaisIdpais = usuarioPaisIdpais;
        this.usuarioRolIdrol = usuarioRolIdrol;
        this.periodoIdperiodo = periodoIdperiodo;
    }

    public int getIdreporte() {
        return idreporte;
    }

    public void setIdreporte(int idreporte) {
        this.idreporte = idreporte;
    }

    public int getTipoReporteIdtipoReporte() {
        return tipoReporteIdtipoReporte;
    }

    public void setTipoReporteIdtipoReporte(int tipoReporteIdtipoReporte) {
        this.tipoReporteIdtipoReporte = tipoReporteIdtipoReporte;
    }

    public int getUsuarioIdusuario() {
        return usuarioIdusuario;
    }

    public void setUsuarioIdusuario(int usuarioIdusuario) {
        this.usuarioIdusuario = usuarioIdusuario;
    }

    public int getUsuarioPaisIdpais() {
        return usuarioPaisIdpais;
    }

    public void setUsuarioPaisIdpais(int usuarioPaisIdpais) {
        this.usuarioPaisIdpais = usuarioPaisIdpais;
    }

    public int getUsuarioRolIdrol() {
        return usuarioRolIdrol;
    }

    public void setUsuarioRolIdrol(int usuarioRolIdrol) {
        this.usuarioRolIdrol = usuarioRolIdrol;
    }

    public int getPeriodoIdperiodo() {
        return periodoIdperiodo;
    }

    public void setPeriodoIdperiodo(int periodoIdperiodo) {
        this.periodoIdperiodo = periodoIdperiodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idreporte;
        hash += (int) tipoReporteIdtipoReporte;
        hash += (int) usuarioIdusuario;
        hash += (int) usuarioPaisIdpais;
        hash += (int) usuarioRolIdrol;
        hash += (int) periodoIdperiodo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportePK)) {
            return false;
        }
        ReportePK other = (ReportePK) object;
        if (this.idreporte != other.idreporte) {
            return false;
        }
        if (this.tipoReporteIdtipoReporte != other.tipoReporteIdtipoReporte) {
            return false;
        }
        if (this.usuarioIdusuario != other.usuarioIdusuario) {
            return false;
        }
        if (this.usuarioPaisIdpais != other.usuarioPaisIdpais) {
            return false;
        }
        if (this.usuarioRolIdrol != other.usuarioRolIdrol) {
            return false;
        }
        if (this.periodoIdperiodo != other.periodoIdperiodo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ReportePK[ idreporte=" + idreporte + ", tipoReporteIdtipoReporte=" + tipoReporteIdtipoReporte + ", usuarioIdusuario=" + usuarioIdusuario + ", usuarioPaisIdpais=" + usuarioPaisIdpais + ", usuarioRolIdrol=" + usuarioRolIdrol + ", periodoIdperiodo=" + periodoIdperiodo + " ]";
    }
    
}
