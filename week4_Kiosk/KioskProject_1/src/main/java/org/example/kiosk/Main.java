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
            System.out.println("으아아아아");
            switch (this) {
                case Burgers -> menu.addMenuItems(
                        new MenuItem("1. ShackBurger   | W ", 6.9, " | 토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                        new MenuItem("2. SmokeShack    | W ", 8.9, " | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                        new MenuItem("3. Cheeseburger  | W ", 6.9, " | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                        new MenuItem("4. Hamburger     | W ", 5.4, " | 비프패티를 기반으로 야채가 들어간 기본버거")
                );
                case Drinks -> menu.addMenuItems(
                        new MenuItem("1. Ice Cream     | W ", 4.5, " | 다양한 맛의 아이스크림"),
                        new MenuItem("2. Brownie       | W ", 3.9, " | 초콜릿 브라우니"),
                        new MenuItem("3. Cheesecake    | W ", 5.0, " | 부드러운 치즈케이크")
                );
                case Desserts -> menu.addMenuItems(
                        new MenuItem("1. Coke          | W ", 2.0, " | 시원한 콜라"),
                        new MenuItem("2. Sprite        | W ", 2.0, " | 상쾌한 스프라이트"),
                        new MenuItem("3. Orange Juice  | W ", 3.0, " | 신선한 오렌지 주스")
                );
                default -> System.out.println("Invalid category");
            }
        }
    }
}




