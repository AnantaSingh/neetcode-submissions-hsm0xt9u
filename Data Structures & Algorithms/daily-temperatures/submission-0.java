class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] ans = new int[n];

        for(int i=0; i< n; i++)
        {
            int x = temperatures[i];
            int count = 0;
            for (int j = i+1; j < n ; j++)
            {
                int y = temperatures[j];
                count++;
                if(y > x)
                {
                    ans[i] = count;
                    break;
                }

            }
        }
        

        return ans;
    }
}
