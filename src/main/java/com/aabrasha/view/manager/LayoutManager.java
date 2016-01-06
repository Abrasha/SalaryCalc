package com.aabrasha.view.manager;

import com.aabrasha.view.root.RootPresenter;
import com.airhacks.afterburner.views.FXMLView;

import javax.inject.Inject;
import java.util.HashMap;

/**
 * @author aabrasha
 */
public class LayoutManager {
    //Holds the screens to be displayed

    private static LayoutManager INSTANCE;
    @Inject
    RootPresenter rootPresenter;
    private HashMap<Class<? extends FXMLView>, FXMLView> screens = new HashMap<>();



    private LayoutManager(){
    }



    public static LayoutManager getInstance(){
        if (INSTANCE == null){
            INSTANCE = new LayoutManager();
        }
        return INSTANCE;
    }



    //Add the screen to the collection
    public void addScreen(Class<? extends FXMLView> clazz){
        try{
            screens.put(clazz, clazz.newInstance());
        } catch (InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }



    //Returns the Node with the appropriate name
    public FXMLView getScreen(Class<? extends FXMLView> clazz){
        return screens.get(clazz);
    }



    //Loads the fxml file, add the screen to the screens collection and
    //finally injects the screenPane to the controller.
    public void setScreen(Class<? extends FXMLView> view){

        if (screens.containsKey(view)){
            addScreen(view);
        }

        FXMLView content = screens.get(view);

        rootPresenter.setContent(content.getView());
    }



    public boolean unloadScreen(String name){
        if (screens.remove(name) == null){
            System.out.println("Screen didn't exist");
            return false;
        } else {
            return true;
        }
    }



    /*

        public boolean setScreen(final String name){
            if (screens.get(name) != null){   //screen loaded
                final DoubleProperty opacity = opacityProperty();

                if (!getChildren().isEmpty()){    //if there is more than one screen
                    Timeline fade = new Timeline(
                            new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                            new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent t){
                                    getChildren().remove(0);                    //remove the displayed screen
                                    getChildren().add(0, screens.get(name));     //add the screen
                                    Timeline fadeIn = new Timeline(
                                            new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                            new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                                    fadeIn.play();
                                }
                            }, new KeyValue(opacity, 0.0)));
                    fade.play();

                } else {
                    setOpacity(0.0);
                    getChildren().add(screens.get(name));       //no one else been displayed, then just show
                    Timeline fadeIn = new Timeline(
                            new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                            new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
                    fadeIn.play();
                }
                return true;
            } else {
                System.out.println("screen hasn't been loaded!!! \n");
                return false;
            }


            /*Node screenToRemove;
             if(screens.get(name) != null){   //screen loaded
             if(!getChildren().isEmpty()){    //if there is more than one screen
             getChildren().add(0, screens.get(name));     //add the screen
             screenToRemove = getChildren().get(1);
             getChildren().remove(1);                    //remove the displayed screen
             }else{
             getChildren().add(screens.get(name));       //no one else been displayed, then just show
             }
             return true;
             }else {
             System.out.println("screen hasn't been loaded!!! \n");
             return false;
             }



        }

    */
    //This method will remove the screen with the given name from the collection of screens

}