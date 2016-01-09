package com.aabrasha.entity.reports.monthly.salary;

import com.aabrasha.entity.Company;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.ejb.Init;
import javax.inject.Inject;
import java.time.YearMonth;

/**
 * Created by Abrasha on 07-Jan-16.
 */
public class PaymentReport {

    @Inject
    Company company;

    private ObservableList<PaymentEntry> reports = FXCollections.observableArrayList();
    private ObjectProperty<YearMonth> forMonth = new SimpleObjectProperty<>();
    private ObjectProperty<PaymentReport> togetherReport = new SimpleObjectProperty<>();


    @Init
    public void init(){
    }

    public ObservableList<PaymentEntry> getReports(){
        return reports;
    }



    public void setReports(ObservableList<PaymentEntry> reports){
        this.reports = reports;
    }



    public YearMonth getForMonth(){
        return forMonth.get();
    }



    public ObjectProperty<YearMonth> forMonthProperty(){
        return forMonth;
    }



    public void setForMonth(YearMonth forMonth){
        this.forMonth.set(forMonth);
    }



    public PaymentReport getTogetherReport(){
        return togetherReport.get();
    }



    public ObjectProperty<PaymentReport> togetherReportProperty(){
        return togetherReport;
    }



    public void setTogetherReport(PaymentReport togetherReport){
        this.togetherReport.set(togetherReport);
    }
}
