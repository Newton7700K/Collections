import java.util.ArrayList;
import java.util.*;

/**
 * Write a description of class MyWeightedGraph here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyWeightedGraph
{
    private int count;
    private MyHashTable<String, Vertex> vertices;
    
    public MyWeightedGraph()
    {
        int count = 0;        
        vertices = new MyHashTable<String, Vertex>();
    }

    public void addVertex(String label) {
        vertices.put(label, new Vertex(label));
        count++;
    }
    
    public void addEdge(String fromLabel, String toLabel, double weight){
        Vertex fromVertex = vertices.get(fromLabel);
        Vertex toVertex = vertices.get(toLabel);
        
        fromVertex.addNeighbor(toVertex, weight);
    }
    
    public MyHashTable<String, Vertex> runDijkstra(String fromLabel){
        MyHashTable<String, Vertex> visited = new MyHashTable<>();
        MyHeap<String> edges = new MyHeap<>(false);
        Vertex current = vertices.get(fromLabel);
        
        visited.put(fromLabel, current);
        
        while(visited.size()<count){
            for(Edge edge: current.getNeighbors()){
                
            }
        }
    }
    
    
    public class Vertex {
        private String label;
        private ArrayList<Edge> neighbors;

        private Vertex(String label) {
            this.label = label;
            neighbors = new ArrayList<>();
        }
        
        private String getLabel(){
            return label;
        }
        
        private void addNeighbor(Vertex add, double weight){
            neighbors.add(new Edge(add, weight));
        }
        
        private ArrayList<Edge> getNeighbors(){
            return neighbors;
        }
        
        public String toString() {
            String result = label + ":";
            for(int i = 0; i<neighbors.size(); i++){
                result += "[" + neighbors.get(i) + "]";
            }
            return result;
        }
    }
    
    public class Edge {
        private Vertex toVertex;
        private double weight;
        
        private Edge(Vertex toVertex, double weight){
            this.toVertex= toVertex;
            this.weight = weight;
        }
        
        public String toString(){
            return toVertex.getLabel() + "~" + weight;
        }
    }
}