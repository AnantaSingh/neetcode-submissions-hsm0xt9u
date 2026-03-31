class Solution 
{
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDiagonal = new HashSet<>();
    Set<Integer> negDiagonal = new HashSet<>();


    public List<List<String>> solveNQueens(int n) 
    {
        List<List<String>> res = new ArrayList<>();
        char[][] grid = new char[n][n];

        for(char[] g : grid)
            Arrays.fill(g, '.');

        backtrack(0, res, grid, n);
        // Set<Integer> cols = new HashSet<>();
        // Set<Integer> posDiagonal = new HashSet<>();
        // Set<Integer> negDiagonal = new HashSet<>();
        return res;

        
    }

    public void backtrack(int r, List<List<String>> res, char[][] grid, int n)
    {
        if(r == n)
        {
            List<String> temp = new ArrayList<>();
            for(char[] arr : grid)
            {
                String str = new String(arr);
                temp.add(str);
            }
            res.add(temp);
            return;
        }

        for(int c = 0; c < n ; c++)
        {
            if(!cols.contains(c) && !posDiagonal.contains(r+c) && !negDiagonal.contains(r-c))
            {
                grid[r][c] = 'Q';
                cols.add(c);
                posDiagonal.add(r+c);
                negDiagonal.add(r-c);

                backtrack(r+1, res, grid, n);

                grid[r][c] = '.';
                cols.remove(c);
                posDiagonal.remove(r+c);
                negDiagonal.remove(r-c);
            }
        }
    }
}