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
    
    public MyGraph() {
       vertices = new MyHashTable<String, Vertex>();
    }    
    
    public void addVertex(String label) {
        if(label == null){
            throw new NullPointerException();
        }
        
        if(vertices.get(label) != null){
            throw new IllegalArgumentException();
        }
        
        vertices.put(label, new Vertex(label));
    }
    
    public void addEdge(String fromLabel,  String toLabel) {
        if(fromLabel == null || toLabel == null) {
            throw new NullPointerException();
        }
        
        if(vertices.get(fromLabel) == null || vertices.get(toLabel) == null) {
            throw new NoSuchElementException();
        }
    }
    
    public class Vertex {
        private String label;
        private ArrayList<Vertex> neighbors = new ArrayList<>();

        private Vertex(String label) {
            this.label = label;
        }
        
        public String toString() {
            String result = label + ":";
            for(int i = 0; i<neighbors.size(); i++){
                result += "[" + neighbors.get(i).label + "]";
            }
            return result;
        }
    }
}