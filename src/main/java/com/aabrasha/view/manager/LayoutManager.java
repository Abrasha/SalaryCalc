package com.aabrasha.view.manager;

import com.aabrasha.view.root.RootPresenter;
import com.airhacks.afterburner.views.FXMLView;

import java.util.HashMap;

/**
 * @author aabrasha
 */
public class LayoutManager {
    //Holds the screens to be displayed

    private static LayoutManager INSTANCE;

    private static RootPresenter rootPresenter;

    private HashMap<Class<? extends FXMLView>, FXMLView> screens = new HashMap<>();



    private LayoutManager(){
    }



    public static LayoutManager getInstance(){
        if (INSTANCE == null){
            INSTANCE = new LayoutManager();
        }
        return INSTANCE;
    }



    public void setRootPresenter(RootPresenter rootPresenter){
        this.rootPresenter = rootPresenter;
    }



    public void setContent(Class<? extends FXMLView> clazz){

        if (!screens.containsKey(clazz)){
            addScreen(clazz);
        }

        FXMLView content = screens.get(clazz);
        rootPresenter.setContent(content.getView());
    }



    public void setMenu(Class<? extends FXMLView> clazz){
        if (!screens.containsKey(clazz)){
            addScreen(clazz);
        }

        FXMLView content = screens.get(clazz);
        rootPresenter.setMenu(content.getView());
    }



    public void addScreen(Class<? extends FXMLView> clazz){
        try{
            screens.put(clazz, clazz.newInstance());
        } catch (InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
    }



    public FXMLView getScreen(Class<? extends FXMLView> clazz){
        return screens.get(clazz);
    }



    public boolean unloadScreen(String name){
        if (screens.remove(name) == null){
            System.out.println("Screen didn't exist");
            return false;
        } else {
            return true;
        }
    }
}