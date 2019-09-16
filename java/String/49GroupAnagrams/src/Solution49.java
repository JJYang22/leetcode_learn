
import java.util.*;

public class Solution49 {
    public static void main(String[] args) {

        String [] strs={"eat","tea","tan","ate","nat","bat"};
        Solution s=new Solution() ;
        List<List<String>> ans=s.groupAnagrams(strs);
        for (List<String> l:ans) {
            for (String str:l) {
                System.out.print(str+" ");
            }
            System.out.println();
        }


    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer,ArrayList<String>> querymap=new HashMap<>();
        for (String str:strs) {
            char [] chars=str.toCharArray();
            Arrays.sort(chars);
            String temp=String.valueOf(chars);
            if(!querymap.containsKey(temp.hashCode()))
                querymap.put(temp.hashCode(),new ArrayList<>());
            querymap.get(temp.hashCode()).add(str);
        }
        return new ArrayList<>(querymap.values());
    }
}