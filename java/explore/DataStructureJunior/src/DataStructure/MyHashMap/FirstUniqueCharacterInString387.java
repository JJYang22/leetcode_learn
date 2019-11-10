package DataStructure.MyHashMap;

import java.util.*;

/**
 * @Author Voidmian
 * @Date 2019/11/7 21:39
 */
public class FirstUniqueCharacterInString387 {
    public int firstUniqChar(String s) {
        if(s == null || s.length()<1)
            return -1;
        int [] chars = new int[128];
        for (int i = 0; i <s.length() ; i++) {
            chars[s.charAt(i)]++;
        }
        for (int i = 0; i <s.length() ; i++) {
            if(chars[s.charAt(i)]== 1)
                return i;
        }
        return -1;
    }
}
