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
public class BuscaPorNombre {
    private String nombre;

    private List<Usuario> resultado;

    public List<Usuario> getResultado() {
        return resultado;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String buscaPorNombre(){
        if(nombre.equals(""))
            return "";
        UsuarioDAO ubd = new UsuarioDAO();
        resultado =  ubd.buscaPorNombre(nombre);
        return "resultado?faces-redirect=true";
    }
}
