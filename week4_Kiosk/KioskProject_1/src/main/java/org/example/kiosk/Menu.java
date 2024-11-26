package org.example.kiosk;

import java.util.*;


public class Menu {
    private ArrayList<MenuItem> menuItems = new ArrayList<>(); //항목별 메뉴를 담을 menuItems 리스트 선언
    private ArrayList<MenuItem> shopping_cart = new ArrayList<>(); //장바구니에 대한 리스트 선언
    MenuItem menuItem1; //메뉴를 위한 필드들 선언
    MenuItem menuItem2;
    MenuItem menuItem3;
    MenuItem menuItem4;
    MenuItem cart_category;
    double total;

    public void select(int i) {//매개변수를 int로 받는 메서드
        Scanner sc = new Scanner(System.in); //스캔을 위한 스캐너 선언
        menuItems.clear(); //menuItems값을 초기화
        switch (i) {
            case 1 -> burgers(); //매개변수 값에 따라서 항목에 맞는 메서드 호출
            case 2 -> drinks();
            case 3 -> desserts();
            default -> {
                System.out.println("선택한 카테고리가 없습니다. 다시 선택해주세요.");
                select(sc.nextInt()); //원하는 case가 아닌 값이 입력되면 예외 메시지가 출력되고 다시 값을 입력받는다.
            }
        }
    }

    public void burgers(){
        menuItems.clear();//값 초기화
        menuItem1 = new MenuItem("1. ShackBurger   | W ", 6.9, " | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menuItem2 = new MenuItem("2. SmokeShack    | W ", 8.9, " | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        menuItem3 = new MenuItem("3. Cheeseburger  | W ", 6.9, " | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menuItem4 = new MenuItem("4. Hamburger     | W ", 5.4, " | 비프패티를 기반으로 야채가 들어간 기본버거");
        addMenuItems(menuItem1, menuItem2, menuItem3, menuItem4);
    }
    //MenuItem 생성자로 필드들에 값을 추가하고, 해당 필드들을 addMenuItems에 가변매개변수로 하여 호출

    public void desserts(){
        menuItems.clear();
        menuItem1 = new MenuItem("1. Ice Cream     | W ", 4.5, " | 다양한 맛의 아이스크림");
        menuItem2 = new MenuItem("2. Brownie       | W ", 3.9, " | 초콜릿 브라우니");
        menuItem3 = new MenuItem("3. Cheesecake    | W ", 5.0, " | 부드러운 치즈케이크");
        addMenuItems(menuItem1, menuItem2, menuItem3);
    }
    //버거 메서드와 동일한 방식으로 새로운 값들이 저장되나 항목이 하나 적다.

    public void drinks(){
        menuItems.clear();
        menuItem1 = new MenuItem("1. Coke          | W ", 2.0, " | 시원한 콜라");
        menuItem2 = new MenuItem("2. Sprite        | W ", 2.0, " | 상쾌한 스프라이트");
        menuItem3 = new MenuItem("3. Orange Juice  | W ", 3.0, " | 신선한 오렌지 주스");
        addMenuItems(menuItem1, menuItem2, menuItem3);
    }
    //버거 메서드와 동일한 방식으로 새로운 값들이 저장되나 항목이 하나 적다.

    public void addMenuItems(MenuItem... item) {// ...을 사용하여 MenuItem 타입의 가변 매개변수를 받는다.
        menuItems.addAll(Arrays.asList(item));//매개변수의 모든 값을 menuItems 리스트에 저장
    }

    public void add_cart(int num){
        shopping_cart.add(getMenuItems().get(num));
        String[] print_tmp = getMenuItems().get(num).getName().split(" "); //메뉴판용 번호와 W 표시 제거를 위해 띄움 단위로 잘라서 임시배열 저장
        System.out.println(print_tmp[1] + " 이(가) 장바구니에 추가되었습니다."); //저장된 중간 값을 출력
    }

    public void orders(int menu_num){
        switch (menu_num){
            case 4 -> order_print();
            case 5 ->{
                System.out.println("저장된 장바구니를 비웠습니다.");
                shopping_cart.clear();
            }
            default -> System.out.println("잘못된 입력입니다.");
        }
    }

    public void order_print(){
        order_total();
        System.out.println("[ Orders ]");
        System.out.println(cart_category.print());
        System.out.println("[ Total ]");
        System.out.println("W" + total);
    }

    public void order_total(){
        for(int i=0;i<shopping_cart.size();i++){
            total += shopping_cart.get(i).getPrice();
        }
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    } //menuItems에 대한 참조메서드

    public ArrayList<MenuItem> getShopping_cart() {
        return shopping_cart;
    }
}
