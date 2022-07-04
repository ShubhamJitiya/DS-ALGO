package DS.linked_list;

public class C01_MyLinkedList {
    Node head;
    private int size;

    C01_MyLinkedList(){
        this.size = 0;
    }

    public static void main(String[] args) {
        C01_MyLinkedList newList = new C01_MyLinkedList();
        newList.addFirst("a");
        newList.addFirst("is");
        newList.traverse();

        newList.addLast("list");
        newList.traverse();

        newList.addFirst("This");
        newList.traverse();

        newList.deleteFirst();
        newList.traverse();

        newList.deleteLast();
        newList.traverse();
        System.out.println(newList.getSize());
        newList.addFirst("First");
        System.out.println(newList.getSize());

    }

  /*
  //functions
  1. Add - first, last

*/

    public void addFirst(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

    public void deleteFirst() {
        //No node is present
        if (head == null) {
            System.out.println("No node is present");
        }
        size--;
        head = head.next;
    }
    public void deleteLast(){
       if(head == null){
           System.out.println("The lsit is empty");
           return;
       }
       size--;
        if(head.next == null){
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;

        while(lastNode.next!=null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    public void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node traverseData = head;
        while (traverseData != null) {
            System.out.print(traverseData.data + " -> ");
            traverseData = traverseData.next;
        }

        System.out.println("NULL");
    }

    public int getSize(){
        return size;
    }

  class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }
}