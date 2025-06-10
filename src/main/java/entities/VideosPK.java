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
public class VideosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idVideos")
    private int idVideos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finanzas_kids_idKids")
    private int finanzaskidsidKids;

    public VideosPK() {
    }

    public VideosPK(int idVideos, int finanzaskidsidKids) {
        this.idVideos = idVideos;
        this.finanzaskidsidKids = finanzaskidsidKids;
    }

    public int getIdVideos() {
        return idVideos;
    }

    public void setIdVideos(int idVideos) {
        this.idVideos = idVideos;
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
        hash += (int) idVideos;
        hash += (int) finanzaskidsidKids;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VideosPK)) {
            return false;
        }
        VideosPK other = (VideosPK) object;
        if (this.idVideos != other.idVideos) {
            return false;
        }
        if (this.finanzaskidsidKids != other.finanzaskidsidKids) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VideosPK[ idVideos=" + idVideos + ", finanzaskidsidKids=" + finanzaskidsidKids + " ]";
    }
    
}
