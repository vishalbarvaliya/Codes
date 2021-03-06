class Node {
    int data;
    Node next;
}
class Runnerss {
    public static void main (String[] args) {
        LQueue que = new LQueue();
        que.enQueue(10);
        que.enQueue(20);
        
        que.deQueue();
        que.enQueue(30);
        que.display();
    }
}

class LQueue {
    Node front, rear;
    
    
    public void enQueue(int data) {
        Node newnode = new Node();
        newnode.data = data;
        if(isEmpty()) {
            front = rear = newnode;
        }
        else {
            rear.next = newnode;
            rear = newnode;
        }
    }
    
    public int deQueue() {
        int data = 0;
        if(isEmpty())
            System.out.println("Could not dequeue data, Queue is empty!");
        else {
            data = front.data;
            front = front.next;
        }
        return data;
    }
    
    public void display() {
        if(isEmpty())
            System.out.println("Could not retrieve data, Queue is empty!");
        else{
            Node tempnode = front;
            while(tempnode != null) {
                System.out.print(tempnode.data + " ");
                tempnode = tempnode.next;
            }
        }
    }
    public int peek() {
        int data = 0;
        if(isEmpty())
            System.out.println("Could not retrieve peek, Queue is empty!");
        else{
            data = front.data;
        }
        return data;
    }
    
    public boolean isEmpty () {
        return front == null & rear == null;
    }
    
}
