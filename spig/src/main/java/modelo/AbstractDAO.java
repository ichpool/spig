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
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author n-droid
 */
public abstract class AbstractDAO<T> {

    /**
     *
     */
    protected SessionFactory sessionFactory;

    /**
     *
     */
    public AbstractDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    /**
     *
     * @param obj
     */
    protected void save(T obj){
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
            session.close();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
            session.close();
            throw e;
        }

    }

    /**
     *
     * @param obj
     */
    protected void update(T obj){
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    /**
     *
     * @param obj
     */
    protected void delete(T obj){
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
    }
    /**
     *
     * @param clazz
     * @param id
     * @return
     */
    protected T find(Class clazz, int id){
        T obj =null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            obj =(T)session.get(clazz, id);
            tx.commit();

        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
        }finally{
            session.close();

        }
        return obj;

    }
    /**
     *
     * @param clazz
     * @return
     */
    protected List<T> findAll(Class clazz){
        List<T> obj =null;
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "from "+clazz.getName();
            System.out.println(hql);
            Query query = session.createQuery(hql);
            obj = (List<T>)query.list();
            tx.commit();

        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
        }finally{
            session.close();

        }
        return obj;
    }


}
