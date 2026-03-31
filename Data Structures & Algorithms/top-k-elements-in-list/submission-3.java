class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int[] answer = new int[k];
        Arrays.sort(nums);
        int prevNum = nums[0];
        int freq = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);


        for(int n : nums)
        {
            if(n == prevNum)
            {
               freq++; 
            }
            else
            {
                queue.add(new int[]{prevNum, freq});
                prevNum = n;
                freq = 1;
            }
        }

        queue.add(new int[]{prevNum, freq});

        for(int i = 0; i < k ; i++)
        {
            int[] temp = queue.poll();
            answer[i] = temp[0];
        }

        return answer;


        
    }
}
