class Solution:
    def isValid(self, s: str) -> bool:
        brackets = {')' : '(', '}' : '{', ']' : '['}
        stack = []

        for i in range(len(s)):
            ch = s[i]

            if ch in brackets:
                if stack and stack[-1] == brackets[ch]: # see nice condition , stack should not be empty added
                    stack.pop()
                else:
                    return False
            else: # mean it is an oepning bracket
                stack.append(ch)
            
        return True if len(stack) == 0 else False
        #return True if not stack else False

        