class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();
        int largestSequence = 0;
        int countOfcurSeq = 0;

        for(Integer n : nums)
        {
            set.add(n);
        }

        for(Integer n : nums)
        {
            if(set.contains(n-1))
            continue;
            else
            {
                int element = n;
                countOfcurSeq = 1;
                while(set.contains(element+1))
                {
                    countOfcurSeq++;
                    element++;
                }
                if(countOfcurSeq > largestSequence)
                {
                    largestSequence = countOfcurSeq;
                }
            }
        }



        return largestSequence;
        
    }
}
