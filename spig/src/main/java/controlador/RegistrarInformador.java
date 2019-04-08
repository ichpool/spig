/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import auxiliares.FileToStringer;
import modelo.InformadorDAO;
import modelo.Informador;
import auxiliares.SendEmail;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.mail.MessagingException;

import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author n-droid
 */

@ManagedBean
public class RegistrarInformador {
    private String nombre;
    private String correo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void agregaInformador(){
        Random rn = new Random();
        Informador i = new Informador();
        i.setNombre(nombre);
        i.setCorreo(correo);
        String contrasenia = nombre.toLowerCase() + Integer.toString(rn.nextInt() % 1000);
        i.setContrasenia(contrasenia);
        InformadorDAO udb = new InformadorDAO();
        try {
            udb.save(i);
            FileToStringer fts = new FileToStringer();
            String html_string = fts.readFile("informador_mail.html");
            html_string = html_string.replace("[[nombre]]",nombre);
            html_string = html_string.replace("[[password]]",contrasenia);
            SendEmail.send(correo,
                    "Bienvenido a SPIG",
                    html_string);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrado", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ya existe ese correo", null));
            Logger.getLogger(RegistrarInformador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
