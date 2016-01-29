package com.aabrasha.view.reports.monthly;

import com.aabrasha.entity.Company;
import com.aabrasha.entity.reports.monthly.salary.PaymentEntry;
import com.aabrasha.entity.reports.monthly.salary.PaymentReport;
import com.aabrasha.helpers.DataGenerator;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.NumberStringConverter;

import javax.inject.Inject;
import java.net.URL;
import java.time.Month;
import java.time.Year;
import java.util.ResourceBundle;

/**
 * Created by Abrasha on 09-Jan-16.
 */
public class SalaryPresenter implements Initializable {

    @Inject
    Company company;

    private PaymentReport paymentReport;

    @FXML
    private TableView<PaymentEntry> tvReport;

    @FXML
    private ComboBox<Month> cbYear;
    @FXML
    private ComboBox<Year> cbMonth;

    @FXML
    private Label lblCompanyName;
    @FXML
    private Label lblCompanyCode;
    @FXML
    private Label lblTableTitle;
    @FXML
    private Label lblPayInfo;
    @FXML
    private Label lblDirector;
    @FXML
    private Label lblMainAccountant;
    @FXML
    private TableColumn<PaymentEntry, Number> orderCol;
    @FXML
    private TableColumn<PaymentEntry, String> initialsCol;
    @FXML
    private TableColumn<PaymentEntry, String> codeCol;
    @FXML
    private TableColumn<PaymentEntry, Number> rateSalaryCol;
    @FXML
    private TableColumn<PaymentEntry, Number> pieceSalaryCol;
    @FXML
    private TableColumn<PaymentEntry, Number> otherSalaryCol;
    @FXML
    private TableColumn<PaymentEntry, Number> totalSalaryCol;
    @FXML
    private TableColumn<PaymentEntry, Number> firstSalaryCol;
    @FXML
    private TableColumn<PaymentEntry, Number> incomeTaxCol;
    @FXML
    private TableColumn<PaymentEntry, Number> militaryTaxCol;
    @FXML
    private TableColumn<PaymentEntry, Number> totalTaxCol;
    @FXML
    private TableColumn<PaymentEntry, Number> totalToPayCol;



    @Override
    public void initialize(URL location, ResourceBundle resources){

        ObservableList<Month> months = FXCollections.observableArrayList(Month.values());
        ObservableList<Year> years = FXCollections.observableArrayList();
        //for (int i = Year.now().getValue() - 10; i < )

        tvReport.setEditable(true);

        paymentReport = new PaymentReport();


        ObservableList<PaymentEntry> items = FXCollections.observableArrayList();
        items.addAll(DataGenerator.getSomePaymentEntries(company.employees()));
        paymentReport.setReports(items);

        lblCompanyName.setText(company.getName());
        lblCompanyCode.setText(company.getEdrpou());

        lblDirector.setText(company.getBoss().getInitials(true));
        lblMainAccountant.setText(company.getMainAccountant().getInitials(true));

        initialsCol.setEditable(false);
        initialsCol.setCellValueFactory(e -> new SimpleStringProperty(e.getValue().getEmployeesSalary().getForEmployee().getInitials(false)));

        codeCol.setCellValueFactory(e -> e.getValue().employeesSalaryProperty().get().forEmployeeProperty().get().codeProperty());

        rateSalaryCol.setCellValueFactory(e -> e.getValue().employeesSalaryProperty().get().rateSalaryProperty());
        rateSalaryCol.setEditable(true);
        rateSalaryCol.setCellFactory(TextFieldTableCell.<PaymentEntry, Number>forTableColumn(new NumberStringConverter()));

        pieceSalaryCol.setCellValueFactory(e -> e.getValue().pieceSalaryProperty());
        pieceSalaryCol.setEditable(true);
        pieceSalaryCol.setCellFactory(TextFieldTableCell.<PaymentEntry, Number>forTableColumn(new NumberStringConverter()));


        firstSalaryCol.setCellValueFactory(e -> e.getValue().firstPartSalaryProperty());
        pieceSalaryCol.setEditable(true);
        pieceSalaryCol.setCellFactory(TextFieldTableCell.<PaymentEntry, Number>forTableColumn(new NumberStringConverter()));


        otherSalaryCol.setCellValueFactory(e -> e.getValue().otherSalaryProperty());
        totalSalaryCol.setCellValueFactory(e -> e.getValue().togetherSalaryProperty());
        incomeTaxCol.setCellValueFactory(e -> e.getValue().incomeTaxProperty());
        militaryTaxCol.setCellValueFactory(e -> e.getValue().militaryTaxProperty());
        totalTaxCol.setCellValueFactory(e -> e.getValue().togetherTaxProperty());
        totalToPayCol.setCellValueFactory(e -> e.getValue().totalToPayProperty());


        tvReport.setItems(items);
    }
}
