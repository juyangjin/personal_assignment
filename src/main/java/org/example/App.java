package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Calculator{
    Queue<Integer> SaveResult = new LinkedList<>();
    private int o,t,result;
    private char op;

    public int calculate() {
        if (op == '+') {
            SaveResult.add(getO() + getT());
            result = getO() + getT();
        } else if (op == '-') {
            SaveResult.add(getO() - getT());
            result = getO() - getT();
        } else if (op == '*') {
            SaveResult.add(getO() * getT());
            result = getO() * getT();
        } else if (op == '/') {
            if (t != 0) {
                SaveResult.add(getO() / getT());
                result = getO() / getT();
            } else {
                System.out.println("나눗셈에서 분모는 0일 수 없습니다.");
            }
        } else {
            System.out.println("잘못 입력되었습니다.");
        }
        return 0;
    }

    public Queue<Integer> getSaveResult() {
        return SaveResult;
    }

    public void setSaveResult(Queue<Integer> saveResult) {
        SaveResult = saveResult;
    }

    public int getO() {
        return o;
    }

    public void setO(int o) {
        this.o = o;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void removeResult(){
        SaveResult.poll();
    }

}

public class App {
    public static void main(String[] args) {
        Calculator cal = new Calculator(); // 인스턴스 생성
        Scanner sc = new Scanner(System.in);
        int f = 0;
        int one = 0;
        int two = 0;
        String ex = "";

        A : while (true) {
            if(f == 1){
                System.out.println("값을 삭제하시겠습니까? delete를 입력 시 과거의 값이 삭제됩니다.");
                String tmp = sc.nextLine();
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
                    break A;
                }else{
                    f = 0;
                }
            }else if(f == 0){
                System.out.println("양의 정수 2개를 입력해주세요.");
                cal.setO(Integer.parseInt(sc.nextLine()))   ;
                cal.setT(Integer.parseInt(sc.nextLine()));
                if (one < 0 || two < 0) {
                    System.out.println("잘못 입력되었습니다. 프로그램이 종료됩니다.");
                    f = 1;
                } else {
                    System.out.println("입력된 값은 " + cal.getO() + "과 " + cal.getT() + "입니다.");
                    System.out.println("값을 계산할 연산자를 입력하세요");
                    cal.setOp(sc.next().charAt(0));
                    cal.calculate();
                    int result = cal.getResult();
                    System.out.println("계산된 값은 " + result + "입니다.");
                    System.out.println("현재까지 계산한 값은 " + cal.getSaveResult() + "입니다.");
                    f = 1;
                }
            }
        }
    }
}