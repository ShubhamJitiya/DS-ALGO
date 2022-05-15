package Graph;

public class BellmanFord {
    public static void main(String[] args) throws Exception {

        //Comment
        // Update add edges vtx2 to vtx1- Directed graph
        C01_Graph graph = new C01_Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdges("A", "B", 8);
        graph.addEdges("A", "C", 4);
        graph.addEdges("A", "D", 5);
        graph.addEdges("C", "D", -3);
        graph.addEdges("D", "E", 4);
        graph.addEdges("E", "B", -10);
        graph.addEdges("B", "E", 2);

        System.out.println(graph.bellmanFord("A"));
    }
}
 