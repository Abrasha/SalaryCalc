package com.aabrasha.helpers;

import javafx.print.*;
import javafx.scene.Node;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import javax.inject.Inject;

/**
 * Created by Abrasha on 07-Jan-16.
 */
public class PrinterAPI {


    private static PrinterAPI INSTANCE;

    @Inject
    Stage mainStage;



    private PrinterAPI(){
    }



    public static PrinterAPI getInstance(){
        if (INSTANCE == null)
            INSTANCE = new PrinterAPI();
        return INSTANCE;
    }



    public synchronized void print(Node nodeToPrint){
        double prevScaleX = nodeToPrint.getScaleX();
        double prevScaleY = nodeToPrint.getScaleY();

        Printer printer = Printer.getDefaultPrinter();
        PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);

        double scaleX = pageLayout.getPrintableWidth() / nodeToPrint.getBoundsInParent().getWidth();
        double scaleY = pageLayout.getPrintableWidth() / nodeToPrint.getBoundsInParent().getHeight();

        double scale = Math.min(scaleX, scaleY);

        nodeToPrint.getTransforms().add(new Scale(scale, scale));

        PrinterJob job = PrinterJob.createPrinterJob();

        boolean userAccepted = job.showPrintDialog(mainStage);
        if (userAccepted){
            boolean success = job.printPage(pageLayout, nodeToPrint);
            nodeToPrint.getTransforms().clear();
            nodeToPrint.getTransforms().add((new Scale(prevScaleX, prevScaleY)));
            if (success){
                job.endJob();
                System.out.println("Page printed");
            }
        }
    }

}
