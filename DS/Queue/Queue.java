class Runners {
    public static void main(String[] args) {
        Queue que = new Queue();
        que.enQueue(10);
        //que.enQueue(20);
        que.deQueue();            
        
        System.out.println(que.isEmpty());
        que.display();
    }
}
class Queue {
    int[] queue = new int[5];
    int front = 0;
    int rear = 0;
    int size = 0;
    
    public void enQueue(int data) {
        
        if(isFull()){
            System.out.println("Could not enqueue data, Queue is overflowed!");
        } else {
            queue[rear] = data;
            rear = (rear + 1) % 5;
            size++;
        }
    }
    
    public int deQueue() {
        int data = 0;
        if(isEmpty())
            System.out.println("Could not dequeue data, Queue is empty!");
        else {
            data = queue[front];
            front = (front + 1) % 5;
            size--;
        }
        return data;
    }
    
    public void display() {
        if(isEmpty())
            System.out.println("Could not retrieve data, Queue is empty!");
        else {
            for(int i = 0; i < size; i++){
                System.out.print(queue[(front + i) % 5] + " ");
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
        return size == queue.length;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
}

