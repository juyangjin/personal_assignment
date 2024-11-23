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

    public MenuItem() {

    }

    public String print(){
        return name + price + explan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExplan() {
        return explan;
    }

    public void setExplan(String explan) {
        this.explan = explan;
    }
}
