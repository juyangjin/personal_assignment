package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        ArithmeticCalculator a_cal = new ArithmeticCalculator(); // 인스턴스 생성
        Scanner sc = new Scanner(System.in);
        int f = 0;
        double result;
        String ex = "";

        if (a_cal.getOp() == '+') {
            result = cal.calculate(a_cal.getOne(),a_cal.getTwo(),OperatorType.ADD);
            a_cal.SaveResult.add(result);
        } else if (a_cal.getOp() == '-') {
            result = cal.calculate(a_cal.getOne(),a_cal.getTwo(),OperatorType.Sub);
            a_cal.SaveResult.add(result);
        } else if (a_cal.getOp() == '*') {
            result = cal.calculate(a_cal.getOne(),a_cal.getTwo(),OperatorType.Mul);
            a_cal.SaveResult.add(result);
        } else if (a_cal.getOp() == '/') {
            if (a_cal.getTwo() != 0) {
                result = cal.calculate(a_cal.getOne(),a_cal.getTwo(),OperatorType.Div);
                a_cal.SaveResult.add(result);
            } else {
                System.out.println("나눗셈에서 분모는 0일 수 없습니다.");
            }
        } else {
            System.out.println("잘못 입력되었습니다.");
        }

           while (true) {
            if(f == 1){
                System.out.println("값을 삭제하시겠습니까? delete를 입력 시 과거의 값이 삭제됩니다. ");
                String tmp = sc.nextLine();//스캐너 오류로 인한 추가부분
                String d = sc.nextLine();
                if(d.equals("delete")){
                    a_cal.removeResult();
                    System.out.println("삭제되고 남은 값은 " + a_cal.getSaveResult() + "입니다.");
                }
                System.out.println("계산을 더 하시겠습니까? exit를 입력 시 프로그램이 종료됩니다.");
                ex = sc.nextLine();
                if(ex.equals("exit")){
                    System.out.println("지금까지 저장된 값은 " + a_cal.getSaveResult() + "입니다.");
                    System.out.println("계산이 종료됩니다.");
                    break;
                }else{
                    f = 0;
                }
            }else if(f == 0){
                System.out.println("첫번째 숫자를 입력해주세요.");
                a_cal.setOne(Integer.parseInt(sc.nextLine()))   ;
                a_cal.setTwo(Integer.parseInt(sc.nextLine()));
                if (a_cal.getOne() < 0 || a_cal.getTwo() < 0) {
                    System.out.println("잘못 입력되었습니다. 프로그램이 종료됩니다.");
                    f = 1;
                } else {
                    System.out.println("입력된 값은 " + a_cal.getOne() + "과 " + a_cal.getTwo() + "입니다.");
                    System.out.println("값을 계산할 연산자를 입력하세요");
                    a_cal.setOp(sc.next().charAt(0));
                    cal.calculate();
                    System.out.println("계산된 값은 " + a_cal.getResult() + "입니다.");
                    System.out.println("현재까지 계산한 값은 " + a_cal.getSaveResult() + "입니다.");
                    f = 1;
                }
            }
        }
    }
}