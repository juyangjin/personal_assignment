package org.example;

import java.util.Scanner;

public class C_machine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = 0;
        int one = 0;
        int two = 0;
        String ex = "";

      A : while (true) {
            if(f == 1){
                System.out.println("계산을 더 하시겠습니까? exit를 입력 시 프로그램이 종료됩니다.");
                String tmp = sc.nextLine();
                ex = sc.nextLine();
                if(ex.equals("exit")){
                    System.out.println("계산이 종료됩니다.");
                    break A;
                }else{
                    f = 0;
                }
            }else if(f == 0){
                System.out.println("양의 정수 2개를 입력해주세요.");
                one = Integer.parseInt(sc.nextLine());
                two = Integer.parseInt(sc.nextLine());
                if (one < 0 || two < 0) {
                    System.out.println("잘못 입력되었습니다. 프로그램이 종료됩니다.");
                    f = 1;
                } else {
                    System.out.println("입력된 값은 " + one + "과 " + two + "입니다.");
                    System.out.println("값을 계산할 연산자를 입력하세요");
                    char oper = sc.next().charAt(0);
                    int result = 0;
                    if (oper == '+') {
                        result = one + two;
                        System.out.println(one + "+" + two + "=" + result);
                    } else if (oper == '-') {
                        result = one - two;
                        System.out.println(one + "-" + two + "=" + result);
                    } else if (oper == '*') {
                        result = one * two;
                        System.out.println(one + "*" + two + "=" + result);
                    } else if (oper == '/') {
                        if (two != 0) {
                            result = one / two;
                            System.out.println(one + "/" + two + "=" + result);
                        } else {
                            System.out.println("나눗셈에서 분모는 0일 수 없습니다.");
                        }
                    } else {
                        System.out.println("잘못 입력되었습니다.");
                    }
                    f = 1;
                }
            }
        }
    }
}
