package DataStructure.MyHashMap;

import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Author Voidmian
 * @Date 2019/11/7 19:18
 */
public class MinimumIndexSumOfTwoLists599 {
    static public void test(){
        String [] list1 ={"a","b","c"};
        String [] list2= {"a"};
        MinimumIndexSumOfTwoLists599 minimumIndexSumOfTwoLists599 = new MinimumIndexSumOfTwoLists599();
        String[] ans = minimumIndexSumOfTwoLists599.findRestaurant(list1, list2);

    }
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> map = new HashMap<>();
        String[] listShort;
        String[] listLong;
        if (list1.length < list2.length) {
            listShort = list1;
            listLong = list2;
        } else {
            listShort = list2;
            listLong = list1;
        }
        for (int i = 0; i < listShort.length; i++) {
            map.put(listShort[i], i);
        }
        List<String> listString =new ArrayList<>();
        for (int i = 0; i < listLong.length ; i++) {
            if(map.containsKey(listLong[i])){
                int temp=i+map.get(listLong[i]);
                map.put(listLong[i],temp);
                if(listString.size() == 0){
                    listString.add(listLong[i]);
                    continue;
                }
                if(temp<map.get(listString.get(0))){
                    listString = new ArrayList<>();
                    listString.add(listLong[i]);
                }else if(temp == map.get(listString.get(0))){
                    listString.add(listLong[i]);
                }
            }
        }
        String [] ans = new String[listString.size()];
        for (int i = 0; i < listString.size() ; i++) {
            ans[i]=listString.get(i);
        }
        return ans;
    }
}
