package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class ArithmeticCalculator<T extends Number> {
    private Double firstNumber;
    private Double secondNumber;
    private OperatorType operatorType;
    static Queue<Double> SaveResult = new LinkedList<>();
    public static void removeResult() {
        SaveResult.poll();
    }

    public ArithmeticCalculator(OperatorType operatorType) {
        this.operatorType = operatorType;
    }

    public ArithmeticCalculator() {
    }

    public void setOperation(OperatorType operatorType) {
        this.operatorType = operatorType;
    }

    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(Double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public Double calculate() {
        return operatorType.operate(firstNumber, secondNumber);
    }

}
