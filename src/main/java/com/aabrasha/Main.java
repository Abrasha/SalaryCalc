package com.aabrasha;

import com.aabrasha.helpers.DataGenerator;
import com.aabrasha.view.directory.EmployeesView;
import com.aabrasha.view.manager.LayoutManager;
import com.aabrasha.view.menus.DirectoryMenuView;
import com.aabrasha.view.root.RootPresenter;
import com.aabrasha.view.root.RootView;
import com.airhacks.afterburner.injection.Injector;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {



    public static void main(String[] args){
        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception{


        Map<Object, Object> props = new HashMap<>(5);
        props.put("company", DataGenerator.getACompany());
        props.put("mainStage", stage);
        props.put("layoutManager", LayoutManager.getInstance());
        Injector.setConfigurationSource(props::get);

        RootView rootView = new RootView();
        RootPresenter rootPresenter = (RootPresenter) rootView.getPresenter();
        LayoutManager.getInstance().setRootPresenter(rootPresenter);

        LayoutManager.getInstance().setContent(EmployeesView.class);
        LayoutManager.getInstance().setMenu(DirectoryMenuView.class);

        Scene scene = new Scene(rootView.getView());
        scene.getStylesheets().add("/com/aabrasha/view/style/style.css");

        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }



    @Override
    public void stop() throws Exception{
        //new Thread(HibernateUtil::close).run();
        super.stop();
    }
}
