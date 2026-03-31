class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[k];

        for(int n : nums)
        {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        // for(int n : nums) // WRONG WE DONT GO TO THE ARRAY NOW else multiple 2 , 3 will come
        // {
        //     System.out.println(map.get(n));
        //     maxHeap.add(new int[]{n, map.get(n)});
        // }

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            maxHeap.add(new int[]{entry.getKey(), entry.getValue()});

        }

        for(int i = 0; i < k; i++)
        {
            int[] temp = maxHeap.poll();
            answer[i] = temp[0];
        }

        return answer;
 
    }
}
