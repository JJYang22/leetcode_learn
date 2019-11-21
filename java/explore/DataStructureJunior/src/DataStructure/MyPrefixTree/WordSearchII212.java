package DataStructure.MyPrefixTree;

import java.util.*;

/**
 * @Author Voidmian
 * @Date 2019/11/19 19:45
 */
public class WordSearchII212 {
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'o'},
                {'i', 'h', 'e', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words ={"oath","pea","eat","rain","oaan"};
        WordSearchII212 wordSearchII212 = new WordSearchII212();
        List<String> ans = wordSearchII212.findWords(board,words);
        System.out.println();
    }


    public List<String> findWords(char[][] board, String[] words) {
        /**
         * 初始化
         * */
        List<String> ans = new ArrayList<>();
        if (words == null || words.length < 1 || board == null || board.length == 0 || board[0].length == 0) {
            return ans;
        }
        int height = board.length;
        int width = board[0].length;
        boolean[][] used = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(used[i], false);
        }
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], 0);
        }
        /**
         * 开始寻找
         * */
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                fun(i, j, board, used, height, width, trie, "", ans);
            }
        }
        return ans;
    }

    private void fun(int i, int j, char[][] board, boolean[][] used, int height, int width, Trie trie, String str, List<String> ans) {
        if (i < 0 || i >= height || j < 0 || j >= width || used[i][j] || trie == null || trie.map.size() == 0) {
            return;
        }
        str += board[i][j];
        if (!trie.map.containsKey(str)) {
            return;
        }
        used[i][j] = true;
        Trie next = trie.map.get(str);
        if (next.isExist) {
            ans.add(str);
            next.isExist = false;
        }
        if(next.map.size() == 0){
            trie.map.remove(str);
        }
        fun(i + 1, j, board, used, height, width, next, str, ans);
        fun(i - 1, j, board, used, height, width, next, str, ans);
        fun(i, j + 1, board, used, height, width, next, str, ans);
        fun(i, j - 1, board, used, height, width, next, str, ans);
        used[i][j] = false;
        if(next.map.size() == 0){
            trie.map.remove(str);
        }
    }


    public class Trie {
        public Map<String, Trie> map;
        public boolean isExist;

        public Trie() {
            map = new HashMap<>();
            isExist = false;
        }

        public void insert(String word, int index) {
            if (word == null || word.length() == index) {
                isExist = true;
                return;
            }
            String temp = word.substring(0, ++index);
            if (!map.containsKey(temp)) {
                map.put(temp, new Trie());
            }
            map.get(temp).insert(word, index);
        }


    }
}
