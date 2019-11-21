import java.util.Stack;

public class Solution227 {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.calculate("1*2-3/4+5*(6-7)*8+900/10"));
    }
}

class Solution {
    int priority [] = {3,0,2,1,0,1,0,2};
    public int calculate(String s) {
        Stack <String> operator =new Stack<>();
        Stack <Integer> number = new Stack<>();
        int temp=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
                continue;
            if(s.charAt(i) >= '0')
            {
                temp*=10;
                temp+=s.charAt(i)-'0';
                if(i+1>=s.length() || s.charAt(i+1)<'0')
                {
                    number.push(temp);
                    temp=0;
                }
            }
            else
            {
                int temp_priority=s.charAt(i)-'(';
                if(operator.isEmpty() || priority[temp_priority]>priority[operator.peek().charAt(0)-'('])
                    operator.push(s.substring(i,i+1));
                else
                {
                    cal(operator,number,s.substring(i,i+1));
                }
            }
        }
        if(!operator.isEmpty())
        {
            cal(operator,number,null);
        }
        return number.pop();
    }
    public void cal(Stack <String> operator,Stack <Integer> number,String present)
    {
        if(operator.peek().compareTo("(")!=0 ) {
            while ( !operator.isEmpty() && (present ==null ||priority[present.charAt(0)-'(']<=priority[operator.peek().charAt(0)-'(']) ) {
                int right = number.pop();
                int left = number.pop();
                switch (operator.pop()) {
                    case "+":
                        number.push(left + right);
                        break;
                    case "-":
                        number.push(left - right);
                        break;
                    case "*":
                        number.push(left * right);
                        break;
                    case "/":
                        number.push(left / right);
                        break;
                }
                if(!operator.isEmpty()) {
                    if (operator.peek().charAt(0) == '(' && present.charAt(0) == ')') {
                        operator.pop();
                        return;
                    }
                }
            }
            if (present != null)
                operator.push(present);
        }
        else
        {
            operator.push(present);
        }
    }
}