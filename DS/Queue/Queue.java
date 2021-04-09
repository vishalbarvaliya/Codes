class Runners {
    public static void main(String[] args) {
        Queue que = new Queue();
        que.enQueue(10);
        que.enQueue(20);
        que.enQueue(30);
        
        System.out.println(que.peek());
        que.display();
    }
}
class Queue {
    int[] queue = new int[5];
    int front = - 1;
    int rear = - 1;
    
    public void enQueue(int data) {
        if(isFull())
            System.out.println("Could not enqueue data, Queue is overflowed!");
        else if(isEmpty()){
            front = rear = 0;
            queue[rear] = data;
        } else {
            rear++;
            queue[rear] = data;
        }       
    }
    
    public int deQueue() {
        int data = 0;
        if(isEmpty())
            System.out.println("Could not dequeue data, Queue is empty!");
        else if(front == rear)
            front = rear = - 1;
        else {
            data = queue[front];
            front++;
        }
        return data;
    }
    
    public void display() {
        if(isEmpty())
            System.out.println("Could not retrieve data, Queue is empty!");
        else {
            for(int i = front; i <= rear; i++){
                System.out.print(queue[i] + " ");
            }
        }
    }
    
    public int peek(){
        if(isEmpty()){
            System.out.println("Could not retrieve peek element, Queue is empty!");
            return 0;
        }            
        else
            return queue[front];
    }
    
    public boolean isFull() {
        return rear == queue.length - 1;
    }
   
    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }
}
