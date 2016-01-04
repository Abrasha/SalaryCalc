package com.aabrasha.helpers;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory SESSION_FACTORY;

    public static void load(){
        if (SESSION_FACTORY == null){
            Configuration configuration = new Configuration();
            configuration.configure(HibernateUtil.class.getResource("/com/aabrasha/res/hibernate/hibernate.cfg.xml"));
            SESSION_FACTORY = configuration.buildSessionFactory();
        }
    }

    public static void close(){
        if (SESSION_FACTORY != null)
            SESSION_FACTORY.close();
    }

    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }

}