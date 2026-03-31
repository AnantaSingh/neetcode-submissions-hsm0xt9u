class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix) #rows
        n = len(matrix[0]) #cols

        # i need to find the row first
        # how am i sure i need to move down l = mid + 1, current row last is less than target
        # how am i sure i need to move up r = mid -1, current row first element is greater than target

        l = 0
        r = m-1

        while l <= r:
            mid = (l+r)//2
            if matrix[mid][n-1] < target:
                l = mid + 1
            elif matrix[mid][0] > target:
                r = mid - 1
            else:
                break # it can break also if r < l so check

        if l > r:
            return False
        
         
        row = mid; # we are now in the correct row
        # now let us see where it is in that row

        l = 0
        r = n-1

        while l <= r:
            mid = (l+r)//2
            if matrix[row][mid] > target:
                r = mid-1
            elif matrix[row][mid] < target:
                l = mid + 1
            else:
                return True

        
        return False








        