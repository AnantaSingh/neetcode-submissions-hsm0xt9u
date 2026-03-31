class Solution {
    public int reverseBits(int n) {

        // & with 1 gives the bit in a number
        // need to right shift above
        // OR with out bit B gives replaces the bit in number to OUR bit B
        // need to left shift above
        // we need to get bit from index 0 of the number and then replace it at index 31

        // we need to go from 0 to index 31. its not like 100 becomes 001 it has to be 32 bits

        int res = 0;

        for(int i=0; i < 32; i++)
        {
            int bit = (n >> i) & 1; // n ko shift krna hoga
            res = res | (bit << (31-i)); // bit ko shift krna hoga
        }

        return res;
        
    }
}
