class Solution {
    public boolean isValidSudoku(char[][] board) {

        Map<Integer, HashSet<Character>> rows = new HashMap<>();
        Map<Integer, HashSet<Character>> cols = new HashMap<>();
        Map<String, HashSet<Character>> squares = new HashMap<>();
        int r = board.length;
        int c = board[0].length;

        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                String key = i/3 + "," + j/3;
                if(board[i][j] == '.')
                    continue;

                // rows.computeIfAbsent(board[i][j], d -> new HashSet<Integer>()).contains(board[i][j])

                if(rows.computeIfAbsent(i, d -> new HashSet<Character>()).contains(board[i][j]) ||
                    cols.computeIfAbsent(j, d -> new HashSet<Character>()).contains(board[i][j]) ||
                    squares.computeIfAbsent(key, d -> new HashSet<Character>()).contains(board[i][j]))
                    {
                        return false;
                    }

                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);
                squares.get(key).add(board[i][j]);
            }
        }

        return true;
        
    }
}
