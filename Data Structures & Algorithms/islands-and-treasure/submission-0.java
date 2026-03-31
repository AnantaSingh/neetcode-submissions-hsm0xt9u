class Solution {
    int rows;
    int cols;
    int INF = Integer.MAX_VALUE;
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        this.rows = grid.length;
        this.cols = grid[0].length;
        List<int[]> directions = Arrays.asList(
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1});

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] == 0)
                {
                    q.add(new int[] { i, j}); // added all the gates. DO we use ADD for queue
                }
            }
        }

        while(!q.isEmpty())
        {
            int[] a = q.poll();
            int row = a[0];
            int col = a[1];
            for(int[] dir : directions)
            {
                int r = row + dir[0];
                int c = col + dir[1];
                if(r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] !=  INF)
                    continue;

                grid[r][c] = grid[row][col] + 1;
                q.add(new int[] {r, c});
            }
        }




    }
}
