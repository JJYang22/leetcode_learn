package DataStructure.MyPrefixTree;

import java.util.*;
import java.util.stream.Collector;

/**
 * @Author Voidmian
 * @Date 2019/11/19 14:05
 */
public class MapSum {
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("aa",3);
        mapSum.insert("aa",2);
        System.out.println(mapSum.sum("a"));
    }
    Map<Character, MapSum> map;
    int sum;

    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
        sum = 0;
    }

    public void insert(String key, int val) {
        if (key == null || key.length() == 0) {
            sum = val;
            return;
        }
        char temp = key.charAt(0);
        if (!map.containsKey(temp)) {
            map.put(temp, new MapSum());
        }
        map.get(temp).insert(key.substring(1),val);
    }

    public int sum(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return fun(this);
        }
        char temp = prefix.charAt(0);
        if (!map.containsKey(temp)) {
            return 0;
        }
        return map.get(temp).sum(prefix.substring(1));
    }
    private int fun(MapSum smap){
        if(smap.map.size() == 0){
            return smap.sum;
        }
        int ans=0;
        for (MapSum mapsum : smap.map.values()) {
            ans+= fun(mapsum);
        }
        return smap.sum + ans;
    }

}
