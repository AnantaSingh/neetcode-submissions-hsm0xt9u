class MinStack:
    stack = []
    minstack = []

    def __init__(self):
        self.stack = []
        self.minstack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        print("append")
        print(self.minstack)
        print(self.stack)
        if len(self.minstack) > 0 and self.minstack[-1] < val:
            print("same ", self.minstack[-1])
            self.minstack.append(self.minstack[-1])
        else:
            print(val)
            self.minstack.append(val)
        

    def pop(self) -> None:
        if self.stack:
            self.stack.pop()
        if self.minstack:
            self.minstack.pop()
        

    def top(self) -> int:
        if self.stack:
            return self.stack[-1]
        

    def getMin(self) -> int:
        print(self.minstack)
        return self.minstack[-1] if self.minstack else 0
        
