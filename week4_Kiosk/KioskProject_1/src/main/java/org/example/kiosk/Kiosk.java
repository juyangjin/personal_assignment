package org.example.kiosk;

import java.util.Scanner;

public class Kiosk extends Menu{
    void start(boolean end) {
        Scanner sc = new Scanner(System.in);
        while (end){
            System.out.println("[ MAIN MENU ]");
            System.out.println("1. Burgers  |");
            System.out.println("2. Drinks   |");
            System.out.println("3. Desserts |");
            System.out.println("0. 종료      | 종료");
            int menu_num = sc.nextInt();
            sc.nextLine();

            if(menu_num != 0){
                select(menu_num);
                for(int i=0;i<getMenuItems().size();i++){
                    System.out.println(getMenuItems().get(i).print());
                }
                System.out.println("0. 뒤로가기       | 종료");
            }else{
                System.out.println("프로그램을 종료합니다.");
                end = false;
                break;
            }
            int num = sc.nextInt();
            if(num == 0){
                System.out.println("프로그램을 종료합니다.");
                end = false;
                break;
            }else{
                if(getMenuItems().size() >= num){
                    num--;
                    System.out.println(getMenuItems().get(num).print());
                    System.out.println();
                }
                else{
                    System.out.println("선택한 메뉴가 없습니다. 다시 선택해주세요.");
                    num = sc.nextInt();
                    num--;
                    System.out.println(getMenuItems().get(num).print());
                    System.out.println();
                }
            }
        }
    }
}
