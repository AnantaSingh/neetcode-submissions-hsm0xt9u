class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int ROWS = matrix.length;
        int COLS = matrix[0].length;
     

        // fist find row
        int top = 0;
        int bottom = ROWS-1;


        while(top <= bottom)
        {
            int mid = (top+bottom)/2;
           
            if(target > matrix[mid][COLS-1])
            {
                top = mid+1;
            }
            else if(target < matrix[mid][0]) // remember here the comparison is with [mid][0] it changes 
            {
                bottom = mid - 1;
            }
            else
            {
                break;
            }
        }

 

        if(top > bottom)
        {
            return false;
        }

        int finalRow = (top + bottom)/2;
        int l = 0;
        int r = COLS-1;

        while(l<=r)
        {
            int mid = (l+r)/2;
            if(target > matrix[finalRow][mid])
            {
                l = mid+1;
            }
            else if(target < matrix[finalRow][mid])
            {
                r = mid-1;
            }
            else
            {
                return true;
            }
        }

        return false;
        
    }
}


