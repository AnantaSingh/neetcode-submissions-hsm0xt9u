class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        Map<Integer, Integer> map = new HashMap<>();

        for(int n: nums)
        {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            maxheap.add(new int[]{entry.getKey(), entry.getValue()});
        }


        for(int i=0; i < k; i++)
        {
            ans[i] = maxheap.poll()[0];
        }

        return ans;
        
    }
}
