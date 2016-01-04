package com.aabrasha.helpers;

import com.aabrasha.entity.Company;
import com.aabrasha.entity.dao.CompanyDAO;

/**
 * Created by Abrasha on 03-Jan-16.
 */
public class DataFiller {

    public static void main(String[] args){
        HibernateUtil.load();

        Company company = DataGenerator.getACompany();


        CompanyDAO.getInstance().save(company);


        HibernateUtil.close();
    }
}
