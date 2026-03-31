class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n: nums)
        {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        for(var entry: freq.entrySet())
        {
            minHeap.add(new int[]{entry.getKey(), entry.getValue()});
            if(minHeap.size() > k)
            {
                minHeap.poll();
            }
        }

        int i = 0;
        while(minHeap.size() > 0)
        {
            ans[i] = minHeap.poll()[0];
            i += 1;
        }

        return ans;
        
    }
}
