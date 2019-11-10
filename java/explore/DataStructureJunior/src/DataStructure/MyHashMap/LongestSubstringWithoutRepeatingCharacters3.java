package DataStructure.MyHashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Voidmian
 * @Date 2019/11/9 20:34
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    static public void test(){
        LongestSubstringWithoutRepeatingCharacters3 longestSubstringWithoutRepeatingCharacters3 = new LongestSubstringWithoutRepeatingCharacters3();
        System.out.println(longestSubstringWithoutRepeatingCharacters3.lengthOfLongestSubstring("aab"));
    }
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int ans = Integer.MIN_VALUE;
        int begin = 0;
        int end = 0;
        Map<Character,Integer> used = new HashMap<>();
        char[] chars = s.toCharArray();
        while (end < s.length()) {
            if (used.getOrDefault(chars[end],-1) >=begin) {
                if(ans < end - begin){
                    ans = end - begin;
                }
                begin = used.get(chars[end])+1;
                used.put(chars[end],end);
            } else {
                used.put(chars[end],end);
                if(ans < end - begin + 1){
                    ans = end - begin + 1;
                }
            }
            end++;
        }
        return ans;
    }
}
