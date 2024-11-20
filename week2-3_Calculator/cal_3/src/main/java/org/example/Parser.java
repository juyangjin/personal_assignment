package org.example;

import java.util.regex.Pattern;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*/]";
    private static final String NUMBER_REG = "^[0-9]*$";

    private final ArithmeticCalculator calculator = new ArithmeticCalculator();

    public Parser parseFirstNum(String firstInput) throws BadInputException {
        if(!Pattern.matches(NUMBER_REG,firstInput)){
            throw new BadInputException("숫자");
        }

        this.calculator.setFirstNumber(Double.parseDouble(firstInput));
        return this;
    }

    public Parser parseSecondNum(String secondInput) throws BadInputException {
        if(!Pattern.matches(NUMBER_REG,secondInput)){
            throw new BadInputException("숫자");
        }
        this.calculator.setSecondNumber(Double.parseDouble(secondInput));
        return this;
    }

    public Parser parseOperator(String operationInput) throws BadInputException {
        if(!Pattern.matches(OPERATION_REG,operationInput)){
            throw new BadInputException("연산자");
        }

        switch (operationInput){
            case "+" -> this.calculator.setOperation(OperatorType.ADD);
            case "-" -> this.calculator.setOperation(OperatorType.Sub);
            case "*" -> this.calculator.setOperation(OperatorType.Mul);
            case "/" -> this.calculator.setOperation(OperatorType.Div);
        }

        return this;
    }

    public double executeCalculator() {
        return calculator.calculate();
    }
}
