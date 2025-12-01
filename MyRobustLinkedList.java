import java.util.*;

public class MyRobustLinkedList<E>
{
    
    private Node<E> head;
    private Node<E> tail;
    
    public void addTail(E element) {
        Node newNode = new Node(element, null, tail);
        if(!isEmpty()) {
            tail.setNext(newNode);
        } else {
            head = newNode;
        }
        tail = newNode;
    }
    
    public void addHead(E element) {
        Node newNode = new Node(element, head, null);
        if(!isEmpty()) {
            head.setPrev(newNode);
        } else {
            tail = newNode;
        }
        head = newNode;
    }
    
    public E removeHead(){
        if(isEmpty()) {
            throw new NoSuchElementException();
        } else {
            E element = head.getElement();
            head = head.getNext();
            head.setPrev(null);
            return element;
        }
    }
    
    public E getHead(){
        if(isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return head.getElement();
        }
    }
    
    public boolean isEmpty(){
        return head == null && tail == null;
    }
    
    public int size(){
        Node<E> currentNode = head;
        int count = 0;
        while(currentNode != null){
            count++;
            currentNode = currentNode.getNext();
        }
        return count;
    }
    
    public String toString(){
        Node<E> currentNode = head;
        String str = "";
        if(currentNode != null){
            str += currentNode.getElement();
            currentNode = currentNode.getNext();
        }
        while(currentNode != null){
            str += ", " + currentNode.getElement();
            currentNode = currentNode.getNext();
        }
        return str;
    }
   
   public class Node<E>
    {
        private E element;
        private Node next;
        private Node prev;
        
        public Node(E element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
        
        public E getElement() {
            return element;
        }
        
        public Node getNext(){
            return next;
        }
        
        public Node getPrev(){
            return prev;
        }
        
        public void setNext(Node next){
            this.next = next;
        }
        
        public void setPrev(Node prev){
            this.prev = prev;
        }
    }
    
}
