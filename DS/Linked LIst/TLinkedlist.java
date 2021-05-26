package testfiles;

class Node<T> {

    T data;
    Node next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    
}

class Runner {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(4);
       // list.insert(5);
        list.insert(6);
        list.insert(7.42);
        list.insert(8);
        list.insertAt(2, "hello 2nd pos");
        list.insertAtStart("Im first");
        list.insert("last");
        list.show();
    }

}

public class LinkedList {

    Node head;

    public <T> void insert(T data) {
        Node newnode = new Node(data);
        
        if (head == null) {
            head = newnode;
        } else {
            Node tempnode = head;
            while (tempnode.next != null) {
                tempnode = tempnode.next;
            }
            tempnode.next = newnode;
        }
    }

    public <T> void insertAtStart(T data) {
        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;

    }

    public <T> void insertAt(int index, T data) {
        if (index < 0 || index > size()) {
            System.out.println("invalid index");
            return;
        }

        Node newnode = new Node(data);

        if (index == 0) {
            insertAtStart(data);
        }

        Node tempnode = head;
        for (int i = 0; i < index - 1; i++) {
            tempnode = tempnode.next;
        }
        newnode.next = tempnode.next;
        tempnode.next = newnode;
    }

    public boolean removeAt(int index) {
        if (head == null || index >= size()) {
            return false;
        }
        if (index == 0) {
           return remove();
        } else {
            Node tempnode = head;
            for (int i = 0; i < index - 1; i++) {
                tempnode = tempnode.next;
            }
            tempnode.next = (tempnode.next).next;
            return true;
        }
    }
    
    public boolean remove() {
        if(head == null) 
            return false;
        head = head.next;
        return true;
    }

    public <T> boolean remove(T data) {
        if(head == null)
            return false;
        
        if(head.data.equals(data)){
            return remove();
        }
        Node tempnode = head;
        if(contains(data)) {
            while(!(tempnode.data.equals(data))) {
            tempnode = tempnode.next;
            }
            tempnode.next = (tempnode.next).next;
            return true;
        }
        return false;
    }
    
    public <T> boolean contains(T data) {
        if (head == null) {
            return false;
        }
        Node tempnode = head;
        while (tempnode != null) {
            if (tempnode.data.equals(data)) {
                return true;
            }
            tempnode = tempnode.next;
        }
        return false;
    }

    public void reverseList() {
        if (head == null) {
            System.out.println("List is empty..");
        } else {
            Node currnode = head, nextnode = head, prevnode = null;
            while (nextnode != null) {
                nextnode = nextnode.next;
                currnode.next = prevnode;
                prevnode = currnode;
                currnode = nextnode;
            }
            head = prevnode;
        }
    }

    public void show() {
        Node tempnode = head;
        while (tempnode != null) {
            System.out.print(tempnode.data + " ");
            tempnode = tempnode.next;
        }
    }

    public int size() {
        Node tempnode = head;
        int count = 0;
        while (tempnode != null) {
            count++;
            tempnode = tempnode.next;
        }
        return count;
    }
}
