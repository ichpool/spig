/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.InformadorDAO;
import modelo.Informador;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author n-droid
 */

@ManagedBean
@SessionScoped
public class ConsultarInformador {
    private String info = null;
    private String tipoBusqueda = null;
    private List<Informador> resultado = null;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTipoBusqueda() {
        return info;
    }

    public void setTipoBusqueda(String tb) {
        this.tipoBusqueda = tb;
    }

    public List<Informador> getResultado() {
        return resultado;
    }

    public void setResultado(List<Informador> res) {
        this.resultado = res;
    }


    public String busca(){
        try {
            InformadorDAO inf_db = new InformadorDAO();
            if(tipoBusqueda.equals("todos")){
                resultado = inf_db.findAll();
            }
            if(info.equals("")){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Llena todos los campos", null));
                return null;
            }
            if(tipoBusqueda.equals("nombre")){
                resultado = inf_db.buscaPorNombreLike(info);
            }
            else{
                resultado = inf_db.buscaPorCorreoLike(info);
            }
            return "ConsultaInformadorHI?faces-redirect=true";
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocurrio un error en el servidor", null));
            Logger.getLogger(RegistrarInformador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
