package com.aabrasha.view.directory;

import com.aabrasha.entity.Company;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Abrasha on 05-Jan-16.
 */
public class CompanyPresenter implements Initializable {

    @Inject
    Company company;

    @FXML
    private Label lblName;

    @FXML
    private Label lblEdrpou;

    @FXML
    private Label lblAccountNumber;

    @FXML
    private Label lblRegNumber;

    @FXML
    private Label lblPfName;

    @FXML
    private Label lblPfCode;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblBoss;

    @FXML
    private Label lblMainAccountant;



    @Override
    public void initialize(URL location, ResourceBundle resources){
        Platform.runLater(this::fillData);
    }

    private void fillData(){
        lblName.textProperty().bind(company.nameProperty());
        lblAccountNumber.textProperty().bind(company.accountProperty());
        lblAddress.setText(company.getAddress().toString());
        lblBoss.setText(company.getBoss().toString());
        lblMainAccountant.setText(company.getMainAccountant().toString());
        lblEdrpou.textProperty().bind(company.edrpouProperty());
        lblRegNumber.textProperty().bind(company.regNumberProperty());
        lblPfName.setText(company.getPensionFund().getName());
        lblPfCode.setText(company.getPensionFund().getCode());
    }

}
