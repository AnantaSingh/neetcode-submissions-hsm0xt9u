class MinStack:
    stack = []
    minstack = []

    def __init__(self):
        self.stack = []
        self.minstack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.minstack and self.minstack[-1] < val:
            self.minstack.append(self.minstack[-1])
        else:
            self.minstack.append(val)
        

    def pop(self) -> None:
        if self.stack:
            self.stack.pop()
            self.minstack.pop()
        

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]
        

    def getMin(self) -> int:
        return self.minstack[-1] if self.minstack else 0
        
