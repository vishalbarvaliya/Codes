class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class SingleLinkedList:
    def __init__(self):
        self.head = None

    def insertAtBeginning(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node

    def insertAtEnd(self, data):
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
            return
        temp = self.head
        while temp.next:
            temp = temp.next
        temp.next = new_node

    def insertAt(self, pos, data):
        if pos == 0:
            self.insertAtBeginning(data)
            return
        elif pos > self.size() or pos < 0:
            raise Exception("Invalid index!")
        new_node = Node(data)
        temp = self.head
        i = 0
        while i < pos - 1:
            temp = temp.next
            i += 1
        new_node.next = temp.next
        temp.next = new_node

    def remove(self, data):
        flag = False
        if self.head is None:
            raise Exception("List is empty!")
        if data == self.head.data:
            self.head = self.head.next
        else:
            temp = self.head
            while temp:
                if temp.data == data:
                    flag = True
                    break
                prev = temp
                temp = temp.next
            if flag:
                prev.next = temp.next
            else:
                raise Exception("List has no such item")

    def printList(self):
        temp = self.head
        while temp:
            print(temp.data, end=" ")
            temp = temp.next

    def size(self):
        count = 0
        temp = self.head
        while temp:
            count += 1
            temp = temp.next
        return count


sl = SingleLinkedList()
sl.insertAtEnd(10)
sl.insertAtEnd(20)
sl.insertAtEnd(30)
sl.remove(30)

sl.printList()
