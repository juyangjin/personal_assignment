package org.example;

import java.awt.font.OpenType;

public enum Discount {
    Person_of_national_merit(1) {
        @Override
        public void dis(Shopping_cart cart) {
            cart.setTotal(cart.getTotal() * 0.9);
        }
    },
    Soldier(2){
        @Override
        public void dis(Shopping_cart cart) {
            cart.setTotal(cart.getTotal() * 0.95);
        }
    },
    Student(3){
        @Override
        public void dis(Shopping_cart cart) {
            cart.setTotal(cart.getTotal() * 0.97);
        }
    },
    Common(4) {
        @Override
        public void dis(Shopping_cart cart) {

        }
    };

    /*
    enum을 이용하여 사용자 유형별 할인률을 적용할 수 있게 함
     */


    private final int num;

    Discount(int num){
        this.num = num;
    }


    public int getNum() {
        return num;
    }

    public static Discount value(int num) throws BadInputException {
        for (Discount type : Discount.values()) {
            if (type.getNum() == num) {
                return type;
            }
        }
        throw new BadInputException("숫자");
    }
    /*
    enum에 입력 받은 숫자가 int 형이 아니라면 예외처리를 하도록 하였다.
     */

    public abstract void dis(Shopping_cart cart);
    //enum에서 할인을 위한 메서드를 추상화해서 오버라이딩으로 사용.
}

