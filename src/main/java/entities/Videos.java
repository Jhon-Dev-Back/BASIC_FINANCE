/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "videos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Videos.findAll", query = "SELECT v FROM Videos v"),
    @NamedQuery(name = "Videos.findByIdVideos", query = "SELECT v FROM Videos v WHERE v.videosPK.idVideos = :idVideos"),
    @NamedQuery(name = "Videos.findByDuracion", query = "SELECT v FROM Videos v WHERE v.duracion = :duracion"),
    @NamedQuery(name = "Videos.findByFinanzaskidsidKids", query = "SELECT v FROM Videos v WHERE v.videosPK.finanzaskidsidKids = :finanzaskidsidKids")})
public class Videos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VideosPK videosPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion")
    @Temporal(TemporalType.TIME)
    private Date duracion;
    @JoinColumn(name = "finanzas_kids_idKids", referencedColumnName = "idKids", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FinanzasKids finanzasKids;

    public Videos() {
    }

    public Videos(VideosPK videosPK) {
        this.videosPK = videosPK;
    }

    public Videos(VideosPK videosPK, String descripcion, Date duracion) {
        this.videosPK = videosPK;
        this.descripcion = descripcion;
        this.duracion = duracion;
    }

    public Videos(int idVideos, int finanzaskidsidKids) {
        this.videosPK = new VideosPK(idVideos, finanzaskidsidKids);
    }

    public VideosPK getVideosPK() {
        return videosPK;
    }

    public void setVideosPK(VideosPK videosPK) {
        this.videosPK = videosPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public FinanzasKids getFinanzasKids() {
        return finanzasKids;
    }

    public void setFinanzasKids(FinanzasKids finanzasKids) {
        this.finanzasKids = finanzasKids;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (videosPK != null ? videosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Videos)) {
            return false;
        }
        Videos other = (Videos) object;
        if ((this.videosPK == null && other.videosPK != null) || (this.videosPK != null && !this.videosPK.equals(other.videosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Videos[ videosPK=" + videosPK + " ]";
    }
    
}
