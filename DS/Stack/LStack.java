package dsa;
class Nodes {
    int data;
    Nodes next;
}
class Runners {
    public static void main(String[] args) {
        LStack st = new LStack();
        st.push(10);
        st.push(20);
        st.push(30);
        
        System.out.println(st.peak());
        st.display();
    }
}
class LStack {
    Nodes top, head;
    
    public void push(int data) {
        Nodes newnode = new Nodes();
        newnode.data = data;    
        newnode.next = top;
        top = newnode;
    }
    
    public int pop() {
        int data = 0;
        if(isEmpty()) {
            System.out.println("Could not pop data, Stack is empty!");
        }
        else {
            data = top.data;
            top = top.next;
        }
        return data;
    }
    
    public int peak() {
        int data = 0;
        if(isEmpty()){
            System.out.println("Could not retrieve peak element, Stack is empty!");
        }
        else {
            data = top.data;
        }
        return data;
    }
    
    public void display() {
        if(isEmpty()) {
            System.out.println("Could not retrieve data, Stack is empty!");
        } 
        else {
            Nodes tempnode = top;
            while(tempnode != null) {
                System.out.print(tempnode.data + " ");
                tempnode = tempnode.next;
            }
        }              
    }
    public boolean isEmpty() {
        return top == null;
    }
}
