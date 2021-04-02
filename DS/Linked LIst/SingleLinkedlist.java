class Node {
	int data;
	Node next;
}
class Runner {
	public static void main(String []args) {
		LinkedList list = new  LinkedList();
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);
		//list.insertAtStart(3);
		//list.insertAt(2,5);
		//list.insertAt(6,8);
		//list.deleteAt(5);
		//list.search(9);
		list.reverseList();
		list.show();
	}

}
class LinkedList {
	Node head;
	public void insert(int data) {
		Node newnode = new Node();
		newnode.data = data;
		newnode.next = null;

		if(head == null)
			head = newnode;
		else {
			Node tempnode = head;
			while(tempnode.next != null)
				tempnode = tempnode.next;
			tempnode.next = newnode;
		}
	}
	
	public void insertAtStart(int data) {
	    Node newnode = new Node();
	    newnode.data = data;
	    newnode.next = head;
	    head = newnode;
	    
	}
	
	public void insertAt(int index, int data) {
	    if(index < 0 || index > size()) {
	        System.out.println("invalid index");
	        return;
	    }
	    
	    Node newnode = new Node();
	    
	    if(index == 0)
	        insertAtStart(data);
	        
	    newnode.data = data;
	    Node tempnode = head;
	    for(int i = 0; i < index - 1; i++) {
	        tempnode = tempnode.next;
	    }
	    newnode.next = tempnode.next;
	    tempnode.next = newnode;
	}
	
	public void deleteAt(int index) {
	    if(head == null || index >= size()){
	        System.out.println("Invalid index");
	        return;
	    }
	    if(index == 0) {
	        head = head.next;
	    }
	    else {
	        Node tempnode = head;
	        for(int i = 0; i < index - 1; i++) {
	            tempnode = tempnode.next;
	        }
	        tempnode.next = (tempnode.next).next;
	    }
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
	
	public void reverseList() {
	    if(head == null)
	        System.out.println("List is empty..");
	    else {
	        Node currnode = head, nextnode = head,prevnode = null;
	        while(nextnode != null) {
	            nextnode = nextnode.next;
	            currnode.next = prevnode;
	            prevnode = currnode;
	            currnode = nextnode;
	        }
	        head = prevnode;
	    }
	}
	
	public void show(){
		Node tempnode = head;
		while(tempnode != null) {
			System.out.print(tempnode.data + " ");
			tempnode = tempnode.next;
		}
	}
	public int size() {
	    Node tempnode = head;
	    int count = 0;
	    while(tempnode != null){
	        count++;
	        tempnode = tempnode.next;
	    }
	    return count;
	}
}
