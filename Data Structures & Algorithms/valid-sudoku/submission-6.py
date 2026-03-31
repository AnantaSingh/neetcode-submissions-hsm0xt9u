class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows, cols = defaultdict(set), defaultdict(set)
        squares = defaultdict(set)

        for i in range(len(board)):
            for j in range(len(board[i])):
                c = board[i][j]
                if c == '.': # forgot this got wrong answer
                    continue

                string_key = str(i//3) + "," + str(j//3); # IMP to use // to avoid float. can also be an array 
                print(string_key)
                if c in rows[i] or c in cols[j] or c in squares[string_key]:
                    return False

                rows[i].add(c) # can use get or this direct
                cols[j].add(c)
                squares[string_key].add(c)

        return True





        
        