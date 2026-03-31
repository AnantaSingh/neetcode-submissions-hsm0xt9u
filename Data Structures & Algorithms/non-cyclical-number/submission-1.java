class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();
        int sum = 0;

        while(sum != 1)
        {
            if(visit.contains(sum))
                return false;
            else
                visit.add(sum);
            sum = 0;
            while(n != 0)
            {
                int p = n%10;
                sum = sum + p*p;
                n=n/10;
            }
            n = sum;
        }


        return sum == 1;
    }
}
