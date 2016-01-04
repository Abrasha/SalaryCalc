package com.aabrasha;

import com.aabrasha.controllers.EmployeesListController;
import com.aabrasha.entity.Company;
import com.aabrasha.helpers.DataGenerator;
import com.aabrasha.helpers.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {



    public static void main(String[] args){
        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception{

        Thread hibernatePreloadThread = new Thread(HibernateUtil::load);
        hibernatePreloadThread.start();


        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/aabrasha/view/directory/employees_list.fxml"));
        Parent root = loader.load();
        EmployeesListController controller = loader.getController();

        hibernatePreloadThread.join();

        Company company = DataGenerator.getACompany();

        controller.setEmployees(company.employees());

        final Scene scene = new Scene(root);

        scene.getStylesheets().add("/com/aabrasha/view/style/style.css");

        stage.setMaximized(true);
        stage.setScene(scene);

        stage.show();
    }



    @Override
    public void stop() throws Exception{
        new Thread(HibernateUtil::close).run();
        super.stop();
    }
}
