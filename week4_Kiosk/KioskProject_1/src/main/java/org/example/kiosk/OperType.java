package org.example.kiosk;

import java.util.Scanner;

public enum OperType {
        Burgers(1) {
                @Override
                public void category(Menu menu) {
                                menu.addMenuItems(
                                new MenuItem("1. ShackBurger   | W ", 6.9, " | 토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                                new MenuItem("2. SmokeShack    | W ", 8.9, " | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                                new MenuItem("3. Cheeseburger  | W ", 6.9, " | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                                new MenuItem("4. Hamburger     | W ", 5.4, " | 비프패티를 기반으로 야채가 들어간 기본버거")
                        );}
        },
        Drinks(2) {
                @Override
                public void category(Menu menu) {
                        menu.addMenuItems(
                                new MenuItem("1. Coke          | W ", 2.0, " | 시원한 콜라"),
                                new MenuItem("2. Sprite        | W ", 2.0, " | 상쾌한 스프라이트"),
                                new MenuItem("3. Orange Juice  | W ", 3.0, " | 신선한 오렌지 주스")
                        );}
        },
        Desserts(3) {
                @Override
                public void category(Menu menu) {
                        menu.addMenuItems(
                                new MenuItem("1. Ice Cream     | W ", 4.5, " | 다양한 맛의 아이스크림"),
                                new MenuItem("2. Brownie       | W ", 3.9, " | 초콜릿 브라우니"),
                                new MenuItem("3. Cheesecake    | W ", 5.0, " | 부드러운 치즈케이크")
                        );}
        },
        Order(4) {
                @Override
                public void category(Menu menu) {
                        Scanner sc = new Scanner(System.in);
                        menu.order_total();
                        System.out.println("[ Orders ]");
                        for (int i = 0; i < menu.getShopping_cart().size(); i++) {
                                System.out.println(menu.getShopping_cart().get(i).print());
                        }
                        System.out.println("[ Total ]");
                        System.out.println("W " + menu.getTotal());
                        System.out.println();
                        System.out.println("1. 주문       2.메뉴판");
                        int tmp = sc.nextInt();
                        switch (tmp) {
                                case 1 -> {
                                        System.out.println("주문이 완료되었습니다. 금액은 W " + menu.getTotal() + "입니다.");
                                }
                                case 2 -> {
                                        System.out.println("끝났습니다.");
                                }
                                default -> {
                                        System.out.println("잘못된 입력입니다.");
                                }
                        }
                }
        },

        Exit(0) {
                @Override
                public void category(Menu menu) {
                        System.out.println("프로그램을 종료합니다.");//항목에 대한 숫자가 0이면 종료메시지 출력
                }
        };

        private final int num;

        OperType(int num){
                this.num = num;
        }

        public int getNum() {
                return num;
        }

        public static OperType value(int num) throws BadInputException {
               for (OperType type : OperType.values()) {
                       if (type.getNum() == num) {
                               return type;
                       }
               }
               throw new BadInputException("숫자");
       }

        public abstract void category(Menu menu) throws BadInputException;

}







