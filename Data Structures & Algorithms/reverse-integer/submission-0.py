class Solution:
    def reverse(self, x: int) -> int:
        if x >= 0 :
            str_x = str(x)
            return int(str_x[::-1]) if (int(str_x[::-1]) <= (2**31)-1) else 0

        else:
            str_x = str(abs(x))
            return -1 * int(str_x[::-1]) if (-1 * int(str_x[::-1]) >= -1*(2**31)) else 0

        



        
        