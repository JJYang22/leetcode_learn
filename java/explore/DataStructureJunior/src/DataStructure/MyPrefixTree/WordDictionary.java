package DataStructure.MyPrefixTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 *
 * @Author Voidmian
 * @Date 2019/11/19 16:12
 */
public class WordDictionary {
    Map<Character, WordDictionary> map;
    boolean isExist;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        map = new HashMap<>();
        isExist = false;
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            isExist = true;
            return;
        }
        char temp = word.charAt(0);
        if (!map.containsKey(temp)) {
            map.put(temp, new WordDictionary());
        }
        map.get(temp).addWord(word.substring(1));
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return isExist;
        }
        char temp = word.charAt(0);
        if(temp != '.') {
            if (!map.containsKey(temp)) {
                return false;
            }
            return map.get(temp).search(word.substring(1));
        } else {
            List<WordDictionary> wordDictionaryList = new ArrayList<>(map.values());
            boolean ans = false;
            for (WordDictionary w: wordDictionaryList
                 ) {
                ans = ans || w.search(word.substring(1));
            }
            return ans;
        }
    }
}
