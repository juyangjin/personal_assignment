package org.example;

public enum OperatorType {
    ADD(new AddOperation<>()),
    Sub(new SubstractOperation<>()),
    Mul(new MultiplyOperation<>()),
    Div(new DivideOperation<>());

    private final IOperation<Double> operation;

    <T extends Number> OperatorType(IOperation<T> operation) {
        this.operation = (IOperation<Double>) operation;
    }
    public <T extends Number> T operate(T firstNumber, T secondNumber) {
        return (T) operation.operate((Double) firstNumber, (Double) secondNumber);
    }
}

