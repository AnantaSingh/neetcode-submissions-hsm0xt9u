class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        // System.out.println("COLS " + COLS);

        // fist find row
        int top = 0;
        int bottom = ROWS-1;


        while(top <= bottom)
        {
            int mid = (top+bottom)/2;
            // System.out.println();
            // System.out.println("TOP " + top);
            // System.out.println("BOTTOM " + bottom);
            // System.out.println("MID " + mid);
            // System.out.println("TARGET " + target);
            // int d = COLS-1;
            //  System.out.println("COLS-1 " + d);
            // System.out.println("matrix[mid][d]" + matrix[mid][d]);
            if(target > matrix[mid][COLS-1])
            {
                top = mid+1;
            }
            else if(target < matrix[mid][0])
            {
                bottom = mid - 1;
            }
            else
            {
                break;
            }
        }

        // System.out.println(top);
        // System.out.println(bottom);

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


