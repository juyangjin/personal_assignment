package org.example.kiosk;

import java.util.Scanner;

public class Kiosk {
    void start(boolean end) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        while (end){
            System.out.println("[ MAIN MENU ]");
            System.out.println("1. Burgers  |");
            System.out.println("2. Drinks   |");
            System.out.println("3. Desserts |");
            System.out.println("0. 종료      | 종료");
            int menu_num = sc.nextInt();
            sc.nextLine();
            if(menu_num != 0){
                menu.select(menu_num);
                menu.addMenuItems();
                for(MenuItem m : menu.getMenuItems()){
                    System.out.println("안녕");
                    System.out.println(m.toString());
                }
                System.out.println("0. 종료           | 종료");
            }else{
                System.out.println("프로그램을 종료합니다.");
                end = false;
            }
            int num = sc.nextInt();
            if(num == 1 || num == 2 || num == 3 || num == 4){
                num--;
                System.out.println(menu.getMenuItems().get(num).print());
                System.out.println();
            }else{
                System.out.println("프로그램을 종료합니다.");
                end = false;
            }
        }
    }
}
