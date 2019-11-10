package DataStructure.MyHashMap;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Voidmian
 * @Date 2019/11/9 20:28
 */
public class JewelsAndStones771 {
    public int numJewelsInStones(String J, String S) {
        if(J == null || S == null || J.length() == 0 || S.length() == 0)
            return 0;
        int ans = 0;
        Set<Character> Jewels = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            Jewels.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if(Jewels.contains(S.charAt(i))){
                ans++;
            }
        }
        return ans;
    }
}
