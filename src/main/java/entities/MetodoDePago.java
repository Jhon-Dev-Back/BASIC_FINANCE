/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "metodo_de_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetodoDePago.findAll", query = "SELECT m FROM MetodoDePago m"),
    @NamedQuery(name = "MetodoDePago.findByIdmetododePago", query = "SELECT m FROM MetodoDePago m WHERE m.idmetododePago = :idmetododePago"),
    @NamedQuery(name = "MetodoDePago.findByNombrePago", query = "SELECT m FROM MetodoDePago m WHERE m.nombrePago = :nombrePago")})
public class MetodoDePago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmetodo_de_Pago")
    private Integer idmetododePago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre_pago")
    private String nombrePago;

    public MetodoDePago() {
    }

    public MetodoDePago(Integer idmetododePago) {
        this.idmetododePago = idmetododePago;
    }

    public MetodoDePago(Integer idmetododePago, String nombrePago) {
        this.idmetododePago = idmetododePago;
        this.nombrePago = nombrePago;
    }

    public Integer getIdmetododePago() {
        return idmetododePago;
    }

    public void setIdmetododePago(Integer idmetododePago) {
        this.idmetododePago = idmetododePago;
    }

    public String getNombrePago() {
        return nombrePago;
    }

    public void setNombrePago(String nombrePago) {
        this.nombrePago = nombrePago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmetododePago != null ? idmetododePago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetodoDePago)) {
            return false;
        }
        MetodoDePago other = (MetodoDePago) object;
        if ((this.idmetododePago == null && other.idmetododePago != null) || (this.idmetododePago != null && !this.idmetododePago.equals(other.idmetododePago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MetodoDePago[ idmetododePago=" + idmetododePago + " ]";
    }
    
}
