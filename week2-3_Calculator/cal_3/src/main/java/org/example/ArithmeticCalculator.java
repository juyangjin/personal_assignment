package org.example;

import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ArithmeticCalculator<T extends Number> {
    private Double firstNumber;
    private Double secondNumber;
    private OperatorType operatorType;
    static Queue<Double> SaveResult = new LinkedList<>();
    static ArrayList<Double> bigResult = new ArrayList<>();
    public static void removeResult() {
        SaveResult.poll();
    }
    static Double result;

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
        result = operatorType.operate(firstNumber, secondNumber);
        return result;
    }

}


