class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


class Tree:
    def __init__(self):
        self.root = None

    def insert(self, data):
        if self.root is None:
            self.root = Node(data)
        else:
            q = [self.root]
            while len(q):
                temp = q[0]
                q.pop(0)

                if not temp.left:
                    temp.left = Node(data)
                    break
                else:
                    q.append(temp.left)

                if not temp.right:
                    temp.right = Node(data)
                    break
                else:
                    q.append(temp.right)

    def inOrder(self, temp):
        if not temp:
            return
        self.inOrder(temp.left)
        print(temp.data, end=" ")
        self.inOrder(temp.right)


tree = Tree()
tree.insert(10)
tree.insert(11)
tree.insert(7)
tree.insert(9)
tree.insert(15)
tree.insert(8)
tree.inOrder(tree.root)
