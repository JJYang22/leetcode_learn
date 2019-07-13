public class Solution79 {
    public static void main(String[] args)
   {
        char [][] board ={{'A','B','C','E'},
                          {'S','F','E','S'},
                          {'A','D','E','E'}};

    //   char [][] board ={{'C','A'}};
        Solution s=new Solution();
        System.out.println(s.exist(board,"ABCESEEEFS"));

    }

}
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean [][] status=new boolean[board.length][board[0].length];

        for (int row=0;row<board.length;row++)
        {
            for(int col=0;col<board[0].length;col++)
            {
                if( board[row][col]== word.charAt(0))
                {
                    for (int row_status=0;row_status<board.length;row_status++) {
                        for (int col_status = 0; col_status < board[0].length; col_status++)
                        {
                            status[row_status][col_status]=false;
                        }
                    }
                    status[row][col]=true;
                    if(Find(board,word,1,row,col,board.length,board[0].length,status)==true)
                    {
                        return true;
                    }
                    System.out.println("首个点更换");
                }
            }
        }
        return false;
    }
    private boolean Find(char[][]board,String word,int charindex,int row,int col,int down,int right,boolean [][]status)
    {
        if(charindex == word.length())
            return true;
        boolean ans =false;
        System.out.println("已找到 "+"x="+col+"y="+row+" 需要找"+word.charAt(charindex));
        if(row-1>=0)
            if(board[row-1][col] == word.charAt(charindex) && !status[row-1][col]  )
            {
                System.out.println(" 上"+"x="+col+"y="+row+" "+board[row-1][col]);
                status[row-1][col]= true;
                ans=Find(board,word,charindex+1,row-1,col,board.length,board[0].length,status);
                status[row-1][col]= ans;
                System.out.println("上"+ans);
            }
        System.out.println("上"+ans+"已找到 "+"x="+col+"y="+row+" 需要找"+word.charAt(charindex));
        if(row+1<down && !ans )
            if(board[row+1][col] == word.charAt(charindex) && !status[row+1][col] )
            {
                System.out.println("  下"+"x="+col+"y="+row+" "+board[row+1][col]);
                status[row+1][col]= true;
                ans=Find(board,word,charindex+1,row+1,col,board.length,board[0].length,status);
                status[row+1][col]= ans;
                System.out.println("下"+ans);
            }
        System.out.println("下"+ans+"已找到 "+"x="+col+"y="+row+" 需要找"+word.charAt(charindex));
        if(col-1>=0 && !ans )
            if(board[row][col-1] == word.charAt(charindex) && !status[row][col-1])
            {
                System.out.println("  左"+"x="+col+"y="+row+" "+board[row][col-1]);
                status[row][col-1]=true;
                ans=Find(board,word,charindex+1,row,col-1,board.length,board[0].length,status);
                status[row][col-1]=ans;
                System.out.println("左"+ans);
            }
        System.out.println("左"+ans+"已找到 "+"x="+col+"y="+row+" 需要找"+word.charAt(charindex));
        if(col+1<right && !ans )
            if(board[row][col+1] == word.charAt(charindex) && !status[row][col+1])
            {
                System.out.println("  右"+"x="+col+"y="+row+" "+board[row][col+1]);
                status[row][col+1]=true;
                ans=Find(board,word,charindex+1,row,col+1,board.length,board[0].length,status);
                status[row][col+1]=ans;
                System.out.println("右"+ans);
            }

        return ans;
    }
}
