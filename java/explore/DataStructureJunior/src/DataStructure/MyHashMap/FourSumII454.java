package DataStructure.MyHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Voidmian
 * @Date 2019/11/9 21:40
 */
public class FourSumII454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> used = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                sum = A[i] + B[j];
                used.put(sum,used.getOrDefault(sum,0)+1);
            }
        }
        int ans = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                sum = -C[i] - D[j];
                if(used.containsKey(sum)) {
                    ans += used.get(sum);
                }
            }
        }
        return ans;
    }
}
