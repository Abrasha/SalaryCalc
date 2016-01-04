package com.aabrasha.entity.dao;

import com.aabrasha.entity.PensionFund;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Abrasha on 03-Jan-16.
 */
public class PensionFundDAO extends AbstractDAO<PensionFund> {
    private static PensionFundDAO dao = new PensionFundDAO();



    private PensionFundDAO(){
    }



    public static PensionFundDAO getInstance(){
        return dao;
    }



    @Override
    public PensionFund get(Serializable id){
        startTransaction();
        PensionFund res = (PensionFund) session.get(PensionFund.class, id);
        endTransaction();
        return res;
    }



    @Override
    public List<PensionFund> getAll(){
        startTransaction();
        Query query = session.createQuery("from PensionFund");
        List<PensionFund> res = query.list();
        endTransaction();
        return res;
    }
}
