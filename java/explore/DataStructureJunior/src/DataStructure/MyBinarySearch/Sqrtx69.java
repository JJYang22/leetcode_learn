package DataStructure.MyBinarySearch;

/**
 * @Author Voidmian
 * @Date 2019/11/12 17:09
 */
public class Sqrtx69 {
    public int mySqrt(int x) {
        return sqrt(x, 0, x);
    }

    private int sqrt(int x, long begin, long end) {
        if (begin > end)
            return -1;
        long index = (begin + end) / 2;
        if (index * index == x || (index * index < x && (index + 1) * (index + 1) > x)) {
            return (int)index;
        }
        if (index * index < x) {
            return sqrt(x, index + 1, end);
        } else {
            return sqrt(x, begin, index);
        }
    }
}
