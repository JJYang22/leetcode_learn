package DataStructure.MyHashSet;

import java.util.LinkedList;

/**
 * @Author Voidmian
 * @Date 2019/11/5 16:27
 */
public class MyHashSet {
    /** Initialize your data structure here. */
    LinkedList<Integer> [] set;
    int length=1000;
    public MyHashSet() {
        set=new  LinkedList [length] ;
    }

    public void add(int key) {
        int hashCode=Integer.hashCode(key)%length;
        if(set[hashCode]== null) {
            set[hashCode] = new LinkedList<>();
            set[hashCode].add(key);
        }else if(!set[hashCode].contains(key)){
            set[hashCode].add(key);
        }
    }

    public void remove(int key) {
        int hashCode = Integer.hashCode(key) % length;
        if(set[hashCode]== null ||!set[hashCode].contains(key)){
            return;
        }
        set[hashCode].remove((Integer)key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashCode=Integer.hashCode(key)%length;
        if(set[hashCode]== null ||!set[hashCode].contains(key)){
            return false;
        }
        return true;
    }
}
