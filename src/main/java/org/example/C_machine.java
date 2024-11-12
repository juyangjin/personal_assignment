package org.example;

import java.util.Scanner;

public class C_machine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("양의 정수를 2개 입력해주세요.");
            int one = sc.nextInt();
            int two = sc.nextInt();

            if (one < 0 || two < 0) {
                System.out.println("잘못 입력되었습니다. 프로그램이 종료됩니다.");
            } else {
                System.out.println("입력된 값은 " + one + "과 " + two + "입니다.");
                System.out.println("값을 계산할 연산자를 입력하세요");
                char oper = sc.next().charAt(0);
                int result = 0;
                if (oper == '+') {
                    result = one + two;
                    System.out.println(one + "+" + two + "=" + result);
                    break;
                } else if (oper == '-') {
                    result = one - two;
                    System.out.println(one + "-" + two + "=" + result);
                    break;
                } else if (oper == '*') {
                    result = one * two;
                    System.out.println(one + "*" + two + "=" + result);
                    break;
                } else if (oper == '/') {
                    if (two != 0) {
                        result = one / two;
                        System.out.println(one + "/" + two + "=" + result);
                        break;
                    } else {
                        System.out.println("나눗셈에서 분모는 0일 수 없습니다.");
                        break;
                    }
                } else {
                    System.out.println("잘못 입력되었습니다.");
                    break;
                }
            }
        }
    }
}