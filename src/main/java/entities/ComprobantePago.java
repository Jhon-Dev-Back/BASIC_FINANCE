/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jhon Deibys Torres
 */
@Entity
@Table(name = "comprobante_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprobantePago.findAll", query = "SELECT c FROM ComprobantePago c"),
    @NamedQuery(name = "ComprobantePago.findByIdComprobante", query = "SELECT c FROM ComprobantePago c WHERE c.comprobantePagoPK.idComprobante = :idComprobante"),
    @NamedQuery(name = "ComprobantePago.findByEncabezadocodigoPago", query = "SELECT c FROM ComprobantePago c WHERE c.comprobantePagoPK.encabezadocodigoPago = :encabezadocodigoPago")})
public class ComprobantePago implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComprobantePagoPK comprobantePagoPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comprobantePago")
    private Collection<Transacciones> transaccionesCollection;
    @JoinColumn(name = "encabezado_codigoPago", referencedColumnName = "codigoPago", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Encabezado encabezado;

    public ComprobantePago() {
    }

    public ComprobantePago(ComprobantePagoPK comprobantePagoPK) {
        this.comprobantePagoPK = comprobantePagoPK;
    }

    public ComprobantePago(int idComprobante, int encabezadocodigoPago) {
        this.comprobantePagoPK = new ComprobantePagoPK(idComprobante, encabezadocodigoPago);
    }

    public ComprobantePagoPK getComprobantePagoPK() {
        return comprobantePagoPK;
    }

    public void setComprobantePagoPK(ComprobantePagoPK comprobantePagoPK) {
        this.comprobantePagoPK = comprobantePagoPK;
    }

    @XmlTransient
    public Collection<Transacciones> getTransaccionesCollection() {
        return transaccionesCollection;
    }

    public void setTransaccionesCollection(Collection<Transacciones> transaccionesCollection) {
        this.transaccionesCollection = transaccionesCollection;
    }

    public Encabezado getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Encabezado encabezado) {
        this.encabezado = encabezado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comprobantePagoPK != null ? comprobantePagoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobantePago)) {
            return false;
        }
        ComprobantePago other = (ComprobantePago) object;
        if ((this.comprobantePagoPK == null && other.comprobantePagoPK != null) || (this.comprobantePagoPK != null && !this.comprobantePagoPK.equals(other.comprobantePagoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ComprobantePago[ comprobantePagoPK=" + comprobantePagoPK + " ]";
    }
    
}
