package com.aabrasha.view.root;

import com.aabrasha.view.directory.CompanyView;
import com.aabrasha.view.directory.EmployeesView;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.*;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by abrasha on 12/27/15.
 */
public class RootPresenter implements Initializable {
    @Inject
    Stage mainStage;
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
            CompanyView companyView = new CompanyView();
            setContent(companyView.getView());
        });
    }



    @FXML
    public void onEmployeesMenuClicked(){

        Platform.runLater(() -> {
            EmployeesView employeesView = new EmployeesView();
            setContent(employeesView.getView());
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
        print(contentPane.getChildren().get(0));
        /*PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null){
            job.showPageSetupDialog(mainStage);
            job.showPrintDialog(mainStage);
            boolean success = job.printPage(contentPane);
            if (success){
                job.endJob();
            }
            System.out.println(success);
        }
*/
    }



    public void print(final Node nodeToPrint){

        final StackPane node = new StackPane(nodeToPrint);

        Printer printer = Printer.getDefaultPrinter();
        PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);
        double scaleX = pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
        double scaleY = pageLayout.getPrintableHeight() / node.getBoundsInParent().getHeight();
        System.out.println(node.getBoundsInParent().getWidth() * scaleX);
        System.out.println(node.getBoundsInParent().getHeight() * scaleY);
        node.getTransforms().add(new Scale(scaleX, scaleY));

        PrinterJob job = PrinterJob.createPrinterJob();
        boolean userAccepted = job.showPrintDialog(mainStage);
        if (job != null && userAccepted){
            boolean success = job.printPage(node);
            if (success){
                System.out.println("Page printed");
                job.endJob();
                job.jobStatusProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue == PrinterJob.JobStatus.DONE)
                        System.out.println("Done printing page");
                    if (newValue == PrinterJob.JobStatus.PRINTING)
                        System.out.println("Printing page right now!");
                    if (newValue == PrinterJob.JobStatus.CANCELED)
                        System.out.println("Printing page was cancelled!");
                    if (newValue == PrinterJob.JobStatus.ERROR)
                        System.out.println("Some error occurred while printing page!");
                    if (newValue == PrinterJob.JobStatus.NOT_STARTED)
                        System.out.println("Printing page hasn't started yet!");
                });
            }
        }
    }


}
