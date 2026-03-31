class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        
        // Step 1: Store the last occurrence of each character
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        // Step 2: Iterate and create partitions
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Extend the partition to include last occurrence of current char
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            
            // If we've reached the end of the partition
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        
        return result;
    }
}