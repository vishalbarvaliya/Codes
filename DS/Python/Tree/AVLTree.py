class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
        self.height = 1


class AVLTree:
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
        else:
            return node
        # increase height of node
        node.height = max(self.height(node.left), self.height(node.right)) + 1
        # check balance factor
        balance = self.__balanceFactor(node)

        if balance > 1:
            # Right rotation
            if data < node.left.data:
                return self.__rightRotate(node)
            # Left right rotation
            elif data > node.left.data:
                node.left = self.__leftRotate(node.left)
                return self.__rightRotate(node)
        if balance < -1:
            # Left rotation
            if data > node.right.data:
                return self.__leftRotate(node)
            # Right left rotation
            elif data < node.right.data:
                node.right = self.__rightRotate(node.right)
                return self.__leftRotate(node)
        return node

    def remove(self, data):
        self.root = self.__remove(self.root, data)

    def __remove(self, node, data):
        if node is None:
            raise ValueError("Data not in the list!")
        elif data < node.data:
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
        if node is None:
            return node

        node.height = max(self.height(node.left), self.height(node.right)) + 1
        balance = self.__balanceFactor(node)

        if balance > 1:
            if self.__balanceFactor(node.left) >= 0:
                return self.__rightRotate(node)
            else:
                node.left = self.__leftRotate(node.left)
                return self.__rightRotate(node)
        if balance < -1:
            if self.__balanceFactor(node.right) <= 0:
                return self.__leftRotate(node)
            else:
                node.right = self.__rightRotate(node.right)
                return self.__leftRotate(node)
        return node

    def levelOrder(self):
        queue = [self.root]
        while queue:
            temp = queue.pop(0)
            print(temp.data, end=" ")
            if temp.left is not None:
                queue.append(temp.left)
            if temp.right is not None:
                queue.append(temp.right)

    # helper functions
    def __leftRotate(self, node):
        x = node.right
        y = x.left
        # Rotate
        x.left = node
        node.right = y
        # height update
        node.height = max(self.height(node.left), self.height(node.right)) + 1
        x.height = max(self.height(x.left), self.height(x.right)) + 1
        return x

    def __rightRotate(self, node):
        x = node.left
        y = x.right
        # Rotate
        x.right = node
        node.left = y
        # Height update
        node.height = max(self.height(node.left), self.height(node.right)) + 1
        x.height = max(self.height(x.left), self.height(x.right)) + 1
        return x

    def __balanceFactor(self, node):
        if not node:
            return 0
        return self.height(node.left) - self.height(node.right)

    def height(self, node):
        if node is None:
            return 0
        return node.height

    def minNode(self, node):
        if node is None:
            return node
        while node.left:
            node = node.left
        return node


avl = AVLTree()
avl.insert(33)
avl.insert(13)
avl.insert(52)
avl.insert(9)
avl.insert(21)
avl.insert(61)
avl.insert(8)
avl.insert(11)
avl.remove(9)
avl.levelOrder()
