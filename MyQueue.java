//1234512345123452134512345123451234521345123451234512345213451234512345123452134512345123451234521345123451234512345213
import java.util.*;

public class MyQueue<E> {
    private E[] queue;
    private int front = 0; //points to location of next in
    private int end = 0; //points to location of last element out
    private int count = 0;
    
    public MyQueue() {
        queue = (E[]) new Object[100];
    }
    
    public MyQueue(int maxSize) {
        queue = (E[]) new Object[maxSize];
    }
    
    public void enqueue(E element) {
        if(isFull()) {
            throw new IllegalStateException();
        } else {
            queue[front] = element;
            front = (front + 1) % queue.length;
            count++;
        }
    }
    
    public E dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        } else {
            end = (end + 1) % queue.length;
            count--;
            return queue[end];
        }       
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public E front() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return queue[(front+queue.length-1) % queue.length];
        }  
    }
    
    public int size() {
        return count;
    }
    
    public boolean isFull() {
        return count == queue.length;
    }
    
    public String toString() {
        String str = "";
        if(!isEmpty()) {
            str += queue[end];
        }
        for (int i = end + 1; i < end + count; i++) {
            str += ", " + queue[i % queue.length];
        }
        return str;
    }
}