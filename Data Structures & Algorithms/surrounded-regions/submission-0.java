class Solution {
    int ROWS;
    int COLS;
    public void solve(char[][] board) {
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for(int i =0; i < ROWS; i++)
        {
            for(int j =0; j < COLS; j++)
            {
                if(board[i][j] == 'O' && (i == 0 || i == ROWS-1 || j == 0 || j == COLS-1))
                    capture(board, i, j);
            }
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
