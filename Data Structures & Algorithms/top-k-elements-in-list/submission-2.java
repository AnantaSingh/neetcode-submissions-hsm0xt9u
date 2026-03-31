class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();


        for(int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            minHeap.add(new int[]{entry.getValue(), entry.getKey()});
            if(minHeap.size() > k)
            {
                minHeap.poll();
            }
        }

        for(int i =0; i < k; i++)
        {
            res[i] = minHeap.poll()[1];

        }

        return res;
        
    }
}
