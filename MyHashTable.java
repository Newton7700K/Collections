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
    
    public Node remove(K key) {
        Node node = table[getHash(key)];
        table[getHash(key)] = null;
        return node;
    }
    
    public void addToBucket(int bucket, Node newNode){
        newNode.setNext(table[bucket]);
        table[bucket] = newNode;
    }
    
    public Node searchBucket(int bucket, K key){
        Node currentNode = table[bucket];
        while(currentNode != null) {
            if(currentNode.getKey().equals(key)){
                return currentNode;
            }
        }
        return null;
    }
    
    public String toString() {
        return Arrays.toString(table);
    }
    
    public class Node<K,V> {
        private K key;
        private V value;
        private Node next;
        
        private Node(K key, V value) {
            this.key = key;
            this.value = value;
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

        private Node getNext() {
            return next;
        }
        
        private void clear() {
            value = null;
            next = null;
        }
        
        public String toString() {
            String str = key + "->" + value;
            Node nextNode = next;
            while(nextNode != null){
                str += "|" + nextNode.getKey() + "->" + nextNode.getValue();
                nextNode = nextNode.getNext();
            }
            return str;
        }
    }
}