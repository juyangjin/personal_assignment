package org.example;

import java.util.LinkedList;
import java.util.Queue;

class Calculator {
    Queue<Integer> SaveResult = new LinkedList<>();
    private int one, two, result;
    private char op;

    public int calculate() {
        if (op == '+') {
            SaveResult.add(getOne() + getTwo());
            result = getOne() + getTwo();
        } else if (op == '-') {
            SaveResult.add(getOne() - getTwo());
            result = getOne() - getTwo();
        } else if (op == '*') {
            SaveResult.add(getOne() * getTwo());
            result = getOne() * getTwo();
        } else if (op == '/') {
            if (two != 0) {
                SaveResult.add(getOne() / getTwo());
                result = getOne() / getTwo();
            } else {
                System.out.println("나눗셈에서 분모는 0일 수 없습니다.");
            }
        } else {
            System.out.println("잘못 입력되었습니다.");
        }
        return 0;
    }

    public Queue<Integer> getSaveResult() {
        return SaveResult;
    }

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public int getResult() {
        return result;
    }

    public void removeResult() {
        SaveResult.poll();
    }

}
