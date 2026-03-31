class Solution {
    public int leastInterval(char[] tasks, int n) {

        // create hashmap(char, int) for count of tasks 
        // create maxheap (int) and add values of hashmap to it
        // create a queue of type int[] for keeping pair - task count remaining,time
        // keep a time counter = 0

         // check if queue.peek() ka time is equal to time then add in maxheap

        // poll from heap the task count
        // reduce the task count by 1, get the time as time + 1 + n and store in queue
       
        // increase time
        // return time

        Map<Character, Integer> map = new HashMap<>();
        for(Character ch : tasks)
            map.put(ch, map.getOrDefault(ch, 0) + 1); // remeber need to add 1. I always forget

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());  // has counts  
        maxHeap.addAll(map.values());

        Queue<int[]> queue = new LinkedList<>();
        int time = 0;


        while(!maxHeap.isEmpty() || !queue.isEmpty())
        {
            // first do queue things
            if(!queue.isEmpty() && time >= queue.peek()[1]) // queue.peek()[1] -- this
            {
                maxHeap.offer(queue.poll()[0]);
            }


            if(!maxHeap.isEmpty())
            {
                int taskcount = maxHeap.poll()-1; // do -1 here
                if(taskcount > 0)
                    queue.offer(new int[]{taskcount, time + 1 + n});
            }

            time++;

        }

        return time;
    
        
    }
}
