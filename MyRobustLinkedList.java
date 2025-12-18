import java.util.*;

/**
 * Creates a doubly linked list data structure
 * 
 * @author Newton Zheng
 * @version December 2025
 * @param E type of element stored in list
 */

public class MyRobustLinkedList<E extends Comparable<E>>
{
    
    private Node<E> head;
    private Node<E> tail;
    private int count = 0;
    /**
     * Adds new node to the end of the linked list.
     * 
     * @param E element in node to be added
     */
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
    
    /**
     * Adds new node to the beginning of the linked list.
     * 
     * @param E element in node to be added
     */
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
    
    /**
     * Returns node at specified index.
     * 
     * @param int index of node to be returned
     * @returns Node<E> node at specified index
     * @throws IndexOutOfBoundsException when index out of bounds
     */
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
    
    /**
     * Adds node to the end of linked list.
     * 
     * @params E element in node to be added
     */
    public void add(E element) {
        addTail(element);
    }
    
    /**
     * Adds node to specified index.
     * 
     * @param int index of node to be added
     * @param E element in node to be added
     * @throws IndexOutOfBoundsException when index out of bounds
     */
    public void add(int index, E element) {
        if(index < 0 || index > size()){ 
            throw new IndexOutOfBoundsException();
        } else if(index == 0) {
            addHead(element);
        } else if (index == size()) {
            addTail(element);
        } else {
            Node<E> currentNode = getNode(index);
            Node<E> newNode = new Node<E>(element, currentNode.getPrev(),
                    currentNode);
            currentNode.getPrev().setNext(newNode);
            currentNode.setPrev(newNode);
            count++;
        }
    }
    
    /**
     * Gets element at specified index.
     * 
     * @params int index of node to be returned
     * @return E element to be returned at index
     * @throws IndexOutOfBoundsException when index out of bounds
     */
    public E get(int index){
        if (index < 0 || index >= size()){ 
            throw new IndexOutOfBoundsException();
        } else {
            return getNode(index).getElement();
        }
    }
    
    /**
     * Replaces node at given index with other node.
     * 
     * @param int index of node to be replaced
     * @param E element in node to replace current node
     * @throws IndexOutOfBoundsException when index out of bounds
     */
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
    
    /**
     * Removes node at given index.
     * 
     * @param int index of node to be removed
     * @return E element removed
     * @throws IndexOutOfBoundsException when index out of bounds
     */
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
    
    /**
     * Removes node at beginning of list.
     * 
     * @return E element in node
     * @throws NoSuchElementException if list is empty
     */
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
    
    /**
     * Returns first index of specified element.
     * 
     * @param E element to be found
     * @return int index of found element
     */
    public int indexOf(E element) {
        for (int i = 0; i<size(); i++) {
            if(getNode(i).getElement().equals(element)){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Returns last index of specified element.
     * 
     * @param E element to be found
     * @return int index of found element
     */
    public int lastIndexOf(E element) {
        int idx = -1;
        for (int i = 0; i<size(); i++) {
            if(getNode(i).getElement().equals(element)){
                idx = i;
            }
        }
        return idx;
    }
    
    /**
     * Removes first instance of node containing element.
     * 
     * @param E element to be removed
     * @return boolean whether element was found
     */
    public boolean remove(E element) {
        if (indexOf(element) != -1) {
            remove(indexOf(element));
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Inserts node at its sorted location.
     * 
     * @param E element to be inserted
     * @throws NoSuchElementException when list is empty
     */
    public void insertSorted(E element) {
        if(isEmpty()){
            throw new NoSuchElementException();
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
    
    /**
     * Returns first element in list.
     * 
     * @return E first element in list
     * @throws NoSuchElementException when list is empty
     */
    public E getHead(){
        if(isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return head.getElement();
        }
    }
    
    /**
     * Returns whether list is empty.
     * 
     * @return boolean is empty
     */
    public boolean isEmpty(){
        return count == 0;
    }
    
    /**
     * Returns size of list
     * 
     * @return int size of list
     */
    public int size(){
        return count;
    }
    
    /**
     * Returns all elements in list formatted.
     * 
     * @return String list to be returned
     */
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
   
    /**
     * Creates a node object
     */
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

