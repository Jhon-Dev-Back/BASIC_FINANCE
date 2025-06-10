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
import javax.validation.constraints.Size;

/**
 *
 * @author Jhon Deibys Torres
 */
@Embeddable
public class PautaPublicitariaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idPauta")
    private int idPauta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "zona_comercial_listaContenido")
    private String zonacomerciallistaContenido;

    public PautaPublicitariaPK() {
    }

    public PautaPublicitariaPK(int idPauta, String zonacomerciallistaContenido) {
        this.idPauta = idPauta;
        this.zonacomerciallistaContenido = zonacomerciallistaContenido;
    }

    public int getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(int idPauta) {
        this.idPauta = idPauta;
    }

    public String getZonacomerciallistaContenido() {
        return zonacomerciallistaContenido;
    }

    public void setZonacomerciallistaContenido(String zonacomerciallistaContenido) {
        this.zonacomerciallistaContenido = zonacomerciallistaContenido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPauta;
        hash += (zonacomerciallistaContenido != null ? zonacomerciallistaContenido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PautaPublicitariaPK)) {
            return false;
        }
        PautaPublicitariaPK other = (PautaPublicitariaPK) object;
        if (this.idPauta != other.idPauta) {
            return false;
        }
        if ((this.zonacomerciallistaContenido == null && other.zonacomerciallistaContenido != null) || (this.zonacomerciallistaContenido != null && !this.zonacomerciallistaContenido.equals(other.zonacomerciallistaContenido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PautaPublicitariaPK[ idPauta=" + idPauta + ", zonacomerciallistaContenido=" + zonacomerciallistaContenido + " ]";
    }
    
}
