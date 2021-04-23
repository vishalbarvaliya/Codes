package dsa;

class TNode {
    int data;
    TNode left;
    TNode right;

    public TNode(int data) {
        this.data = data;
    }   
}

class TTree{
    public static void main(String[] args) {
        BSTree tree = new BSTree();
        tree.addNode(50);
        tree.addNode(25);
        tree.addNode(15);
        tree.addNode(55);
        tree.addNode(60);
        tree.addNode(20);
        tree.addNode(35);
        tree.addNode(30);
        
        tree.inOrderTraverseTree(tree.root);
//        tree.preOrderTraverseTree(tree.root);        
//        tree.postOrderTraverseTree(tree.root);
        
        System.out.println(tree.searchNode(350));
    }
}
class BSTree {
    TNode root;
    
    public void addNode(int data) {
        TNode newnode = new TNode(data);
        
        if(root == null) {
            root = newnode;
        }
        else {
            TNode focusNode = root;
            TNode parent;
            
            while (true) {                
                parent = focusNode;
                
                if(data < focusNode.data) {
                    focusNode = focusNode.left;
                    
                    if(focusNode == null) {
                        parent.left = newnode;
                        return;
                    }
                }
                else {
                    focusNode = focusNode.right;
                    
                    if(focusNode == null) {
                        parent.right = newnode;
                        return;
                    }
                }
            }
        }
    }
    
    public void inOrderTraverseTree(TNode focusNode) {
        if(focusNode != null) {
            inOrderTraverseTree(focusNode.left);
            System.out.print(focusNode.data + " ");
            inOrderTraverseTree(focusNode.right);
        }
    }
    
    public void preOrderTraverseTree(TNode focusNode){
        if(focusNode != null) {
            System.out.print(focusNode.data + " ");
            preOrderTraverseTree(focusNode.left);
            preOrderTraverseTree(focusNode.right);
        }
    }
    
    public void postOrderTraverseTree(TNode focusNode){
        if(focusNode != null) {
            postOrderTraverseTree(focusNode.left);
            postOrderTraverseTree(focusNode.right);
            System.out.print(focusNode.data + " ");        
        }
    }
    public String searchNode(int data) {
        if(isEmpty()) 
            return "False";
        TNode focusNode = root;
        
        while(focusNode.data != data){
            if(focusNode.data > data){
                focusNode = focusNode.left;
            }
            else {
                focusNode = focusNode.right;
            }
            
            if(focusNode == null)
                return "Not Found";
        }
        return "Found";
    }
    
    public boolean isEmpty(){
        return root == null;
    }
}
