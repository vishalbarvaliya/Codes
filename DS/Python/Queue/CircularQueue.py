class CircularQueue:

    def __init__(self, k):
        self.k = k
        self.queue = [None] * k
        self.front = self.rear = -1

    # Insert an element into the circular queue
    def enqueue(self, data):

        if ((self.rear + 1) % self.k == self.front):
            print("The circular queue is full\n")

        elif (self.front == -1):
            self.front = 0
            self.rear = 0
            self.queue[self.rear] = data
        else:
            self.rear = (self.rear + 1) % self.k
            self.queue[self.rear] = data

    # Delete an element from the circular queue
    def dequeue(self):
        if (self.front == -1):
            print("The circular queue is empty\n")

        elif (self.front == self.rear):
            temp = self.queue[self.front]
            self.front = -1
            self.rear = -1
            return temp
        else:
            temp = self.queue[self.front]
            self.front = (self.front + 1) % self.k
            return temp
          
    # Print the circular queue
    def printCQueue(self):
        if(self.front == -1):
            print("No element in the circular queue")

        elif (self.rear >= self.front):
            for i in range(self.front, self.rear + 1):
                print(self.queue[i], end=" ")
            print()
        else:
            for i in range(self.front, self.k):
                print(self.queue[i], end=" ")
            for i in range(0, self.rear + 1):
                print(self.queue[i], end=" ")
            print()
            
    def peek(self):
        if self.front == -1:
            return None
        return self.queue[self.front]

# Driver Code
q = CircularQueue(5)
q.enqueue(1)
q.enqueue(2)
q.enqueue(3)
q.enqueue(4)
q.enqueue(5)
q.printCQueue()
