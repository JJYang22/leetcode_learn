import java.util.Stack;

public class Solution394 {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.decodeString("3[a2[c]]"));
    }
}
class Solution {
    public String decodeString(String s) {
        Stack <String> stack=new Stack<>();
        int start=0;
        int end=0;
        while (start<s.length()){
            end=start;
            while (end+1<s.length()&&(s.charAt(end)>='0' && s.charAt(end)<='9')){
                end++;
            }
            if(start !=end){
                stack.push(s.substring(start,end));
                start=end;
                continue;
            }
            if(s.charAt(start)=='[') {
                stack.push("[");
                start++;
                continue;
            }
            if(s.charAt(start) == ']'){
                String string="";
                while (!stack.peek().equals("[")) {
                    string = stack.pop()+string;
                }
                stack.pop();
                int count=Integer.parseInt(stack.pop());
                for (int i = 0; i <count ; i++) {
                    stack.push(string);
                }
                start++;
                continue;
            }
            while (end<s.length() && s.charAt(end)!=']' && !(s.charAt(end)>='0' && s.charAt(end)<='9'))
                end++;
            stack.push(s.substring(start,end));
            start=end;
        }
        String ans="";
        while (!stack.isEmpty())
            ans=stack.pop()+ans;
        return ans;
    }
}