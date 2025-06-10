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
@Table(name = "pauta_publicitaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PautaPublicitaria.findAll", query = "SELECT p FROM PautaPublicitaria p"),
    @NamedQuery(name = "PautaPublicitaria.findByIdPauta", query = "SELECT p FROM PautaPublicitaria p WHERE p.pautaPublicitariaPK.idPauta = :idPauta"),
    @NamedQuery(name = "PautaPublicitaria.findByEstado", query = "SELECT p FROM PautaPublicitaria p WHERE p.estado = :estado"),
    @NamedQuery(name = "PautaPublicitaria.findByPresupuesto", query = "SELECT p FROM PautaPublicitaria p WHERE p.presupuesto = :presupuesto"),
    @NamedQuery(name = "PautaPublicitaria.findByZonacomerciallistaContenido", query = "SELECT p FROM PautaPublicitaria p WHERE p.pautaPublicitariaPK.zonacomerciallistaContenido = :zonacomerciallistaContenido")})
public class PautaPublicitaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PautaPublicitariaPK pautaPublicitariaPK;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "presupuesto")
    private BigDecimal presupuesto;
    @JoinColumn(name = "zona_comercial_listaContenido", referencedColumnName = "listaContenido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ZonaComercial zonaComercial;

    public PautaPublicitaria() {
    }

    public PautaPublicitaria(PautaPublicitariaPK pautaPublicitariaPK) {
        this.pautaPublicitariaPK = pautaPublicitariaPK;
    }

    public PautaPublicitaria(PautaPublicitariaPK pautaPublicitariaPK, String descripcion, String estado, BigDecimal presupuesto) {
        this.pautaPublicitariaPK = pautaPublicitariaPK;
        this.descripcion = descripcion;
        this.estado = estado;
        this.presupuesto = presupuesto;
    }

    public PautaPublicitaria(int idPauta, String zonacomerciallistaContenido) {
        this.pautaPublicitariaPK = new PautaPublicitariaPK(idPauta, zonacomerciallistaContenido);
    }

    public PautaPublicitariaPK getPautaPublicitariaPK() {
        return pautaPublicitariaPK;
    }

    public void setPautaPublicitariaPK(PautaPublicitariaPK pautaPublicitariaPK) {
        this.pautaPublicitariaPK = pautaPublicitariaPK;
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

    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(BigDecimal presupuesto) {
        this.presupuesto = presupuesto;
    }

    public ZonaComercial getZonaComercial() {
        return zonaComercial;
    }

    public void setZonaComercial(ZonaComercial zonaComercial) {
        this.zonaComercial = zonaComercial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pautaPublicitariaPK != null ? pautaPublicitariaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PautaPublicitaria)) {
            return false;
        }
        PautaPublicitaria other = (PautaPublicitaria) object;
        if ((this.pautaPublicitariaPK == null && other.pautaPublicitariaPK != null) || (this.pautaPublicitariaPK != null && !this.pautaPublicitariaPK.equals(other.pautaPublicitariaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PautaPublicitaria[ pautaPublicitariaPK=" + pautaPublicitariaPK + " ]";
    }
    
}
