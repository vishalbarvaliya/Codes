
package testfiles;

class TreeNode {
    int data;
    int height;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int data) {
        this.data = data;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}
public class AVLTree {
    private TreeNode root;
    static int count = 10;
    
    public void insert(int data) {
        this.root = insertRec(this.root, data);
    }
    
    private TreeNode insertRec(TreeNode node, int data) {
        if(node == null)
            return new TreeNode(data);             
        if(data < node.data) 
            node.left = insertRec(node.left, data);        
        else if(data > node.data) 
            node.right = insertRec(node.right, data);
        else
            return node;
        
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        
        int balance = balanceFactor(node);
        
        if (balance > 1) {
            if (data < node.left.data) {
                return rightRotate(node);
            } else if (data > node.left.data) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (balance < -1) {
            if (data > node.right.data) {
                return leftRotate(node);
            } else if (data < node.right.data) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }
    
    private TreeNode leftRotate(TreeNode node) {
        TreeNode x = node.right;
        TreeNode y = x.left;
        
        //rotate        
        x.left = node;
        node.right = y;
        
        //Hight update
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;        
        
        return x;
    }
    
     private TreeNode rightRotate(TreeNode node) {
        TreeNode x = node.left;
        TreeNode y = x.right;
        
        //rotate        
        x.right = node;
        node.left = y;
        
        //Height update
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;        
        
        return x;
    } 
     
    public void remove(int data) {
        this.root = remove(this.root, data);
    }    
    
    public void display() {
        display(this.root, 0);
    }
    
    private TreeNode remove(TreeNode node, int data){
        if(node == null)
            return node;
        if(data < node.data)
            node.left = remove(node.left, data);
        else if(data > node.data)
            node.right = remove(node.right, data);
        else {
             if ((node.left == null) || (node.right == null)) { 
                TreeNode temp = null; 
                if (temp == node.left) 
                    temp = node.right; 
                else
                    temp = node.left;   
                // No child case 
                if (temp == null) { 
                    temp = node; 
                    node = null; 
                } 
                else 
                    node = temp;
            } 
            else{   
                // node with two children: Get the inorder 
                // successor (smallest in the right subtree) 
                TreeNode temp = smallestNode(node.right);   
                // Copy the inorder successor's data to this node 
                node.data = temp.data; 
                // Delete the inorder successor 
                node.right = remove(node.right, temp.data); 
            } 
            if(node == null)
                return node;
        }
        
                
        //update height of current node
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        
        int balance = balanceFactor(node);
        
        if(balance > 1) {
            if(balanceFactor(node.left) >= 0)
                return rightRotate(node);
            else{
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(balance < -1){
            if(balanceFactor(node.right) <= 0)
                return leftRotate(node);
            else{
                node.right = rightRotate(node.right);
                return leftRotate(node);    
            }
        }        
        return node;
    }
    
    private TreeNode smallestNode(TreeNode node) {
        TreeNode curr = node;
        
        while(curr.left != null)
            curr = curr.left;
        return curr;
    }
    
    private void display(TreeNode node, int space) {
        if(node == null)
            return;
        space += count;
        display(node.right, space);
        System.out.print("\n");
        for(int i = count; i < space; i++){
            System.out.print(" ");
        }
        System.out.print(node.data + "\n");
        display(node.left, space);
        
    }
    
    int height(TreeNode node){
        if(node == null)
            return 0;
        return node.height;
    }    
    
    private int balanceFactor(TreeNode node) {
        if(node == null)
            return 0;
        return height(node.left) - height(node.right);
    }
}
class Solution {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
;
        for(int i = 0; i < 4; i++) {
            tree.insert(i + 1);
        }
        
        tree.insert(110);
        tree.insert(112);
        tree.remove(3);
        tree.remove(2);
        tree.remove(1);
        tree.insert(3);
        tree.insert(1);
        
        tree.display();
    }
}
