package GraphTheory;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Voidmian
 * @Date 2019/12/30 14:03
 */
public class NumberOfIslands200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int height = grid.length;
        int width = grid[0].length;

        Queue<Integer> queueH = new LinkedList<>();
        Queue<Integer> queueW = new LinkedList<>();

        int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int ans = 0;
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (grid[h][w] != '0') {
                    ans++;
                    queueH.offer(h);
                    queueW.offer(w);
                    grid[h][w] = '0';
                    while (!queueH.isEmpty() && !queueW.isEmpty()) {
                        int length = queueH.size();
                        for (int i = 0; i < length; i++) {
                            int hTemp = queueH.poll();
                            int wTemp = queueW.poll();
                            for (int j = 0; j < 4; j++) {
                                int hTempMove = hTemp + move[j][0];
                                int wTempMove = wTemp + move[j][1];
                                if (0 <= hTempMove && 0 <= wTempMove && height > hTempMove && width > wTempMove) {
                                    if (grid[hTempMove][wTempMove] != '0') {
                                        queueH.offer(hTempMove);
                                        queueW.offer(wTempMove);
                                        grid[hTempMove][wTempMove] = '0';
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
