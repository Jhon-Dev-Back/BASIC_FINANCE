/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Jhon Deibys Torres
 * 
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {

    private String usuario;
    private String contrasenna;

    public Login(String usuario, String contrasenna) {
        this.usuario = usuario;
        this.contrasenna = contrasenna;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }
    
    public String iniciarSesion(){
        
        if (usuario.equals("admin") && contrasenna.equals("admin123")) {
            HttpSession sesion = ( HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            sesion.setAttribute("usuario", usuario);
            return "inicio?faces-redirect=true";
        }else{
            
            FacesContext context =  FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o contraseña invalidos", "MSG_ERROR");
            context.addMessage(null, fm);
            return null;
        }
    }
    
    public Login() {
    }
    
}
