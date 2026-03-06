import java.lang.Math;
import java.util.Arrays;
/**
 * Write a description of class MyHashTable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyHashTable<K,V>
{
    
    private Node[] table;
    private int count;
    
    /**
     * Constructor for objects of class MyHashTable
     */
    public MyHashTable() {
        table = new Node[10];
        count = 0;
    }
    
    public void put(K key, V value) {
        Node<K,V> search = searchBucket(getHash(key), key);
        if(search != null){
            search.setValue(value);
        } else {
            
        }
        addToBucket(getHash(key), new Node(key, value));
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public int size() {
        return count;
    }
    
    public V get(K key) {
        return (V) table[getHash(key)].getValue();
    }
    
    private int getHash(K key) {
        int hash = Math.abs(key.hashCode());
        return hash % table.length;
    }
    
    public V remove(K key) {
        return removeFromBucket(getHash(key), searchBucket(getHash(key), key)).getValue();
    }
    
    public void addToBucket(int bucket, Node<K,V> newNode){
        Node<K,V> node = new Node<K,V>(newNode.getKey(), newNode.getValue());
        while(newNode.getNext() != null)
        newNode.setNext(table[bucket]);
        table[bucket] = newNode;
    }
    
    public Node<K,V> searchBucket(int bucket, K key){
        Node currentNode = table[bucket];
        while(currentNode != null) {
            if(currentNode.getKey().equals(key)){
                return currentNode;
            }
        }
        return null;
    }
    
    public Node<K,V> removeFromBucket(int bucket, Node<K,V> oldNode){
        Node currentNode = table[bucket];
        Node searchNode = searchBucket(bucket, oldNode.getKey());
        while(currentNode.getNext() != null && currentNode.getNext() != searchNode){
            if(currentNode.getNext() == searchNode){
                currentNode.setNext(searchNode.getNext());
                return searchNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }
    
    public String toString() {
        return Arrays.toString(table);
    }
    
    public class Node<K,V> {
        private K key;
        private V value;
        private Node<K,V> next;
        
        private Node(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }
        
        private K getKey(){
            return key;
        }
        
        private V getValue(){
            return value;
        }
        
        private void setKey(K key) {
            this.key = key;
        }
        
        private void setValue(V value) {
            this.value = value;
        }
        
        private void setNext(Node next) {
            this.next = next;
        }

        private Node<K,V> getNext() {
            return next;
        }
        
        private void clear() {
            value = null;
            next = null;
        }
        
        public String toString() {
            String str = key + "->" + value;
            Node<K,V> nextNode = next;
            while(nextNode != null){
                str += "|" + nextNode.getKey() + "->" + nextNode.getValue();
                nextNode = nextNode.getNext();
            }
            return str;
        }
    }
}