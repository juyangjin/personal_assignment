package org.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner sc = new Scanner(System.in);
    List<MenuItem> menuItems = new ArrayList<>();
    public Kiosk(){
        MenuItem menuItem1 = new MenuItem("1. ShackBurger   | W ",6.9, " | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem menuItem2 = new MenuItem("2. SmokeShack    | W ",8.9," | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem menuItem3 = new MenuItem("3. Cheeseburger  | W ",6.9," | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem menuItem4 = new MenuItem("4. Hamburger     | W ",5.4," | 비프패티를 기반으로 야채가 들어간 기본버거");

        menuItems.clear();
        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        menuItems.add(menuItem3);
        menuItems.add(menuItem4);
    }

    boolean start(boolean end) {
        while (end){
            for(MenuItem m : menuItems){
                System.out.println(m.print());
            }
            System.out.println("0. 종료           | 종료");
            int num = sc.nextInt();
            sc.nextLine();
            if(num == 1 || num == 2 || num == 3 || num == 4){
                num--;
                System.out.println(menuItems.get(num).print());
                System.out.println();
            }else{
                System.out.println("프로그램을 종료합니다.");
                end = false;
            }
        }
        return true;
    }

}
