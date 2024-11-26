package org.example.kiosk;

import java.util.Scanner;

public class Kiosk extends Menu{ //Kiosk클래스는 Menu 클래스를 상속한다.
    void start(boolean end) { //start 메서드 시작되고 매개변수로 boolean 타입을 받는다.
        Scanner sc = new Scanner(System.in); //값을 스캔받기 위한 스캐너 선언
        while (end){ // end가 true라면 실행
            System.out.println("[ MAIN MENU ]");
            System.out.println("1. Burgers  |");
            System.out.println("2. Drinks   |");
            System.out.println("3. Desserts |");
            System.out.println("0. 종료      | 종료"); // 항목 메뉴 출력
            System.out.println();

            if(getShopping_cart().size() > 0){
                System.out.println("[ ORDER MENU ]");
                System.out.println("4. Orders    | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel    | 진행중인 주문을 취소합니다.");
            }
            int menu_num = sc.nextInt(); //원하는 항목을 숫자로 입력받는다.
            sc.nextLine(); //스캔 오류 방지

            if(menu_num == 0){
                System.out.println("프로그램을 종료합니다.");//항목에 대한 숫자가 0이면 종료메시지 출력
                end = false;
                break;
            }else if(menu_num == 4 || menu_num == 5){
                orders(menu_num);
            }else{
                select(menu_num);//select 메서드를 해당 값을 매개변수로 호출한다.
                for(int i=0;i<getMenuItems().size();i++){//menuItems값 만큼 반복
                    System.out.println(getMenuItems().get(i).print()); //참조메서드를 이용하여 menuItems값을 한 줄씩 출력
                }
                System.out.println("0. 뒤로가기       | 종료"); //저장된 메뉴값이 아닌 뒤로가기 값을 출력
            }
            int num = sc.nextInt();//항목에 대한 상세 메뉴 선택 (숫자)
            if(num == 0){//뒤로가기 선택
                start(end);
            }else{//0이 아니라면 상세 항목 선택을 위해 다음으로 넘어가게 한다.
                if(getMenuItems().size() >= num){//menuItems 길이와 같거나 작으면 메뉴가 정상 선택된 것이므로
                    num--;//인덱스 값은 0부터 시작하므로 1을 빼준다.
                    System.out.println("선택한 메뉴 : " + getMenuItems().get(num).print());//인덱스 값에 맞는 값 출력
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");//장바구니 안내 메시지
                    System.out.println("1.확인       2.취소");
                    int cart_num = sc.nextInt();
                    if(cart_num == 1){
                        add_cart(num);
                    }else if(cart_num == 2){
                        continue;
                    }else{
                        System.out.println("잘못된 입력입니다.");
                        break;
                    }
                }
                else{
                    System.out.println("선택한 메뉴가 없습니다. 다시 선택해주세요.");
                    //이 부분 예외처리가 미흡한 부분이 있음. 고칠 필요가 보인다.
                }
            }
        }
    }
}
