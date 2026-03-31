class Solution 
{
    int ROWS;
    int COLS;
    public void solve(char[][] board) 
    {
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for(int i =0; i < ROWS; i++)
        {
            if(board[i][0] == 'O')
                capture(board, i, 0);
            if(board[i][COLS-1] == 'O')
                capture(board, i, COLS-1);
        }

         for(int j =0; j < COLS; j++)
         {
            if(board[0][j] == 'O')
                capture(board, 0, j);
            if(board[ROWS-1][j] == 'O')
                capture(board, ROWS-1, j);

         }

        for(int i =0; i < ROWS; i++)
            for(int j =0; j < COLS; j++)
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
 

        for(int i =0; i < ROWS; i++)
            for(int j =0; j < COLS; j++)
                if(board[i][j] == 'T')
                    board[i][j] = 'O';
        
    }

    public void capture(char[][] board, int i, int j)
    {
        if(i < 0 || j < 0 || i == ROWS || j == COLS || board[i][j] != 'O')
            return;

        board[i][j] = 'T';
        capture(board, i+1, j);
        capture(board, i-1, j);
        capture(board, i, j+1);
        capture(board, i, j-1);
    }
}
