package org.example;

public class AddOperation<T extends Number> implements IOperation<T> {
    @Override
    public T operate(T firstNumber, T secondNumber) {
        return (T) (Double) (firstNumber.doubleValue() + secondNumber.doubleValue());
    }
}
