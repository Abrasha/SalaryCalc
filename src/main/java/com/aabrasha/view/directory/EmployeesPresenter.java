package com.aabrasha.view.directory;

import com.aabrasha.entity.Address;
import com.aabrasha.entity.Company;
import com.aabrasha.entity.Employee;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.datafx.controller.FXMLController;
import org.datafx.controller.context.ApplicationContext;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Created by abrasha on 12/27/15.
 */
@FXMLController("/com/aabrasha/view/directory/employees.fxml")
public class EmployeesPresenter implements Initializable {

    @FXML
    private TableView<Employee> tvEmployee;

    @FXML
    private ContextMenu rowContext;


    @SuppressWarnings(value = "unchecked")
    @Override
    public void initialize(URL location, ResourceBundle resources){

        Company company = ApplicationContext.getInstance().getRegisteredObject(Company.class);

        tvEmployee.setEditable(true);
        tvEmployee.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        rowContext.setOnAction(e -> {
            System.out.println(e.getSource());
            System.out.println(e.getEventType());
            System.out.println(e.getTarget());
        });

        tvEmployee.getSelectionModel().getSelectedItems().addListener((ListChangeListener) c -> System.out.println(c.getList()));


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
        tvEmployee.setItems(company.employees());
    }


}
