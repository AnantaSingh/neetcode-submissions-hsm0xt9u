class Solution {
    public int rob(int[] nums) {

        return Math.max(nums[0],
        Math.max(houserobber1(Arrays.copyOfRange(nums, 0, nums.length-1)),
        houserobber1(Arrays.copyOfRange(nums, 1, nums.length))));

    }

    public int houserobber1(int[] nums)
    {
        int fir = 0;
        int sec = 0;

        for(int n : nums)
        {
            int temp = Math.max(fir + n, sec);
            fir = sec;
            sec = temp;
        }

        return sec;
    }
}
