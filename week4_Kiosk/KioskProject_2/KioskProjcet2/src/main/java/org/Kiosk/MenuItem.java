package org.Kiosk;

public class MenuItem {
    private String name; //이름 필드를 string으로 선언
    private double price; //가격 필드를 double로 선언
    private String explan;//설명 필드를 string으로 선언
    private int category_num;
    private int menu_num;

    public MenuItem(String name, double price, String explan){//생성자에 이름, 가격, 설명타입의 매개변수를 받을 수 있게 한다.
        this.name = name; // 매개변수는 각각 필드에 저장된다.
        this.price = price;
        this.explan = explan;
    }

    public MenuItem() {

    }

    public String print(){//각기 다른 변수유형을 위한 출력 메서드 선언
        return name + price + explan;//이름, 가격, 설명을 String 타입으로 리턴
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCategory_num() {
        return category_num;
    }

    public void setCategory_num(int category_num) {
        this.category_num = category_num;
    }

    public int getMenu_num() {
        return menu_num;
    }

    public void setMenu_num(int menu_num) {
        this.menu_num = menu_num;
    }
}
