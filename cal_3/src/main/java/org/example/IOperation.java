package org.example;

public interface IOperation <T extends Number> {
    T operate(T firstNumber, T secondNumber);
}