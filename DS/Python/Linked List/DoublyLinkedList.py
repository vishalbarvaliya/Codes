class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None


class DoublyLinkedList:
    def __init__(self):
        self.head = None

    def insertAtBegining(self, data):
        new_node = Node(data)
        new_node.next = self.head
        if self.head is not None:
            self.head.prev = new_node
        self.head = new_node

    def insertAtEnd(self, data):
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
            return
        else:
            temp = self.head
            while temp.next:
                temp = temp.next
            temp.next = new_node
            new_node.prev = temp

    def insertAt(self, pos, data):
        new_node = Node(data)
        if pos < 0 or pos > self.size():
            raise IndexError("Invalid index!")
        elif pos == 0:
            self.insertAtBegining(data)
        elif pos == self.size():
            self.insertAtEnd(data)
        else:
            i = 0
            temp = self.head
            while i < pos - 1:
                temp = temp.next
                i += 1
            new_node.next = temp.next
            temp.next.prev = new_node
            new_node.prev = temp
            temp.next = new_node

    def remove(self, data):
        if self.head is None:
            raise ValueError("List is empty!")
        elif self.head.data == data:
            self.head = self.head.next
        else:
            flag = False
            temp = self.head
            while temp:
                if temp.data == data:
                    flag = True
                    break
                prev = temp
                temp = temp.next
            if flag:
                prev.next = temp.next
                if temp.next is not None:
                    temp.next.prev = prev
            else:
                raise ValueError("Item not in list!")

    def printList(self):
        if self.head is None:
            print("List is empty!")
        else:
            temp = self.head
            while temp:
                print(temp.data, end=" ")
                temp = temp.next

    def size(self):
        count = 0
        if self.head:
            temp = self.head
            while temp:
                count += 1
                temp = temp.next
        return count


dl = DoublyLinkedList()
dl.insertAt(0, 10)
dl.insertAt(1, 20)
dl.insertAtEnd(30)
dl.insertAtEnd(40)
dl.insertAtBegining(5)
dl.remove(5)

dl.printList()
