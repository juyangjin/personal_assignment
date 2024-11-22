package org.example.kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.kiosk.Main.*;

public class Menu {
    List<MenuItem> menuItems;

    public void select(int i){
        switch (i){
            case 1 -> OperType.Burgers.category();
            case 2 -> OperType.Drinks.category();
            case 3 -> OperType.Desserts.category();
        }
    }

    public void addMenuItems(MenuItem menuItem) {
        menuItems.add(menuItem);
        menuItems.add(menuItem);
        menuItems.add(menuItem);
        menuItems.add(menuItem);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }


}
