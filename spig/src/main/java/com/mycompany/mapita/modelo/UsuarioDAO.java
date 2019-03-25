/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapita.modelo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Lisandro V.
 */
public class UsuarioDAO extends AbstractDAO<Usuario> {

    /**
     *
     */
    public UsuarioDAO(){
        super();
    }

    /**
     *
     * @param usuario
     */
    @Override
    public void save(Usuario usuario){
        super.save(usuario);
    }

    /**
     *
     * @param usuario
     */
    @Override
    public  void update(Usuario usuario){
        super.update(usuario);
    }

    /**
     *
     * @param usuario
     */
    @Override
    public void delete(Usuario usuario){
        super.delete(usuario);
    }

    /**
     *
     * @param id
     * @return
     */
    public Usuario find(int id){
        return super.find(Usuario.class, id);
    }

    /**
     *
     * @return
     */
    public List<Usuario> findAll(){
        return super.findAll(Usuario.class);

    }

    public List<Usuario> buscaPorNombre(String nombre){
//        if(nombre.equals(""))
//            return null;
        List<Usuario> usuarios =null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "From Usuario where nombre like concat('%',:nombre,'%')";
            Query query = session.createQuery(hql);
            query.setParameter("nombre", nombre);
            usuarios = (List<Usuario>)query.list();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return usuarios;
    }


    public Usuario buscaPorCorreo(String correo){
       if(correo.equals(""))
           return null;
        Usuario u =null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "From Usuario where correo = :correo";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            u = (Usuario)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return u;
    }

    public Usuario buscaPorCorreoContrasenia(String correo, String passwd){
       if(correo.equals("") || passwd.equals(""))
           return null;
        Usuario u =null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "From Usuario where correo = :correo AND contrasesnia = :contra";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            query.setParameter("contra", passwd);
            u = (Usuario)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return u;
    }

}
