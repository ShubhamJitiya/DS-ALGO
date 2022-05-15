//CB
package Graph;

import SubmissionFormat.Date_Time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class C02_GraphClient {
    public static void main(String[] args) {
        Date_Time format = new Date_Time(9);

        C01_Graph graph = new C01_Graph();
        graph.addVertex("V1");
        graph.addVertex("V2");
        graph.addVertex("V3");
        graph.addVertex("V4");
        graph.addVertex("V5");
        graph.addVertex("V6");
        graph.addVertex("V7");
        graph.addVertex("V8");

        graph.addEdges("V1", "V2", 5);
        graph.addEdges("V5", "V6", 6);
        graph.addEdges("V1", "V7", 6);
        graph.addEdges("V5", "V7", 3);
        graph.addEdges("V1", "V5", 4);
        graph.addEdges("V2", "V3", 3);
        graph.addEdges("V6", "V4", 2);
        graph.addEdges("V2", "V5", 2);
        graph.addEdges("V8", "V8", 4);
        graph.addEdges("V2", "V6", 4);
        graph.addEdges("V3", "V4", 2);
        graph.addEdges("V7", "V8", 5);


        graph.display();

        // System.out.println(graph.numVertex());
        // System.out.println(graph.numEdges());

        // System.out.println(graph.containsEdges("A", "C"));
        // System.out.println(graph.containsEdg es("E", "F"));

//         graph.removeEdges("D", "E");
        // graph.display();

        // graph.removeVertex("F");
        // graph.display();

        // graph.addVertex("F");
        // graph.display();

        // graph.addEdges("F", "A", 10);
        // graph.display();
//        System.out.println(graph.hasPath("A", "F", new HashMap<>()));
//        graph.kruskal();

//                graph.removeEdges("D", "E");
//                graph.removeEdges("A", "D");


//        System.out.println(graph.bfs("A", "F"));
//        System.out.println(graph.prims());
//        graph.kruskal();
        graph.bfs("V1", "V4");

        
    }


}
