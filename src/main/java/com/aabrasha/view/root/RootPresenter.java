package com.aabrasha.view.root;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by abrasha on 12/27/15.
 */
public class RootPresenter implements Initializable {

    @FXML
    StackPane menuPane;

    @FXML
    StackPane contentPane;



    @Override
    public void initialize(URL location, ResourceBundle resources){

    }



    public void setMenu(Node menu){
        menuPane.getChildren().setAll(menu);
    }



    public void setContent(Node content){
        menuPane.getChildren().setAll(content);
    }



    @FXML
    public void onExitMenuClicked(){

    }



    @FXML
    public void onAboutCompanyMenuClicked(){

    }



    @FXML
    public void onEmployeesMenuClicked(){

    }



    @FXML
    public void onAddressesMenuClicked(){

    }



    @FXML
    public void onLeadershipMenuClicked(){

    }


}
