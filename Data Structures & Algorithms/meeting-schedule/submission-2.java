/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        
        // sort first
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        
        //int prev_end = -1; no need for this incase there is an overlap we just return false
        //if there is not overlap then there should be no problem since its sorted

        // for(Interval interval : intervals)
        // {
        //     int start = interval.start;
        //     int end = interval.end;

        //     if(start < prev_end)
        //     {
        //         return false;
        //     }
        //     else
        //     {
        //         prev_end = end;
        //     }

        // }

        for(int i = 1 ; i < intervals.size() ; i++)
        {
            Interval interval1 = intervals.get(i-1);
            Interval interval2 = intervals.get(i);

            if(interval1.end > interval2.start) // 1 end baad mei ho rha 2 start pehle
            {
                return false;
            }

        }

        return true;

    }
}
