package dsa;
class Runner {
    public static void main (String[] args) {
        DStack st = new DStack();
        st.push(10);
        st.display();
        st.push(20);
        st.display();
        st.push(30);
        st.display();
        st.push(40);
        st.display();
        st.push(50);
        st.display();
        
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        
        st.display();          
    }
}
class DStack {
    int capacity = 2;
    int stack[] = new int[capacity];
    int top = - 1;
    
    public void push(int data) {
        if(top + 1 == capacity) 
            expand();
        top++;       
        stack[top] = data;
    }
    
    public int pop(){
        int data = 0;
        if(isEmpty())
            System.out.println("Could not pop data, Stack is empty!");
        else {
            data = stack[top];
            stack[top] = 0;
            top--;
            if(top + 1 <= (capacity / 2) / 2)
                shrink();
        }
        return data;
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
        System.out.println("");
    }
    
    private void expand() {
        int length = capacity;
        int newStack[] = new int[capacity * 2];
        System.arraycopy(stack, 0, newStack, 0,length);
        stack = newStack;
        capacity *= 2;
    }
    
    private  void shrink() {
        capacity = capacity / 2;
        int[] newStack = new int[capacity];
        System.arraycopy(stack, 0, newStack, 0, top + 1);
        stack = newStack;        
    }
    
    public boolean isEmpty() {
        return top == -1;
    }   
}


