package DataStructure.MyBinarySearch;

/**
 * @Author Voidmian
 * @Date 2019/11/15 19:33
 */
public class FindMedianSortedArrays4 {
    static public void test() {
        FindMedianSortedArrays4 findMedianSortedArrays4 = new FindMedianSortedArrays4();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double ans = findMedianSortedArrays4.findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return -1;
        }
        if (nums1.length == 0) {
            if (nums2.length % 2 == 0) {
                return (double) (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2;
            } else {
                return nums2[nums2.length / 2];
            }
        }
        if (nums2.length == 0) {
            if (nums1.length % 2 == 0) {
                return (double) (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2;
            } else {
                return nums1[nums1.length / 2];
            }
        }

        int[] Long, Short;
        boolean isOdd = false;
        int length = nums1.length + nums2.length;
        if (length % 2 != 0) {
            length++;
            isOdd = true;
        }
        length /= 2;
        if (nums1.length < nums2.length) {
            Short = nums1;
            Long = nums2;
        } else {
            Short = nums2;
            Long = nums1;
        }
        int beginShort = 0;
        int endShort = Short.length;
        int indexShort = 0, indexLong = 0;

        while (beginShort <= endShort) {
            indexShort = beginShort + (endShort - beginShort) / 2;
            indexLong = length - indexShort;
            if (indexShort == 0) {
                if (Long[indexLong - 1] <= Short[indexShort]) {
                    break;
                } else {
                    beginShort = indexShort + 1;
                }
            } else if (indexShort == Short.length) {
                if (Short[indexShort - 1] <= Long[indexLong]) {
                    break;
                } else {
                    endShort = indexShort - 1;
                }
            } else {
                if (Short[indexShort - 1] <= Long[indexLong] && Long[indexLong - 1] < Short[indexShort]) {
                    break;
                }
                if (Short[indexShort - 1] > Long[indexLong]) {
                    endShort = indexShort - 1;
                } else {
                    beginShort = indexShort + 1;
                }
            }
        }
        if (isOdd) {
            if (indexShort == 0)
                return Long[indexLong - 1];
            if (Short[indexShort - 1] > Long[indexLong - 1]) {
                return Short[indexShort - 1];
            } else {
                return Long[indexLong - 1];
            }
        } else {
            double ans = 0;
            if (indexShort - 1 < 0) {
                ans = Long[indexLong - 1];
            } else if (indexLong - 1 < 0) {
                ans = Short[indexShort - 1];
            } else {
                if (Short[indexShort - 1] > Long[indexLong - 1]) {
                    ans = Short[indexShort - 1];
                } else {
                    ans = Long[indexLong - 1];
                }
            }
            if (indexShort >= Short.length) {
                ans += Long[indexLong];
            } else if (indexLong >= Long.length) {
                ans += Short[indexShort];
            } else {
                if (Short[indexShort] > Long[indexLong]) {
                    ans += Long[indexLong];
                } else {
                    ans += Short[indexShort];
                }
            }
            return ans / 2;
        }
    }
}
