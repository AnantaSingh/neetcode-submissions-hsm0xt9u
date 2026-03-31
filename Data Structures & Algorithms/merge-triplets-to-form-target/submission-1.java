class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // Track which target values we've found
        boolean foundX = false;
        boolean foundY = false;
        boolean foundZ = false;
        
        for (int[] triplet : triplets) {
            // Skip if any element exceeds target (invalid triplet)
            if (triplet[0] > target[0] || 
                triplet[1] > target[1] || 
                triplet[2] > target[2]) {
                continue;  // Can't use this triplet
            }
            
            // Check if this valid triplet contributes to target
            if (triplet[0] == target[0]) foundX = true;
            if (triplet[1] == target[1]) foundY = true;
            if (triplet[2] == target[2]) foundZ = true;
        }
        
        // Can form target if we found all three values
        return foundX && foundY && foundZ;
    }
}