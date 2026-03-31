class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int number = 1;
        
        for(int i = n-1; i >= 0; i--)
        {
            int sum = digits[i] + number;
            if(sum < 10)
            {
                digits[i] = sum;
                return digits;
            }
            else
            {
                digits[i] = sum%10;
                sum = sum/10;
                number = sum;
            }
        }

        int[] result = new int[n+1];
        result[0] = 1;
        int p = 1;
        for(int k : digits)
        {
            result[p++] = k;
        }


        return result;
    }
    }

