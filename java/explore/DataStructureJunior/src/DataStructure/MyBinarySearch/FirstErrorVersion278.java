package DataStructure.MyBinarySearch;

/**
 * @Author Voidmian
 * @Date 2019/11/14 10:49
 */
public class FirstErrorVersion278 {
    public int firstBadVersion(int n) {
        long begin = 1;
        long end = n - 1;
        int index = (int)((begin + end) / 2);
        while (begin <= end) {
            if (isBadVersion(index) && !isBadVersion(index - 1)) {
                return index;
            }
            if (isBadVersion(index)) {
                end = index;
            } else {
                begin = index + 1;
            }
            index = index = (int)((begin + end) / 2);
        }
        if(begin <= n && isBadVersion((int)begin) && !isBadVersion((int)begin - 1))
            return (int)begin;
        return -1;
    }

    private boolean isBadVersion(int version) {
        return false;
    }
}
