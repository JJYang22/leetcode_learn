package DataStructure.MyStack;

import java.util.Stack;

/**
 * @Author Voidmian
 * @Date 2019/10/26 21:50
 */
public class EvalRPN {
    static public void test(){
        EvalRPN evalRPN=new EvalRPN();
        String [] tokens={"4","3","-"};
        System.out.println(evalRPN.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack <String> RPN =new Stack<>();
        for (int i = 0; i <tokens.length ; i++) {
                char operator = tokens[i].charAt(0);
                switch (operator) {
                    case '+': {
                        int b = Integer.parseInt(RPN.pop());
                        int a = Integer.parseInt(RPN.pop());
                        RPN.push(String.valueOf(a + b));
                        break;
                    }
                    case '-': {
                        if(tokens[i].length()>1){
                            RPN.push(tokens[i]);
                            break;
                        }
                        int b = Integer.parseInt(RPN.pop());
                        int a = Integer.parseInt(RPN.pop());
                        RPN.push(String.valueOf(a - b));
                        break;
                    }
                    case '*': {
                        int b = Integer.parseInt(RPN.pop());
                        int a = Integer.parseInt(RPN.pop());
                        RPN.push(String.valueOf(a * b));
                        break;
                    }
                    case '/': {
                        int b = Integer.parseInt(RPN.pop());
                        int a = Integer.parseInt(RPN.pop());
                        RPN.push(String.valueOf(a / b));
                        break;
                    }
                    default:{
                        RPN.push(tokens[i]);
                    }
            }
        }
        return Integer.parseInt(RPN.pop());
    }
}
