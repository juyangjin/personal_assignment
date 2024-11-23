package org.example.kiosk;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        Kiosk kiosk = new Kiosk();

        System.out.println("시작하려면 start를 입력해주세요.");
        String start = sc.nextLine();

        if(start.equals("start")){
            end = true;
            kiosk.start(end);
        }
    }

    public enum OperType {
        Burgers, Drinks, Desserts;

        public void category() {
            Menu menu = new Menu();
            switch (this) {
                case Burgers -> menu.burgers();
                case Drinks -> menu.drinks();
                case Desserts -> menu.desserts();
                default -> System.out.println("선택한 카테고리가 없습니다. 다시 선택해주세요.");
            }
        }
    }
}




