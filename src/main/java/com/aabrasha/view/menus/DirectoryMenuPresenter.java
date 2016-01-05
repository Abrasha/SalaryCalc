package com.aabrasha.view.menus;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

;
;

/**
 * Created by Abrasha on 04-Jan-16.
 */
public class DirectoryMenuPresenter implements Initializable {

    @FXML
    private Button btnEmployees;

    @FXML
    private Button btnCompany;

    @FXML
    private Button btnDirectory;

    @FXML
    private Button btnAuthority;



    @Override
    public void initialize(URL location, ResourceBundle resources){

    }



    @FXML
    private void onBtnEmployeesClicked() {

    }



    @FXML
    private void onBtnCompanyClicked(){
        System.out.println("comp");
    }



    @FXML
    private void onBtnDirectoryClicked(){
        System.out.println("dir");
    }



    @FXML
    private void onBtnAuthorityClicked(){
        System.out.println("autho");
    }
}
