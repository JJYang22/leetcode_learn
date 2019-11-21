package DataStructure.MyPrefixTree;

import DataStructure.Obj.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Voidmian
 * @Date 2019/11/19 15:17
 */
public class ReplaceWords648 {
    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for (String str : dict) {
            trie.insert(str);
        }
        String[] words = sentence.split(" ");
        String ans = "";
        for (int i = 0; i < words.length - 1; i++) {
            ans += trie.replace(words[i], 0) + " ";
        }
        ans += trie.replace(words[words.length - 1], 0);
        return ans;
    }

    public class Trie {

        Map<Character, Trie> map;
        boolean isExist;

        public Trie() {
            map = new HashMap<>();
            isExist = false;
        }

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

        public String replace(String word, int count) {
            if (isExist  || word.length() == count) {
                return word.substring(0,count);
            }
            char temp = word.charAt(count++);
            if (!map.containsKey(temp)) {
                return word;
            }
            return map.get(temp).replace(word,count);
        }
    }
}
