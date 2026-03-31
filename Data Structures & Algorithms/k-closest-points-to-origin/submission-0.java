class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(Comparator.comparing(a -> a[0]));

        for(int[] point : points)
        {
            int distance = point[0] * point[0] + point[1] * point[1];
            maxHeap.offer(new int[]{distance, point[0], point[1]});
        }

        int answer[][] = new int[k][2];

        for(int i =0 ; i < k ;i ++)
        {
            int[] x = maxHeap.poll();
            answer[i] = new int[] { x[1], x[2]};
        }

        return answer;



        
        

    }
}
