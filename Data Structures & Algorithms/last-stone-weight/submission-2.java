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
            // System.out.println("X" + x);
            int y = queue.poll();
            // System.out.println("Y" + y);
            if(x != y)
                queue.offer(x-y);
        }


        return queue.peek() != null ? queue.peek() : 0;


        
    }
}
