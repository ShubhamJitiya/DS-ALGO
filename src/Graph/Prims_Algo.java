package Graph;

import Heap.HeapGeneric;
import SubmissionFormat.Date_Time;

import java.util.ArrayList;
import java.util.HashMap;

public class Prims_Algo {
    private class Vertex {
        HashMap<String, Integer> nbrs = new HashMap<>();
    }

    public static void main(String[] args) {
        Date_Time format = new Date_Time(10);
        System.out.println("\n");


        HashMap<String, Vertex> vtces;

        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

//        graph.addVertex("X");
//        graph.addVertex("Y");
//
//        graph.addEdges("X", "Y", 1);
////        graph.addEdges("Y", "X", 1);
//        System.out.println(graph.containsEdges("Y", "X"));
//
//        graph.addEdges("A", "B", 2);
//        graph.addEdges("A", "D", 6);
//        graph.addEdges("B", "C", 3);
//        graph.addEdges("C", "D", 1);
//        graph.addEdges("D", "E", 8);
//        graph.addEdges("E", "F", 5);
////        graph.addEdges("E", "G", 7);
//        graph.addEdges("F", "G", 4);

        graph.addEdges("A", "B", 2);
        graph.addEdges("A", "D", 10);
        graph.addEdges("B", "C", 3);
        graph.addEdges("C", "D", 1);
        graph.addEdges("D", "E", 8);
        graph.addEdges("E", "F", 5);
        graph.addEdges("E", "G", 6);
        graph.addEdges("F", "G", 4);

//        graph.display();

        graph.prims().display();
    }
}


