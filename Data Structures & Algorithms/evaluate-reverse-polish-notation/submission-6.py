class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        for token in tokens:
            if token == '+':
                a = stack.pop()
                b = stack.pop()
                stack.append(a+b)
            elif token == '*':
                a = stack.pop()
                b = stack.pop()
                stack.append(a*b)
            elif token == '-':
                a = stack.pop()
                b = stack.pop()
                stack.append(b-a)
            elif token == '/':
                a = stack.pop()
                b = stack.pop()
                stack.append(int(b/a)) # REMEBER THIS is diff. this b // a would round off
            else:
                stack.append(int(token))
        
        return stack.pop()
        