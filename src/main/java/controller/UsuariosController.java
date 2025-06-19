/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import entities.EstadoRol;
import entities.Pais;
import entities.Rol;
import entities.Usuario;
import entities.UsuarioPK;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import services.EstadoRolFacadeLocal;
import services.PaisFacadeLocal;
import services.RolFacadeLocal;
import services.UsuarioFacadeLocal;

/**
 *
 * @author Jhon Deibys Torres
 */
@Named(value = "usuariosController")
@SessionScoped
public class UsuariosController implements Serializable {

    /**
     * Creates a new instance of UsuariosController
     */
    Usuario user =new Usuario();
    UsuarioPK pk = new UsuarioPK();
    Rol rol = new Rol();
    Pais pais = new Pais();
    EstadoRol est = new EstadoRol();

    @EJB
    PaisFacadeLocal pfl;
    @EJB
    UsuarioFacadeLocal ufl;
    @EJB
    RolFacadeLocal rfl;
    @EJB
    EstadoRolFacadeLocal erfl;
    

    List<SelectItem> listaPaises;
    List<SelectItem> listarEstados;
    List<SelectItem> listarRoles;

    public UsuarioPK getPk() {
        return pk;
    }

    public void setPk(UsuarioPK pk) {
        this.pk = pk;
    }

    public EstadoRol getEst() {
        return est;
    }

    public void setEst(EstadoRol est) {
        this.est = est;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public List<Usuario> listarUsuarios() {

        try {
            return this.ufl.findAll();
        } catch (Exception e) {
        }

        return null;
    }

    public UsuariosController() {
    }

    public List<SelectItem> listarPaises() {

        listaPaises = new ArrayList<>();
        try {
            for (Pais pais : this.pfl.findAll()) {

                SelectItem item = new SelectItem(pais.getIdpais(), pais.getNombrePais());
                listaPaises.add(item);

            }

            return listaPaises;
        } catch (Exception e) {
        }
        return null;
    }

    public List<SelectItem> listarEstados() {

        listarEstados = new ArrayList<>();
        try {
            for (EstadoRol erol : this.erfl.findAll()) {
                if ("Activo".equalsIgnoreCase(erol.getEstadoRol())) {
                    SelectItem item = new SelectItem(erol.getIdestadoRol(), erol.getEstadoRol());
                    listarEstados.add(item);
                }
            }

            return listarEstados;
        } catch (Exception e) {
        }
        return null;
    }

    private int generarIdUsuario() {
        List<Usuario> lista = ufl.findAll();
        int maxId = 0;
        for (Usuario u : lista) {
            if (u.getUsuarioPK().getIdusuario() > maxId) {
                maxId = u.getUsuarioPK().getIdusuario();
            }
        }
        return maxId + 1;
    }

    public String crearUsuarioPartOne() {
   
        this.user = new Usuario();
        return "crear_usuarios_Admin.xhtml?faces-redirect=true";

    }

    public String crearUsuario() {

        try {
            UsuarioPK pk = new UsuarioPK();
            pk.setIdusuario(generarIdUsuario());
            pk.setRolIdrol(this.rol.getIdrol());
            pk.setPaisIdpais(this.pais.getIdpais());

            this.user.setUsuarioPK(pk);
            Pais p = pfl.find(this.pais.getIdpais());
            this.user.setPais(p);
            this.ufl.create(user);
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Registrado Exitosamente", "MSG_INFO");
            context.addMessage(null, fm);

            return "/newLogin.xhtml?faces-redirect=true";

        } catch (Exception e) {
        }
        return null;
    }

    public List<SelectItem> listarRol() {

        listarRoles = new ArrayList<>();
        try {
            for (Rol rol : this.rfl.findAll()) {
                if ("Cliente".equalsIgnoreCase(rol.getNombreRol())) {
                    SelectItem item = new SelectItem(rol.getIdrol(), rol.getNombreRol());
                    listarRoles.add(item);
                }
            }

            return listarRoles;
        } catch (Exception e) {
        }
        return null;
    }

    public List<SelectItem> listarRolAdmin() {

        listarRoles = new ArrayList<>();
        try {
            for (Rol rol : this.rfl.findAll()) {

                SelectItem item = new SelectItem(rol.getIdrol(), rol.getNombreRol());
                listarRoles.add(item);

            }

            return listarRoles;
        } catch (Exception e) {
        }
        return null;
    }

    public String editarUserOne(Usuario u) {       
     
        this.user = u;
        this.pk = this.user.getUsuarioPK();
       return "crear_usuarios_Admin.xhtml?faces-redirect=true";
       
    }
    
    public String editarStepTwo() {       
     
        try {
            this.ufl.edit(user);
            
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Editado Exitosamente", "MSG_INFO");
            context.addMessage(null, fm);
        } catch (Exception e) {
        }
       return "crear_usuarios_Admin.xhtml?faces-redirect=true";
       
    }
    
    public void Eliminar(Usuario user){
        try {
            this.ufl.remove(user); 
            FacesContext context = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Eliminado Exitosamente", "MSG_INFO");
            context.addMessage(null, fm);
        } catch (Exception e) {
        }
    }
    
    
}
