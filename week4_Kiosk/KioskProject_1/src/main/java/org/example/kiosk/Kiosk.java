package org.example.kiosk;

import java.util.Scanner;

public class Kiosk extends Menu { //Kiosk클래스는 Menu 클래스를 상속한다.
    void start(boolean end) throws Exception { //start 메서드 시작되고 매개변수로 boolean 타입을 받는다.
        Scanner sc = new Scanner(System.in); //값을 스캔받기 위한 스캐너 선언
        while (end) { // end가 true라면 실행
            System.out.println("[ MAIN MENU ]");
            System.out.println("1. Burgers  |");
            System.out.println("2. Drinks   |");
            System.out.println("3. Desserts |");
            System.out.println("0. 종료      | 종료"); // 항목 메뉴 출력
            System.out.println();

            if (!getShopping_cart().isEmpty()) {
                System.out.println("[ ORDER MENU ]");
                System.out.println("4. Orders    | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel    | 진행중인 주문을 취소합니다.");
            }
            String str_menu1 = sc.nextLine(); //예외처리를 위한 String 입력받기
            int menu1 = parseNum(str_menu1);
            if (getShopping_cart().isEmpty() && menu1 > 3) {
                System.out.println("잘못입력 되었습니다.");
                System.out.println();
                continue;
            }
            select(menu1);//select 메서드를 해당 값을 매개변수로 호출한다.

            String str_menu2 = sc.nextLine();//항목에 대한 상세 메뉴 선택 (숫자)
            int menu2 = parseNum(str_menu2);

            if (menu2 == 0) {//뒤로가기 선택
                start(end);
            } else if (getMenuItems().size() >= menu2) {//menuItems 길이와 같거나 작으면 메뉴가 정상 선택된 것이므로
                menu2--;//인덱스 값은 0부터 시작하므로 1을 빼준다.
                System.out.println("선택한 메뉴 : " + getMenuItems().get(menu2).print());//인덱스 값에 맞는 값 출력
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");//장바구니 안내 메시지
                System.out.println("1.확인       2.취소");
                String str_cart_num = sc.nextLine();
                int cart_num = parseNum(str_cart_num);
                if (cart_num == 1) {
                    add_cart(menu2);
                } else if (cart_num == 2) {
                    continue;
                } else {
                    System.out.println("잘못 입력되었습니다. 1이나 2를 선택해주세요.");
                }
            } else {
                throw new BadInputException("메뉴판에 있는 값을");
            }
        }
    }
}
