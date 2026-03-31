class Solution {
    public double myPow(double x, int n) 
    {
        long N = n;
        if(N < 0)
        {
            x = 1/x;
            N = - N;
        }

        double result = 1.0; // remeber 1 not 0
        double currentProduct = x;

        while(N > 0)
        {
            if(N % 2 == 1) // bit has a 1
            {
                result = result * currentProduct;
            }

            currentProduct = currentProduct * currentProduct; // 3, 9 , 81

            N = N/2; //next bit
        }


        return result;
    }
}
