//CB
package Graph;

import Heap.HeapGeneric;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class C01_Graph {
    private class Vertex {
        HashMap<String, Integer> nbrs = new HashMap<>();
    }

    HashMap<String, Vertex> vtces;

    public C01_Graph() {
        vtces = new HashMap<>();
    }

    public void addVertex(String vname) {
        Vertex vtx = new Vertex();
        vtces.put(vname, vtx);
    }
    public void removeVertex(String vname) {
        //First remove from nbrs
        //then remove vertex
        Vertex vtx = vtces.get(vname);
        ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
        for (String key :
                keys) {
            Vertex nbrVtx = vtces.get(key);
            nbrVtx.nbrs.remove(vname);
        }
        vtces.remove(vname);
    }

    //Total vertex in graph
    public int numVertex() {
        return this.vtces.size();
    }
    public int numEdges() {
        ArrayList<String> keys = new ArrayList<>(vtces.keySet());
        int count = 0;
        for (String key : keys) {
            Vertex vtx = vtces.get(key);
            count = count + vtx.nbrs.size();
        }
        return count / 2;
    }

    //present or not
    public boolean containsVertex(String vname) {
        return this.vtces.containsKey(vname);
    }
    public boolean containsEdges(String vname1, String vname2) {
        //First Check wherther it is present in vtces HashMap or not

        Vertex vtx1 = vtces.get(vname1);
        Vertex vtx2 = vtces.get(vname2);

        if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2))
            return false;

        return true;
    }

    public void addEdges(String vname1, String vname2, int cost) {
        Vertex vtx1 = vtces.get(vname1);  //2k
//        Vertex vtx2 = vtces.get(vname2); //4k //Comment to run bellman ford

//
//        if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2))
//            return;

        if (vtx1 == null || vtx1.nbrs.containsKey(vname2))
            return;
        vtx1.nbrs.put(vname2, cost);
//        vtx2.nbrs.put(vname1, cost);
    }
    public void removeEdges(String vname1, String vname2) {
        Vertex vtx1 = vtces.get(vname1);  //2k
        Vertex vtx2 = vtces.get(vname2); //4k

        if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2))
            return;

        vtx1.nbrs.remove(vname2);
        vtx2.nbrs.remove(vname1);
    }

    public void display() {
        System.out.println("----------------------------");
        ArrayList<String> keys = new ArrayList<>(vtces.keySet());
        for (String key : keys) {
            Vertex vtx = vtces.get(key);
            System.out.println(key + " : " + vtx.nbrs);
        }
        System.out.println("----------------------------");
    }

    public boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> processed) {

        processed.put(vname1, true);

        //Direct edge
        if (containsEdges(vname1, vname2)) {
            return true;
        }

        Vertex vtx = vtces.get(vname1);

        ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

        for (String nbr : nbrs) {
            if (!processed.containsKey(nbr) && hasPath(nbr, vname2, processed)) {
                return true;
            }

        }
        return false;
    }

    //BFS
    private class Pair
    {
        String vName;
        String psf;
    }
    public boolean bfs(String src, String dst)
    {
        //Create a new pair
        HashMap<String, Boolean> processed = new HashMap<>();
        LinkedList<Pair> queue = new LinkedList<>();
        Pair sp = new Pair();
        sp.vName = src;
        sp.psf = src;

        //Put the new pair in queue
        queue.addLast(sp);


        //While queue is not empty keep on doing your work
        while(!queue.isEmpty())
        {
            //Remvoe a pair from queue
            Pair rp = queue.removeFirst();

            //If removing vertex second time
            if(processed.containsKey(rp.vName))
            {
                continue; //skip the below codes and continue from next iteration of while loop
            }

            //1. processed put
            processed.put(rp.vName, true);

            //2. de
            if(containsEdges(rp.vName, dst))
            {
                System.out.println(rp.psf + dst);
                return true;
            }
            //3. nbrs - at level 1
            Vertex rpvtx = vtces.get(rp.vName);
            ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

            //Loop on nbr
            for (String nbr: nbrs)
            {
                //Process only unprocessed nbrs
                if(!processed.containsKey(nbr)) {
                    //Make a new pair of nbr and put in queue
                    Pair np = new Pair();
                    np.vName = nbr;
                    np.psf = rp.psf + nbr;

                    queue.addLast(np);
                }
            }
        }
        return false;
    }
    //--X---BFS---X--//

    class DisjointSet {
        HashMap<String, Node> map = new HashMap<>();

        private class Node {
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

            if (re1.data.equals(re2.data)) {
                return;
            } else {
                if (re1.rank == re2.rank) {
                    re2.parent = re1;
                    re1.rank = re1.rank + 1;
                } else if (re1.rank > re2.rank) {
                    re2.parent = re1;
                } else {
                    re1.parent = re2;
                }
            }
        }

        public String find(String value) {
            return find(map.get(value)).data;
        }

        private Node find(Node node) {
            if (node == node.parent)
                return node;

            Node rr = find(node.parent);
            node.parent = rr; //path compression - First time takes time
            return rr;
        }

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

            if (re1.equals(re2)) {
                continue;
            } else {
                //Prints MST
                System.out.println(edge);
                set.union(edge.v1, edge.v2);
            }
        }

        //Prints all edges with its cost
        System.out.println(edges);

    }

    class EdgePair implements Comparable<EdgePair> {
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

    private class PrimsPair implements Comparable<PrimsPair> {
        String vname;
        String acqname;
        int cost;

        @Override
        public int compareTo(PrimsPair o) {
            return o.cost - this.cost; //Smaller value have more priority
        }
    }

    public C01_Graph prims() {
        C01_Graph mst = new C01_Graph();
        HashMap<String, PrimsPair> map = new HashMap<>();

        HeapGeneric<PrimsPair> heap = new HeapGeneric<PrimsPair>();

        //Make a pair & key
        for(String key : vtces.keySet())
        {
            PrimsPair np = new PrimsPair();
            np.vname = key;
            np.acqname = null;
            np.cost = Integer.MAX_VALUE; //Infinity

            heap.add(np);
            map.put(key,np);
        }

        //till the heap is not empty keep on removing the pairs
        while(!heap.isEmpty())
        {
            //Remove a pair
            PrimsPair rp = heap.remove();
            map.remove(rp.vname);

            //Add to mst
            if(rp.acqname == null)
            {
                mst.addVertex(rp.vname);
            }else
            {
                mst.addVertex(rp.vname);
                mst.addEdges(rp.vname, rp.acqname, rp.cost);
            }
            for (String nbr: vtces.get(rp.vname).nbrs.keySet())
            {
                //Work for nbrs which are in heap
                if(map.containsKey(nbr))
                {
                    int oc = map.get(nbr).cost;
                    int nc = vtces.get(rp.vname).nbrs.get(nbr);

                    //Update the pair only when nc < oc
                    if(nc < oc)
                    {
                        PrimsPair gp = map.get(nbr);
                        gp.acqname = rp.vname;
                        gp.cost = nc;

                        heap.updatePriority(gp);
                    }
                }

            }
        }

//        HeapGeneric<PrimsPair> heap
        return mst;
    }

    public HashMap<String, Integer> bellmanFord (String src) throws Exception {
        ArrayList<EdgePair> edges = getAllEdges();
        HashMap<String, Integer> map = new HashMap<>();

        //Fill the hashmap with infinity & zero
        for (String vname : vtces.keySet()) {
            map.put(vname, 100000); //Not infinity, if we have to add then it goes out of range

            if (src.equals(vname))
                map.put(vname, 0);

        }
        int V = vtces.size();

//        Relax every edge V-1 times
        for (int i = 1; i <= V; i++) {

            //Loop on edges
            for (EdgePair edge: edges)
            {
                int oc = map.get(edge.v2);
                int nc = map.get(edge.v1) + edge.cost;

                if(oc > nc)
                    if(i<=V-1)
                        map.put(edge.v2,nc);
                    else
                        throw new Exception("-ve wt Cycle is present.");
            }
        }
        return map;
    }
}

