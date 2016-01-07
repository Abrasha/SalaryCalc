package com.aabrasha.view.directory;

import com.aabrasha.entity.Address;
import com.aabrasha.entity.Company;
import com.aabrasha.entity.Employee;
import com.aabrasha.helpers.PrinterAPI;
import com.aabrasha.view.custom.LocalDateTableCell;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import javax.inject.Inject;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Created by abrasha on 12/27/15.
 */
public class EmployeesPresenter implements Initializable {

    @Inject
    Company company;
    @FXML
    TableColumn<Employee, String> fnameCol;
    @FXML
    TableColumn<Employee, String> lnameCol;
    @FXML
    TableColumn<Employee, String> patronymicCol;
    @FXML
    TableColumn<Employee, String> passportCol;
    @FXML
    TableColumn<Employee, String> positionCol;
    @FXML
    TableColumn<Employee, String> codeCol;
    @FXML
    TableColumn<Employee, String> phoneCol;
    @FXML
    TableColumn<Employee, LocalDate> hiredCol;
    @FXML
    TableColumn<Employee, LocalDate> firedCol;
    @FXML
    TableColumn<Employee, Boolean> hasExpBookCol;
    @FXML
    TableColumn<Employee, Address> addressCol;
    @FXML
    private TableView<Employee> tvEmployee;
    @FXML
    private ContextMenu rowContext;



    @SuppressWarnings(value = "unchecked")
    @Override
    public void initialize(URL location, ResourceBundle resources){


        tvEmployee.setEditable(true);


        TableColumn<Employee, Number> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(e -> e.getValue().idProperty());
        idCol.setCellFactory(TextFieldTableCell.<Employee, Number>forTableColumn(new NumberStringConverter()));
        idCol.setOnEditCommit(e -> {
            if (e.getNewValue() != null)
                e.getRowValue().setId(e.getNewValue().intValue());
        });

        fnameCol.setCellValueFactory(e -> e.getValue().fnameProperty());
        fnameCol.setCellFactory(TextFieldTableCell.<Employee>forTableColumn());
        fnameCol.setOnEditCommit(e -> {
            if (e.getNewValue() != null)
                e.getRowValue().setFname(e.getNewValue());
        });

        lnameCol.setCellValueFactory(e -> e.getValue().lnameProperty());
        lnameCol.setCellFactory(TextFieldTableCell.<Employee>forTableColumn());
        lnameCol.setOnEditCommit(e -> {
            if (e.getNewValue() != null)
                e.getRowValue().setLname(e.getNewValue());
        });

        patronymicCol.setCellValueFactory(e -> e.getValue().patronymicProperty());
        patronymicCol.setCellFactory(TextFieldTableCell.<Employee>forTableColumn());
        patronymicCol.setOnEditCommit(e -> {
            if (e.getNewValue() != null)
                e.getRowValue().setPatronymic(e.getNewValue());
        });

        passportCol.setCellValueFactory(e -> e.getValue().passportProperty());
        passportCol.setCellFactory(TextFieldTableCell.<Employee>forTableColumn());
        passportCol.setOnEditCommit(e -> {
            if (e.getNewValue() != null)
                e.getRowValue().setPassport(e.getNewValue());
        });

        positionCol.setCellValueFactory(e -> e.getValue().positionProperty());
        positionCol.setCellFactory(TextFieldTableCell.<Employee>forTableColumn());
        positionCol.setOnEditCommit(e -> {
            if (e.getNewValue() != null)
                e.getRowValue().setPosition(e.getNewValue());
        });

        codeCol.setCellValueFactory(e -> e.getValue().codeProperty());
        codeCol.setCellFactory(TextFieldTableCell.<Employee>forTableColumn());
        codeCol.setOnEditCommit(e -> {
            if (e.getNewValue() != null)
                e.getRowValue().setCode(e.getNewValue());
        });

        hiredCol.setCellValueFactory(e -> e.getValue().hiredProperty());
        hiredCol.setCellFactory(p -> new LocalDateTableCell<>());

        firedCol.setCellValueFactory(e -> e.getValue().firedProperty());
        firedCol.setCellFactory(p -> new LocalDateTableCell<>());

        hasExpBookCol.setCellValueFactory(e -> e.getValue().hasExpBookProperty());
        hasExpBookCol.setCellFactory(e -> {
            CheckBoxTableCell cell = new CheckBoxTableCell();
            cell.setSelectedStateCallback(new Callback<Integer, ObservableValue<Boolean>>() {
                @Override
                public ObservableValue<Boolean> call(Integer index){
                    return tvEmployee.getItems().get(index.intValue()).hasExpBookProperty();
                }
            });
            return cell;
        });

        addressCol.setCellValueFactory(e -> e.getValue().addressProperty());
        addressCol.setCellFactory(TextFieldTableCell.<Employee, Address>forTableColumn(new StringConverter<Address>() {
            @Override
            public String toString(Address object){
                if (object != null)
                    return object.toString();
                return "";
            }



            @Override
            public Address fromString(String string){
                return Address.valueOf(string);
            }
        }));
        addressCol.setOnEditCommit(e -> {
            if (e.getNewValue() != null)
                e.getRowValue().setAddress(e.getNewValue());
        });

        phoneCol.setCellValueFactory(e -> e.getValue().phoneProperty());
        phoneCol.setCellFactory(TextFieldTableCell.<Employee>forTableColumn());
        phoneCol.setOnEditCommit(e -> {
            if (e.getNewValue() != null)
                e.getRowValue().setPhone(e.getNewValue());
        });


        tvEmployee.getColumns().add(idCol);
        tvEmployee.setItems(company.employees());
    }



    @FXML
    private void onBtnPrintDataClicked(){
        PrinterAPI.getInstance().print(tvEmployee);
    }



    @FXML
    private void onBtnAddEmployeeClicked(){
        company.addEmployee(new Employee());
    }


}
