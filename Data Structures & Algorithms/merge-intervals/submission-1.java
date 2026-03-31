class Solution {
    public int[][] merge(int[][] intervals) {

        // intervals[0] will mean both col come
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> answer = new ArrayList<>();
        answer.add(intervals[0]);

        for(int[] interval : intervals)
        {
            int start = interval[0];
            int end = interval[1];
            int outputlastElement_end = answer.get(answer.size() - 1)[1];

            if(start <=  outputlastElement_end)
            {
                answer.get(answer.size() - 1)[1] = Math.max(outputlastElement_end, end);
            }
            else
            {
                answer.add(interval); // simply add the interval
            }
        }

        return answer.toArray(new int[answer.size()][]); // same conversion as prev question

    }
}
