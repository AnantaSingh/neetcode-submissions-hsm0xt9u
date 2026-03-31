class Solution {
    public boolean isValidSudoku(char[][] board) {

        Map<Integer, HashSet<Character>> rows = new HashMap<>();
        Map<Integer, HashSet<Character>> cols = new HashMap<>();
        Map<String, HashSet<Character>> squares = new HashMap<>();

        for(int r =0 ; r < 9; r++)
        {
            for(int c =0 ; c < 9; c++)
            {
                String key = r/3 + "," + c/3; // cool
                System.out.println(key);

                if(board[r][c] == '.')
                    continue;
                if(rows.computeIfAbsent(r, d -> new HashSet<>()).contains(board[r][c]) || // cool
                   cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                   squares.computeIfAbsent(key, k -> new HashSet<>()).contains(board[r][c]))
                {
                    return false;

                }

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(key).add(board[r][c]);
            }


        }

        return true;

        
    }
}
