package MyQueue;

import javax.print.attribute.IntegerSyntax;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author Voidmian
 * @Date 2019/10/26 14:24
 */
public class NumIslands {
    static public void test(){
        char [][]grid={ {'1','0','1','1','1'},
                        {'1','0','1','0','1'},
                        {'1','1','1','0','1'}
        };
        NumIslands numIslands=new NumIslands();

        System.out.println(numIslands.numIslands(grid));

    }


    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0)
            return 0;
        int ans=0;
        int height=grid.length;
        int width=grid[0].length;
        int [] temp_x = {-1,1,0,0};
        int [] temp_y = {0,0,-1,1};
        Queue <Integer> queue =new LinkedList<>();
        for (int i = 0; i <height ; i++) {
            for (int j = 0; j <width ; j++) {
                if( grid[i][j] != '1')
                    continue;
                grid[i][j]='0';
                queue.offer(i*width+j);
                ans++;
                while (queue.size() > 0) {
                    int cur = queue.poll();
                    int temp_i = cur / width;
                    int temp_j = cur % width;
                    for(int k=0;k<4;k++) {
                        int x=temp_i+temp_x[k];
                        int y=temp_j+temp_y[k];
                        if (x >= 0 && x < height && y >= 0 && y < width) {
                            if(grid[x][y]== '1')
                            {
                                queue.offer(x*width+y);
                                grid[x][y]='0';
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
