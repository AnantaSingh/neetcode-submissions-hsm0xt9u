class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> answer = new ArrayList<>();
        answer.add(intervals[0]);


        for(int[] interval : intervals)
        {
            int start = interval[0];
            int end = interval[1];
            int lastElement_start = answer.get(answer.size()-1)[0];
            int lastElement_end = answer.get(answer.size()-1)[1];
            
            if(start < lastElement_end)
            {
                answer.get(answer.size()-1)[0] = Math.min(start, lastElement_start);
                answer.get(answer.size()-1)[1] = Math.min(end, lastElement_end);
            }
            else
            {
                answer.add(interval);
            }
        }

        return intervals.length - answer.size();


        
    }
}
