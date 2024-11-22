package org.example.kiosk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        //Menu menu = new Menu("1. Burgers","2. Drinks","3. Desserts");
        Kiosk kiosk = new Kiosk();

        System.out.println("시작하려면 start를 입력해주세요.");
        String start = sc.nextLine();

        if(start.equals("start")){
            end = true;
            kiosk.start(end);
        }
    }
}



