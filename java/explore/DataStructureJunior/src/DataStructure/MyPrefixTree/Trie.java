package DataStructure.MyPrefixTree;

import DataStructure.MyLinkList.HasCycleII142;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Voidmian
 * @Date 2019/11/19 13:36
 */
public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.startsWith("app");
    }


    Map<Character, Trie> map;
    boolean isExist;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        map = new HashMap<>();
        isExist = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            isExist = true;
            return;
        }
        char temp = word.charAt(0);
        if (!map.containsKey(temp)) {
            map.put(temp, new Trie());
        }
        map.get(temp).insert(word.substring(1));
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return isExist;
        }
        char temp = word.charAt(0);
        if (!map.containsKey(temp)) {
            return false;
        }
        return map.get(temp).search(word.substring(1));
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return true;
        }
        char temp = prefix.charAt(0);
        if (!map.containsKey(temp)) {
            return false;
        }
        return map.get(temp).startsWith(prefix.substring(1));
    }
}
