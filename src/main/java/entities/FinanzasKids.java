/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "finanzas_kids")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinanzasKids.findAll", query = "SELECT f FROM FinanzasKids f"),
    @NamedQuery(name = "FinanzasKids.findByIdKids", query = "SELECT f FROM FinanzasKids f WHERE f.idKids = :idKids"),
    @NamedQuery(name = "FinanzasKids.findByNombres", query = "SELECT f FROM FinanzasKids f WHERE f.nombres = :nombres"),
    @NamedQuery(name = "FinanzasKids.findByApellidos", query = "SELECT f FROM FinanzasKids f WHERE f.apellidos = :apellidos"),
    @NamedQuery(name = "FinanzasKids.findByEdad", query = "SELECT f FROM FinanzasKids f WHERE f.edad = :edad"),
    @NamedQuery(name = "FinanzasKids.findByTokens", query = "SELECT f FROM FinanzasKids f WHERE f.tokens = :tokens")})
public class FinanzasKids implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idKids")
    private Integer idKids;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "tokens")
    private BigDecimal tokens;
    @JoinTable(
    name = "juegos_has_finanzas_kids",
    joinColumns = {
        @JoinColumn(name = "finanzas_kids_idKids", referencedColumnName = "idKids")
    },
    inverseJoinColumns = {
        @JoinColumn(name = "idJuegos", referencedColumnName = "idJuegos"),
        @JoinColumn(name = "finanzas_kids_idKids", referencedColumnName = "finanzas_kids_idKids")
    }
)
@ManyToMany
private Collection<Juegos> juegosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "finanzasKids")
    private Collection<FinanzasPersonales> finanzasPersonalesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "finanzasKids")
    private Collection<Videos> videosCollection;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "finanzasKids")
    //private Collection<Juegos> juegosCollection1;

    public FinanzasKids() {
    }

    public FinanzasKids(Integer idKids) {
        this.idKids = idKids;
    }

    public FinanzasKids(Integer idKids, String nombres, String apellidos, int edad, BigDecimal tokens) {
        this.idKids = idKids;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.tokens = tokens;
    }

    public Integer getIdKids() {
        return idKids;
    }

    public void setIdKids(Integer idKids) {
        this.idKids = idKids;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public BigDecimal getTokens() {
        return tokens;
    }

    public void setTokens(BigDecimal tokens) {
        this.tokens = tokens;
    }

    @XmlTransient
    public Collection<Juegos> getJuegosCollection() {
        return juegosCollection;
    }

    public void setJuegosCollection(Collection<Juegos> juegosCollection) {
        this.juegosCollection = juegosCollection;
    }

    @XmlTransient
    public Collection<FinanzasPersonales> getFinanzasPersonalesCollection() {
        return finanzasPersonalesCollection;
    }

    public void setFinanzasPersonalesCollection(Collection<FinanzasPersonales> finanzasPersonalesCollection) {
        this.finanzasPersonalesCollection = finanzasPersonalesCollection;
    }

    @XmlTransient
    public Collection<Videos> getVideosCollection() {
        return videosCollection;
    }

    public void setVideosCollection(Collection<Videos> videosCollection) {
        this.videosCollection = videosCollection;
    }

   /* @XmlTransient
    public Collection<Juegos> getJuegosCollection1() {
        return juegosCollection1;
    }

    public void setJuegosCollection1(Collection<Juegos> juegosCollection1) {
        this.juegosCollection1 = juegosCollection1;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKids != null ? idKids.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinanzasKids)) {
            return false;
        }
        FinanzasKids other = (FinanzasKids) object;
        if ((this.idKids == null && other.idKids != null) || (this.idKids != null && !this.idKids.equals(other.idKids))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FinanzasKids[ idKids=" + idKids + " ]";
    }
    
}
