package com.aabrasha.controllers;

import com.aabrasha.entity.Address;
import com.aabrasha.entity.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Created by abrasha on 12/27/15.
 */
public class EmployeesListController implements Initializable {

    @FXML
    private TableView<Employee> tvEmployee;

    @FXML
    private ContextMenu rowContext;

    private ObservableList<Employee> observableEmployees;



    @Override
    public void initialize(URL location, ResourceBundle resources){

        tvEmployee.setEditable(true);


        rowContext.setOnAction(e -> {
            System.out.println(e.getSource());
            System.out.println(e.getEventType());
            System.out.println(e.getTarget());
        });

        tvEmployee.getSelectionModel().getSelectedItems().addListener((ListChangeListener) c -> System.out.println(c.getList()));


        observableEmployees = FXCollections.observableArrayList();

        TableColumn<Employee, Number> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(e -> e.getValue().idProperty());

        TableColumn<Employee, String> firstNameCol = new TableColumn<>("Имя");
        firstNameCol.setCellValueFactory(e -> e.getValue().fnameProperty());

        TableColumn<Employee, String> lastNameCol = new TableColumn<>("Фамилия");
        lastNameCol.setCellValueFactory(e -> e.getValue().lnameProperty());

        TableColumn<Employee, String> patronymicCol = new TableColumn<>("Отчество");
        patronymicCol.setCellValueFactory(e -> e.getValue().patronymicProperty());

        TableColumn<Employee, String> passportCol = new TableColumn<>("Паспорт");
        passportCol.setCellValueFactory(e -> e.getValue().passportProperty());

        TableColumn<Employee, String> positionCol = new TableColumn<>("Должность");
        positionCol.setCellValueFactory(e -> e.getValue().positionProperty());

        TableColumn<Employee, String> codeCol = new TableColumn<>("Код");
        codeCol.setCellValueFactory(e -> e.getValue().codeProperty());

        TableColumn<Employee, LocalDate> hiredCol = new TableColumn<>("Hired");
        hiredCol.setCellValueFactory(e -> e.getValue().hiredProperty());

        TableColumn<Employee, LocalDate> firedCol = new TableColumn<>("Fired");
        firedCol.setCellValueFactory(e -> e.getValue().firedProperty());

        TableColumn<Employee, Boolean> hasExpBookCol = new TableColumn<>("Наличие трудовой");
        hasExpBookCol.setCellValueFactory(e -> e.getValue().hasExpBookProperty());

        TableColumn<Employee, Address> addressCol = new TableColumn<>("Address");
        addressCol.setCellValueFactory(e -> e.getValue().addressProperty());

        TableColumn<Employee, String> phoneCol = new TableColumn<>("Phone");
        phoneCol.setCellValueFactory(e -> e.getValue().phoneProperty());


        tvEmployee.getColumns().addAll(codeCol, lastNameCol, firstNameCol, patronymicCol, positionCol, passportCol, addressCol, hiredCol, firedCol, hasExpBookCol, phoneCol);
        tvEmployee.setItems(observableEmployees);
    }



    public void setEmployees(ObservableList<Employee> employees){
        System.out.println(employees);
        this.observableEmployees = employees;
        tvEmployee.setItems(observableEmployees);
    }


}
