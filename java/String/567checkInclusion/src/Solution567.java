import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution567 {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.checkInclusion("ab","asojefklsab"));
    }
}
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s1.length()==0 )
            return true;
        if(s2 == null || s1.length()>s2.length())
            return false;

        Map <Character ,Integer> map1=new HashMap();
        Map <Character ,Integer> map2=new HashMap();
        for (int i = 0; i <s1.length() ; i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i),0)+1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i),0)+1);
        }
        System.out.println(map1);
        System.out.println(map1.hashCode());
        System.out.println();

        int left=0;
        int right=s1.length();



        while (right<s2.length()) {
            System.out.println(map2);
            System.out.println(map2.hashCode());
            if(map1.equals(map2)) {
                return true;
            }
            System.out.println(s2.charAt(left));
            if(map2.get(s2.charAt(left)) == 1)
                map2.remove(s2.charAt(left));
            else
                map2.put(s2.charAt(left), map2.get(s2.charAt(left))-1);
            left++;

            System.out.println(s2.charAt(right));

            map2.put(s2.charAt(right), map2.getOrDefault(s2.charAt(right),0)+1);
            right++;
        }
        System.out.println(map2);
        System.out.println(map2.hashCode());
        if(map1.equals(map2)) {
            return true;
        }
        return false;
    }
}