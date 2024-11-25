package org.example.kiosk;

public class MenuItem {
    private String name;
    private double price;
    private String explan;

    public MenuItem(String name, double price, String explan){
        this.name = name;
        this.price = price;
        this.explan = explan;
    }
    public String print(){
        return name + price + explan;
    }
}

