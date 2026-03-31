class TimeMap {

    Map<String, List<Pair<Integer,String>>> map;

    public TimeMap() 
    {
        map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) 
    {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) 
    {
        List<Pair<Integer, String>> values = map.getOrDefault(key, new ArrayList<>());
        int left = 0;
        int right = values.size()-1;
        String res = "";

        while(left <= right)
        {
            int mid = (left + right)/2;
            if(values.get(mid).getKey() <= timestamp)
            {
                res = values.get(mid).getValue();
                left = mid +1;
               
            }
            else
            {
                 right = mid-1;
                
            }
        }

        return res;
        
    }
}

class Pair<K, V>
{
    K key; // timestamp
    V value; // bar, bar2

    public Pair(K key, V value)
    {
        this.key = key;
        this.value = value;
    }


    public K getKey()
    {
        return key;
    }

    public V getValue()
    {

        return value;

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */