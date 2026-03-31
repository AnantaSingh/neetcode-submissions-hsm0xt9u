class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for(int[] interval : intervals)
        {
            if(newInterval == null || interval[1] < newInterval[0]) // newInterval can be null so it needs to be first condition
            {
                res.add(interval);
            }
            else if(interval[0] > newInterval[1])
            {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            }
            else 
            {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }


        // 3, 5
        //case 1 newInterval lies before this then add both to res -- newInterval[1] < interval[0] 
        // case 2 newInterval lies after this then add interval to res only -- newInterval[0] > interval[1]
        // case 3  newInterval lies in btw -- else merge how? make a new newinterval
    

        if(newInterval != null)
        {
            res.add(newInterval);
                
        }




        return res.toArray(new int[res.size()][]);

    }
}
