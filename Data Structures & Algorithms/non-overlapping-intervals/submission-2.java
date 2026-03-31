class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int prev_end = -1;
        int count = 0;

        for(int[] interval : intervals)
        {
            int start = interval[0];
            int end = interval[1];
            
            if(prev_end != -1 && start < prev_end) // overlapping
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
