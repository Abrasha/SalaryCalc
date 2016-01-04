package com.aabrasha.entity.dao;

import com.aabrasha.helpers.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

/**
 * Created by Abrasha on 03-Jan-16.
 */
public abstract class AbstractDAO<T extends Serializable> implements DAO<T> {

    protected static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    protected static Transaction transaction;
    protected static Session session;



    protected void startTransaction(){
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }



    protected void endTransaction(){
        session.flush();
        transaction.commit();
        session.close();
    }



    @Override
    public Serializable save(T obj){
        startTransaction();
        Serializable res = session.save(obj);
        endTransaction();
        return res;
    }



    @Override
    public void delete(T obj){
        startTransaction();
        session.delete(obj);
        endTransaction();
    }



    @Override
    public void update(T obj){
        startTransaction();
        session.saveOrUpdate(obj);
        endTransaction();
    }
}
