package com.aabrasha.view.directory;

import com.aabrasha.entity.Company;
import com.aabrasha.entity.Employee;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Duration;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by abrasha on 12/27/15.
 */
public class EmployeesPresenter implements Initializable {

    @Inject
    Company company;
    @FXML
    private SplitPane container;
    @FXML
    private ListView<Employee> lvEmployees;
    @FXML
    private Button btnRemoveEmployee;
    @FXML
    private Button btnAddEmployee;
    @FXML
    private Button btnUpdateEmployee;
    @FXML
    private Button btnSaveEmployee;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField tfFname;
    @FXML
    private TextField tfLname;
    @FXML
    private TextField tfPatronymic;
    @FXML
    private TextField tfCode;
    @FXML
    private TextField tfAddress;
    @FXML
    private TextField tfPassport;
    @FXML
    private TextField tfPosition;
    @FXML
    private TextField tfPhone;
    @FXML
    private DatePicker dpHired;
    @FXML
    private DatePicker dpFired;
    @FXML
    private CheckBox cbHasExpBook;
    private boolean detailesHidden = true;
    private boolean addingEmployee = false;

    private Timeline hideDetailsAnimation;
    private Timeline showDetailsAnimation;

    private Employee addedEmployee = null;



    @Override
    public void initialize(URL location, ResourceBundle resources){


        hideDetailsAnimation = createHideAnimation();
        showDetailsAnimation = createShowAnimation();

        btnSaveEmployee.setDisable(true);

        lvEmployees.setCellFactory(param -> new EmployeeCell());

        updateEmployeesList();

        lvEmployees.getSelectionModel().selectedItemProperty().addListener(e -> {
            Employee selected = getSelectedEmployee();
            if (selected == null){
                if (!detailesHidden){
                    detailesHidden = true;
                    btnUpdateEmployee.setDisable(true);
                    btnRemoveEmployee.setDisable(true);
                    hideDetailsAnimation.play();
                }
            } else {
                Platform.runLater(() -> this.updateDetailsPanel(getSelectedEmployee()));
                if (detailesHidden){
                    detailesHidden = false;
                    btnUpdateEmployee.setDisable(true);
                    btnRemoveEmployee.setDisable(false);
                    showDetailsAnimation.play();
                }
            }
        });

        clearSelections();
    }



    private Timeline createShowAnimation(){
        final KeyValue kv = new KeyValue(container.getDividers().get(0).positionProperty(), 0.5);
        final KeyFrame kf = new KeyFrame(Duration.seconds(0.5), kv);
        return new Timeline(kf);
    }



    private Timeline createHideAnimation(){
        final KeyValue kv = new KeyValue(container.getDividers().get(0).positionProperty(), 1.0);
        final KeyFrame kf = new KeyFrame(Duration.seconds(0.5), kv);
        return new Timeline(kf);
    }



    private Employee getSelectedEmployee(){
        return lvEmployees.getSelectionModel().getSelectedItem();
    }



    private void updateEmployeesList(){
        lvEmployees.getItems().clear();
        lvEmployees.getItems().addAll(company.employees());
    }



    private void updateDetailsPanel(Employee selected){
        tfFname.setText(selected.getFname());
        tfLname.setText(selected.getLname());
        tfPatronymic.setText(selected.getPatronymic());
        tfCode.setText(selected.getCode());
        tfPassport.setText(selected.getPassport());
        tfPosition.setText(selected.getPosition());
        tfAddress.setText(selected.getPosition());
        dpHired.setValue(selected.getHired());
        dpFired.setValue(selected.getFired());
        cbHasExpBook.setSelected(selected.getHasExpBook());
        tfPhone.setText(selected.getPhone());
        btnUpdateEmployee.setDisable(false);
    }



    private void saveEmployeeDetails(){
        addedEmployee.setFname(tfFname.getText());
        addedEmployee.setLname(tfLname.getText());
        addedEmployee.setPatronymic(tfPatronymic.getText());
        addedEmployee.setAddress(tfAddress.getText());
        addedEmployee.setCode(tfCode.getText());
        addedEmployee.setPassport(tfPassport.getText());
        addedEmployee.setPosition(tfPosition.getText());
        addedEmployee.setHired(dpHired.getValue());
        addedEmployee.setFired(dpFired.getValue());
        addedEmployee.setHasExpBook(cbHasExpBook.isSelected());
        addedEmployee.setPhone(tfPhone.getText());
        company.employees().add(addedEmployee);
        addedEmployee = null;
    }



    private void updateEmployee(){
        Employee selected = getSelectedEmployee();
        selected.setFname(tfFname.getText());
        selected.setLname(tfLname.getText());
        selected.setPatronymic(tfPatronymic.getText());
        selected.setAddress(tfAddress.getText());
        selected.setCode(tfCode.getText());
        selected.setPassport(tfPassport.getText());
        selected.setPosition(tfPosition.getText());
        selected.setHired(dpHired.getValue());
        selected.setFired(dpFired.getValue());
        selected.setHasExpBook(cbHasExpBook.isSelected());
        selected.setPhone(tfPhone.getText());
    }



    private void clearSelections(){
        lvEmployees.getSelectionModel().clearSelection();
    }



    private void removeEmployee(){
        Employee selected = getSelectedEmployee();
        company.employees().remove(selected);
    }



    @FXML
    private void btnSaveClicked(){
        saveEmployeeDetails();
        updateEmployeesList();
        btnRemoveEmployee.setDisable(false);
        btnAddEmployee.setDisable(false);
        btnSaveEmployee.setDisable(true);
        Platform.runLater(hideDetailsAnimation::play);
        detailesHidden = true;
    }



    @FXML
    private void btnRemoveClicked(){
        removeEmployee();
        updateEmployeesList();
        Platform.runLater(hideDetailsAnimation::play);
        detailesHidden = true;
    }



    @FXML
    private void btnUpdateClicked(){
        updateEmployee();
        btnAddEmployee.setDisable(false);
        updateEmployeesList();
        Platform.runLater(hideDetailsAnimation::play);
        detailesHidden = true;
    }



    @FXML
    private void btnCancelClicked(){
        addedEmployee = null;
        btnAddEmployee.setDisable(false);
        btnSaveEmployee.setDisable(true);
        Platform.runLater(hideDetailsAnimation::play);
        detailesHidden = true;
        clearSelections();
    }



    @FXML
    private void btnAddClicked(){
        btnAddEmployee.setDisable(true);
        btnSaveEmployee.setDisable(false);
        btnRemoveEmployee.setDisable(true);
        addedEmployee = new Employee();
        updateDetailsPanel(addedEmployee);
    }



    class EmployeeCell extends ListCell<Employee> {
        @Override
        protected void updateItem(Employee item, boolean empty){
            super.updateItem(item, empty);
            if (empty || item == null){
                setText(null);
            } else {
                setText((getIndex() + 1) + ". " + item.getCode() + " " + String.join(" ", item.getLname(), item.getFname(), item.getPatronymic()));
            }
        }
    }

}
