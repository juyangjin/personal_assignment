package org.exceptions;

import org.Kiosk.MenuItem;

import java.util.regex.Pattern;

public class Parser {
    private static final String NUMBER_REG = "^[0-9]*$";
    private final MenuItem menuItem = new MenuItem();

    // 예외처리를 위한 파싱메서드
    public Parser parseCategory(String num) throws BadInputException{
        if(!Pattern.matches(NUMBER_REG,num)){
            throw new BadInputException("숫자");
        }
        this.menuItem.setCategory_num(Integer.parseInt(num));
        return this;
    }

    public Parser parseMenu(String num) throws BadInputException{
        if(!Pattern.matches(NUMBER_REG,num)){
            throw new BadInputException("숫자");
        }
        this.menuItem.setMenu_num(Integer.parseInt(num));
        return this;
    }

    public MenuItem menuItem
}
