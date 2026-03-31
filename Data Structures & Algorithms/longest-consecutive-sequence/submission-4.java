class Solution {
    public int longestConsecutive(int[] nums) {

        //sort the array
        //take i = 0 j = i + 1
        //if (nums[j]- nums[i] == 1) -- j++
        // else add (j-i) in Pq
        // 

         if(nums.length == 0)
         return 0;

        Arrays.sort(nums);
        int i=0;
        int j = 1;
        int count = 1;
       

        

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(count);

        while(i < nums.length && j < nums.length)
        {
            if(nums[j] - nums[j-1] == 1)
            {
                count++;
                j++;
            }
            else if(nums[j] == nums[j-1])
            {
                j++;
            }
            else
            {
                pq.offer(count);
                i=j;
                j=i+1;
                count=1;
            }
        }

        if(count > 1)
         pq.offer(count);



        return pq.poll();
        
    }
}
