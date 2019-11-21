package DataStructure.MyString;

/**
 * @Author Voidmian
 * @Date 2019/11/21 9:15
 */
public class ShortestPalindrome214 {
    public static void main(String[] args) {
        ShortestPalindrome214 shortestPalindrome214 = new ShortestPalindrome214();
        System.out.println(shortestPalindrome214.shortestPalindrome("aacecaaa"));
    }
//暴力法 需要改进
    public String shortestPalindrome(String s) {
        int i = 0;
        for (; i <= s.length(); i++) {
            String temp = s.substring(0, s.length() - i);
            if (isPalindrome(temp)) {
                break;
            }
        }
        StringBuilder sBuilder = new StringBuilder(s);
        for (int j = 1; j <= i; j++) {
            sBuilder.insert(j - 1, sBuilder.charAt(sBuilder.length() - j));
        }
        s = sBuilder.toString();
        return s;
    }
    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
