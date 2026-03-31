class Solution {
    //nums is array with nums of money, length n
    //so we need to kind of refill an array of length n
    //each element in the array will have the max we can get robbing till there
    // so lets take 2 elements previous fir, sec of the current num n
    // there can be 2 options we take fir + n (alternate) OR sec - Max of these. this will be the sum of current
    // now we can make sec = sum, and fir = sec
    // start with 0 and 0
    // so no need to take entire array we just need 2 variables fir and sec
    // return sec

    public int rob(int[] nums) {
        int fir =0;
        int sec = 0;

        for(int n : nums)
        {
            int temp = Math.max(fir + n, sec);
            fir = sec; // do this before assigning sec 
            sec = temp; 
        }

        return sec; 
    }
}
