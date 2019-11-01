package DataStructure.MyString;

import DataStructure.MyArray.RemoveElement27;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author Voidmian
 * @Date 2019/11/1 19:37
 */
public class ReverseWords151 {
    static public void test() {
        ReverseWords151 reverseWords151 = new ReverseWords151();
        System.out.println(reverseWords151.reverseWords("the  sky is blue"));
    }

//    2ms
//    public String reverseWords(String s) {
//        StringBuilder str=new StringBuilder();
//        String [] Strs=s.split(" ");
//        for (int i = Strs.length-1; i>=0 ; i--) {
//            if (Strs[i].length() > 0) {
//                if (str.length() == 0)
//                    str.append(Strs[i]);
//                else
//                    str.append(" "+Strs[i]);
//            }
//        }
//        return str.toString();
//    }



// 23ms  String.split()
    public String reverseWords(String s) {
        List<String> strs = new LinkedList<>();
        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                end = i;
                if(begin<end)
                    strs.add(s.substring(begin,end));
                begin = i+1;
            }
            end++;
        }
        if(begin!= s.length())
            strs.add(s.substring(begin,s.length()));
        if(strs.size()==0)
            return "";
        String ans="";
        for (String str:strs
             ) {
            ans=str+" "+ans;
        }
        return ans.substring(0,ans.length()-1);
    }

}
