class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // new comparator thing learnt
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(Comparator.comparing(a -> a[0]));

        for(int[] point : points) // new way of accessing 2d because we know column is fixed 2
        {
            int distance = point[0] * point[0] + point[1] * point[1]; // no need to sqrt
            maxHeap.offer(new int[]{distance, point[0], point[1]}); // new way of inserting. added new int[]{}
        }

        int answer[][] = new int[k][2];

        for(int i =0 ; i < k ;i ++)
        {
            int[] x = maxHeap.poll(); 
            answer[i] = new int[] { x[1], x[2]}; // new way of inserting with new int[]{}
        }

        return answer;

    }
}
