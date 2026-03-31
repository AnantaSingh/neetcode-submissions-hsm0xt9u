class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows, cols = defaultdict(set), defaultdict(set)
        squares = defaultdict(set)

        for i in range(len(board)):
            for j in range(len(board[i])):
                c = board[i][j]
                if c == '.':
                    continue

                string_key = str(i//3) + "," + str(j//3);
                print(string_key)
                if c in rows[i] or c in cols[j] or c in squares[string_key]:
                    return False

                rows[i].add(c)
                cols[j].add(c)
                squares[string_key].add(c)

        return True





        
        