package org.example;

public class BadInputException extends Exception {
    public BadInputException(String type) {
        super("잘못된 입력입니다! " + type + "을 입력해주세요!");
        /*
        잘못된 입력일 때 사용하는 예외처리 클래스
         */
    }
}
