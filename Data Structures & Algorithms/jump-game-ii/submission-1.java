class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        
        int jumps = 0;
        int currentEnd = 0;      // End of current jump level
        int farthest = 0;        // Farthest we can reach in next jump
        
        // We don't need to jump from the last index
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest we can reach
            farthest = Math.max(farthest, i + nums[i]);
            
            // If we've reached the end of current jump level
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;  // Start new level
                
                // Early exit if we can reach the end
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        
        return jumps;
    }
}