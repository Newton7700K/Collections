import java.util.*;

public class MyStack {
    private int[] stack;
    private int top = 0;
    
    public MyStack(int maxSize) {
        stack = new int[maxSize];
    }
    
    public void push(int element) {
        if(isFull()) {
            throw new IllegalStateException();
        } else {
            stack[top] = element;
            top++;
        }
    }
    
    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            top--;
            return stack[top];
        }
    }
    
    public boolean isEmpty() {
        return top == 0;
    }
    
    public int top() {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stack[top - 1];
        }
    }
    
    public int size() {
        return top;
    }
    
    public boolean isFull() {
        return top == stack.length;
    }
    
    public String toString() {
        String str = "";
        if(!isEmpty()) {
            str += stack[0];
        }
        for (int i = 1; i < top; i++) {
            str += ", " + stack[i];
        }
        return str;
    }
    
}