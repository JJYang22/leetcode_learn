package DataStructure.MyHashSet;

import java.util.*;

/**
 * @Author Voidmian
 * @Date 2019/11/10 14:35
 */
public class RandomizedCollecion381 {

    static public void test() {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(1);
        randomizedCollection.insert(10);
        randomizedCollection.insert(10);
        randomizedCollection.insert(100);
        int count1=0;
        int count10=0;
        int count100=0;

        for (int i = 0; i <10000 ; i++) {
            int temp = randomizedCollection.getRandom();
            if(temp == 1)
                count1++;
            if(temp == 10)
                count10++;
            if(temp == 100)
                count100++;

        }
        System.out.println(count1+" "+count10+" "+count100+" ");


    }
}

class RandomizedCollection {
    Map<Integer, List<Integer>> randomizedSet;
    List<Integer> set;
    Random random = new Random();
    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        randomizedSet = new HashMap<>();
        set = new LinkedList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (randomizedSet.containsKey(val)) {
            randomizedSet.get(val).add(set.size());
            set.add(val);
            return false;
        } else {
            randomizedSet.put(val, new ArrayList<>());
            randomizedSet.get(val).add(set.size());
            set.add(val);
        }

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (randomizedSet.containsKey(val)) {
            List<Integer> indexs = randomizedSet.get(val);
            int num = indexs.size();
            int last = set.get(set.size() - 1);
            int index;
            if (num == 1) {
                index = indexs.get(0);
                randomizedSet.remove(val);
            } else {
                index = indexs.remove(num - 1);
            }
            set.set(index, last);
            set.remove(set.size() - 1);
            if (randomizedSet.containsKey(last)) {
                indexs = randomizedSet.get(last);
                for (int i = 0; i < indexs.size(); i++) {
                    if (indexs.get(i) > index) {
                        int temp = index;
                        index = indexs.get(i);
                        indexs.set(i, temp);
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (randomizedSet == null || randomizedSet.size() == 0)
            return -1;
        int index = random.nextInt(set.size());
        return set.get(index);
    }

}