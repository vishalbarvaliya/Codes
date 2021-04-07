package dsa;

class Node {

    int data;
    Node next;
}

class Runner {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        //list.insert(50);
        //list.insert(60);
        //list.insert(70);
        //list.insertAt(0,10);
        //list.insertAt(5,60);
        // list.insertAt(9,100);
        //list.delete();
        //list.deleteAt(4);
        //list.deleteAt(3);
        //list.deleteAt(6);
        list.reverseList();
        list.show();

        System.out.println("");

        System.out.println(list.getHead());
        System.out.println(list.getTail());
        // System.out.println(list.size());

    }
}

class LinkedList {

    Node head, tail;

    public void insert(int data) {
        Node newnode = new Node();
        newnode.next = null;
        newnode.data = data;

        if (head == null) {
            head = tail = newnode;
            newnode.next = head;
        } else {
            tail.next = newnode;
            tail = newnode;
            tail.next = head;
        }
    }

    public void insertAtBegin(int data) {
        Node newnode = new Node();
        newnode.data = data;

        newnode.next = head;
        head = newnode;
        tail.next = head;
    }

    public void insertAt(int index, int data) {
        if (index == 0) {
            insertAtBegin(data);
        } else {
            Node newnode = new Node();
            newnode.data = data;
            Node tempnode = head;
            for (int i = 0; i < index - 1; i++) {
                tempnode = tempnode.next;
            }

            if (index == size()) {
                tempnode.next = newnode;
                newnode.next = head;
                tail = tempnode.next;
                return;
            }
            newnode.next = tempnode.next;
            tempnode.next = newnode;
        }
    }

    public void delete() {
        head = head.next;
        tail.next = head;
    }

    public void deleteAt(int index) {
        if (head == null) {
            System.out.println("List is empty..");
            return;
        }
        if (index < 0 || index >= size()) {
            System.out.println("Invalid index..");
            return;
        }
        if (index == 0) {
            delete();
            return;
        }
        Node tempnode = head;
        for (int i = 0; i < index - 1; i++) {
            tempnode = tempnode.next;
        }
        if (index == size() - 1) {
            tempnode.next = head;
            tail = tempnode;
            tail.next = head;
            return;
        }
        tempnode.next = (tempnode.next).next;
    }

    public void reverseList() {

        tail = head;
        Node currnode = head, prevnode = head, nextnode = head;
        currnode = currnode.next;
        nextnode = nextnode.next.next;

        while (currnode != head) {
            currnode.next = prevnode;
            prevnode = currnode;
            currnode = nextnode;
            nextnode = nextnode.next;
        }
        head = prevnode;
        currnode.next = head;

    }

    public void show() {
        Node tempnode = head;
        do {
            System.out.print(tempnode.data + " ");
            tempnode = tempnode.next;
        } while (tempnode != head);
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        int count = 1;
        Node tempnode = head;
        while (tempnode.next != head) {
            count++;
            tempnode = tempnode.next;
        }
        return count;
    }

    public int getHead() {
        return head.data;
    }

    public int getTail() {
        return tail.data;
    }
}
