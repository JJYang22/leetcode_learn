import java.util.HashMap;
import java.util.Map;

public class Solution242 {
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.isAnagram("anagram","nagbram"));
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t== null)
            return true;
        if(s == null || t==null)
            return false;
        if(s.length()!=t.length())
            return false;
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);
        }
        for (Integer i:map.values()
             ) {
            if(i != 0)
                return false;
        }
        return true;
    }
}