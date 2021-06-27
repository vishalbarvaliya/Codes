# Queue implementation in Python

class Queue:

    def __init__(self):
        self.queue = []

    # Add an element
    def enqueue(self, item):
        self.queue.append(item)

    # Remove an element
    def dequeue(self):
        if len(self.queue) < 1:
            return None
        return self.queue.pop(0)

    # Display  the queue
    def display(self):
        print(self.queue)
        
    def peek(self):
        if self.queue:
            return self.queue[0]

    def size(self):
        return len(self.queue)
        
    def isEmpty(self):
        return len(self.queue) == 0


q = Queue()
q.enqueue(1)
q.enqueue(2)
q.enqueue(3)
q.enqueue(4)
q.enqueue(5)

q.dequeue()
print(q.peek())
q.display()
