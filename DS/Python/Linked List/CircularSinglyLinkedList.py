class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class CircularSinglyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def insertAtBegin(self, data):
        new_node = Node(data)
        new_node.next = self.head
        if self.head is None:
            self.head = self.tail = new_node
        else:
            self.head = new_node
        self.tail.next = self.head

    def insertAtEnd(self, data):
        if self.head is None:
            self.insertAtBegin(data)
            return
        new_node = Node(data)
        new_node.next = self.head
        self.tail.next = new_node
        self.tail = new_node

    def insertAfter(self, item, data):
        if self.head:
            flag = False
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
                temp.next = new_node
                if new_node.next == self.head:
                    self.tail = new_node
            else:
                raise ValueError("Item not in the list!")
        else:
            raise ValueError("List is empty!")

    def remove(self, data):
        if self.head is None:
            raise ValueError("List is empty!")
        elif self.head.data == data:
            self.head = self.head.next
            self.tail.next = self.head
            return
        else:
            flag = False
            temp = self.head
            while True:
                if temp.data == data:
                    flag = True
                    break
                prev = temp
                temp = temp.next
                if temp == self.head:
                    break
            if flag:
                prev.next = temp.next
                if prev.next == self.head:
                    self.tail = prev
            else:
                raise ValueError("Item not in list!")

    def printList(self):
        if self.head:
            temp = self.head
            while True:
                print(temp.data, end=" ")
                temp = temp.next
                if temp == self.head:
                    break

    def size(self):
        count = 0
        if self.head:
            temp = self.head
            while True:
                count += 1
                temp = temp.next
                if temp == self.head:
                    break
        return count


csl = CircularSinglyLinkedList()

csl.insertAtEnd(50)
csl.insertAtEnd(60)
csl.insertAtBegin(40)
csl.insertAfter(40, 45)
csl.remove(60)
csl.insertAtEnd(60)

print("Head : ", csl.head.data)
print("Tail : ", csl.tail.data)

csl.printList()
