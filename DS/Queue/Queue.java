class Runners {

    public static void main(String[] args) {
        Queue que = new Queue();
        que.enQueue(10);
        que.enQueue(20);
        //que.enQueue(30);
        que.deQueue();

        System.out.println(que.isEmpty());
        que.display();
    }
}

class Queue {

    int[] queue = new int[5];
    int front = -1;
    int rear = -1;

    public void enQueue(int data) {

        if(isFull()) {
            System.out.println("Could not enqueue data, Queue is overflowed!");
        }
        else if(isEmpty()){
            front = rear = 0;
            queue[rear] = data;
        }
        else{
            rear = (rear + 1) % 5;
            queue[rear] = data;
        }
    }

    public int deQueue() {
        int data = 0;
        if (isEmpty()) {
            System.out.println("Could not dequeue data, Queue is empty!");
        } 
        else if (front == rear){
            data = queue[front];
            front = rear = -1;
        }            
        else {
            data = queue[front];
            front = (front + 1) % 5;            
        }
        return data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Could not retrieve data, Queue is empty!");
        } else {
            int i = front;
            while(i != rear) {
                System.out.print(queue[i] + " ");
                i = (i + 1) % queue.length;
            }
            System.out.print(queue[rear]);
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Could not retrieve peek element, Queue is empty!");
            return 0;
        } else {
            return queue[front];
        }
    }

    public boolean isFull() {
        return (rear + 1) % queue.length == front;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }
}
