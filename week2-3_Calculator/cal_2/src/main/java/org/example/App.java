package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator cal = new Calculator(); // 인스턴스 생성
        Scanner sc = new Scanner(System.in);
        int f = 0;
        String ex = "";

           while (true) {
            if(f == 1){
                System.out.println("값을 삭제하시겠습니까? delete를 입력 시 과거의 값이 삭제됩니다. ");
                String tmp = sc.nextLine();//스캐너 오류로 인한 추가부분
                String d = sc.nextLine();
                if(d.equals("delete")){
                    cal.removeResult();
                    System.out.println("삭제되고 남은 값은 " + cal.getSaveResult() + "입니다.");
                }
                System.out.println("계산을 더 하시겠습니까? exit를 입력 시 프로그램이 종료됩니다.");
                ex = sc.nextLine();
                if(ex.equals("exit")){
                    System.out.println("지금까지 저장된 값은 " + cal.getSaveResult() + "입니다.");
                    System.out.println("계산이 종료됩니다.");
                    break;
                }else{
                    f = 0;
                }
            }else if(f == 0){
                System.out.println("양의 정수 2개를 입력해주세요.");
                cal.setOne(Integer.parseInt(sc.nextLine()))   ;
                cal.setTwo(Integer.parseInt(sc.nextLine()));
                if (cal.getOne() < 0 || cal.getTwo() < 0) {
                    System.out.println("잘못 입력되었습니다. 프로그램이 종료됩니다.");
                    f = 1;
                } else {
                    System.out.println("입력된 값은 " + cal.getOne() + "과 " + cal.getTwo() + "입니다.");
                    System.out.println("값을 계산할 연산자를 입력하세요");
                    cal.setOp(sc.next().charAt(0));
                    cal.calculate();
                    System.out.println("계산된 값은 " + cal.getResult() + "입니다.");
                    System.out.println("현재까지 계산한 값은 " + cal.getSaveResult() + "입니다.");
                    f = 1;
                }
            }
        }
    }
}