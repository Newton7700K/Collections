
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
    public MyHashTable()
    {
        table = new String[10];
        count = 0;
    }
    
    public void put(String key, String value) {
        
    }
    
    private int getHash(String key){
        return key.hashCode() % count;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
}