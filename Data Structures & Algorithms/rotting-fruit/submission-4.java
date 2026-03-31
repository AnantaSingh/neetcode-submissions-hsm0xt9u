class Solution {
    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int time = 0;
        int fresh = 0;
        int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};

        Queue<int[]> q = new LinkedList<>(); // read about this class

        for(int i=0; i < M; i++)
        {
            for(int j=0; j < N; j++)
            {
                if(grid[i][j] == 1)
                    fresh++;
                if(grid[i][j] == 2)
                    q.add(new int[]{i,j});
            }
        }

        while(fresh > 0 && !q.isEmpty())
        {
            int size = q.size();
            for(int i =1; i <= size; i++)
            {
                int[] p = q.poll();
                int row = p[0];
                int col = p[1];
                for(int[] dir : directions)
                {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if(r < 0 || c < 0 || r >=M || c >= N || grid[r][c] != 1)
                        continue;

                    grid[r][c] = 2;
                    fresh--;
                    q.add(new int[] {r, c});
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;    
    }
}
