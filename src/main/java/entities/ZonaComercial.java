/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jhon Deibys Torres
 */
@Entity
@Table(name = "zona_comercial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZonaComercial.findAll", query = "SELECT z FROM ZonaComercial z"),
    @NamedQuery(name = "ZonaComercial.findByListaContenido", query = "SELECT z FROM ZonaComercial z WHERE z.listaContenido = :listaContenido")})
public class ZonaComercial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "listaContenido")
    private String listaContenido;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "detalleContenido")
    private String detalleContenido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zonaComercial")
    private Collection<PautaPublicitaria> pautaPublicitariaCollection;

    public ZonaComercial() {
    }

    public ZonaComercial(String listaContenido) {
        this.listaContenido = listaContenido;
    }

    public ZonaComercial(String listaContenido, String detalleContenido) {
        this.listaContenido = listaContenido;
        this.detalleContenido = detalleContenido;
    }

    public String getListaContenido() {
        return listaContenido;
    }

    public void setListaContenido(String listaContenido) {
        this.listaContenido = listaContenido;
    }

    public String getDetalleContenido() {
        return detalleContenido;
    }

    public void setDetalleContenido(String detalleContenido) {
        this.detalleContenido = detalleContenido;
    }

    @XmlTransient
    public Collection<PautaPublicitaria> getPautaPublicitariaCollection() {
        return pautaPublicitariaCollection;
    }

    public void setPautaPublicitariaCollection(Collection<PautaPublicitaria> pautaPublicitariaCollection) {
        this.pautaPublicitariaCollection = pautaPublicitariaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listaContenido != null ? listaContenido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZonaComercial)) {
            return false;
        }
        ZonaComercial other = (ZonaComercial) object;
        if ((this.listaContenido == null && other.listaContenido != null) || (this.listaContenido != null && !this.listaContenido.equals(other.listaContenido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ZonaComercial[ listaContenido=" + listaContenido + " ]";
    }
    
}
