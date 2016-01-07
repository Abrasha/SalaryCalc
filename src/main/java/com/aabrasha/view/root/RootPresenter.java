package com.aabrasha.view.root;

import com.aabrasha.helpers.PrinterAPI;
import com.aabrasha.view.directory.CompanyView;
import com.aabrasha.view.directory.EmployeesView;
import com.aabrasha.view.manager.LayoutManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by abrasha on 12/27/15.
 */
public class RootPresenter implements Initializable {


    @FXML
    SplitPane splitPane;

    @FXML
    StackPane menuPane;

    @FXML
    StackPane contentPane;



    @Override
    public void initialize(URL location, ResourceBundle resources){
        SplitPane.setResizableWithParent(menuPane, Boolean.FALSE);
    }



    public void setMenu(Node menu){
        menuPane.getChildren().setAll(menu);
    }



    public void setContent(Node content){
        contentPane.getChildren().setAll(content);
    }



    @FXML
    public void onExitMenuClicked(){

    }



    @FXML
    public void onAboutCompanyMenuClicked(){

        Platform.runLater(() -> {
            LayoutManager.getInstance().setContent(CompanyView.class);
        });
    }



    @FXML
    public void onEmployeesMenuClicked(){
        Platform.runLater(() -> {
            LayoutManager.getInstance().setContent(EmployeesView.class);
        });
    }



    @FXML
    public void onAddressesMenuClicked(){
    }



    @FXML
    public void onLeadershipMenuClicked(){

    }



    @FXML
    public void onPrintContentClicked(){
        PrinterAPI.getInstance().print(contentPane.getChildren().get(0));
    }


}
