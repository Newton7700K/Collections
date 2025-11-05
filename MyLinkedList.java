public class MyLinkedList<E>
{
    
    private Node<E> head;
    private Node<E> tail;
    
    public void addTail(E element) {
        Node currentNode = new Node(element, tail);
        tail.setNext(currentNode);
        tail = currentNode;
    }
    
    public void addHead(E element) {
        Node currentNode = new Node(element, head);
        head = currentNode;
    }
    
    public E removeHead(){
        E element = head.getElement();
        head = head.getNext();
        return element;
    }
    
    public E getHead(){
        return head.getElement();
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
        
        public Node(E value, Node next) {
            this.element = value;
            this.next = next;
        }
        
        public E getElement() {
            return element;
        }
        
        public Node getNext(){
            return next;
        }
        
        public void setNext(Node next){
            this.next = next;
        }
    }
    
}