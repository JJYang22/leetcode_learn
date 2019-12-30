package GraphTheory;

import javax.print.DocFlavor;
import java.util.*;

/**
 * @Author Voidmian
 * @Date 2019/12/29 21:28
 */
public class WordLadder127 {
    public static void main(String[] args) {
        WordLadder127 wordLadder127 = new WordLadder127();

        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
//        wordList.add("tot");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(wordLadder127.ladderLength("hit", "cog", wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /** 单次一个方向搜索的双向BFS */
        HashMap<String, List<String>> map = new HashMap<>();
        boolean isAns = true;
        for (String word : wordList) {
            if (word.equals(endWord)) {
                isAns = false;
            }
            for (int i = 0; i < word.length(); i++) {
                String temp = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
                if (map.containsKey(temp)) {
                    map.get(temp).add(word);
                } else {
                    List<String> tempList = new ArrayList<>();
                    tempList.add(word);
                    map.put(temp, tempList);

                }
            }
        }
        if (isAns) {
            return 0;
        }
        Set<String> beginUsed = new HashSet<>();
        Set<String> endUsed = new HashSet<>();
        Queue<String> beginQueue = new LinkedList<>();
        Queue<String> endQueue = new LinkedList<>();
        int ans = 0;
        beginQueue.offer(beginWord);
        endQueue.offer(endWord);
        beginUsed.add(beginWord);
        endUsed.add(endWord);
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int beginLength = beginQueue.size();
            int endLength = endQueue.size();
            int length = beginLength;
            Set<String> used = beginUsed;
            Queue<String> queue = beginQueue;
            if (beginLength > endLength) {
                length = endLength;
                used = endUsed;
                queue = endQueue;
            }
            ans++;
            for (int i = 0; i < length; i++) {
                String word = queue.poll();
                if (endUsed.contains(word) && beginUsed.contains(word)) {
                    return ans ;
                }
                for (int j = 0; j < word.length(); j++) {
                    String temp = word.substring(0, j) + "*" + word.substring(j + 1, word.length());
                    List<String> strings = map.get(temp);
                    if (strings != null && strings.size() > 0) {
                        for (String string : strings) {
                            if (endUsed.contains(word) && beginUsed.contains(word)) {
                                return ans + 1;
                            }
                            if (!used.contains(string)) {
                                used.add(string);
                                queue.offer(string);
                            }
                        }
                    }
                }
            }

        }
        return 0;

        /** 邻接表+BFS
         HashMap<String, List<String>> map = new HashMap<>();
         for (String word:wordList) {
         for (int i = 0; i < word.length(); i++) {
         String temp = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
         if (map.containsKey(temp)) {
         map.get(temp).add(word);
         } else {
         List<String> tempList = new ArrayList<>();
         tempList.add(word);
         map.put(temp, tempList);

         }
         }
         }
         Set<String> used = new HashSet<>();
         Queue<String> queue = new LinkedList<>();
         int ans = 0;
         queue.offer(beginWord);
         used.add(beginWord);
         while (!queue.isEmpty()) {
         int length = queue.size();
         ans++;
         for (int i = 0; i < length; i++) {
         String word = queue.poll();
         if (word.equals(endWord)) {
         return ans;
         }
         for (int j = 0; j < word.length(); j++) {
         String temp = word.substring(0, j) + "*" + word.substring(j + 1, word.length());
         List<String> strs = map.get(temp);
         if (strs != null && strs.size() > 0) {
         for (String str:strs) {
         if (!used.contains(str)) {
         used.add(str);
         queue.offer(str);
         }
         }
         }
         }
         }
         }
         return 0;
         */
        /** 单向BFS
         Set<String> used = new HashSet<>();
         Queue<String> queue = new LinkedList<>();
         int ans = 0;
         queue.offer(beginWord);
         used.add(beginWord);
         while (!queue.isEmpty()) {
         int length = queue.size();
         ans++;
         for (int i = 0; i < length; i++) {
         String str = queue.poll();
         if (str.equals(endWord)) {
         return ans;
         }
         for (String strInList: wordList) {
         if (!used.contains(strInList)) {
         if (isLegal(str, strInList)) {
         queue.offer(strInList);
         used.add(strInList);
         }
         }
         }
         }
         }
         return 0;
         */
    }

    public boolean isLegal(String source, String target) {
        if (source.length() != target.length()) {
            return false;
        }
        char[] sources = source.toCharArray();
        char[] targets = target.toCharArray();
        int temp = 0;
        for (int i = 0; i < source.length(); i++) {
            if (sources[i] != targets[i]) {
                temp++;
            }
        }
        if (temp == 1) {
            return true;
        } else {
            return false;
        }
    }
}
