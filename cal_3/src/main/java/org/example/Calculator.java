package org.example;

public class Calculator {
    public double calculate(Double firstNumber, Double secondNumber, OperatorType operationType) {
        return operationType.operate(firstNumber,secondNumber);
    }
}
