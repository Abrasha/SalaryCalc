package com.aabrasha.entity.dao;

import com.aabrasha.entity.Employee;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Abrasha on 03-Jan-16.
 */
public class EmployeeDAO extends AbstractDAO<Employee> {

    private static EmployeeDAO dao = new EmployeeDAO();



    public static EmployeeDAO getInstance(){
        return dao;
    }



    private EmployeeDAO(){
    }



    @Override
    public Employee get(Serializable id){
        startTransaction();
        Employee res = (Employee) session.get(Employee.class, id);
        endTransaction();
        return res;
    }



    @Override
    public List<Employee> getAll(){
        startTransaction();
        Query query = session.createQuery("from Employee");
        List<Employee> res = query.list();
        endTransaction();
        return res;

    }
}
