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
public class UsuarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idusuario")
    private int idusuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pais_idpais")
    private int paisIdpais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rol_idrol")
    private int rolIdrol;

    public UsuarioPK() {
    }

    public UsuarioPK(int idusuario, int paisIdpais, int rolIdrol) {
        this.idusuario = idusuario;
        this.paisIdpais = paisIdpais;
        this.rolIdrol = rolIdrol;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getPaisIdpais() {
        return paisIdpais;
    }

    public void setPaisIdpais(int paisIdpais) {
        this.paisIdpais = paisIdpais;
    }

    public int getRolIdrol() {
        return rolIdrol;
    }

    public void setRolIdrol(int rolIdrol) {
        this.rolIdrol = rolIdrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idusuario;
        hash += (int) paisIdpais;
        hash += (int) rolIdrol;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPK)) {
            return false;
        }
        UsuarioPK other = (UsuarioPK) object;
        if (this.idusuario != other.idusuario) {
            return false;
        }
        if (this.paisIdpais != other.paisIdpais) {
            return false;
        }
        if (this.rolIdrol != other.rolIdrol) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UsuarioPK[ idusuario=" + idusuario + ", paisIdpais=" + paisIdpais + ", rolIdrol=" + rolIdrol + " ]";
    }
    
}
