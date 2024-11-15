package org.example;

public enum OperatorType {
    ADD(new AddOperation<>()),
    Sub(new SubstractOperation<>()),
    Mul(new MultiplyOperation<>()),
    Div(new DivideOperation<>());

    private final IOperation<Double> operation;

    OperatorType(IOperation<Double> operation) {
        this.operation = operation;
    }

    public Double operate(Double firstNumber, Double secondNumber) {
        return operation.operate(firstNumber, secondNumber);
    }

}

