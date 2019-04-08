/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.InformadorDAO;
import modelo.Informador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author n-droid
 */

@ManagedBean
public class EliminarInformador {
    private String correo;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void eliminaInformador(){
        try {
            InformadorDAO inf_db = new InformadorDAO();
            Informador i = inf_db.buscaPorCorreo(correo);
            if(i == null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No existe ese informador", null));
                return;
            }
            inf_db.delete(i);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informador eliminado", null));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocurrio un error en el servidor", null));
            Logger.getLogger(RegistrarInformador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
