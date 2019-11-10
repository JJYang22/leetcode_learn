package DataStructure.MyHashSet;

import java.util.*;

/**
 * @Author Voidmian
 * @Date 2019/11/10 11:06
 */
public class RandomizedSet380 {
    class RandomizedSet {
        Map<Integer,Integer> randomizedSet ;
        List<Integer> set ;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            randomizedSet = new HashMap<>();
            set = new LinkedList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(randomizedSet.containsKey(val))
                return false;
            randomizedSet.put(val,set.size());
            set.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(randomizedSet.containsKey(val)){
                int index=randomizedSet.get(val);
                int last = set.get(set.size()-1);
                set.set(index,last);
                randomizedSet.put(last,index);
                set.remove(set.size()-1);
                randomizedSet.remove(val);
                return true;
            }
            return false;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            if(randomizedSet ==null || randomizedSet.size() == 0)
                return -1;
            Random random = new Random();
            int index = random.nextInt(set.size());
            return set.get(index);
        }
    }

}
