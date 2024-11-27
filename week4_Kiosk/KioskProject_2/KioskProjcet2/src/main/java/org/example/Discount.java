package org.example;

import java.awt.font.OpenType;

public enum Discount {
    Person_of_national_merit(1) {
        @Override
        public void dis(Menu menu) {
            menu.setTotal(menu.getTotal() * 0.9);
        }
    },
    Soldier(2){
        @Override
        public void dis(Menu menu) {
            menu.setTotal(menu.getTotal() * 0.95);
        }
    },
    Student(3){
        @Override
        public void dis(Menu menu) {
            menu.setTotal(menu.getTotal() * 0.97);
        }
    },
    Common(4) {
        @Override
        public void dis(Menu menu) {

        }
    };


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

    public abstract void dis(Menu menu);
}

