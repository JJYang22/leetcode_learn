package DataStructure.MyStack;

import java.util.Stack;

/**
 * @Author Voidmian
 * @Date 2019/10/26 20:59
 */
public class IsValid {
    static public void test() {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        if (s.length()%2 !=0) {
            return false;
        }
        Stack<Character> str = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                str.push(s.charAt(i));
            } else {
                if (str.isEmpty())
                    return false;
                if ((s.charAt(i) == ')' && str.peek() == '(') || (s.charAt(i) == ']' && str.peek() == '[') || (s.charAt(i) == '}' && str.peek() == '{')) {
                    str.pop();
                } else
                    return false;
            }
        }
        if (str.isEmpty())
            return true;
        else
            return false;
    }
}
