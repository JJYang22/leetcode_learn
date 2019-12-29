package DataStructure.MyArray;

import DataStructure.MyPrefixTree.WordSearchII212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Voidmian
 * @Date 2019/12/24 12:30
 * , {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}
 */
public class ClockwisePrintMatrix {
    public static void main(String[] args) {
        ClockwisePrintMatrix clockwisePrintMatrix = new ClockwisePrintMatrix();
        int[][] matrix = {{}};
        ArrayList<Integer> ans = clockwisePrintMatrix.printMatrix(matrix);
        int num = 0;
        for (Integer i : ans
        ) {
            System.out.println(num + ":" + i);
            num++;
        }
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (matrix == null && matrix.length == 0 && matrix[0].length == 0) {
            return ans;
        }
        Set<Integer> used = new HashSet<>();
        int[] moveX = {0, 1, 0, -1};
        int[] moveY = {1, 0, -1, 0};
        int xMax = matrix.length;
        int yMax = matrix[0].length;
        int x = 0, y = 0;
        int moveTemp = 0;
        ans.add(matrix[x][y]);
        used.add(x * yMax + y);
        for (int i = 1; i < xMax * yMax;) {
            int xTemp = x + moveX[moveTemp];
            int yTemp = y + moveY[moveTemp];
            if (xTemp >= 0 && xTemp < xMax && yTemp >= 0 && yTemp < yMax && !used.contains(xTemp * yMax + yTemp)) {
                x = xTemp;
                y = yTemp;
                ans.add(matrix[x][y]);
                used.add(x * yMax + y);
                i++;
            } else {
                if (moveTemp == 3) {
                    moveTemp = 0;
                } else {
                    moveTemp++;
                }
            }
        }
        return ans;
    }

    /** 正方形
     public ArrayList<Integer> printMatrix(int[][] matrix) {
     ArrayList<Integer> ans = new ArrayList<>();
     if (matrix == null && matrix.length == 0) {
     return ans;
     }

     int[] moveX = {0, 1, 0, -1};
     int[] moveY = {1, 0, -1, 0};

     int x = 0, y = 0;
     int n = matrix.length - 1;
     boolean isSub = false;
     boolean isFirst = true;
     ans.add(matrix[x][y]);

     while (n > 0) {
     for (int moveTemp = 0; moveTemp < 4; moveTemp++) {
     for (int i = 0; i < n; i++) {
     x += moveX[moveTemp];
     y += moveY[moveTemp];
     ans.add(matrix[x][y]);
     }
     if (isFirst) {
     isFirst = false;
     } else {
     if (isSub) {
     n--;
     isSub = false;
     } else {
     isSub = true;
     }
     }
     }
     }
     return ans;
     }
     */

//    public ArrayList<Integer> printMatrix1(int[][] matrix) {
//        ArrayList<Integer> result = new ArrayList<Integer>();
//        if (matrix == null) return result;
//        else {
//            int H = matrix.length - 1;
//            int L = matrix[0].length - 1;
//            int upBorder = 0;
//            int downBorder = H;
//            int leftBorder = 0;
//            int rightBorder = L;
//
//            while (upBorder <= downBorder && leftBorder <= rightBorder) {
//                for (int i = leftBorder; i <= rightBorder; i++) {
//                    result.add(matrix[upBorder][i]);
//                }
//                upBorder++;
//                for (int i = upBorder; i <= downBorder; i++) {
//                    result.add(matrix[i][rightBorder]);
//                }
//                rightBorder--;
//                if (upBorder <= downBorder) {
//                    for (int i = rightBorder; i >= leftBorder; i--) {
//                        result.add(matrix[downBorder][i]);
//                    }
//                }
//                downBorder--;
//                if (leftBorder <= rightBorder) {
//                    for (int i = downBorder; i >= upBorder; i--) {
//                        result.add(matrix[i][leftBorder]);
//                    }
//                }
//                leftBorder++;
//            }
//            return result;
//        }
//    }
//
//
//    public ArrayList<Integer> printMatrix(int[][] matrix) {
//        ArrayList<Integer> result = new ArrayList<Integer>();
//        if (matrix == null) return result;
//        else {
//            int L = matrix.length - 1;
//            int row1 = 0;
//            int row2 = L;
//            int col1 = L;
//            int col2 = 0;
//            int row1S = 0;
//            int row1E = L;
//            int col1S = 0;
//            int col1E = L;
//            int row2S = L;
//            int row2E = 0;
//            int col2S = L;
//            int col2E = 0;
//
//            while (col2E <= col2S) {
//                if (row1S == row2S)
//                    result.add(matrix[row1S][col1S]);
//                else {
//                    for (int i = row1S; i <= row1E; i++) {
//                        result.add(matrix[row1][i]);
//                    }
//                    row1S++;
//                    row1E--;
//                    row1++;
//                    for (int i = row1; i <= col1E; i++) {
//                        result.add(matrix[i][col1]);
//                    }
//                    col1S++;
//                    col1E--;
//                    col1--;
//                    for (int i = col1; i >= row2E; i--) {
//                        result.add(matrix[row2][i]);
//                    }
//                    row2S--;
//                    row2E++;
//                    row2--;
//                    for (int i = row2; i > col2E; i--) {
//                        result.add(matrix[i][col2]);
//                    }
//                    col2S--;
//                    col2E++;
//                    col2++;
//                }
//            }
//            return result;
//        }
//    }

}
