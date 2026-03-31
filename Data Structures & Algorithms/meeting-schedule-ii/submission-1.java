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
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        
        // Sort meetings by start time
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        
        // Min heap to track end times of ongoing meetings
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(intervals.get(0).end);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            
            // If earliest ending meeting finishes before current starts
            if (heap.peek() <= current.start) {
                heap.poll(); // Reuse that room
            }
            
            // Add current meeting's end time
            heap.add(current.end);
        }
        
        // Size of heap = number of rooms needed
        return heap.size();
    }
}