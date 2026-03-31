class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        ROWS = len(matrix)
        COLS = len(matrix[0])
        
        dp = {} # ((r,c) , prevValue)
        # for each r , c calculate the longest path possible
        # then take a max
        
        def dfs(r, c, prevValue):
            if r < 0 or c < 0 or r == ROWS or c == COLS or matrix[r][c] <= prevValue:
                return 0
            
            if (r, c) in dp:
                return dp[(r, c)]
            
            
            length = 1
            directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
            for dr, dc in directions:
                nr = r + dr
                nc = c + dc
                length = max(length, 1 + dfs(nr, nc, matrix[r][c]))
                
            dp[(r, c)] = length
            return length
            
        
        for r in range(ROWS):
            for c in range(COLS):
                dfs(r, c, -1)
        
        
        return max(dp.values())