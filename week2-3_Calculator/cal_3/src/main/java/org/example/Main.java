package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean calculateEnded = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("계산을 시작하시겠습니까? 시작시 start를 입력해주세요.");
        String on = sc.nextLine();
        if(on.equals("start")) calculateEnded = true;

        while (calculateEnded){
            try {
                CalculatorApp.start();
                System.out.println("현재 결과값보다 큰 값은" + ArithmeticCalculator.bigResult+ "입니다.");
                System.out.println("현재까지 저장된 값은 " + ArithmeticCalculator.SaveResult + "입니다. 값을 삭제하려면 delete를 입력해주세요.");
                String del = sc.nextLine();
                if(del.equals("delete")){
                    ArithmeticCalculator.removeResult();
                    System.out.println("남은 값은" + ArithmeticCalculator.SaveResult + "입니다.");
                }
                System.out.println("계산을 한번 더 하시겠습니까? exit를 입력시 계산기가 종료됩니다.");
                String end = sc.nextLine();
                if(end.equals("exit")){
                    System.out.println("계산이 종료됩니다.");
                    calculateEnded = false;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}