package DynamicProgramming;

import java.util.*;

/**
 * @Author Voidmian
 * @Date 2019/12/29 16:36
 */
public class LongestIncreasingPathInAMatrix329 {
    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix329 longestIncreasingPathInAMatrix329 = new LongestIncreasingPathInAMatrix329();
        int[][] matrix = {{3,2,3}, {2,1,2},{3,2,3}};
        System.out.println(longestIncreasingPathInAMatrix329.longestIncreasingPath(matrix));
    }
    private static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;
    public int longestIncreasingPath(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        // padding the matrix with zero as boundaries
        // assuming all positive integer, otherwise use INT_MIN as boundaries
        int[][] matrix = new int[m + 2][n + 2];
        for (int i = 0; i < m; ++i)
            System.arraycopy(grid[i], 0, matrix[i + 1], 1, n);

        // calculate outdegrees
        int[][] outdegree = new int[m + 2][n + 2];
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                for (int[] d: dir)
                    if (matrix[i][j] < matrix[i + d[0]][j + d[1]])
                        outdegree[i][j]++;

        // find leaves who have zero out degree as the initial level
        n += 2;
        m += 2;
        List<int[]> leaves = new ArrayList<>();
        for (int i = 1; i < m - 1; ++i)
            for (int j = 1; j < n - 1; ++j)
                if (outdegree[i][j] == 0) leaves.add(new int[]{i, j});

        // remove leaves level by level in topological order
        int height = 0;
        while (!leaves.isEmpty()) {
            height++;
            List<int[]> newLeaves = new ArrayList<>();
            for (int[] node : leaves) {
                for (int[] d:dir) {
                    int x = node[0] + d[0], y = node[1] + d[1];
                    if (matrix[node[0]][node[1]] > matrix[x][y])
                        if (--outdegree[x][y] == 0)
                            newLeaves.add(new int[]{x, y});
                }
            }
            leaves = newLeaves;
        }
        return height;
    }


/** DFS
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int width = matrix[0].length;
        int height = matrix.length;
        int[][] dp = new int[height][width];
        boolean[][] used = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(used[i], false);
        }
        int ans = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!used[i][j]) {
                    ans = Math.max(fun(matrix, dp, used, i, j, width, height), ans);
                }
            }
        }
        return ans;
    }

    private int fun(int[][] matrix, int[][] dp, boolean[][] used, int x, int y, int width, int height) {
        int[] heightMove = {1, 0, -1, 0};
        int[] widthMove = {0, 1, 0, -1};
        int tempAns = 1;
        for (int l = 0; l < 4; l++) {
            int xTemp = x + heightMove[l];
            int yTemp = y + widthMove[l];
            if ((xTemp < height && xTemp >= 0) && (yTemp < width && yTemp >= 0)) {
                if (matrix[xTemp][yTemp] > matrix[x][y]) {
                    if (used[xTemp][yTemp]) {
                        tempAns = Math.max(1 + dp[xTemp][yTemp], tempAns);
                    } else {
                        tempAns = Math.max(tempAns, 1 + fun(matrix, dp, used, xTemp, yTemp, width, height));
                    }
                }
            }
        }
        dp[x][y] = tempAns;
        used[x][y] = true;
        return tempAns;
    }
*/
    /** BFS
     *
     * @param matrix
     * @return public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
    return 0;
    }
    int width = matrix[0].length;
    int height = matrix.length;
    int[] heightMove = {1, 0, -1, 0};
    int[] widthMove = {0, 1, 0, -1};
    Queue<Integer> Queue = new LinkedList<Integer>();
    int[][] dp = new int[height][width];
    boolean[][] used = new boolean[height][width];
    for (int i = 0; i < height; i++) {
    Arrays.fill(used[i], false);
    }
    int ans = 0;
    for (int i = 0; i < height; i++) {
    for (int j = 0; j < width; j++) {
    if (used[i][j] == true) {
    break;
    }
    int tempAns = 0;
    used[i][j] = true;
    Queue.offer(i);
    Queue.offer(j);
    while (!Queue.isEmpty()) {
    dp[i][j]++;
    int length = Queue.size() / 2;
    for (int k = 0; k < length; k++) {
    int x = Queue.poll();
    int y = Queue.poll();
    for (int l = 0; l < 4; l++) {
    int xTemp = x + heightMove[l];
    int yTemp = y + widthMove[l];
    if ((xTemp < height && xTemp >= 0) && (yTemp < width && yTemp >= 0)) {
    if (matrix[xTemp][yTemp] > matrix[x][y]) {
    if (used[xTemp][yTemp]) {
    tempAns = Math.max(dp[i][j] + dp[xTemp][yTemp], tempAns);
    } else {
    Queue.offer(xTemp);
    Queue.offer(yTemp);
    }
    }
    }
    }
    }
    }
    dp[i][j] = Math.max(tempAns, dp[i][j]);
    ans = Math.max(dp[i][j], ans);
    }
    }
    return ans;
    }
     */
}
