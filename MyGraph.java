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
        } else if (vertices.get(label) != null) {
            throw new IllegalArgumentException();
        } else {
            vertices.put(label, new Vertex(label));
        }
    }
    
    public void addEdge(String fromLabel,  String toLabel) {
        if(fromLabel == null || toLabel == null) {
            throw new NullPointerException();
        } else if(vertices.get(fromLabel) == null || vertices.get(toLabel) == null) {
            throw new NoSuchElementException();
        } else if(vertices.get(fromLabel).getNeighbors().contains(vertices.get(toLabel))){
            throw new IllegalArgumentException();
        } else {
            vertices.get(fromLabel).addNeighbor(vertices.get(toLabel));
        }
    }
    
    public ArrayList<String> depthFirstTraversal(String fromLabel) {
        ArrayList<String> visited = new ArrayList<String>();
        visited.add(fromLabel);
        depthFirstTraversal(visited, fromLabel);
        return visited;
    } 
    
    private void depthFirstTraversal(ArrayList<String> visited, String current){
        for(Vertex neighbor: vertices.get(current).getNeighbors()){
            if(!visited.contains(neighbor.getLabel())){
                visited.add(neighbor.getLabel());
                depthFirstTraversal(visited, neighbor.getLabel());
            }
        }
    }
    
    private ArrayList<String> breadthFirstTraversal(String fromLabel) {
        ArrayList<String> visited = new ArrayList<String>();
        visited.add(fromLabel);
        MyQueue<String> queue = new MyQueue<String>();
        while(!queue.isEmpty()){
            for(String neighbor : vertices.get(current).getNeighbors()){
                if(!visited.contains(neighbor.getLabel())){
                    visited.add(neighbor.getLabel());
                    
                }
            }
        }
    }
    
    public class Vertex {
        private String label;
        private ArrayList<Vertex> neighbors;

        private Vertex(String label) {
            this.label = label;
            neighbors = new ArrayList<>();
        }
        
        private String getLabel(){
            return label;
        }
        
        private void addNeighbor(Vertex add){
            neighbors.add(add);
        }
        
        private ArrayList<Vertex> getNeighbors(){
            return neighbors;
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