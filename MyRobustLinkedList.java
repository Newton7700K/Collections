import java.util.*;

public class MyRobustLinkedList<E extends Comparable<E>>
{
    
    private Node<E> head;
    private Node<E> tail;
    private int count = 0;
    
    public void addTail(E element) {
        Node newNode = new Node(element, null, null);
        if(isEmpty()) {
            head = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
        }
        count++;
        tail = newNode;
    }
    
    public void addHead(E element) {
        Node newNode = new Node(element, null, null);
        if(isEmpty()) {
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
        }
        count++;
        head = newNode;
    }
    
    public Node<E> getNode(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> pointer;
            if(index > size()/2){
                pointer = tail;
                for(int i = size() - 1; i > index; i--){
                    pointer = pointer.getPrev();
                }
            } else {
                pointer = head;
                for(int i = 0; i < index; i++){
                    pointer = pointer.getNext();
                }
            }
            return pointer;
        }
    }
    
    public void add(E element) {
        addTail(element);
    }
    
    public void add(int index, E element) {
        if(index < 0 || index >= size()){ 
            throw new IndexOutOfBoundsException();
        } else if(index == 0) {
            addHead(element);
        } else {
            Node<E> currentNode = getNode(index);
            Node<E> newNode = new Node<E>(element, currentNode.getPrev(),
                    currentNode);
            currentNode.getPrev().setNext(newNode);
            currentNode.setPrev(newNode);
            count++;
        }
    }
    
    public E get(int index){
        if (index < 0 || index >= size()){ 
            throw new IndexOutOfBoundsException();
        } else {
            return getNode(index).getElement();
        }
    }
    
    public void set(int index, E element) {
        Node<E> newNode = new Node<E>(element, null, null);
        Node<E> currentNode = getNode(index);
        if (index < 0 || index >= size()){ 
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            removeHead();
            addHead(element);
        } else if (index == size() - 1) {
            if(tail.getPrev() != null){
                tail.getPrev().setNext(newNode);
                newNode.setPrev(tail.getPrev());
            } else {
                head = newNode;
            }
            tail = newNode;
        } else {
            currentNode.getPrev().setNext(newNode);
            newNode.setPrev(currentNode.getPrev());
            currentNode.getNext().setPrev(newNode);
            newNode.setNext(currentNode.getNext());
        }
    }
    
    public E remove(int index) {
        if(index < 0 || index >= size()){ 
            throw new IndexOutOfBoundsException();
        } else if (index == 0){
            return removeHead();
        } else if (index == size() - 1) {
            Node<E> currentNode = getNode(index);
            if (tail.getPrev() != null) {
                tail = tail.getPrev();
                tail.setNext(null);
            } else {
                tail = null;
                head = null;
            }
            count--;
            return currentNode.getElement();
        } else {
            Node<E> currentNode = getNode(index);
            currentNode.getPrev().setNext(currentNode.getNext());
            currentNode.getNext().setPrev(currentNode.getPrev());
            count--;
            return currentNode.getElement();
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
    
    int indexOf(E element) {
        for (int i = 0; i<size(); i++) {
            if(getNode(i).getElement().equals(element)){
                return i;
            }
        }
        return -1;
    }
    
    int lastIndexOf(E element) {
        int idx = -1;
        for (int i = 0; i<size(); i++) {
            if(getNode(i).getElement().equals(element)){
                idx = i;
            }
        }
        return idx;
    }
    
    boolean remove(E element) {
        if (indexOf(element) != -1) {
            remove(indexOf(element));
            return true;
        } else {
            return false;
        }
    }
    
    void insertSorted(E element) {
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        } else {
            boolean lessThanCurrent = true;
            int idx = 0;
            while(lessThanCurrent && idx < size()){
                if(getNode(idx).getElement().compareTo(element)>=0){
                    lessThanCurrent = false;
                } else {
                    idx++;
                }
            }
            if (idx == 0) {
                addHead(element);
            } else if(idx >= size()) {
                add(element);
            } else {
                add(idx, element);
            }
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
        
        public Node(E element, Node prev, Node next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
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

