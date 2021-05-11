package dsa;

import java.util.Queue;

class TNode {
    int data;
    TNode left;
    TNode right;
    
    public TNode(int data){
        this.data = data;
    }
}
class BSTree {
    TNode root;
    
    public static void main (String[] args) {
        /*
        ~AVAILABLE BINARY SEARCH TREE OPERATIONS~
        *add()
        *contains()
        *remove()
        *inOrderTraversal(root)
        *preOrderTraversal(root)
        *postOrderTraversal(root)
        *levelOrderTraversal(root)
        *min()
        *max()
        *height()
        *isBST()
        */
        BSTree tree = new BSTree();
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);
        tree.inOrderTraversal(tree.root);
        //System.out.println(tree.containsTNode(5));
        tree.levelOrderTraversalBFS(tree.root);        
    }
    
    public void add(int data){
        root = addRecursive(root, data);
    }
    
    public boolean contains(int data) {
        return searchRecursive(root, data);
    }
    
    public void remove(int data) {
        root = deleleTNode(root, data);
    }
    
    public void inOrderTraversal(TNode current) {
        if(current != null) {
            inOrderTraversal(current.left);
            System.out.print(current.data + " ");
            inOrderTraversal(current.right);
        }
    }
    
    public void preOrderTraversal(TNode current) {
        if(current != null) {
            System.out.print(current.data + " ");
            preOrderTraversal(current.left);
            preOrderTraversal(current.right);
        }
    }
    
    public void postOrderTraversal(TNode current) {
        if(current !=  null) {
            postOrderTraversal(current.left);
            postOrderTraversal(current.right);
            System.out.print(current.data + " ");
        }
    }
    
    public void levelOrderTraversalBFS(TNode current) {
        Queue<TNode> nodes = new java.util.LinkedList<>();
        nodes.add(current);
        
        while(!(nodes.isEmpty())) {
            TNode temp = nodes.remove();
            System.out.print(temp.data + " ");
            
            if(temp.left != null)
                nodes.add(temp.left);
            if(temp.right != null)
                nodes.add(temp.right);
        }
    }
    
    public int height() {
        return findHeight(root);
    }
    
    public int min() {
        TNode temp = smallestTNode(root);
        return temp.data;
    }
    
    public int max() {
        TNode temp = biggestTNode(root);
        return temp.data;
    }
    
    public boolean isBST() {
        return isBSTUtil(root, Integer.MIN_VALUE, Inetger.MAX_VALUE);    
    }
    
    private TNode addRecursive(TNode current, int data) {
        if (current == null) {
            return new TNode(data);
        } 
        else {
            if(data < current.data) {
                current.left = addRecursive(current.left, data);
            }
            else if(data > current.data) {
                current.right = addRecursive(current.right, data);
            } 
            else {
                return current;
            }            
        }
        return current;
    }   
    
    private boolean searchRecursive(TNode current, int data) {
        if(current == null) {
            return false;
        }
        if(current.data == data){
            return true;
        }
        return data < current.data
            ? searchRecursive(current.left, data)
            : searchRecursive(current.right, data);
    }
    
    private TNode smallestTNode(TNode temp) {
        if(temp.left == null)
            return temp;
        else 
            return smallestTNode(temp.left);
    }
    
    private TNode biggestTNode(TNode temp) {
        if(temp.right == null)
            return temp;
        else 
            return smallestTNode(temp.right);
    }
    
    private TNode deleleTNode(TNode current, int data) {
        if(current == null)
            return null;
        if (data < current.data)
            current.left = deleleTNode(current.left, data);
        else if(data > current.data) 
            current.left = deleleTNode(current.right, data);
        else {
            
            if(current.left != null && current.right != null) {
                TNode temp = root;
                TNode minTNode = smallestTNode(temp.right);
                current.data = minTNode.data;
                current.right = deleleTNode(current.right, minTNode.data);
            }
            else if(current.left != null)
                current = current.left;
            else if(current.right != null)
                current = current.right;
            else 
                current = null;
        }
        return current;
    }    
    
    private int findHeight(TNode current) {
        if(current == null) {
            return - 1;
        }
        else {
            int leftHeight = findHeight(current.left);
            int rihgtHeight = findHeight(current.right);
            return Math.max(leftHeight, rihgtHeight) + 1;
        }
    }
    
    private boolean isBSTUtil(TNode current, int minValue, int maxValue) {
        if(current == null)
            return true;
        if(current.data < minValue || current.data > maxValue)
            return false;
        return ( isBSTUtil(current.left, minValue, current.data - 1)
                && isBSTUtil(current.right, current.data + 1, maxValue));
    }
}
