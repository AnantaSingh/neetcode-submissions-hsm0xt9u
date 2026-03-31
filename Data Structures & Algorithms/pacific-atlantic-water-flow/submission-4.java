class Solution {

    int rows =0;
    int cols = 0;
    int[][] Heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        List<List<Integer>> ans = new ArrayList<>();

        
        // Set<Integer> pac = new HashSet<>();
        // Set<Integer> atl = new HashSet<>();
        rows = heights.length;
        cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];
        Heights = heights;

        // run dfs on 1st and last row
        for(int c = 0; c < cols; c++)
        {
            dfs(0, c, pac, heights[0][c]);
            dfs(rows-1, c, atl, heights[rows-1][c]);
        }

        for(int r = 0; r < rows; r++)
        {
            dfs(r, 0, pac,  heights[r][0]);
            dfs(r, cols-1, atl,  heights[r][cols-1]);
        }

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(pac[i][j] && atl[i][j])
                {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans; 
    }

    public void dfs(int r, int c, boolean[][] visit, int prevHeight)
    {
        if(r < 0 || c < 0 || r >= rows || c >= cols || visit[r][c] || Heights[r][c] < prevHeight)
            return;

        visit[r][c] = true;
        dfs(r + 1, c, visit, Heights[r][c]);
        dfs(r - 1, c, visit, Heights[r][c]);
        dfs(r , c + 1, visit, Heights[r][c]);
        dfs(r, c - 1, visit, Heights[r][c]);
    }
}
