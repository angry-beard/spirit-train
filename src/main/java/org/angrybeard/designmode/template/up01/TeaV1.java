package org.angrybeard.designmode.template.up01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TeaV1 extends CaffeineBeverage {

    @Override
    protected void addCondiments() {
        System.out.println("添加柠檬！");
    }

    @Override
    protected void brew() {
        System.out.println("用沸水冲泡茶叶！");
    }

    @Override
    protected boolean customerWantsCondiments() {
        String answer = getUserInput();
        return answer.toLowerCase().equals("y") ? true : false;
    }

    private String getUserInput() {
        String answer = null;
        System.out.println("你要添加调料吗？(y/n)");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            System.out.println("IO error trying to read your answer");
        }
        if (null == answer) {
            return "no";
        }
        return answer;
    }
}
