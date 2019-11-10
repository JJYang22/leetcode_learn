package DataStructure.MyHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Voidmian
 * @Date 2019/11/9 16:15
 */
public class GroupAnagrams49 {
    static public void test(){
        GroupAnagrams49 groupAnagrams49 = new GroupAnagrams49();
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams49.groupAnagrams(strs);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if(strs == null)
            return ans;
        Map<Integer,Integer> group = new HashMap<>();
        for (String str:strs
             ) {
            int [] temp=new int[26] ;
            for (char c:str.toCharArray()
                 ) {
                temp[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <temp.length ; i++) {
                for(int j = 0; j<temp[i];j++){
                    sb.append((char)(i+'a'));
                }
            }
            if(!group.containsKey(sb.toString().hashCode())){
                group.put(sb.toString().hashCode(),ans.size());
                ans.add(new ArrayList<>());
                ans.get(ans.size()-1).add(str);
            } else {
               ans.get(group.get(sb.toString().hashCode())).add(str);
            }
        }
        return ans;
    }
}
