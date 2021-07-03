class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None


class CircularDoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def insertAtBeginning(self, data):
        new_node = Node(data)
        if self.head is None:
            self.head = self.tail = new_node
            self.head.next = self.head
            self.head.prev = self.head
        else:
            new_node.next = self.head
            self.head.prev = new_node
            new_node.prev = self.tail
            self.head = new_node
            self.tail.next = self.head
            # if new_node.next == self.tail:
            #    self.tail.prev = new_node

    def insertAtEnd(self, data):
        if self.head is None:
            self.insertAtBeginning(data)
        else:
            new_node = Node(data)
            self.head.prev = new_node
            new_node.next = self.head
            new_node.prev = self.tail
            self.tail.next = new_node
            self.tail = new_node

    def insertAfter(self,item, data):
        if self.head is None:
            raise ValueError("List is empty!")
        else:
            new_node = Node(data)
            temp = self.head
            while True:
                if temp.data == item:
                    flag = True
                    break
                temp = temp.next
                if temp == self.head:
                    break
            if flag:
                new_node.next = temp.next
                if new_node.next == self.head:
                    self.tail = new_node
                new_node.prev = temp
                temp.next.prev = new_node
                temp.next = new_node
            else:
                raise ValueError("Item not in the list!")

    def removeFirst(self):
        self.head = self.head.next
        self.tail.next = self.head
        self.head.prev = self.tail

    def removeLast(self):
        self.tail = self.tail.prev
        self.tail.next = self.head
        self.head.prev = self.tail

    def remove(self, data):
        if self.head is None:
            raise ValueError("List is empty!")
        elif self.head.data == data:
            self.removeFirst()
        elif self.tail.data == data:
            self.removeLast()
        else:
            flag = False
            temp = self.head
            while True:
                if temp.data == data:
                    flag = True
                    break
                temp = temp.next
                if temp == self.head:
                    break
            if flag:
                temp.next.prev = temp.prev
                temp.prev.next = temp.next
            else:
                raise ValueError("Item not in the list!")

    def printList(self):
        if self.head:
            temp = self.head
            while True:
                print(temp.data, end=" ")
                temp = temp.next
                if temp == self.head:
                    break


cdl = CircularDoublyLinkedList()

cdl.insertAtEnd(40)
cdl.insertAtEnd(50)
cdl.insertAtBeginning(5)
cdl.insertAfter(5, 10)
cdl.insertAfter(10, 30)
cdl.insertAfter(10, 20)
cdl.remove(5)
cdl.remove(30)

cdl.printList()
