class Node {
    int data;
    Node next;
    Node prev;
}

class Runner{
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(10);
        list.insert(20);
        list.insertAt(0,1);
        list.insertAt(3,15);
      //  list.insertAt(5,25);
       // list.deleteAt(3);
        //list.reverseList();
        list.show();
        System.out.println();
        list.search(35);
        //list.getHead();
        //list.getTail();
    }
    
}

class LinkedList {
    
    Node head, tail;
    public void insert(int data) {
        Node newnode = new Node();
        newnode.data = data;
        newnode.prev = null;
        newnode.next = null;
        
        if(head == null) {
            head = tail = newnode;
        }
        else {
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
    }
    
    public void insertAtBegin(int data) {
        Node newnode = new Node();
        newnode.data = data;
        newnode.prev = null;
        newnode.next = head;
        head.prev = newnode;
        head = newnode;
    }
    
    public void insertAt(int index,int data) {
        if(index < 0 || index > size()){
            System.out.println("Invalid index..");
            return;
        }
        if(index == 0){
            insertAtBegin(data);
        }
        else {
            Node newnode = new Node();
            newnode.data = data;
            Node tempnode = head;
            
           
            for(int i = 0; i < index - 1; i++) {
                tempnode = tempnode.next;
            }
            
             if(index == size()){
                tempnode.next = newnode;
                newnode.prev = tempnode;
                tail = newnode;
                return;
            }
            newnode.next = tempnode.next;
            (tempnode.next).prev = newnode;
            newnode.prev = tempnode;
            tempnode.next = newnode;
        }
    }
    
    public void deleteAt(int index) {
        if(index < 0 || index >= size()){
            System.out.println("Invalid index..");
            return;
        }
        if(index == 0)
            head = head.next;
        else { 
            Node tempnode = head;
            for(int i = 0; i < index - 1 ; i++) {
                tempnode = tempnode.next;
            }
            
            if(index == size()-1){
                tail = tail.prev;
                tail.next = null;
                return;
            }
            (tempnode.next).prev = tempnode;
            tempnode.next = (tempnode.next).next;
        }
    }
    
    public void reverseList() {
        
        //Using tail pointer.
      /*Node tempnode = tail;
        
        if(head == null) {
            System.out.println("List is empty..");
            return;
        }
        
        System.out.print("Reversed List : ");
        while(tempnode != null) {
            System.out.print(tempnode.data + " ");
            tempnode = tempnode.prev;
        }*/
        
        // Without tail pointer
        Node currnode = head, nextnode = null;
        while(currnode != null) {
            nextnode = currnode.next;
            currnode.next = currnode.prev;
            currnode.prev = nextnode;
            currnode = nextnode;
        }
        currnode = head;
        head = tail;
        tail = currnode;
        
    }
    
    public void search(int data) {
	    if(head == null) {
	        System.out.println("List is empty.");
	        return;
	    }
	    Node tempnode = head;
	    while(tempnode != null){
	        if(tempnode.data == data){
	            System.out.println("Data found..");
	            return;
	        }
	        tempnode = tempnode.next;
	    }
	    System.out.println("Data not found..");
	}
    
    public void show() {
        if(head == null) {
            System.out.println("List is empty..");
            return;
        }
        Node tempnode = head;
        System.out.println();
        while(tempnode != null) {
            System.out.print(tempnode.data + " ");
            tempnode = tempnode.next;
        }
    }
    
    public int size() {
        int count = 0;
        Node tempnode = head;
        while(tempnode != null) {
            count++;
            tempnode = tempnode.next;
        }
        return count;
    }
    
    public void getHead() {
        System.out.println("\nHead is : " + head.data);
    }
    
    public void getTail() {
        System.out.println("Tail is : " + tail.data);
    }
}
