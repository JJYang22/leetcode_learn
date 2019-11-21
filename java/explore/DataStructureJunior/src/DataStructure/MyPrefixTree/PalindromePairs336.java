package DataStructure.MyPrefixTree;

import DataStructure.MyArray.PascalTriangle118;

import java.util.*;

/**
 * @Author Voidmian
 * @Date 2019/11/20 10:51
 */
public class PalindromePairs336 {
    public static void main(String[] args) {
        PalindromePairs336 palindromePairs336 = new PalindromePairs336();
        String[] words = {"baabaa", "b"};
        List<List<Integer>> ans = palindromePairs336.palindromePairs(words);
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if (words == null || words.length < 2) {
            return ans;
        }
        Trie trie = new Trie();
        Set<String> palindromes = new HashSet<>();
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String temp = word.substring(0, i);
                if (isPalindrome(temp)) {
                    palindromes.add(temp);
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], i, palindromes);
        }
        for (int i = 0; i < words.length; i++) {
            fun(words[i], i, palindromes, trie, ans);
        }
        return ans;
    }

    private void fun(String word, int index, Set<String> palindromes, Trie trie, List<List<Integer>> ans) {
        if (word.length() == 0 || trie.isExist) {
            if (word.length() == 0 && trie.isPalindrome) {
                for (Integer i : trie.index) {
                    if (index != i) {
                        ans.add(new ArrayList<>());
                        ans.get(ans.size() - 1).add(index);
                        ans.get(ans.size() - 1).add(i);
                    }
                }
            }
            if (word.length() == 0 && trie.isExist) {
                if (index != trie.indexExist) {
                    ans.add(new ArrayList<>());
                    ans.get(ans.size() - 1).add(index);
                    ans.get(ans.size() - 1).add(trie.indexExist);
                }
            } else if (trie.isExist && isPalindrome(word)) {
                if (index != trie.indexExist) {
                    ans.add(new ArrayList<>());
                    ans.get(ans.size() - 1).add(index);
                    ans.get(ans.size() - 1).add(trie.indexExist);
                }
            }
        }
        if (word.length() != 0 && trie.map.size() != 0) {
            char temp = word.charAt(0);
            if (trie.map.containsKey(temp)) {
                Trie next = trie.map.get(temp);
                fun(word.substring(1), index, palindromes, next, ans);
            }
        }
    }

    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private class Trie {
        public Map<Character, Trie> map;
        boolean isPalindrome;
        boolean isExist;
        int indexExist;
        public List<Integer> index;

        Trie() {
            map = new HashMap<>();
            index = new ArrayList<>();
            isPalindrome = false;
            isExist = false;
        }

        void insert(String word, int index, Set<String> palindromes) {
            if (word == null || word.length() == 0) {
                isExist = true;
                indexExist = index;
                return;
            }
            if (palindromes.contains(word)) {
                isPalindrome = true;
                this.index.add(index);
            }
            char temp = word.charAt(word.length() - 1);
            if (!map.containsKey(temp)) {
                map.put(temp, new Trie());
            }
            map.get(temp).insert(word.substring(0, word.length() - 1), index, palindromes);
        }
    }
}
