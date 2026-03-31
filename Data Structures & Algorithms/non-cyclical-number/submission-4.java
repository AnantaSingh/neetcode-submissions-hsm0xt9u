class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();
        // int sum = 0;

        while(n != 1)
        {
            if(visit.contains(n))
                return false;
            else
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
