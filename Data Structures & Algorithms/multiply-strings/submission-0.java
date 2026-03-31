class Solution {

        public String multiply(String num1, String num2) {
        // Edge case: if either is "0", return "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int m = num1.length();
        int n = num2.length();
        
        // Result can have at most m + n digits
        int[] result = new int[m + n];
        
        // Multiply each digit from num1 with each digit from num2
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                
                int product = digit1 * digit2;
                
                // Position in result array
                int pos1 = i + j;      // tens place
                int pos2 = i + j + 1;  // ones place
                
                // Add product to existing value at pos2
                // (pos2 may already have value from previous iterations)
                int sum = product + result[pos2];
                
                // Update positions with carry
                result[pos2] = sum % 10;
                result[pos1] += sum / 10;
            }
        }
        
        // Convert result array to string
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            // Skip leading zeros
            if (!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }
        
        return sb.toString();
    }
}



