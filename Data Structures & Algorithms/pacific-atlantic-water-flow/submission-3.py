class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        ROWS = len(heights)
        COLS = len(heights[0])
        pac, atl = set(), set()
        res = []

        def dfs(row, col, visit, prevHeight):
            if(row < 0 or col < 0 or row >= ROWS or col >= COLS or (row, col) in visit or heights[row][col] < prevHeight):
                return
            visit.add((row, col))
            dfs(row-1, col, visit, heights[row][col])
            dfs(row+1, col, visit, heights[row][col])
            dfs(row, col+1, visit, heights[row][col])
            dfs(row, col-1, visit, heights[row][col])

        for r in range(ROWS):
            dfs(r, 0, pac, heights[r][0]) #1st col
            dfs(r, COLS-1, atl, heights[r][COLS-1]) #last col

        for c in range(COLS):
            dfs(0, c, pac, heights[0][c])
            dfs(ROWS-1, c, atl, heights[ROWS-1][c])

        for r in range(ROWS):
            for c in range(COLS):
                if(r, c) in pac and (r,c) in atl:
                    res.append([r, c])

        return res


        

        