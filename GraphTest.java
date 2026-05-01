/**
 * Write a description of class GraphTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GraphTest
{
    MyGraph graph = new MyGraph();
    public void runTest()
    {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        
        graph.addEdge("A","B");
        graph.addEdge("A","C");
        graph.addEdge("B","D");
        graph.addEdge("B","E");
        graph.addEdge("B","F");
        graph.addEdge("F","G");
        
        System.out.println(graph.breadthFirstTraversal("A"));
    }

}