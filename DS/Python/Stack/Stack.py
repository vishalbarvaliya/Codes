class Stack:
    def __init__(self):
        self.stack = []
    
    def push(self, item):
        self.stack.append(item)
        
    def pop(self):
        if self.stack:
            return self.stack.pop()
        
    def isEmpty(self):
        return len(self.stack) == 0
        
    def peek(self):
        if self.stack:
            return self.stack[-1]
              
    def display(self):
        print(self.stack)
            
st = Stack()
st.push(10)
st.push(20)
st.push(30)

st.display()
