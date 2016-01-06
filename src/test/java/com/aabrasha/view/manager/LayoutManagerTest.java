package com.aabrasha.view.manager;

import com.aabrasha.view.directory.CompanyView;
import com.aabrasha.view.directory.EmployeesView;
import com.aabrasha.view.menus.DirectoryMenuView;
import com.aabrasha.view.root.RootView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.AfterBegin;

/**
 * Created by Abrasha on 06-Jan-16.
 */
public class LayoutManagerTest {


    @Test
    @Before
    public void testGet(){
        LayoutManager layoutManager = LayoutManager.getInstance();
        layoutManager.addScreen(RootView.class);
        layoutManager.addScreen(DirectoryMenuView.class);
        layoutManager.addScreen(CompanyView.class);
        layoutManager.addScreen(EmployeesView.class);

    }



    @Test
    @AfterBegin
    public void testPut(){
        LayoutManager layoutManager = LayoutManager.getInstance();


        Assert.assertNotNull(layoutManager.getScreen(RootView.class));
        Assert.assertNotNull(layoutManager.getScreen(DirectoryMenuView.class));
        Assert.assertNotNull(layoutManager.getScreen(CompanyView.class));
        Assert.assertNotNull(layoutManager.getScreen(EmployeesView.class));
    }

}
