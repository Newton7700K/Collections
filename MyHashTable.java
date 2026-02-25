import java.lang.Math;
/**
 * Write a description of class MyHashTable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyHashTable
{
    
    private String[] table;
    private int count;
    
    /**
     * Constructor for objects of class MyHashTable
     */
    public MyHashTable() {
        table = new String[10];
        count = 0;
    }
    
    public void put(String key, String value) {
        table[getHash(key)] = value;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public int size() {
        return count;
    }
    
    public String get(String key) {
        return table[getHash(key)];
    }
    
    private int getHash(String key) {
        int hash = Math.abs(key.hashCode());
        return hash % table.length;
    }
    
    public String remove(String key) {
        String str = table[getHash(key)];
        table[getHash(key)] = null;
        return str;
    }
    
    public String toString() {
        String hashTable = table[0] + "";
        for(int i = 1; i < count; i++) {
            hashTable += "," + table[i];
        }
        return hashTable;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
}