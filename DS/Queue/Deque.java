package dsa;
class Run {
    public static void main(String[] args) {
        Deque deq = new Deque();
        deq.enQueueFront(2);
        deq.enQueueFront(5);
        deq.enQueueFront(10);
            
        deq.display();
    }
}
public class Deque {
    int[] deque = new int[5];
    int front = -1, rear = -1;
    
    public void enQueueFront(int data) {
        if(isFull()) {
            System.out.println("Could not enqueue data, Queue is overflowed!");
        }
        else if(isEmpty()){
            front = rear = 0;
            deque[front] = data;
        }
        else if(front == 0) {
            front = deque.length - 1;
            deque[front] = data;
        }
        else {
            front--;
            deque[front] = data;
        }
    }
    
    public void enQueueRear(int data) {
        if(isFull()){
            System.out.println("Could not enqueue data, Dueue is overflowed!");
        }
        else if(isEmpty()){
            front = rear = 0;
            deque[rear] = data;
        }
        else if(rear == deque.length - 1) {
            rear = 0;
            deque[rear] = data;
        }
        else {
            rear++;
            deque[rear] = data;
        }
    }
    
    public int deQueueFront(){
        int data = 0;
        if(isEmpty()){
            System.out.println("Could not dequeue, Dueue is empty!");
        }
        else if(front == rear) {
            data = deque[front];
            front = rear = -1;
        }
        else if(front == deque.length - 1){
            data = deque[front];
            front = 0;
        }
        else {
            data = deque[front];
            front++;
        }
        
        return data;
    }
    
    public int deQueueRear() {
        int data = 0;
        if(isEmpty()){
            System.out.println("Could not dequeue, Deque is empty!");
        }
        else if(front == rear) {
            data = deque[rear];
            front = rear = -1;
        }
        else if(rear == 0){
            data = deque[rear];
            rear = deque.length - 1;
        }
        else {
            data = deque[rear];
            rear--;
        }
        return data;
    }
        
    public void display() {
        if(isEmpty()){
            System.out.println("Could not retrieve data, Dueue is empty!");
        }
        else {
            int i = front;
            while(i != rear) {
                System.out.print(deque[i] + " ");
                i = (i + 1) % deque.length;
            }
            System.out.print(deque[rear]);
        }
    }    
    
    public int getFront() {
        return isEmpty() ? 0 : deque[front];
    }
    
    public int getRear() {
        return isEmpty() ? 0 : deque[rear];
    }
    
    public boolean isFull() {
        return (front == 0 && rear == deque.length - 1) || (front == rear + 1);
    }
    
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }
    
}
