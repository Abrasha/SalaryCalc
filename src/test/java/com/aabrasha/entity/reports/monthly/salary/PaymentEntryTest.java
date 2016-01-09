package com.aabrasha.entity.reports.monthly.salary;

import com.aabrasha.entity.Employee;
import com.aabrasha.entity.EmployeesSalary;
import com.aabrasha.helpers.DataGenerator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Abrasha on 08-Jan-16.
 */
public class PaymentEntryTest {

    @Test
    public void testCalculate() throws Exception{


        List<Employee> employees = DataGenerator.getACompany().employees();
        EmployeesSalary es1 = new EmployeesSalary(employees.get(0), 3400.00);
        EmployeesSalary es2 = new EmployeesSalary(employees.get(1), 2000.00);
        EmployeesSalary es3 = new EmployeesSalary(employees.get(2), 0);

        PaymentEntry pe1 = new PaymentEntry(es1, 4240.00, 2500.00);
        PaymentEntry pe2 = new PaymentEntry(es2, 16779.54, 7500.00);
        PaymentEntry pe3 = new PaymentEntry(es3, 4440.08, 2000.00);

        assertEquals(7640.00, pe1.getTogetherSalary(), 0.01);
        assertEquals(2500.00, pe1.getFirstPartSalary(), 0.01);
        assertEquals(1375.20, pe1.getIncomeTax(), 0.01);
        assertEquals(114.60, pe1.getMilitaryTax(), 0.01);
        assertEquals(3989.80, pe1.getTogetherTax(), 0.01);
        assertEquals(3650.20, pe1.getTotalToPay(), 0.01);

        assertEquals(18779.54, pe2.getTogetherSalary(), 0.01);
        assertEquals(7500.00, pe2.getFirstPartSalary(), 0.01);
        assertEquals(3380.32, pe2.getIncomeTax(), 0.01);
        assertEquals(281.69, pe2.getMilitaryTax(), 0.01);
        assertEquals(11162.01, pe2.getTogetherTax(), 0.01);
        assertEquals(7617.53, pe2.getTotalToPay(), 0.01);

        assertEquals(4440.08, pe3.getTogetherSalary(), 0.01);
        assertEquals(2000.00, pe3.getFirstPartSalary(), 0.01);
        assertEquals(799.21, pe3.getIncomeTax(), 0.01);
        assertEquals(66.60, pe3.getMilitaryTax(), 0.01);
        assertEquals(2865.81, pe3.getTogetherTax(), 0.01);
        assertEquals(1574.27, pe3.getTotalToPay(), 0.01);

    }
}