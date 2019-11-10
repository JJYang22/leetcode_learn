package DataStructure.MyHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Voidmian
 * @Date 2019/11/7 18:31
 */
public class IsomorphicStrings205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
            return false;
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i <s.length() ; i++) {
            char sTemp=s.charAt(i);
            char tTemp=t.charAt(i);
            if(map.containsKey(sTemp)){
                if(map.get(sTemp)!=tTemp){
                    return false;
                }
            }else {
                if(map.containsValue(tTemp)){
                    return false;
                }else {
                    map.put(sTemp,tTemp);
                }
            }
        }
        return true;
    }
}
