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
    private int count;
    
    public MyGraph() {
       vertices = new MyHashTable<String, Vertex>();
       count = 0;
    }    
    
    public void addVertex(String label) {
        if(label == null){
            throw new NullPointerException();
        } else if (vertices.get(label) != null) {
            throw new IllegalArgumentException();
        } else {
            vertices.put(label, new Vertex(label));
        }
        count++;
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
    
    public ArrayList<String> breadthFirstTraversal(String fromLabel) {
        ArrayList<String> visited = new ArrayList<String>();
        visited.add(fromLabel);
        MyQueue<String> queue = new MyQueue<String>();
        queue.enqueue(fromLabel);
        while(visited.size() != count){
            for(Vertex neighbor : vertices.get(queue.dequeue()).getNeighbors()){
                if(!visited.contains(neighbor.getLabel())){
                    visited.add(neighbor.getLabel());
                    queue.enqueue(neighbor.getLabel());
                }
            }
        }
        return visited;
    }
    
    public int distance(String fromLabel, String toLabel) {
        int distance = 0;
        MyHashTable<String,String> visited = new MyHashTable<String,String>();
        visited.put(fromLabel,fromLabel);
        MyQueue<TraversalNode> queue = new MyQueue<TraversalNode>();
        queue.enqueue(new TraversalNode(fromLabel,distance));
        
        while(visited.size() != count){
            distance++;
            for(Vertex neighbor : vertices.get(queue.dequeue().getLabel()).getNeighbors()){
                if(visited.get(neighbor.getLabel())!=null){
                    TraversalNode tNode = new TraversalNode(neighbor.getLabel(),distance);
                    queue.enqueue(tNode);
                    visited.put(tNode.getLabel(),neighbor.getLabel());
                }
            }
        }
        return 1;
    }
    
    public ArrayList<String> shortestPath(String fromLabel, String toLabel){
        return null;
    }
    
    public String toString(){
        return vertices.toString();
    }
    
    public class TraversalNode {
        private String label;
        private int distance;
        
        private TraversalNode(String label, int distance){
            this.label = label;
            this.distance = distance;
        }
        
        private String getLabel(){
            return label;
        }
        
        private int getDistance(){
            return distance;
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