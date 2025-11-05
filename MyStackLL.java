import java.util.*;

public class MyStackLL<E> {
    private MyLinkedList<E> list;
    
    public MyStackLL(){
        list = new MyLinkedList<E>();
    }
    
    public void push(E element) {
        list.addHead(element);
    }
    
    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            return list.removeHead();
        }
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public E top() {
        if(isEmpty()) {
            throw new EmptyStackException();
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