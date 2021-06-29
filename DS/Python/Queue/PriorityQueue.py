class PriorityQueue:
    def __init__(self):
        self.queue = []
        self.deq = []

    def enqueue(self, item):
        self.queue.append(item)
        self.__heapifyUp(len(self.queue) - 1)

    def __heapifyUp(self, i):
        while self.__hasParent(i) and self.queue[i] > self.queue[self.__getParentIndex(i)]:
            self.queue[i], self.queue[self.__getParentIndex(i)] =\
                self.queue[self.__getParentIndex(i)], self.queue[i]
            i = self.__getParentIndex(i)

    def dequeue(self):
        if self.queue:
            item = self.queue[0]
            self.queue[0] = self.queue[len(self.queue) - 1]
            self.deq.append(item)
            self.queue.pop()
            self.__heapifyDown()
            return item
        else:
            raise IndexError("Queue is empty!")

    def __heapifyDown(self):
        i = 0
        while self.__hasLeftChild(i):
            biggerChildIndex = self.__getLeftChildIndex(i)
            if self.__hasRightChild(i) and self.queue[self.__getRightChildIndex(i)] > self.queue[biggerChildIndex]:
                biggerChildIndex = self.__getRightChildIndex(i)
            if self.queue[i] > self.queue[biggerChildIndex]:
                break
            else:
                self.queue[i], self.queue[biggerChildIndex] = self.queue[biggerChildIndex], self.queue[i]
                i = biggerChildIndex

    def peek(self):
        if self.queue:
            return self.queue[0]
        else:
            raise IndexError("Queue is empty!")

    def printPQ(self):
        print(self.queue)
        print(self.deq)

    def isEmpty(self):
        return len(self.queue) == 0

    # Helper Functions
    def __getParentIndex(self, i):
        return (i - 1) // 2

    def __getLeftChildIndex(self, i):
        return (i * 2) + 1

    def __getRightChildIndex(self, i):
        return (i * 2) + 2

    def __hasParent(self, i):
        return self.__getParentIndex(i) >= 0

    def __hasLeftChild(self, i):
        return self.__getLeftChildIndex(i) < len(self.queue)

    def __hasRightChild(self, i):
        return self.__getRightChildIndex(i) < len(self.queue)

    def __getLeftChild(self, i):
        return self.queue[self.__getLeftChildIndex(i)]

    def __getRightChild(self, i):
        return self.queue[self.__getRightChildIndex(i)]

    def __getParent(self, i):
        return self.queue[self.__getParentIndex(i)]


pq = PriorityQueue()
pq.enqueue(10)
pq.enqueue(20)
pq.enqueue(30)
pq.enqueue(40)
pq.enqueue(50)
pq.enqueue(5)
pq.enqueue(35)

pq.dequeue()
pq.dequeue()

print(pq.peek())
pq.printPQ()
