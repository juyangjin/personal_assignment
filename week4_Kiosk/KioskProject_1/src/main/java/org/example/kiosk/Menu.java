package org.example.kiosk;

import java.util.*;
import java.util.regex.Pattern;


public class Menu {
    Scanner sc = new Scanner(System.in);
    private OperType operType;
    MenuItem menuItem = new MenuItem();
    private static final String NUMBER_REG = "^[0-9]*$";
    private ArrayList<MenuItem> menuItems = new ArrayList<>(); //항목별 메뉴를 담을 menuItems 리스트 선언
    private ArrayList<MenuItem> shopping_cart = new ArrayList<>(); //장바구니에 대한 리스트 선언
    private int num;
    private double total;

    public int parseNum(String num) throws BadInputException {
        if(!Pattern.matches(NUMBER_REG,num)){
            throw new BadInputException("숫자");
        }
        return Integer.parseInt(num);
    }// 예외처리를 위한 파싱메서드


    public void select(int num) throws Exception {//매개변수를 int로 받는 메서드

        OperType type = OperType.value(num);
        type.category(this);
    }

    public void addMenuItems(MenuItem... item) {// ...을 사용하여 MenuItem 타입의 가변 매개변수를 받는다.
        menuItems.clear();
        menuItems.addAll(Arrays.asList(item));//매개변수의 모든 값을 menuItems 리스트에 저장
        for(int i=0;i<menuItems.size();i++){
            System.out.println(menuItems.get(i).print()); //상세 메뉴판 출력
        }
        System.out.println("0. 뒤로가기       | 종료");

    }

    public void add_cart(int num){
        shopping_cart.add(getMenuItems().get(num));
        String[] print_tmp = getMenuItems().get(num).getName().split(" "); //메뉴판용 번호와 W 표시 제거를 위해 띄움 단위로 잘라서 임시배열 저장
        System.out.println(print_tmp[1] + " 이(가) 장바구니에 추가되었습니다."); //저장된 중간 값을 출력
    }

    public double getTotal() {
        return total;
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
