package DataStructure.MyBinarySearch;

/**
 * @Author Voidmian
 * @Date 2019/11/15 14:44
 */
public class IsPerfectSquare367 {
    static public void test() {
        IsPerfectSquare367 isPerfectSquare367 = new IsPerfectSquare367();
        System.out.println(isPerfectSquare367.isPerfectSquare(2147483647));
    }

    public boolean isPerfectSquare(int num) {
        int begin = 0;
        int end = num;
        int mid = begin + (end - begin) / 2;
        while (begin <= end) {
            long value = mid * mid;
            if (value == num) {
                return true;
            }
            if (value  > num){
                end =mid - 1;
            } else {
                begin = mid + 1;
            }
            mid = begin + (end - begin) / 2;
        }
        return false;
    }
}
