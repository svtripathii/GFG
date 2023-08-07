class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int board[][])
    {
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j] == 0){
                    for(int c = 1;c<=9;c++){
                        if(isvalid(board,i,j,c)){
                            board[i][j] = c;

                            if(SolveSudoku(board)){
                                return true;
                            }else{
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isvalid(int[][] board, int row, int col, int c) {
    for (int i = 0; i < 9; i++) {
      if (board[i][col] == c)
        return false;

      if (board[row][i] == c)
        return false;

      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
        return false;
    }
    return true;
  }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
       for(int i = 0;i<9;i++){
           for(int j = 0;j<9;j++){
               System.out.print(grid[i][j]+" ");
           }
       }
    }
}
