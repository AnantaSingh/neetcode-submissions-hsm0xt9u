class Solution {
public int leastInterval(char[] tasks, int n) {
        // Count frequency of each task
        int[] freq = new int[26];
        int maxFreq = 0;
        
        for (char task : tasks) {
            freq[task - 'A']++;
            maxFreq = Math.max(maxFreq, freq[task - 'A']);
        }
        
        // Count how many tasks have max frequency
        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }
        
        // Calculate minimum intervals
        // Formula: (maxFreq - 1) * (n + 1) + maxCount
        int minIntervals = (maxFreq - 1) * (n + 1) + maxCount;
        
        // Return max of calculated intervals or total tasks
        return Math.max(minIntervals, tasks.length);
    }
}
