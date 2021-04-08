class Runner {
    public static void main (String[] args) {
        Stack st = new Stack();
        st.push(10);
        st.push(20);
        st.push(30);
    
        st.display();
    }
}
class Stack {
    int[] stack = new int[5];
    int top = - 1;
    
    public void push(int data) {
        if(isFull()) {
            System.out.println("Could not push data, Stack overflowed!");
        } else {
            top++;
            stack[top] = data;
        }
    }
    
    public int pop(){
        if(isEmpty())
            System.out.println("Could not pop data, Stack is empty!");
        else {
            int data;
            data = stack[top];
            stack[top] = 0;
            top--;
            return data;
        }
        return 0;
    }
    
    public int peak() {
        return stack[top];
    }
    
    public void display() {
        if(isEmpty()) 
            System.out.println("Could not retrieve data, Stack is empty!");
        else
            for(int i : stack) 
                System.out.print(i + " ");
    }
    
    public boolean isEmpty() {
        if(top == -1)
            return true;
        return false;
    }
    
    public boolean isFull() {
        if(top + 1 == stack.length)
            return true;
        return false;
    }
}

