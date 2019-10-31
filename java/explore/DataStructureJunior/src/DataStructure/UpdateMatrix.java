package DataStructure;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author Voidmian
 * @Date 2019/10/30 20:10
 */
public class UpdateMatrix {
    static public void test() {
        UpdateMatrix updateMatrix = new UpdateMatrix();
        int[][] image = {{1, 1, 1, 0, 0}, {1, 1, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        image = updateMatrix.updateMatrix(image);
        for (int[] ints : image) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix[0] == null)
            return null;
        int height = matrix.length;
        int width = matrix[0].length;
        int[] temp_x = {1, -1, 0, 0};
        int[] temp_y = {0, 0, 1, -1};
        int[][] ans = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    ans[i][j] = 0;
                } else {
                    Queue<Integer> queue_x = new LinkedList<>();
                    Queue<Integer> queue_y = new LinkedList<>();
                    Set<Integer> used = new HashSet<>();
                    queue_x.offer(i);
                    queue_y.offer(j);
                    used.add(i * width + j);
                    boolean isAns = false;
                    while (!queue_x.isEmpty() && !isAns) {
                        ans[i][j]++;
                        int size=queue_x.size();
                        for (int k = 0; k <size; k++)
                        {
                            int x = queue_x.poll();
                            int y = queue_y.poll();
                            for (int l = 0; l < 4; l++) {
                                int x_temp = x + temp_x[l];
                                int y_temp = y + temp_y[l];
                                if (0 <= x_temp && height > x_temp && y_temp >= 0 && y_temp < width && !used.contains(x_temp * width + y_temp)) {
                                    if (matrix[x_temp][y_temp] == 0) {
                                        isAns = true;
                                    } else {
                                        used.add(x_temp * width + y_temp);
                                        queue_x.offer(x_temp);
                                        queue_y.offer(y_temp);
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
