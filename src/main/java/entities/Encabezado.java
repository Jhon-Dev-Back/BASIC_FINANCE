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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jhon Deibys Torres
 */
@Entity
@Table(name = "encabezado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encabezado.findAll", query = "SELECT e FROM Encabezado e"),
    @NamedQuery(name = "Encabezado.findByCodigoPago", query = "SELECT e FROM Encabezado e WHERE e.codigoPago = :codigoPago"),
    @NamedQuery(name = "Encabezado.findByFechaEmision", query = "SELECT e FROM Encabezado e WHERE e.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "Encabezado.findByMonto", query = "SELECT e FROM Encabezado e WHERE e.monto = :monto")})
public class Encabezado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoPago")
    private Integer codigoPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEmision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private BigDecimal monto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "encabezado")
    private Collection<ComprobantePago> comprobantePagoCollection;

    public Encabezado() {
    }

    public Encabezado(Integer codigoPago) {
        this.codigoPago = codigoPago;
    }

    public Encabezado(Integer codigoPago, Date fechaEmision, BigDecimal monto) {
        this.codigoPago = codigoPago;
        this.fechaEmision = fechaEmision;
        this.monto = monto;
    }

    public Integer getCodigoPago() {
        return codigoPago;
    }

    public void setCodigoPago(Integer codigoPago) {
        this.codigoPago = codigoPago;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    @XmlTransient
    public Collection<ComprobantePago> getComprobantePagoCollection() {
        return comprobantePagoCollection;
    }

    public void setComprobantePagoCollection(Collection<ComprobantePago> comprobantePagoCollection) {
        this.comprobantePagoCollection = comprobantePagoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPago != null ? codigoPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encabezado)) {
            return false;
        }
        Encabezado other = (Encabezado) object;
        if ((this.codigoPago == null && other.codigoPago != null) || (this.codigoPago != null && !this.codigoPago.equals(other.codigoPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Encabezado[ codigoPago=" + codigoPago + " ]";
    }
    
}
