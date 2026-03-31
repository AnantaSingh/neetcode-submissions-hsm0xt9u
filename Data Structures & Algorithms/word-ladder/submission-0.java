class Solution 
{
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        if(!wordList.contains(endWord))
            return 0;

        Map<String, List<String>> map = new HashMap<>();
        wordList.add(beginWord); // we want to generate a pattern for this

        for(String word : wordList)
        {
            for(int i=0; i < word.length(); i++)
            {
                String pattern = word.substring(0,i) + "*" + word.substring(i+1);
                map.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        queue.add(beginWord);
        int res = 1;

        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i =0; i < size; i++)
            {
                String currWord = queue.poll();
                if(currWord.equals(endWord))
                    return res;
            
                // if(visit.contains(currWord))
                //     continue;

         
                for(int j=0; j < currWord.length(); j++)
                {
                    String pattern = currWord.substring(0,j) + "*" + currWord.substring(j+1);
                    for(String s : map.getOrDefault(pattern, new ArrayList<>()))
                    {
                        if(visit.contains(s))
                            continue;
                        visit.add(s);
                        queue.add(s);
                    }
                }
 
            }
            res++;
        }


        return 0;

        
    }
}
