/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "juegos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juegos.findAll", query = "SELECT j FROM Juegos j"),
    @NamedQuery(name = "Juegos.findByIdJuegos", query = "SELECT j FROM Juegos j WHERE j.juegosPK.idJuegos = :idJuegos"),
    @NamedQuery(name = "Juegos.findByNombreJuego", query = "SELECT j FROM Juegos j WHERE j.nombreJuego = :nombreJuego"),
    @NamedQuery(name = "Juegos.findByDificultad", query = "SELECT j FROM Juegos j WHERE j.dificultad = :dificultad"),
    @NamedQuery(name = "Juegos.findByProgreso", query = "SELECT j FROM Juegos j WHERE j.progreso = :progreso"),
    @NamedQuery(name = "Juegos.findByFinanzaskidsidKids", query = "SELECT j FROM Juegos j WHERE j.juegosPK.finanzaskidsidKids = :finanzaskidsidKids")})
public class Juegos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JuegosPK juegosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombreJuego")
    private String nombreJuego;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "dificultad")
    private String dificultad;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "progreso")
    private float progreso;
    @ManyToMany(mappedBy = "juegosCollection")
    private Collection<FinanzasKids> finanzasKidsCollection;
    @JoinColumn(name = "finanzas_kids_idKids", referencedColumnName = "idKids", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FinanzasKids finanzasKids;

    public Juegos() {
    }

    public Juegos(JuegosPK juegosPK) {
        this.juegosPK = juegosPK;
    }

    public Juegos(JuegosPK juegosPK, String nombreJuego, String dificultad, String descripcion, float progreso) {
        this.juegosPK = juegosPK;
        this.nombreJuego = nombreJuego;
        this.dificultad = dificultad;
        this.descripcion = descripcion;
        this.progreso = progreso;
    }

    public Juegos(int idJuegos, int finanzaskidsidKids) {
        this.juegosPK = new JuegosPK(idJuegos, finanzaskidsidKids);
    }

    public JuegosPK getJuegosPK() {
        return juegosPK;
    }

    public void setJuegosPK(JuegosPK juegosPK) {
        this.juegosPK = juegosPK;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getProgreso() {
        return progreso;
    }

    public void setProgreso(float progreso) {
        this.progreso = progreso;
    }

    @XmlTransient
    public Collection<FinanzasKids> getFinanzasKidsCollection() {
        return finanzasKidsCollection;
    }

    public void setFinanzasKidsCollection(Collection<FinanzasKids> finanzasKidsCollection) {
        this.finanzasKidsCollection = finanzasKidsCollection;
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
        hash += (juegosPK != null ? juegosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juegos)) {
            return false;
        }
        Juegos other = (Juegos) object;
        if ((this.juegosPK == null && other.juegosPK != null) || (this.juegosPK != null && !this.juegosPK.equals(other.juegosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Juegos[ juegosPK=" + juegosPK + " ]";
    }
    
}
