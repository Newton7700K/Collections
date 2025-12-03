import java.util.*;

public class MyRobustLinkedList<E>
{
    
    private Node<E> head;
    private Node<E> tail;
    private int count;
    
    public void addTail(E element) {
        Node newNode = new Node(element, null, tail);
        if(!isEmpty()) {
            tail.setNext(newNode);
        } else {
            head = newNode;
        }
        count++;
        tail = newNode;
    }
    
    public void addHead(E element) {
        Node newNode = new Node(element, head, null);
        if(!isEmpty()) {
            head.setPrev(newNode);
        } else {
            tail = newNode;
        }
        count++;
        head = newNode;
    }
    
    public Node<E> getNode(int index) {
        Node<E> pointer;
        if(index > size()){
            pointer = tail;
            for(int i = size() - 1; i > index; i--){
                pointer = pointer.getPrev();
            }
        } else {
            pointer = head;
            for(int i = 0; i < index; i++){
                pointer = pointer.getPrev();
            }
        }
        return pointer;
    }
    
    public void add(E element) {
        addTail(element);
    }
    
    public void add(int index, E element) {
        if(index == 1 || index == size() - 2){ 
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> newNode = new Node<E>(element, getNode(index).getPrev(), 
                    getNode(index).getNext());
            getNode(index).getPrev().setNext(getNode(index));
            getNode(index).getNext().setPrev(getNode(index));
            
        }
    }
    
    public E removeHead(){
        if(isEmpty()) {
            throw new NoSuchElementException();
        } else {
            E element = head.getElement();
            if(size() == 1){ //is last element
                head = null;
                tail = null;
            } else {
                head = head.getNext();
                head.setPrev(null);
            }
            count--;
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
