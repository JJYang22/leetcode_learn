package DataStructure.MyArray;

/**
 * @Author Voidmian
 * @Date 2019/10/31 13:36
 */
public class FindDiagonalOrder498 {
    static public void test() {
        FindDiagonalOrder498 findDiagonalOrder498 = new FindDiagonalOrder498();
        int[][] nums = {{1, 2, 6}, {3, 5, 7}, {4, 8, 9}};
        int[] ans = findDiagonalOrder498.findDiagonalOrder(nums);
        for (int a : ans
        ) {
            System.out.print(a + " ");
        }
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int [0];
        int height = matrix.length;
        int width = matrix[0].length;
        boolean isObliqueUp = true;
        int[] ans = new int[height * width];
        int mr = 0, mc = 0;
        for (int i = 0; i < ans.length; i++) {
            ans[i] = matrix[mr][mc];
            if (isObliqueUp) {
                if (mc == width - 1) {
                    isObliqueUp = !isObliqueUp;
                    mr += 1;
                    continue;
                }
                if (mr == 0) {
                    isObliqueUp = !isObliqueUp;
                    mc += 1;
                    continue;
                }
                mr -= 1;
                mc += 1;
            } else {
                if (mr == height - 1) {
                    isObliqueUp = !isObliqueUp;
                    mc += 1;
                    continue;
                }
                if (mc == 0) {
                    isObliqueUp = !isObliqueUp;
                    mr += 1;
                    continue;
                }
                mr += 1;
                mc -= 1;
            }

        }
        return ans;
    }
}
