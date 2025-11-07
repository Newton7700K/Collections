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
        return list.removeHead();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public E top() {
        return list.getHead();
    }
    
    public int size() {
        return list.size();
    }
    
    public String toString() {
        return list.toString();
    }
    
}