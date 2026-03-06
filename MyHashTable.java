import java.util.*;
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
    private double loadFactor;
    
    /**
     * Constructor for objects of class MyHashTable
     */
    public MyHashTable() {
        table = new Node[10];
        count = 0;
        loadFactor = 0.7;
    }
    
    public void put(K key, V value) {
        if(key == null || value == null){
            throw new NullPointerException();
        } else {
            int bucket = getHash(key);
            Node<K,V> search = searchBucket(bucket, key);
            
            if(search != null){
                search.setValue(value);
            } else {
                addToBucket(bucket, new Node<K, V>(key, value));
                count++;
                
                if (count > loadFactor * table.length) {
                    expandHashTable();
                }
            }
        }

    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public int size() {
        return count;
    }
    
    public V get(K key) {
        if (key == null) {
            throw new NullPointerException();
        } else {
            int bucket = getHash(key);
            Node<K, V> search = searchBucket(bucket, key);

            if (search == null) {
                return null;
            } else {
                return search.getValue();
            }
        }

    }
    
    private int getHash(K key) {
        int hash = Math.abs(key.hashCode());
        return hash % table.length;
    }
    
    public V remove(K key) {
        if (key == null) {
            throw new NullPointerException();
        } else {
            int bucket = getHash(key);
            Node<K, V> search = searchBucket(bucket, key);

            if (search == null) {
                return null;
            } else {
                V value = search.getValue();
                removeFromBucket(bucket, search);
                search.clear();
                count--;
                return value;
            }
        }
    }

    
    private void expandHashTable() {
        Node<K, V>[] oldTable = table;
        table = (Node<K, V>[]) new Node[oldTable.length * 2];

        for (int i = 0; i < oldTable.length; i++) {
            Node<K, V> currentNode = oldTable[i];

            while (currentNode != null) {
                Node<K, V> nextNode = currentNode.getNext();
                int newBucket = Math.abs(currentNode.getKey().hashCode()) % table.length;

                currentNode.setNext(table[newBucket]);
                table[newBucket] = currentNode;

                currentNode = nextNode;
            }
        }
    }

    
    public void addToBucket(int bucket, Node<K,V> newNode){
        if(table[bucket] == null) {
            table[bucket] = newNode;
        } else {
            newNode.setNext(table[bucket]);
            table[bucket] = newNode;
        }
    }
    
    public Node<K,V> searchBucket(int bucket, K key){
        Node<K,V> currentNode = table[bucket];
        while(currentNode != null) {
            if(currentNode.getKey().equals(key)){
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }
    
    public Node<K,V> removeFromBucket(int bucket, Node<K,V> oldNode){
        if(table[bucket] == null) {
            throw new NoSuchElementException();
        } else {
            Node<K,V> currentNode = table[bucket];
            Node<K,V> searchNode = searchBucket(bucket, oldNode.getKey());
            
            if (currentNode == searchNode) {
                currentNode.setNext(searchNode.getNext());
                return searchNode;
            }
            
            while(currentNode.getNext() != null && currentNode.getNext() != searchNode){
                if(currentNode.getNext() == searchNode){
                    currentNode.setNext(searchNode.getNext());
                    return searchNode;
                }
                currentNode = currentNode.getNext();
            }
            return null;
        }
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