class Solution {
    // keep a visited but what should we mark as visited
    // remember that we can keep it 
    boolean[][] visited;
    int count = 0;
    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(grid[i][j] == '1' && visited[i][j] != true)
                {
                    dfs(grid, i, j);
                    count = count + 1;
                }
            }
        }

        return count; 
    }

    public void dfs(char[][] grid, int i, int j)
    {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == true || grid[i][j] == '0')
        {
            return;
        }
        
        if(grid[i][j] == '1')
        {
            visited[i][j] = true;
        }

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);

        return;

    }
}
