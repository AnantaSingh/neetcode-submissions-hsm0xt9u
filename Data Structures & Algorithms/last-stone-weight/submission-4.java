class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones)
        {
            queue.offer(stone);
        }
        
        // heaviest stone so need a max Heap for polling
        while(queue.size() > 1)
        {
            int x = queue.poll();
            int y = queue.poll();
            if(x != y)
                queue.offer(x-y); // x will be greater than y
        }


        return queue.size() > 0 ? queue.peek() : 0;


        
    }
}
