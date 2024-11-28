package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) throws BadInputException {
        Scanner sc = new Scanner(System.in); // 시작값을 받기 위한 스캐너 선언
        List<MenuItem> menuItems = new ArrayList<>(); //항목별 메뉴를 담을 menuItems 리스트 선언
        boolean end = false; //종료 값을 false로 선언
        Kiosk kiosk = new Kiosk();//kiosk 인스턴스

        System.out.println("시작하려면 start를 입력해주세요.");
        String start = sc.nextLine();//시작 여부를 위한 값을 스캔해서 start에 선언

        if(start.equals("start")){ //start 변수값이 start와 동일하다면
            end = true;
            kiosk.start(end);//kiosk 클래스 안에 있는 start에 end를 매개변수로 넣는다.
        }
    }
}


