package  dsa;
class Node {
    int data;
    Node next, prev;
}

class Runner {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        
        list.reverseList();
        list.show();
        
        System.out.println(list.size());
        System.out.println("Head : " + list.getHead());
        System.out.println("Tail : " + list.getTail());
    }   
}

class LinkedList {
    Node head = null, tail = null;
    
    public void insert(int data) {
        Node newnode = new Node();
        newnode.data = data;
        newnode.prev = null;
        newnode.next = null;
        
        if(head == null) {
            head = tail = newnode;
            head.next = head;
            head.prev = head;
        }
        else {
            tail.next = newnode;
            newnode.prev = tail;
            newnode.next = head;
            head.prev = newnode;
            tail = newnode;
        }
    }
    
    public void insertBegin(int data) {
        Node newnode = new Node();
        newnode.data = data;
        
        newnode.next = head;
        newnode.prev = tail;
        head = newnode;
        tail.next = head;
    }
    
    public void insertAt(int index, int data) {
        if(index == 0){
            insertBegin(data);
        } else {
            
            if(index == size()){
                insertLast(data);
                return;
            } 
            
            Node tempnode = head;
            Node newnode = new Node();
            newnode.data = data;
            
            for(int i = 0; i < index - 1; i++) {
                tempnode = tempnode.next;
            }
                  
            newnode.next = tempnode.next;
            newnode.prev = tempnode;
            (tempnode.next).prev = newnode;
            tempnode.next = newnode;
        }        
    }
    
    public void insertLast(int data) {
        if(head == null) {
            System.out.println("List is empty..");
        } else {
            Node tempnode = head;
            Node newnode = new Node();
            newnode.data = data;
            
            for(int i = 0; i < size() - 1; i++) {
                tempnode = tempnode.next;
            }
            tempnode.next = newnode;
            newnode.prev = tempnode;
            newnode.next = head;
            tail = newnode;
        }
    }
    
    public void removeFirst() {
        if(head == null) {
            System.out.println("List is empty..");
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
    }
    
    public void removeLast() {
        if(head == null){
            System.out.println("List is empty..");
        } else {
            tail = tail.prev;
            tail.next = head;
        }
    }
    
    public void  removeAt(int index) {
        if(head == null) {
            System.out.println("List is empty.."); 
        }
        else {
            if(index == 0){
                removeFirst();
            } else if(index == size() - 1) {
                removeLast();
            }
            else {
                
                Node tempnode = head;
                for(int i = 0; i < index - 1; i++) {
                    tempnode = tempnode.next;
                }
                
                (tempnode.next).prev = tempnode;
                tempnode.next = (tempnode.next).next;          
            }
        }
    }
    
    public void reverseList() {
        if(head == null) {
            System.out.println("Lsit is empty..");
        } else {
            Node currnode = head, nextnode = null;
            do{
                nextnode = currnode.next;
                currnode.next = currnode.prev;
                currnode.prev = nextnode;
                currnode = nextnode;
                
            } while(currnode != head);
            currnode = head;
            head = tail;
            tail = currnode;
        }
    }
    
    public void show() {
        if(head == null) {
            System.out.println("List is empty..");
        }
        else {
            Node tempnode = head;
            do {
                System.out.print(tempnode.data + " ");
                tempnode = tempnode.next;                    
            } while(tempnode != head);
        }
        System.out.println("");
    }
    
    public int size() {
        if(head == null)
            return 0;
        int count = 0;
        Node tempnode = head;
        do {
            count++;
            tempnode = tempnode.next;
        } while(tempnode != head);
        return count;
    }
    
    public int getHead() {
        return head.data;
    }
    
    public int getTail() {
        return tail.data;
    }
}
