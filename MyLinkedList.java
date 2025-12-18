import java.util.*;

public class MyLinkedList<E>
{
    
    private Node<E> head;
    private Node<E> tail;
    private int count = 0;
    
    public void addTail(E element) {
        Node newNode = new Node(element, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            
        } else {
            tail.setNext(newNode); //fix this
            tail = newNode;
        }
        count++;
    }
    
    public void addHead(E element) {
        Node newNode = new Node(element, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        count++;
    }
    
    public E removeHead(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            E element = head.getElement();
            head = head.getNext();
            count--;
            return element;
        }
    }
    
    public E getHead(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return head.getElement();
        }
    }
    
    public boolean isEmpty(){
        return count == 0;
    }
    
    public int size(){
        return count;
    }
    
    public String toString(){
        Node<E> newNode = head;
        String str = "";
        if (newNode != null){
            str += newNode.getElement();
            newNode = newNode.getNext();
        }
        while (newNode != null){
            str += ", " + newNode.getElement();
            newNode = newNode.getNext();
        }
        return str;
    }
   
   private class Node<E>
    {
        private E element;
        private Node next;
        
        private Node(E value, Node next) {
            this.element = value;
            this.next = next;
        }
        
        private E getElement() {
            return element;
        }
        
        private Node getNext(){
            return next;
        }
        
        private void setNext(Node next){
            this.next = next;
        }
    }
    
}