class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int prev_end = intervals[0][1];
        int count = 0;

        for(int i = 1; i < intervals.length; i++)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if(start < prev_end) // overlapping
            {
                count++;
                prev_end = Math.min(prev_end, end); 
            }
            else
            {
                prev_end = end;
            }
        }

        return count;


        
    }
}
