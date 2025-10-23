import java.util.*;

public class MyStack<E> {
    private E[] stack;
    private int top = 0;
    
    public MyStack() {
        stack = (E[]) new Object[100];
    }
    
    public MyStack(int maxSize) {
        stack = (E[]) new Object[maxSize];
    }
    
    public void push(E element) {
        if(isFull()) {
            throw new IllegalStateException();
        } else {
            stack[top] = element;
            top++;
        }
    }
    
    public E pop() {
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
    
    public E top() {
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