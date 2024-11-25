package org.example.kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Menu {
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    MenuItem menuItem1;
    MenuItem menuItem2;
    MenuItem menuItem3;
    MenuItem menuItem4;

    public void select(int i) {
        Scanner sc = new Scanner(System.in);
        menuItems.clear();
        switch (i) {
            case 1 -> burgers();
            case 2 -> drinks();
            case 3 -> desserts();
            default -> {
                System.out.println("선택한 카테고리가 없습니다. 다시 선택해주세요.");
                select(sc.nextInt());
            }
        }
    }

    public void burgers(){
        menuItems.clear();
        menuItem1 = new MenuItem("1. ShackBurger   | W ", 6.9, " | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menuItem2 = new MenuItem("2. SmokeShack    | W ", 8.9, " | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        menuItem3 = new MenuItem("3. Cheeseburger  | W ", 6.9, " | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menuItem4 = new MenuItem("4. Hamburger     | W ", 5.4, " | 비프패티를 기반으로 야채가 들어간 기본버거");
        addMenuItems(menuItem1, menuItem2, menuItem3, menuItem4);
    }

    public void desserts(){
        menuItems.clear();
        menuItem1 = new MenuItem("1. Ice Cream     | W ", 4.5, " | 다양한 맛의 아이스크림");
        menuItem2 = new MenuItem("2. Brownie       | W ", 3.9, " | 초콜릿 브라우니");
        menuItem3 = new MenuItem("3. Cheesecake    | W ", 5.0, " | 부드러운 치즈케이크");
        addMenuItems(menuItem1, menuItem2, menuItem3);
    }

    public void drinks(){
        menuItems.clear();
        menuItem1 = new MenuItem("1. Coke          | W ", 2.0, " | 시원한 콜라");
        menuItem2 = new MenuItem("2. Sprite        | W ", 2.0, " | 상쾌한 스프라이트");
        menuItem3 = new MenuItem("3. Orange Juice  | W ", 3.0, " | 신선한 오렌지 주스");
        addMenuItems(menuItem1, menuItem2, menuItem3);
    }

    public void addMenuItems(MenuItem... item) {
        menuItems.addAll(Arrays.asList(item));
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }


}
