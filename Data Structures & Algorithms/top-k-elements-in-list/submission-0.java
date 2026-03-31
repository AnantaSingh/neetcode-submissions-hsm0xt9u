class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap();
        // below important new stuff
        List<Integer>[] freq = new List[nums.length + 1];

        for(int i=0; i< freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        for(int i=0; i< nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        // Below code IMP
        for(Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] answer = new int[k];
        int index = 0;

        for(int i = freq.length-1; i > 0; i--) 
        {
            for(int n : freq[i])
            {
                answer[index] = n;
                index++;
                if(index == k)
                return answer;
            }

        }

        return answer;


        
    }
}
