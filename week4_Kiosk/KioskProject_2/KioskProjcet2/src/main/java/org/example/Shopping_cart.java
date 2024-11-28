package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shopping_cart {
    private List<MenuItem> shopping_cart = new ArrayList<>(); //장바구니에 대한 리스트 선언
    private double total;

    public int orders(int menu_num) {
        switch (menu_num) {
            case 4 -> {
                return order_print();
                /*
                이후 장바구니 추가를 위한 선택 값을 return 받기 위해 return order_print() 사용
                 */
            }
            case 5 -> {
                System.out.println("저장된 장바구니를 비웠습니다.");
                shopping_cart.clear();
            }
            default -> System.out.println("잘못된 입력입니다.");
        }
        return 0;
    }
    /*
    4 또는 5가 입력되었을 때 처리를 위한 switch case문
     */

    public int order_print() {
        Scanner sc = new Scanner(System.in);
        order_total();
        System.out.println("[ Orders ]");
        for (int i = 0; i < shopping_cart.size(); i++) {
            System.out.println(shopping_cart.get(i).print());
        }
        System.out.println("[ Total ]");
        System.out.println("W " + total);
        System.out.println();
        System.out.println("1. 주문       2.메뉴판");
        int tmp = sc.nextInt();
        sc.nextLine();
        return tmp;
    }
    /*
    주문 메뉴와 주문메뉴값의 합산을 계산하여 저장하고 주문을 할 지 여부를 tmp로 return
     */

    public void Discnt(int num) {//매개변수를 int로 받는 메서드
        Discount type;
        try {
            type = Discount.value(num);
        } catch (BadInputException e) {
            throw new RuntimeException(e);
        }
        type.dis(this);
    }
    /*
    Discnt로 할인에 대한 선택이 int 값으로 들어오면 그것을 enum으로 넘겨주고 값이 잘못되면 예외처리
     */

    public void order_total() {
        for (int i = 0; i < shopping_cart.size(); i++) {
            total += shopping_cart.get(i).getPrice();
        }
    }
    /*
    주문 총합량에 대한 메서드
     */

    public List<MenuItem> getShopping_cart() {
        return shopping_cart;
    }

    public void setShopping_cart(List<MenuItem> shopping_cart) {
        this.shopping_cart = shopping_cart;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
