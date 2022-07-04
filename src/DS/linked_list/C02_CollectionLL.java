package DS.linked_list;

import java.util.LinkedList;

public class C02_CollectionLL {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();

        list.addFirst("a");
        list.addFirst("is");
        System.out.println("Add first: " + list);
//        -------------------------
        list.addLast("This");
        list.addLast("List");
        System.out.println("Add last: " + list);
//        -------------------------
        list.add("default 1");
        list.add("default 2");
        System.out.println("Add: " + list);
//        -------------------------
        System.out.println("Size: " + list.size());
//        -------------------------
        System.out.print("Get: ");
        for (int i = 0; i < list.size(); i++) {
//            if(list.get(i) == value)
            System.out.print(list.get(i) + " -> ");
        }
        System.out.println("null");
//        -------------------------
        list.removeFirst();
        System.out.println("Remove First: " + list);
        //        -------------------------
        list.remove(2);
        System.out.println("Remove at Index 2: " + list);


    }
}