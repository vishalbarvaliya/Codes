class MaxHeap:
    def __init__(self):
        self.heapList = []

    def push(self, item):
        self.heapList.append(item)
        self.heapifyUp(len(self.heapList) - 1)

    def heapifyUp(self, i):
        while self.__hasParent(i) and self.heapList[i] > self.heapList[self.__getParentIndex(i)]:
            self.heapList[i], self.heapList[self.__getParentIndex(i)] =\
                self.heapList[self.__getParentIndex(i)], self.heapList[i]
            i = self.__getParentIndex(i)

    def printHeap(self):
        print(self.heapList)

    def peek(self):
        if self.heapList:
            return self.heapList[0]
        else:
            raise IndexError("Heap is empty!")

    def pop(self):
        if self.heapList:
            item = self.heapList[0]
            self.heapList[0] = self.heapList[len(self.heapList) - 1]
            self.heapList.pop()
            self.heapifyDown()
            return item
        else:
            raise IndexError("Heap is empty!")

    def heapifyDown(self):
        i = 0
        while self.__hasLeftChild(i):
            biggerChildIndex = self.__getLeftChildIndex(i)
            if self.__hasRightChild(i) and\
                    self.heapList[self.__getRightChildIndex(i)] > self.heapList[biggerChildIndex]:
                biggerChildIndex = self.__getRightChildIndex(i)
            if self.heapList[i] > self.heapList[biggerChildIndex]:
                break
            else:
                self.heapList[i], self.heapList[biggerChildIndex] =\
                    self.heapList[biggerChildIndex], self.heapList[i]
            i = biggerChildIndex

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
        return self.__getLeftChildIndex(i) < len(self.heapList)

    def __hasRightChild(self, i):
        return self.__getRightChildIndex(i) < len(self.heapList)

    def __getLeftChild(self, i):
        return self.heapList[self.__getLeftChildIndex(i)]

    def __getRightChild(self, i):
        return self.heapList[self.__getRightChildIndex(i)]

    def __getParent(self, i):
        return self.heapList[self.__getParentIndex(i)]

# Driver Code:
heap = MaxHeap()
heap.push(3)
heap.push(43)
heap.push(92)
heap.push(5)
heap.push(2)

heap.pop()
heap.pop()

heap.printHeap()
