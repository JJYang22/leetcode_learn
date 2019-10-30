package DataStructure.MyQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Voidmian
 * @Date 2019/10/26 19:03
 */
public class NumSquares {
    static public void test() {
        NumSquares numSquares = new NumSquares();
        System.out.println(numSquares.numSquares(13));
    }

    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; ++i) {
            squares.add(i * i);
        }
        int ans = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = squares.size() - 1; j >= 0; j--) {
                    int temp = cur - squares.get(j);
                    if (temp == 0)
                        return ans + 1;
                    if (temp > 0)
                        queue.offer(temp);
                }
            }
        }
        return -1;
    }
}
