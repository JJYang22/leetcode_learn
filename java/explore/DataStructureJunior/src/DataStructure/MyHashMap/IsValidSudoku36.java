package DataStructure.MyHashMap;

/**
 * @Author Voidmian
 * @Date 2019/11/9 17:30
 */
public class IsValidSudoku36 {
    static public void test(){
        char[][] board ={
                {'5','3','.','.','7','.','.','.','.'},
  {'6','.','.','1','9','5','.','.','.'},
  {'.','9','8','.','.','.','.','6','.'},
  {'8','.','.','.','6','.','.','.','3'},
  {'4','.','.','8','.','3','.','.','1'},
  {'7','.','.','.','2','.','.','.','6'},
  {'.','6','.','.','.','.','2','8','.'},
  {'.','.','.','4','1','9','.','.','5'},
  {'.','.','.','.','8','.','.','7','9'}
        };
        IsValidSudoku36 isValidSudoku36 = new IsValidSudoku36();
        System.out.println(isValidSudoku36.isValidSudoku(board));
    }
    public boolean isValidSudoku(char[][] board) {
        boolean[][] col = new boolean[9][9];
        boolean[][] row = new boolean[9][9];
        boolean[][] nine = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int temp = board[i][j] - '1';
                    int count = (i / 3) * 3 + j / 3;
                    if (row[i][temp] || col[j][temp] || nine[count][temp]) {
                        return false;
                    } else {
                        row[i][temp] = true;
                        col[j][temp] = true;
                        nine[count][temp] = true;
                    }
                }
            }
        }
        return true;
    }
}
