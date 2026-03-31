class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> pac = new HashSet<>();
        Set<Integer> atl = new HashSet<>();
        int rows = heights.length;
        int cols = heights[0].length;

        // run dfs on 1st and last row
        for(int c = 0; c < cols; c++)
        {
            dfs(0, c, pac, heights, rows, cols, heights[0][c]);
            dfs(rows-1, c, atl, heights, rows, cols, heights[rows-1][c]);
        }

        for(int r = 0; r < rows; r++)
        {
            dfs(r, 0, pac, heights, rows, cols, heights[r][0]);
            dfs(r, cols-1, atl, heights, rows, cols, heights[r][cols-1]);
        }

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                int coord = i * cols + j;
                if(pac.contains(coord) && atl.contains(coord))
                {
                    ans.add(Arrays.asList(i,j));
                }
                    

            }

        }

        return ans;
        
        
    }

    public void dfs(int r, int c, Set<Integer> visit, int[][] heights, int rows, int cols, int prevHeight)
    {
        int element = r * cols + c;
        if(r < 0 || c < 0 || r >= rows || c >= cols || visit.contains(element) || heights[r][c] < prevHeight)
            return;

        visit.add(element);
        dfs(r + 1, c, visit, heights, rows, cols, heights[r][c]);
        dfs(r - 1, c, visit, heights, rows, cols, heights[r][c]);
        dfs(r , c + 1, visit, heights, rows, cols, heights[r][c]);
        dfs(r, c - 1, visit, heights, rows, cols, heights[r][c]);

    }




}
