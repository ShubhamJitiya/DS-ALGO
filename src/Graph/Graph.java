package Graph;

import Heap.HeapGeneric;

import javax.print.DocPrintJob;
import java.util.ArrayList;
import java.util.HashMap;

class Vertex {
    HashMap<String, Integer> nbrs = new HashMap<>();
}
class Graph {
    HashMap<String, Vertex> vtces;

    public Graph() {
        vtces = new HashMap<>();
    }

    //Total vertex in graph
    public int numVertex() {
        return this.vtces.size();
    }

    //present or not
    public boolean containsVertex(String vName) {
        return this.vtces.containsKey(vName);
    }

    public void addVertex(String vName) {
        Vertex vtx = new Vertex();
        vtces.put(vName, vtx);
    }

    //If A is connected with B then B is also connected with A
    public void removeVertex(String vName) { //A - B, C
        Vertex vtx = vtces.get(vName);
        ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet()); //B, C
        for (String key : keys) {           //B
            Vertex nbrVtx = vtces.get(key); //Add of B
            nbrVtx.nbrs.remove(vName);      //get neighbors of B remove (A)
        }
        vtces.remove(vName);
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

    public boolean containsEdges(String vName1, String vName2) {
        //Check vertex present or not
        //Returns null if not

        Vertex vtx1 = vtces.get(vName1);
        Vertex vtx2 = vtces.get(vName2);

        if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vName2))
            return false;

        return true;
    }

    public void addEdges(String vName1, String vName2, int cost) {
        Vertex vtx1 = vtces.get(vName1);  //2k
        Vertex vtx2 = vtces.get(vName2); //4k

        if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vName2)) {
            System.out.println("Vertex is not present or already contains edge");
            return;
        }
        vtx1.nbrs.put(vName2, cost);
        vtx2.nbrs.put(vName1, cost);
    }

    public void removeEdges(String vName1, String vName2) {
        Vertex vtx1 = vtces.get(vName1);  //2k
        Vertex vtx2 = vtces.get(vName2); //4k

        if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vName2))
            return;

        vtx1.nbrs.remove(vName2);
        vtx2.nbrs.remove(vName1);
    }

    public void display() {
        System.out.println("-------- Prims's Algorithm -------- ");
        ArrayList<String> keys = new ArrayList<>(vtces.keySet());
        for (String key : keys) {
            Vertex vtx = vtces.get(key);
            System.out.println(key + " : " + vtx.nbrs);
        }
        System.out.println("-----------------------------------");
    }
    public boolean hasPath(String vName1, String vName2, HashMap<String, Boolean> processed) {

        processed.put(vName1, true);

        //Direct edge
        if (containsEdges(vName1, vName2)) {
            return true;
        }

        Vertex vtx = vtces.get(vName1);

        ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

        for (String nbr : nbrs) {
            if (!processed.containsKey(nbr) && hasPath(nbr, vName2, processed)) {
                return true;
            }

        }
        return false;
    }

    class PrimsPair implements Comparable<PrimsPair> {
        String vName;
        String acqname;
        int cost;

        @Override
        public int compareTo(PrimsPair o) {
            return o.cost - this.cost; //Smaller value have more priority
        }
    }
    public Graph prims() {
        Graph mst = new Graph();
        HashMap<String, PrimsPair> map = new HashMap<>();

        HeapGeneric<PrimsPair> heap = new HeapGeneric<PrimsPair>();

        //Make a pair & key
        for (String key : vtces.keySet()) {
            PrimsPair np = new PrimsPair();
            np.vName = key;
            np.acqname = null;
            np.cost = Integer.MAX_VALUE; //Infinity

            heap.add(np);
            map.put(key, np);
        }

        //till the heap is not empty keep on removing the pairs
        while (!heap.isEmpty()) {
            //Remove a pair
            PrimsPair rp = heap.remove();
            map.remove(rp.vName);

            //Add to mst
            if (rp.acqname == null) {
                mst.addVertex(rp.vName);
            } else {
                mst.addVertex(rp.vName);
                mst.addEdges(rp.vName, rp.acqname, rp.cost);
            }
            for (String nbr : vtces.get(rp.vName).nbrs.keySet()) {
                //Work for nbrs which are in heap
                if (map.containsKey(nbr)) {
                    int oc = map.get(nbr).cost;
                    int nc = vtces.get(rp.vName).nbrs.get(nbr);

                    //Update the pair only when nc < oc
                    if (nc < oc) {
                        PrimsPair gp = map.get(nbr);
                        gp.acqname = rp.vName;
                        gp.cost = nc;

                        heap.updatePriority(gp);
                    }
                }

            }
        }
        return mst;
    }

    class DijkstraPair implements Comparable<DijkstraPair> {
        String vName;
        String psf;
        int cost;

        @Override
        public int compareTo(DijkstraPair o) {
            return o.cost - this.cost; //Smaller value have more priority
        }
    }
    public HashMap<String, Integer> dijkstra(String src) {

        HashMap<String, Integer> ans = new HashMap<>();
        HashMap<String, DijkstraPair> map = new HashMap<>();
        HeapGeneric<DijkstraPair> heap = new HeapGeneric<DijkstraPair>();

        //Make a pair & key
        for (String key : vtces.keySet()) {
            DijkstraPair np = new DijkstraPair();
            np.vName = key;
            np.psf = "";
            np.cost = Integer.MAX_VALUE; //Infinity

            if(key.equals(src))
            {
                np.cost = 0;
                np.psf = key;
            }
            heap.add(np);
            map.put(key, np);
        }

        //till the heap is not empty keep on removing the pairs
        while (!heap.isEmpty()) {
            //Remove a pair
            DijkstraPair rp = heap.remove();
            map.remove(rp.vName);

            //Add to ans
            ans.put(rp.vName, rp.cost);

            for (String nbr : vtces.get(rp.vName).nbrs.keySet()) {
                //Work for nbrs which are in heap
                if (map.containsKey(nbr)) {
                    int oc = map.get(nbr).cost;
                    int nc = rp.cost + vtces.get(rp.vName).nbrs.get(nbr);

                    //Update the pair only when nc < oc
                    if (nc < oc) {
                        DijkstraPair gp = map.get(nbr);
                        gp.psf = rp.psf + nbr;
                        gp.cost = nc;

                        heap.updatePriority(gp);
                    }
                }

            }
        }
        return ans;
    }
}

