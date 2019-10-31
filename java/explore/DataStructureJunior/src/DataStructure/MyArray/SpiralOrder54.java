package DataStructure.MyArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Voidmian
 * @Date 2019/10/31 14:25
 */
public class SpiralOrder54 {
    static public void test() {
        SpiralOrder54 spiralOrder54 = new SpiralOrder54();
        int[][] nums = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        List<Integer> ans = spiralOrder54.spiralOrder(nums);
        for (int a : ans
        ) {
            System.out.print(a + " ");
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ans;

        int up = 0;
        int right = matrix[0].length-1;
        int down = matrix.length-1;
        int left = 0;
        int[] moveX = {0, 1, 0, -1};
        int[] moveY = {1, 0, -1, 0};
        int moveStatus = 0;

        int mr = 0, mc = 0;
        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            ans.add(matrix[mr][mc]);
            if (moveStatus == 0 && mc == right) {
                up++;
                moveStatus++;
            }
            if (moveStatus == 1 && mr == down) {
                right--;
                moveStatus++;
            }
            if (moveStatus == 2 && mc == left) {
                down--;
                moveStatus++;
            }
            if (moveStatus == 3 && mr == up) {
                left++;
                moveStatus=0;
            }
            mr += moveX[moveStatus];
            mc += moveY[moveStatus];
        }
        return ans;
    }
}
