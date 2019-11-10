package DataStructure.MyHashSet;

import java.util.LinkedList;

/**
 * @Author Voidmian
 * @Date 2019/11/5 16:51
 */
public class MyHashMap {
    static public void test(){
        MyHashMap myHashMap =new MyHashMap();
        myHashMap.put(1,2);
        System.out.println();

    }
    /** Initialize your data structure here. */
    LinkedList<Integer>[] values;
    LinkedList<Integer>[] keys;
    int length=1000;
    public MyHashMap() {
        values = new LinkedList[length];
        keys = new LinkedList[length];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashCode = Integer.hashCode(key)%length;
        if(keys[hashCode] == null){
            keys[hashCode] = new LinkedList<>();
            values[hashCode] = new LinkedList<>();
        }
        if(keys[hashCode].contains(key)) {
            values[hashCode].set(keys[hashCode].indexOf((Integer) key), value);
        }else {
            keys[hashCode].add(key);
            values[hashCode].add(value);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashCode = Integer.hashCode(key)%length;
        if(keys[hashCode] == null)
            return -1;
        if(keys[hashCode].contains(key)) {
            return values[hashCode].get(keys[hashCode].indexOf((Integer) key));
        }else {
            return -1;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashCode = Integer.hashCode(key)%length;
        if(keys[hashCode] == null)
            return;
        if(keys[hashCode].contains(key)) {
            values[hashCode].remove(keys[hashCode].indexOf((Integer) key));
            keys[hashCode].remove((Integer)key);
        }else {
            return;
        }
    }
}
