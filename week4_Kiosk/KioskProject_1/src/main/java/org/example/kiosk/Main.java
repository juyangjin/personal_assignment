package org.example.kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu(category);
        Kiosk kiosk = new Kiosk();

        int num = sc.nextInt();
        if(num != 0){
            kiosk.start();
        }
    }
}



