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
public class FinanzasPersonalesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idReporte")
    private int idReporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_idUsuario")
    private int usuarioidUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finanzas_kids_idKids")
    private int finanzaskidsidKids;

    public FinanzasPersonalesPK() {
    }

    public FinanzasPersonalesPK(int idReporte, int usuarioidUsuario, int finanzaskidsidKids) {
        this.idReporte = idReporte;
        this.usuarioidUsuario = usuarioidUsuario;
        this.finanzaskidsidKids = finanzaskidsidKids;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public int getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(int usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public int getFinanzaskidsidKids() {
        return finanzaskidsidKids;
    }

    public void setFinanzaskidsidKids(int finanzaskidsidKids) {
        this.finanzaskidsidKids = finanzaskidsidKids;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idReporte;
        hash += (int) usuarioidUsuario;
        hash += (int) finanzaskidsidKids;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinanzasPersonalesPK)) {
            return false;
        }
        FinanzasPersonalesPK other = (FinanzasPersonalesPK) object;
        if (this.idReporte != other.idReporte) {
            return false;
        }
        if (this.usuarioidUsuario != other.usuarioidUsuario) {
            return false;
        }
        if (this.finanzaskidsidKids != other.finanzaskidsidKids) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FinanzasPersonalesPK[ idReporte=" + idReporte + ", usuarioidUsuario=" + usuarioidUsuario + ", finanzaskidsidKids=" + finanzaskidsidKids + " ]";
    }
    
}
