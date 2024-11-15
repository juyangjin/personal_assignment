package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class ArithmeticCalculator<T> {
    Queue<Double> SaveResult = new LinkedList<>();
    private double one, two, result;
    private char op;

    public Queue<Double> getSaveResult() {
        return SaveResult;
    }

    public double getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public double getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public char getOp() {
        return op;
    }

    public double getResult() {
        return result;
    }

    public void removeResult() {
        SaveResult.poll();
    }

}
