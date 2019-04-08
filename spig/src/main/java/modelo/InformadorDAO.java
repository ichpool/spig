/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author n-droid
 */
public class InformadorDAO extends AbstractDAO<Informador>{

    /**
     *
     */
    public InformadorDAO(){
        super();
    }

    /**
     *
     * @param informador
     */
    @Override
    public void save(Informador informador){
        super.save(informador);
    }

    /**
     *
     * @param informador
     */
    @Override
    public void update(Informador informador){
        super.update(informador);
    }

    /**
     *
     * @param informador
     */
    @Override
    public void delete(Informador informador){
        super.delete(informador);
    }

    /**
     *
     * @param id
     * @return
     */
    public Informador find(int id){
        return super.find(Informador.class, id);
    }

    /**
     *
     * @return
     */
    public List<Informador> findAll(){
        return super.findAll(Informador.class);
    }

    public List<Informador> buscaPorNombreLike(String nombre){
       if(nombre.equals(""))
           return null;
        List<Informador> informadores =null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "From Informador  u where u.nombre like concat('%',:nombre,'%')";
            Query query = session.createQuery(hql);
            query.setParameter("nombre", nombre);
            informadores = (List<Informador>)query.list();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return informadores;
    }

    public List<Informador> buscaPorCorreoLike(String correo){
       if(correo.equals(""))
           return null;
        List<Informador> informadores =null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "From Informador  u where u.correo like concat('%',:correo,'%')";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            informadores = (List<Informador>)query.list();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return informadores;
    }

    public Informador buscaPorCorreo(String correo){
       if(correo.equals(""))
           return null;
        Informador informador = null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "From Informador i where i.correo = :correo";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            informador = (Informador)query.uniqueResult();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
        return informador;
    }

    public Informador buscaPorCorreoContrasenia(String correo,String contrasenia){
        Informador u =null;
        Session session = this.sessionFactory.openSession();
        Transaction tx =null;
        try{
            tx = session.beginTransaction();
            String hql = "from Informador where correo = :correo and contrasenia = :contrasenia";
            Query query = session.createQuery(hql);
            query.setParameter("correo", correo);
            query.setParameter("contrasenia",contrasenia);
            u = (Informador)query.uniqueResult();
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
