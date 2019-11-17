package DataStructure.MyBinarySearch;

import DataStructure.MyHashMap.GroupAnagrams49;

/**
 * @Author Voidmian
 * @Date 2019/11/12 18:06
 */
public class GuessNum {
    static public void test(){
        GuessNum guessNum = new GuessNum();
        guessNum.guessNumber(2126753390);
    }
    public int guessNumber(int n) {
        return binarySearch(1, n);
    }
    private int binarySearch(long begin, long end) {
        int index =(int) ((begin + end )/ 2);
        int ans = guess(index);
        if (ans == 0) {
            return index;
        }
        if (ans > 0) {
            return binarySearch(index + 1 , end);
        } else {
            return binarySearch(begin, index );
        }
    }
    private int guess(int n){
        if(n == 1702766719)
            return 0;
        if(n>1702766719)
            return -1;
        else
            return 1;
    }
}
