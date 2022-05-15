package Graph;

import java.util.HashMap;

public class Dijkstra_Algo {
    private class Vertex {
        HashMap<String, Integer> nbrs = new HashMap<>();
    }

    public static void main(String[] args) {
        HashMap<String, Vertex> vtces;

        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");


//        graph.addVertex("X");
//        graph.addVertex("Y");
//
//        graph.addEdges("X", "Y", 1);
////        graph.addEdges("Y", "X", 1);
//        System.out.println(graph.containsEdges("Y", "X"));

        graph.addEdges("A", "B", 8);
        graph.addEdges("A", "D", 5);
        graph.addEdges("A", "C", 4);
        graph.addEdges("C", "D", -3);
        graph.addEdges("D", "E", 4);
        graph.addEdges("E", "B", 1);
        graph.addEdges("B", "E", 2);

//        graph.display();

        System.out.println(graph.dijkstra("A"));
    }
}