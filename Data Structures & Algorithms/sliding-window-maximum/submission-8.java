class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new LinkedList<>();
        int l = 0, r = 0;
        int[] output = new int[n-k+1];

        
        // the last window will start at n-k. the first at 0.so total number of windows = n-k+1

        while( r < n)
        {
   
            while(!q.isEmpty() && nums[q.getLast()] < nums[r])
            {
                q.removeLast();
            }

            q.addLast(r);

            if(l > q.getFirst())
            {
                q.removeFirst(); // hence we store indexes in queue for this
            }

            if((r+1) >= k)
            {
                output[l] = nums[q.getFirst()];
                l++; // l will move with window
            }

            r++;
        }

        return output;


        
    }
}
