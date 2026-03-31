class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();

        while(!visit.contains(n))
        {
            visit.add(n);
            
            int sum = 0;
            while(n != 0)
            {
                int p = n%10;
                sum = sum + p*p;
                n=n/10;
            }
            n = sum;
        }


        return n == 1;
    }
}
