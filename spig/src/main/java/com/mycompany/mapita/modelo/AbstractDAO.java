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
        Session session = this.sessionFactory.getCurrentSession();
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
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "From"+clazz;
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
