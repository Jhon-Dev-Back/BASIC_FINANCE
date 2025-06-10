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
public class JuegosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idJuegos")
    private int idJuegos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finanzas_kids_idKids")
    private int finanzaskidsidKids;

    public JuegosPK() {
    }

    public JuegosPK(int idJuegos, int finanzaskidsidKids) {
        this.idJuegos = idJuegos;
        this.finanzaskidsidKids = finanzaskidsidKids;
    }

    public int getIdJuegos() {
        return idJuegos;
    }

    public void setIdJuegos(int idJuegos) {
        this.idJuegos = idJuegos;
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
        hash += (int) idJuegos;
        hash += (int) finanzaskidsidKids;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JuegosPK)) {
            return false;
        }
        JuegosPK other = (JuegosPK) object;
        if (this.idJuegos != other.idJuegos) {
            return false;
        }
        if (this.finanzaskidsidKids != other.finanzaskidsidKids) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.JuegosPK[ idJuegos=" + idJuegos + ", finanzaskidsidKids=" + finanzaskidsidKids + " ]";
    }
    
}
