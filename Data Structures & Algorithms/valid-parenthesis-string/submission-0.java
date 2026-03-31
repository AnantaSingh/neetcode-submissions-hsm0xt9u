class Solution {
    // Approach 1: Greedy - Track range of possible open parentheses
    public boolean checkValidString(String s) {
        int minOpen = 0;  // Minimum possible open parentheses
        int maxOpen = 0;  // Maximum possible open parentheses
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--;  // Treat as ')'
                maxOpen++;  // Treat as '('
            }
            
            // If maxOpen < 0, we have more ')' than we can handle
            if (maxOpen < 0) {
                return false;
            }
            
            // minOpen should never go below 0
            // (we can use '*' as empty string to prevent negative)
            minOpen = Math.max(minOpen, 0);
        }
        
        // Valid if we can balance all parentheses
        return minOpen == 0;
    }
}