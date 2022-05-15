package Heap;

import java.util.ArrayList;

public class C02_HeapGeneric {
    public static void main(String[] args) {

        Car[] cars = new Car[5];
        cars[0] = new Car(1000, 400, "Red");
        cars[1] = new Car(2000, 200, "Yellow");
        cars[2] = new Car(500, 900, "Black");
        cars[3] = new Car(300, 60, "Grey");
        cars[4] = new Car(700, 30, "White");

        HeapGeneric<Car> heapg = new HeapGeneric<Car>();
        heapg.add(cars[0]);
        heapg.add(cars[1]);
        heapg.add(cars[2]);
        heapg.add(cars[3]);
        heapg.add(cars[4]);

        System.out.println(heapg.remove());
        System.out.println(heapg.remove());
        System.out.println(heapg.remove());
        System.out.println(heapg.remove());
        System.out.println(heapg.remove());
    }
}
