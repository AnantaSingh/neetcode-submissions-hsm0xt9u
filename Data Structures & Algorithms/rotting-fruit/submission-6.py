class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        ROWS = len(grid)
        COLS = len(grid[0])
        time = 0
        fresh = [0]
        q = deque()
        #directions = [[1,0],[-1,0],[0,1],[0,-1]]

        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 1:
                    fresh[0] += 1
                if grid[r][c] == 2:
                    q.append([r,c]) # remember
        
        def rotten(row, col, fresh):
            if(row < 0 or col < 0 or row >= ROWS or col >= COLS or grid[row][col] == 2 or grid[row][col] == 0):
                return
            grid[row][col] = 2
            fresh[0] -= 1
            q.append([row,col])

            
        while q and fresh[0] > 0:
            for i in range(len(q)): #rememeber not r,c
                r, c = q.popleft()
                rotten(r+1, c, fresh)
                rotten(r-1, c, fresh)
                rotten(r, c+1, fresh)
                rotten(r, c-1, fresh)
            time += 1
        
        return time if fresh[0] == 0 else -1
                
                
        




        