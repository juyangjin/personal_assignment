package org.Kiosk;

import org.exceptions.BadInputException;
import org.exceptions.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> menuItems;
    List<MenuItem> shopping_cart;

    void start(boolean end) throws BadInputException {//start 메서드 시작되고 매개변수로 boolean 타입을 받는다.
        Parser parser = new Parser();
        Menu menu = new Menu(menuItems,shopping_cart);
        Scanner sc = new Scanner(System.in); //값을 스캔받기 위한 스캐너 선언

        S: while (end) { // end가 true라면 실행
            menu.category(); //첫번째 항목 선택지
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println(menuItems.get(i).print());
            }

            // 두번째 항목 선택지

            // 장바구니 선택지


            System.out.println("0. 뒤로가기       | 종료"); //저장된 메뉴값이 아닌 뒤로가기 값을 출력
            if()

        }



            if (menu1 == 0) {
                System.out.println("프로그램을 종료합니다.");//항목에 대한 숫자가 0이면 종료메시지 출력
                end = false;
                break;
            } else if (menu1 == 4 || menu1 == 5) {
                int o_num = cart.orders(menu1);
                /*
                선택 메뉴 값이 4라면 할인율에 대한 메시지와 연산이 수행되고 장바구니값과 합산가격은 비워진 뒤에 처음으로 돌아갑니다.
                 */
                switch (o_num) {
                    case 1 -> {
                        System.out.println("할인 정보를 입력해주세요");
                        System.out.println("1. 국가유공자 : 10%");
                        System.out.println("2. 군인     :  5%");
                        System.out.println("3. 학생     :  3%");
                        System.out.println("4. 일반     :  0%");
                        cart.Discnt(sc.nextInt());
                        sc.nextLine();
                        System.out.println("주문이 완료되었습니다. 금액은 W " + cart.getTotal() + "입니다.");
                        cart.setShopping_cart(tmp);
                        cart.setTotal(0);
                        continue S;
                    }
                    case 2 -> {
                        continue S;
                    }
                    default -> {
                        System.out.println("잘못된 입력입니다.");
                    }
                }
                /*
                값이 5라면 안내메시지를 띄운 후 장바구니에 담긴 값을 취소할 수 있습니다.
                 */
            } else if (menu1 == 5) {
//                System.out.println("진행 중인 주문은 아래와 같습니다. 무엇을 취소하시겠습니까? 취소항목의 이름을 입력해주세요.");
//                System.out.println("[ Orders ]");
//                for (int i = 0; i < cart.getShopping_cart().size(); i++) {
//                    System.out.println(cart.getShopping_cart().get(i).print());
//                }
//                String del = sc.nextLine();
//                cart.getShopping_cart().stream()
//                        .filter(d -> cart.getShopping_cart().get().getName().contains(del))
//                        .toList()
//                        .forEach(i -> { cart.getShopping_cart().remove(i); });
//                cart.setShopping_cart(getMenuItems()); //삭제된 값을 set을 이용하여 장바구니 클래스 안에 있는 장바구니 리스트에 넣는다.
//
//                System.out.println("삭제 되고 남은 항목은 다음과 같습니다.");
//                System.out.println("[ Orders ]");
//                for (int i = 0; i < cart.getShopping_cart().size(); i++) {
//                    System.out.println(cart.getShopping_cart().get(i).getName());
//                }
                continue; //제대로 실행되지 않음. 수정이 필요하기 때문에 일단 주석처리
            } else {
                /*
                위에 있는 예외들을 모두 제외시키면 비로소 제대로 된 메뉴가 출력되도록 select가 호출됩니다.
                호출되어 계산된 값은 getMenuItems로 불러와서 상세 메뉴판이 출력되게 합니다.
                 */



            String str_menu2 = sc.nextLine();//항목에 대한 상세 메뉴
            int menu2 = parseNum(str_menu2);
            /*
            두 번째 메뉴 선택이 진행되고 해당 값이 0이라면 뒤로가기 선택, 이 부분 뒤로가기는 구현 실패
             */
            if (menu2 == 0) {
                break S;
                /*
                menuItems 길이와 같거나 작으면 메뉴가 정상 선택된 것이므로 인덱스 값은 0부터 시작하므로 1을 빼준다.
                인덱스 값에 맞는 값 출력하고 장바구니 안내메시지가 나온다.
                 */
            } else if (getMenuItems().size() >= menu2) {//
                menu2--;//
                System.out.println("선택한 메뉴 : " + getMenuItems().get(menu2).print());
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1.확인       2.취소");

                String str_cart_num = sc.nextLine();
                int cart_num = parseNum(str_cart_num);
                /*
                장바구니 값이 1이라면 값을 추가하고 2라면 취소된다.
                 */
                if (cart_num == 1) {
                    add_cart(menu2);
                } else if (cart_num == 2) {
                    continue S;
                } else {
                    throw new BadInputException("1이나 2를");
                }
            } else {
                System.out.println("선택한 메뉴가 없습니다. 다시 선택해주세요.");
                //이 부분 예외처리가 미흡한 부분이 있음. 고칠 필요가 보인다.
            }
        }
    }
}


