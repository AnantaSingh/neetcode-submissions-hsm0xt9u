class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        int[] answer = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums)
        {
            map.put(n,map.getOrDefault(n, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            maxHeap.add(new int[]{entry.getKey(), entry.getValue()});
        }

        for(int i=0; i < k ; i++)
        {
            int[] temp = maxHeap.poll();
            answer[i] = temp[0];
        }

        return answer;
        
    }
}
