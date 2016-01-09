package com.aabrasha.helpers;

import com.aabrasha.entity.*;
import com.aabrasha.entity.reports.monthly.salary.PaymentEntry;
import javafx.collections.FXCollections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abrasha on 12/28/15.
 */
public class DataGenerator {

    public static List<Employee> getSomeEmployees(){
        List<Employee> employees = new ArrayList<>(3);

        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setFname("Андрей");
        employee1.setLname("Абрамов");
        employee1.setPatronymic("Владимирович");
        employee1.setPosition("Boss");
        employee1.setCode("4515254");
        employee1.setPassport("MA 9784587");
        employee1.setAddress(new Address("Киев", "Княжий Затон, 14г, кв. 19", "236523"));
        employee1.setHired(LocalDate.now());
        employee1.setFired(LocalDate.now());
        employee1.setHasExpBook(false);
        employee1.setPhone("+380978847054");

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setFname("Татьяна");
        employee2.setLname("Абрамова");
        employee2.setPatronymic("Викторовна");
        employee2.setPosition("Dispatcher");
        employee2.setCode("29387952");
        employee2.setPassport("АМ 235246");
        employee2.setAddress(new Address("Киев", "Урловская, 112в, кв. 62", "1351234"));
        employee2.setHired(LocalDate.now());
        employee2.setFired(LocalDate.now());
        employee2.setHasExpBook(true);
        employee2.setPhone("+380677775897");

        Employee employee3 = new Employee();
        employee3.setId(3);
        employee3.setFname("Александра");
        employee3.setLname("Абрамова");
        employee3.setPatronymic("Михайловна");
        employee3.setCode("2345624");
        employee3.setPassport("ЦА 874547");
        employee3.setAddress(new Address("Киев", "Драгоманова, 61, 41", "03240"));
        employee3.setHired(LocalDate.now());
        employee3.setFired(LocalDate.now());
        employee3.setPosition("Main Accountant");
        employee3.setHasExpBook(true);
        employee3.setPhone("+380503121518");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        return employees;
    }



    public static Company getACompany(){

        List<Employee> employees = getSomeEmployees();


        Company res = new Company();

        employees.forEach(e -> e.setCompany(res));

        res.setName("ТОВ \"Архивист\"");
        res.setAddress(new Address("Киев", "Ревуцкого, 41, оф. 12", "024564"));
        res.setAccount("84645453212315");
        res.setBoss(employees.stream().filter(e -> e.getPosition().equals("Boss")).findFirst().get());
        res.setMainAccountant(employees.stream().filter(e -> e.getPosition().equals("Main Accountant")).findFirst().get());
        res.setEmployees(employees);
        res.setEdrpou("37561293");
        res.setRegNumber("04215441");
        res.setPensionFund(new PensionFund("ПФ Дарниця", "414123"));

        return res;

    }

    public static List<PaymentEntry> getSomePaymentEntries(List<Employee> employees){

        List<PaymentEntry> res = FXCollections.observableArrayList();
        int numOfEntries = employees.size();

        res.add(new PaymentEntry(new EmployeesSalary(employees.get(0), 3400.00), 4240.00, 2500.00));
        res.add(new PaymentEntry(new EmployeesSalary(employees.get(1), 2000.00), 16779.54, 7500.00));
        res.add(new PaymentEntry(new EmployeesSalary(employees.get(2), 0.00), 4440.08, 2000.00));

        return res;

    }


}
