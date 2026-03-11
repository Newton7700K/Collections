import java.util.ArrayList;
import java.util.*;

/**
 * Implements basic graph functionality.
 *
 * @author Newton Zheng
 * @version March 2026
 */
public class MyGraph
{
    private MyHashTable<String, Vertex> vertices;
    
    public MyGraph()
    {
       vertices = new MyHashTable<String, Vertex>();
    }    
    
    public void addVertex(String label) {
        
    }
    
    public class Vertex {
        private String label;
        private ArrayList<Vertex> neighbors = new ArrayList<>();

        private Vertex(String label){
            this.label = label;
        }
        
        
    }
}