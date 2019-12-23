package DynamicProgramming;

/**
 * @Author Voidmian
 * @Date 2019/12/22 20:11
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters395 {
    public static void main(String[] args) {

    }

    public int longestSubstring(String s, int k) {
        if (s == null) {
            return 0;
        }
        return count(s.toCharArray(), 0, s.length(), k);
    }

    private int count(char[] str, int head, int rear, int k) {
        if (rear - head < k) {
            return 0;
        }
        int[] chars = new int[26];
        for (int i = head; i < rear; i++) {
            chars[str[i] - 'a']++;
        }
        while (rear - head >= k && chars[str[head] - 'a'] < k) {
            head++;
        }
        while (rear - head >= k && chars[str[rear - 1] - 'a'] < k) {
            rear--;
        }
        if (rear - head < k) {
            return 0;
        }
        for (int i = head; i < rear; i++) {
            if (chars[str[i] - 'a'] < k) {
                while (chars[str[i + 1] - 'a'] < k) {
                    i++;
                }
                return Math.max(count(str, head, i, k), count(str, i + 1, rear, k));
            }
        }
        return rear - head;
    }
}
