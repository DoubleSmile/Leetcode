package com.daily.March;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Created by luckyyflv on 16-3-10.
 *
 * Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

 You may assume that the given expression is always valid.

 Some examples:
 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5
 */
public class BasicCalculatorII {

    public int calculate(String s){
        s=s.replaceAll(" ","");
        Stack<String> stack=new Stack<String>();
        StringBuilder sb=new StringBuilder();
        int falg = 0;
        boolean isNumber=false;
        String pre;
        char c;
        String preFactor;

        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            if(stack.isEmpty()){
                if(c >= '0' && c <= '9') isNumber=true;
                stack.add(String.valueOf(c));
            }else if(c >='0' && c <='9' && isNumber){
                pre=stack.pop();
                stack.add(pre+c);
            }else if(c >='0' && c <='9' && !isNumber){
                preFactor=stack.pop();
                if(preFactor.equals("*")){
                    pre=stack.pop();
                    stack.add(Integer.valueOf(pre)*Integer.valueOf(String.valueOf(c))+"");
                    isNumber=true;
                }else if(preFactor.equals("/")){

                    pre=stack.pop();
                    stack.add(Integer.valueOf(pre)/Integer.valueOf(String.valueOf(c))+"");
                    isNumber=true;
                }else{
                    stack.add(preFactor);
                    stack.add(String.valueOf(c));
                    isNumber=true;
                }
            }else{
                isNumber=false;
                stack.add(String.valueOf(c));
            }
        }

        String[] array=new String[stack.size()];

        for(int i=array.length-1;i>=0;i--){
            array[i]=stack.pop();
        }
        int temp=0;
        Boolean add=true;
        for(int i=0;i<array.length;i++) {
            if (array[i].equals("+")) {
                add = true;
            } else if (array[i].equals("-")) {
                add = false;
            } else {
                if(add){
                    temp+=Integer.valueOf(array[i]);
                }else{
                    temp-=Integer.valueOf(array[i]);
                }
            }
        }
        return temp;
    }

    public static void main(String[] args){
        String s="2*3*3*5+1-10";
        System.out.println(new BasicCalculatorII().calculate("1*2-3/4+5*6-7*8+9/10"));
    }


}
