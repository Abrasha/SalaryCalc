package com.aabrasha.entity.reports.monthly.salary;

import com.aabrasha.entity.Company;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.inject.Inject;
import java.time.YearMonth;

/**
 * Created by Abrasha on 07-Jan-16.
 */
public class PaymentReport {

    @Inject
    Company company;

    private ObservableList<PaymentReport> reports = FXCollections.observableArrayList();
    private ObjectProperty<YearMonth> forMonth = new SimpleObjectProperty<>();

    private ObjectProperty<PaymentReport> togetherReport = new SimpleObjectProperty<>();



}
