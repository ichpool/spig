/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mycompany.mapita.modelo.Usuario;
import com.mycompany.mapita.modelo.UsuarioDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Lisandro V.
 */
@ManagedBean
@SessionScoped
//@RequestScoped
public class EliminaUsuario {
    private String correo;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String eliminaPorCorreo(){
        if(correo.equals(""))
            return "";
        UsuarioDAO ubd = new UsuarioDAO();
        Usuario u = ubd.buscaPorCorreo(correo);
        if(u!=null){
            ubd.delete(u);
        }
        return "index?faces-redirect=true";
    }
}
