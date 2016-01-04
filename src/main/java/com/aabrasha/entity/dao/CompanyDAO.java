package com.aabrasha.entity.dao;

import com.aabrasha.entity.Company;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Abrasha on 03-Jan-16.
 */
public class CompanyDAO extends AbstractDAO<Company> {

    private static CompanyDAO dao = new CompanyDAO();



    private CompanyDAO(){
    }



    public static CompanyDAO getInstance(){
        return dao;
    }



    @Override
    public Company get(Serializable id){
        startTransaction();
        Company res = (Company) session.get(Company.class, id);
        endTransaction();
        return res;
    }



    @Override
    public List<Company> getAll(){
        startTransaction();
        Query query = session.createQuery("from Company");
        List<Company> res = query.list();
        endTransaction();
        return res;
    }
}
