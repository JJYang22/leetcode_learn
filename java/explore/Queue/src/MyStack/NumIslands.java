package MyStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author Voidmian
 * @Date 2019/10/26 14:24
 */
public class NumIslands {
    static public void test(){
        char [][]grid={ {'1','0','1','0','1'},
                        {'1','0','0','1','1'},
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
        for (int i = 0; i <height ; i++) {
            for (int j = 0; j <width ; j++) {
                if( grid[i][j] != '1')
                    continue;
                DFS(i,j,height,width,grid);
                ans++;
            }
        }
        return ans;
    }

    private void DFS(int temp_i,int temp_j, int height, int width, char[][] grid) {
        int[] temp_x = {-1, 1, 0, 0};
        int[] temp_y = {0, 0, -1, 1};
        grid[temp_i][temp_j]='0';
        for(int k=0;k<4;k++) {
            int x=temp_i+temp_x[k];
            int y=temp_j+temp_y[k];
            if (x >= 0 && x < height && y >= 0 && y < width) {
                if(grid[x][y]== '1')
                {
                    DFS(x,y,height,width,grid);
                }
            }
        }
    }
}
