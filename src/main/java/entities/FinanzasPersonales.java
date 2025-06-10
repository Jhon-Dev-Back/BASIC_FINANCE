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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "finanzas_personales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinanzasPersonales.findAll", query = "SELECT f FROM FinanzasPersonales f"),
    @NamedQuery(name = "FinanzasPersonales.findByIdReporte", query = "SELECT f FROM FinanzasPersonales f WHERE f.finanzasPersonalesPK.idReporte = :idReporte"),
    @NamedQuery(name = "FinanzasPersonales.findByFecha", query = "SELECT f FROM FinanzasPersonales f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "FinanzasPersonales.findByIngresosTotales", query = "SELECT f FROM FinanzasPersonales f WHERE f.ingresosTotales = :ingresosTotales"),
    @NamedQuery(name = "FinanzasPersonales.findByGastosTotales", query = "SELECT f FROM FinanzasPersonales f WHERE f.gastosTotales = :gastosTotales"),
    @NamedQuery(name = "FinanzasPersonales.findByAhorros", query = "SELECT f FROM FinanzasPersonales f WHERE f.ahorros = :ahorros"),
    @NamedQuery(name = "FinanzasPersonales.findByPeriodo", query = "SELECT f FROM FinanzasPersonales f WHERE f.periodo = :periodo"),
    @NamedQuery(name = "FinanzasPersonales.findByUsuarioidUsuario", query = "SELECT f FROM FinanzasPersonales f WHERE f.finanzasPersonalesPK.usuarioidUsuario = :usuarioidUsuario"),
    @NamedQuery(name = "FinanzasPersonales.findByFinanzaskidsidKids", query = "SELECT f FROM FinanzasPersonales f WHERE f.finanzasPersonalesPK.finanzaskidsidKids = :finanzaskidsidKids")})
public class FinanzasPersonales implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FinanzasPersonalesPK finanzasPersonalesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ingresosTotales")
    private BigDecimal ingresosTotales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gastosTotales")
    private BigDecimal gastosTotales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ahorros")
    private BigDecimal ahorros;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "periodo")
    private String periodo;
    @JoinColumn(name = "finanzas_kids_idKids", referencedColumnName = "idKids", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FinanzasKids finanzasKids;
    @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public FinanzasPersonales() {
    }

    public FinanzasPersonales(FinanzasPersonalesPK finanzasPersonalesPK) {
        this.finanzasPersonalesPK = finanzasPersonalesPK;
    }

    public FinanzasPersonales(FinanzasPersonalesPK finanzasPersonalesPK, Date fecha, BigDecimal ingresosTotales, BigDecimal gastosTotales, BigDecimal ahorros, String periodo) {
        this.finanzasPersonalesPK = finanzasPersonalesPK;
        this.fecha = fecha;
        this.ingresosTotales = ingresosTotales;
        this.gastosTotales = gastosTotales;
        this.ahorros = ahorros;
        this.periodo = periodo;
    }

    public FinanzasPersonales(int idReporte, int usuarioidUsuario, int finanzaskidsidKids) {
        this.finanzasPersonalesPK = new FinanzasPersonalesPK(idReporte, usuarioidUsuario, finanzaskidsidKids);
    }

    public FinanzasPersonalesPK getFinanzasPersonalesPK() {
        return finanzasPersonalesPK;
    }

    public void setFinanzasPersonalesPK(FinanzasPersonalesPK finanzasPersonalesPK) {
        this.finanzasPersonalesPK = finanzasPersonalesPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getIngresosTotales() {
        return ingresosTotales;
    }

    public void setIngresosTotales(BigDecimal ingresosTotales) {
        this.ingresosTotales = ingresosTotales;
    }

    public BigDecimal getGastosTotales() {
        return gastosTotales;
    }

    public void setGastosTotales(BigDecimal gastosTotales) {
        this.gastosTotales = gastosTotales;
    }

    public BigDecimal getAhorros() {
        return ahorros;
    }

    public void setAhorros(BigDecimal ahorros) {
        this.ahorros = ahorros;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public FinanzasKids getFinanzasKids() {
        return finanzasKids;
    }

    public void setFinanzasKids(FinanzasKids finanzasKids) {
        this.finanzasKids = finanzasKids;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finanzasPersonalesPK != null ? finanzasPersonalesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinanzasPersonales)) {
            return false;
        }
        FinanzasPersonales other = (FinanzasPersonales) object;
        if ((this.finanzasPersonalesPK == null && other.finanzasPersonalesPK != null) || (this.finanzasPersonalesPK != null && !this.finanzasPersonalesPK.equals(other.finanzasPersonalesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FinanzasPersonales[ finanzasPersonalesPK=" + finanzasPersonalesPK + " ]";
    }
    
}
