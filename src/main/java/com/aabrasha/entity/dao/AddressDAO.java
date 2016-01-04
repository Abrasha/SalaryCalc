package com.aabrasha.entity.dao;

import com.aabrasha.entity.Address;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Abrasha on 03-Jan-16.
 */
public class AddressDAO extends AbstractDAO<Address> {

    private static AddressDAO dao = new AddressDAO();



    private AddressDAO(){
    }



    public static AddressDAO getInstance(){
        return dao;
    }



    @Override
    public Address get(Serializable id){
        startTransaction();
        Address res = (Address) session.get(Address.class, id);
        endTransaction();
        return res;
    }



    @Override
    public List<Address> getAll(){
        startTransaction();
        Query query = session.createQuery("from Address ");
        List<Address> res = query.list();
        endTransaction();
        return res;
    }
}
