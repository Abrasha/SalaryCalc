package com.aabrasha.view.menus;

import com.aabrasha.view.directory.CompanyView;
import com.aabrasha.view.directory.EmployeesView;
import com.aabrasha.view.manager.LayoutManager;
import javafx.application.Platform;
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
    private void onBtnEmployeesClicked(){
        Platform.runLater(() -> {
            LayoutManager.getInstance().setContent(EmployeesView.class);
        });
    }



    @FXML
    private void onBtnCompanyClicked(){
        Platform.runLater(() -> {
            LayoutManager.getInstance().setContent(CompanyView.class);
        });
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
