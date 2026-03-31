class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int largestSeq = 0;
        int currSeq = 0;

        for(int n : nums)
        {
            set.add(n);
        }

        for(int n : nums)
        {
            if(set.contains(n-1)) // basically its not the start so no need to do extra work
                continue;
            else
            {
                // int element = n;
                currSeq = 1;
                while(set.contains(n+1))
                {
                    currSeq++;
                    n++;
                }
                largestSeq = Math.max(largestSeq, currSeq);
            }
        }

        return largestSeq;
        
    }
}
