package DataStructure;

import java.util.Stack;

/**
 * @Author Voidmian
 * @Date 2019/10/30 15:08
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stackChar = new Stack<>();
        Stack<Integer> stackNum = new Stack<>();
        char[] ss = s.toCharArray();
        int num=0;
        for (char temp : ss) {
            if (temp == ']') {
                int length = stackNum.pop();
                String str="";
                while (!stackChar.peek().equals("[")) {
                    str=stackChar.pop()+str;
                }
                stackChar.pop();
                for (int i = 0; i < length; i++) {
                    stackChar.push(str);
                }
            } else {
                if (temp >= '0' && temp <= '9') {
                    num*=10;
                    num+=temp - '0';
                } else {
                    if(num!=0){
                        stackNum.push(num);
                        num=0;
                    }
                    stackChar.push(String.valueOf(temp));
                }
            }
        }


        String ans = "";
        while (!stackChar.isEmpty())
            ans = stackChar.pop() + ans;
        return ans;
    }
}
