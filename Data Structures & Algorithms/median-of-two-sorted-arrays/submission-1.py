class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        A = nums1
        B = nums2
        if len(A) > len(B):
            A, B = B, A

        l = 0
        r = len(A) - 1
        total = len(A) + len(B)
        half = total // 2


        while True: # VERY IMP its while TRUE and not true in end 
            i = (l + r) // 2  # no mid just take i and then calculate j
            j = half - i - 2

            Aleft = A[i] if i >= 0 else float('-inf') # take A and B and equality for 0
            Aright = A[i+1] if i + 1 < len(A) else float('inf')
            Bleft = B[j] if j >= 0 else float('-inf')
            Bright = B[j+1] if j + 1 < len(B) else float('inf')

            if Aleft <= Bright and Bleft <= Aright:
                if total % 2 != 0:
                    return min(Aright, Bright) # its min of Aright and Bright
                else:
                    return (max(Aleft, Bleft) + min(Aright, Bright))/ 2
            elif Aleft > Bright:
                r = i - 1
            else:
                l = i + 1

        