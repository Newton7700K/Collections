public class MyStack
{
    /*
        - public MyStack() – Constructs a stack that can hold 100 elements.
        - public MyStack(int maxSize) – Constructs a stack that can hold max.
        - public void push(int element) – Pushes an element on to the stack.
        - public int pop() – Pops an element off of the stack.
        - public boolean isEmpty() – Indicates whether stack contains any elements.
        - public int top() – Reads the element at the top of the stack.
        - public int size() – Returns the number of elements stored in the stack.
        - public boolean isFull() – Indicates whether the stack has exhausted its available storage.
        - public String toString() – Returns the contents of the stack from top to bottom.
    */
   
    private int[] stack;
    private int top = 0;
    
    public MyStack(int maxSize) {
        stack = new int[maxSize];
    }
    
    public void push(int element) {
        stack[top] = element;
        top++;
    }
    
    public int pop() {
        top--;
        return stack[top];
    }
    
    public boolean isEmpty(){
        if (top == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public int top(){
        return stack[top-1];
    }
    
    public int size(){
        return top;
    }
    
    public boolean isFull(){
        if(top == stack.length){
            return true;
        } else {
            return false;
        }
    }
    
    public String toString() {
        String str = stack[0] + "";
        for (int i = 1; i < top; i++) {
            str += ", " + stack[i];
        }
        return str;
    }
    
}