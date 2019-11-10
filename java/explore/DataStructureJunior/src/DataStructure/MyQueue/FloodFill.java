package DataStructure.MyQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Voidmian
 * @Date 2019/10/30 15:43
 */
public class FloodFill {
    static public void test() {
        FloodFill floodFill = new FloodFill();
        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        image=floodFill.floodFill(image,1,1,1);
        for (int i = 0; i <image.length ; i++) {
            for (int j = 0; j <image[0].length ; j++) {
                System.out.print(image[i][j]);
            }
            System.out.println();
        }


    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor)
            return image;
        int height = image.length;
        int width = image[0].length;
        int pre = image[sr][sc];
        int[] temp_x = {1, -1, 0, 0};
        int[] temp_y = {0, 0, 1, -1};

        Queue<Integer> queue_x = new LinkedList<>();
        Queue<Integer> queue_y = new LinkedList<>();
        image[sr][sc] = newColor;
        queue_x.offer(sr);
        queue_y.offer(sc);

        while (!queue_x.isEmpty()) {
            int x = queue_x.poll();
            int y = queue_y.poll();
            for (int i = 0; i < 4; i++) {
                int x_temp = x + temp_x[i];
                int y_temp = y + temp_y[i];
                if (0 <= x_temp && height > x_temp && y_temp >= 0 && y_temp < width && image[x_temp][y_temp] == pre) {
                    image[x_temp][y_temp] = newColor;
                    queue_x.add(x_temp);
                    queue_y.add(y_temp);
                }
            }
        }
        return image;
    }

}
