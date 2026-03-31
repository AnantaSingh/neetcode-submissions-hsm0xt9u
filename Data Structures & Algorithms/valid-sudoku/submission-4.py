class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # rows = { i:[] for i in range(len(board))}
        # cols = { i:[] for i in range(len(board[0]))}
        # squares = {i: [] for i in range(len(board))}
        rows = defaultdict(set) # forgot this
        cols = defaultdict(set)
        squares = defaultdict(set)

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == ".":
                    continue;

                if board[i][j] in rows[i] or board[i][j] in cols[j] or board[i][j] in squares[(i//3, j//3)]:
                    return False
                
                rows.get(i).add(board[i][j]); # set does not have append
                cols.get(j).add(board[i][j]);
                squares.get((i//3, j//3)).add(board[i][j])
                # get will allow to give default 
                # could do rows[i] but will give exception

        return True
        

        
        