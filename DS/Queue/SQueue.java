class Runnerr{
    public static void main(String[] args) {
        SQueue que = new SQueue();
        que.enQueue(10);
        que.enQueue(20);
        
       // que.deQueue();
        que.display();
    }
}
class SQueue {
    int[] stackEn = new int[5];
    int[] stackDe = new int[5];
    int count = 0;
    int topEn = -1, topDe = -1;
    
    public void enQueue(int data) {
        if(isFull()){
            System.out.println("Could not enqueue data, Queue is overflowed!");
        }
        else {
            push_En(data);
            count++;
        }
    }
    
    public int deQueue() {
        int data = 0;
        if(isEmpty()) {
            System.out.println("Could not dequeue data, Queue is empty!");
        }
        else {
            int x = 0;
            for(int i = 0; i < count; i++) {
                x = pop_En();
                push_De(x);
            }
            data = pop_De();
            count--;
            for(int i = 0; i < count; i++) {
                x = pop_De();
                push_En(x);
            }
        }
        return data;
    }
    
    public void display(){
        if(isEmpty()){
            System.out.println("Could not retrieve data, Queue is empty!");
        }
        else {
            for(int i = 0; i <= topEn; i++) {
                System.out.print(stackEn[i] + " ");
            }
        }
    }
        
    private void push_En(int item) {
        topEn++;
        stackEn[topEn] = item;
    }
    
    private void push_De(int item) {
        topDe++;
        stackDe[topDe] = item;
    }
    
    private int pop_En() {
        return stackEn[topEn--];
    }
    
    private int pop_De(){
        return stackDe[topDe--];
    }
    
    public boolean isEmpty() {
        return topEn == -1;
    }
    
    public boolean isFull() {
        return topEn == stackEn.length - 1;
    }
}

