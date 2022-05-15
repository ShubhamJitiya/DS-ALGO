package Graph;

import SubmissionFormat.Date_Time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

public class Kruskals_Algo {
    private class Vertex {
        HashMap<String, Integer> nbrs = new HashMap<>();
    }

    HashMap<String, Vertex> vtces;

    public static void main(String[] args) {
        Date_Time format = new Date_Time(11);

        C01_Graph graph = new C01_Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdges("A", "B", 2);
        graph.addEdges("A", "D", 10);
        graph.addEdges("B", "C", 3);
        graph.addEdges("C", "D", 1);
        graph.addEdges("D", "E", 8);
        graph.addEdges("E", "F", 5);
        graph.addEdges("E", "G", 6);
        graph.addEdges("F", "G", 4);

//        graph.display();

        graph.kruskal();
    }

    public void kruskal() {
        //1. Sort the edges in increasing order of weight
        ArrayList<EdgePair> edges = getAllEdges();
        Collections.sort(edges);

        DisjointSet set = new DisjointSet();

        //2. Create Set for each vertex
        for (String vname : vtces.keySet()) {
            set.create(vname);
        }

        //3. Traverse over the edges
        for (EdgePair edge : edges) {
            //If edge belongs to different sets - Union
            //else(equals) - nothing
            String re1 = set.find(edge.v1);
            String re2 = set.find(edge.v2);

            //Same set - Nothing
            if (re1.equals(re2)) {
                continue;
            }
            //Different set - Union
            else {
                //Prints MST
                System.out.println(edge);
                set.union(edge.v1, edge.v2);
            }
        }

        //Prints all edges with its cost
        System.out.println(edges);

    }

    public ArrayList<EdgePair> getAllEdges() {
        ArrayList<EdgePair> edges = new ArrayList<>();
        for (String vname : vtces.keySet()) {
            Vertex vtx = vtces.get(vname);

            for (String nbr : vtx.nbrs.keySet()) {
                EdgePair ep = new EdgePair();
                ep.v1 = vname;
                ep.v2 = nbr;
                ep.cost = vtx.nbrs.get(nbr);

                edges.add(ep);
            }
        }
        return edges;
    }

    static class DisjointSet {
        HashMap<String, Node> map = new HashMap<>();

        private static class Node {
            String data;
            Node parent;
            int rank;
        }

        public void create(String value) {
            Node nn = new Node();
            nn.data = value;
            nn.parent = nn;
            nn.rank = 0;

            map.put(value, nn);
        }

        public void union(String value1, String value2) {
            Node n1 = map.get(value1);
            Node n2 = map.get(value2);

            Node re1 = find(n1);
            Node re2 = find(n2);

            //Representative element is same - Nothing
            if (re1.data.equals(re2.data)) {
                return;
            } else {
                if (re1.rank == re2.rank) {
                    re2.parent = re1;
                    re1.rank = re1.rank + 1;
                } else if (re1.rank > re2.rank) {
                    re2.parent = re1;
                }
                //re1.parent < re2.parent - Change rank of re1
//                Change the rank of smallest
                else {
                    re1.parent = re2;
                }
            }
        }

        //Gives representative element
        public String find(String value) {
            return find(map.get(value)).data;
        }

        //Recursive call to find parent node
        private Node find(Node node) {
            if (node == node.parent)
                return node;

            Node rr = find(node.parent);
            node.parent = rr; //path compression - First time takes time
            return rr;
        }

    }

    static class EdgePair implements Comparable<EdgePair> {
        String v1;
        String v2;
        int cost;

        @Override
        public int compareTo(EdgePair o) {
            return this.cost - o.cost;
        }

        public String toString() {
            return v1 + "-" + v2 + " : " + cost;
        }
    }
}
