class Solution {
    public int findKthLargest(int[] nums, int k) {

        // min heap will first take out minimum
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int num: nums){
            queue.offer(num);
        }

        while(k > 1)
        {
            queue.poll();
            k--;
        }

        return queue.peek();
        
    }
}
