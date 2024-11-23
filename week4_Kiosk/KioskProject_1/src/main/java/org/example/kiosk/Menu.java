package org.example.kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.example.kiosk.Main.OperType.*;

public class Menu{
    List<MenuItem> menuItems = new ArrayList<>();
    MenuItem menuItem1;
    MenuItem menuItem2;
    MenuItem menuItem3;
    MenuItem menuItem4;
    public void select(int i){
        switch (i){
            case 1 -> Burgers.category();
            case 2 -> Drinks.category();
            case 3 -> Desserts.category();
            default -> System.out.println();
        }
    }

    public void addMenuItems(MenuItem... item) {
        MenuItem menuItem = new MenuItem();
        menuItems.addAll(Arrays.asList(item));
        for(int i=0;i<item.length;i++){
            System.out.println(getMenuItems().get(i).print());
        }
    }


    public void burgers(){
        menuItem1 = new MenuItem("1. ShackBurger   | W ", 6.9, " | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menuItem2 = new MenuItem("2. SmokeShack    | W ", 8.9, " | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        menuItem3 = new MenuItem("3. Cheeseburger  | W ", 6.9, " | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menuItem4 = new MenuItem("4. Hamburger     | W ", 5.4, " | 비프패티를 기반으로 야채가 들어간 기본버거");

        addMenuItems(menuItem1,menuItem2,menuItem3,menuItem4);
    }

    public void desserts(){
        menuItem1 = new MenuItem("1. Ice Cream     | W ", 4.5, " | 다양한 맛의 아이스크림");
        menuItem2 = new MenuItem("2. Brownie       | W ", 3.9, " | 초콜릿 브라우니");
        menuItem3 = new MenuItem("3. Cheesecake    | W ", 5.0, " | 부드러운 치즈케이크");
        addMenuItems(menuItem1,menuItem2,menuItem3);
    }

    public void drinks(){
        menuItem1 = new MenuItem("1. Coke          | W ", 2.0, " | 시원한 콜라");
        menuItem2 = new MenuItem("2. Sprite        | W ", 2.0, " | 상쾌한 스프라이트");
        menuItem3 = new MenuItem("3. Orange Juice  | W ", 3.0, " | 신선한 오렌지 주스");
        addMenuItems(menuItem1,menuItem2,menuItem3);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }


}
