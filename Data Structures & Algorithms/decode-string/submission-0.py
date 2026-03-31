class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        
        for ch in s:
            if ch != ']':
                stack.append(ch)
            else:
                substring = ""
                while stack[-1] != '[':
                    substring = stack.pop() + substring
                stack.pop()
                
                intstring = "" 
                while stack and stack[-1].isdigit():
                    intstring = stack.pop() + intstring
                
                k = int(intstring)
                    
                stack.append(substring * k)
                
        
        return "".join(stack)
                    
        