package Heap;

//Not ensuring sorted

import java.util.ArrayList;

public class C01_Heap {
    public static void main(String[] args) {
        Heap heap = new Heap();

        heap.add(10);
        heap.display();
        heap.add(20);
        heap.display();
        heap.add(30);
        heap.display();
        heap.add(40);
        heap.display();
        heap.add(5);
        heap.display();
        heap.add(3);
        heap.display();

        System.out.println(heap.remove());
        heap.display();
        System.out.println(heap.remove());
        heap.display();
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        heap.display();

    }
}

class Heap {
    ArrayList<Integer> data = new ArrayList<>();

    //Add Element
    public void add(int item) {
        data.add(item);
        upheapify(data.size() - 1);
    }

    private void upheapify(int ci) {
        int pi = (ci - 1) / 2;

        //Base cond not required
        if (data.get(ci) < data.get(pi)) {
            swap(pi, ci);
            upheapify(pi);
        }
    }

    private void swap(int i, int j) {
        int ith = data.get(i);
        int jth = data.get(j);

        data.set(i, jth);
        data.set(j, ith);
    }

    public void display() {
        System.out.println(data);
    }

    public int size() {
        return this.data.size();
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    //Remove Element - Highest priority
    public int remove() {
        swap(0, this.data.size() - 1);

        int rv = this.data.remove(this.data.size() - 1);
        downHeapify(0);

        return rv;

    }
    private void downHeapify(int pi)  {
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;

        int mini = pi;

        if (lci < this.data.size() && data.get(lci) < data.get(mini))
            mini = lci;
        if (rci < this.data.size() && (data.get(rci) < data.get(mini)))
            mini = rci;

        if (mini != pi) {
            swap(mini, pi);
            downHeapify(mini);
        }
    }
    private int get()
    {
        return this.data.get(0);
    }

}