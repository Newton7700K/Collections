//1234512345123452134512345123451234521345123451234512345213451234512345123452134512345123451234521345123451234512345213
import java.util.*;

public class MyQueueLL<E> {
    private MyLinkedList<E> list;
    
    public MyQueueLL() {
        list  = new MyLinkedList<E>();
    }
    
    public void enqueue(E element) {
        list.addHead(element);
    }
    
    public E dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return list.removeHead();
        }       
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public E front() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return list.getHead();
        }  
    }
    
    public int size() {
        return list.size();
    }
    
    public String toString() {
        return list.toString();
    }
}