class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


class Tree:
    def __init__(self):
        self.root = None

    def insert(self, data):
        self.root = self.__insert(self.root, data)

    def __insert(self, node, data):
        if node is None:
            return Node(data)
        if data < node.data:
            node.left = self.__insert(node.left, data)
        elif data > node.data:
            node.right = self.__insert(node.right, data)
        return node

    def remove(self, data):
        self.root = self.__remove(self.root, data)

    def __remove(self, node, data):
        if node is None:
            raise ValueError("Data not in the list!")
        if data < node.data:
            node.left = self.__remove(node.left, data)
        elif data > node.data:
            node.right = self.__remove(node.right, data)
        else:
            if node.left is not None and node.right is not None:
                temp = self.minNode(node.right)
                node.data = temp.data
                node.right = self.__remove(node.right, temp.data)
            elif node.left is None:
                node = node.right
            elif node.right is None:
                node = node.left
        return node

    def minNode(self, node):
        if node is None:
            raise ValueError("List is empty!")
        while node.left:
            node = node.left
        return node

    def inOrder(self, temp):
        if not temp:
            return
        self.inOrder(temp.left)
        print(temp.data, end=" ")
        self.inOrder(temp.right)

    def levelOrder(self):
        queue = [self.root]
        while queue:
            temp = queue.pop(0)
            print(temp.data, end=" ")
            if temp.left is not None:
                queue.append(temp.left)
            if temp.right is not None:
                queue.append(temp.right)


tree = Tree()
tree.insert(10)
tree.insert(11)
tree.insert(7)
tree.insert(9)
tree.insert(6)
tree.insert(8)

tree.remove(9)
tree.levelOrder()
# print(tree.minNode(tree.root))
# tree.inOrder(tree.root)
