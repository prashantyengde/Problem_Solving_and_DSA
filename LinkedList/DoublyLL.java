package LinkedList;

public class DoublyLL {

    // ─── Node (inner class — replaces C++ struct node) ───────────────────────
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // ─── Fields ───────────────────────────────────────────────────────────────
    private Node head;
    private int size;

    // ─── Constructor ──────────────────────────────────────────────────────────
    public DoublyLL() {
        head = null;
        size = 0;
    }

    // ─── Insert First ─────────────────────────────────────────────────────────
    public void insertFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // ─── Insert Last ──────────────────────────────────────────────────────────
    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        size++;
    }

    // ─── Insert At Position ───────────────────────────────────────────────────
    public void insertAtPosition(int data, int pos) {
        if (pos < 1 || pos > size + 1) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            insertFirst(data);
        } else if (pos == size + 1) {
            insertLast(data);
        } else {
            Node newNode = new Node(data);
            Node temp = head;

            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
            size++;
        }
    }

    // ─── Delete First ─────────────────────────────────────────────────────────
    public void deleteFirst() {
        if (head == null) {
            return;
        } else if (head.next == null) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    // ─── Delete Last ──────────────────────────────────────────────────────────
    public void deleteLast() {
        if (head == null) {
            return;
        } else if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        size--;
    }

    // ─── Delete At Position ───────────────────────────────────────────────────
    public void deleteAtPosition(int pos) {
        if (pos < 1 || pos > size) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            deleteFirst();
        } else if (pos == size) {
            deleteLast();
        } else {
            Node temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            Node target = temp.next;
            temp.next = target.next;
            target.next.prev = temp;
            size--;
        }
    }

    // ─── Display ──────────────────────────────────────────────────────────────
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // ─── Count ────────────────────────────────────────────────────────────────
    public int count() {
        return size;
    }

    // ─── Main ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {

        // obj1 — stack equivalent (just a local variable in Java)
        DoublyLL obj1 = new DoublyLL();

        obj1.insertFirst(21);
        obj1.insertFirst(11);
        obj1.insertFirst(101);
        obj1.insertFirst(111);
        obj1.display();
        System.out.println("Number of nodes: " + obj1.count());

        obj1.insertAtPosition(75, 4);
        obj1.insertAtPosition(85, 4);
        obj1.display();

        obj1.deleteFirst();
        obj1.deleteLast();
        obj1.display();

        // obj2 — heap equivalent (all objects in Java are heap-allocated)
        DoublyLL obj2 = new DoublyLL();

        obj2.insertFirst(50);
        obj2.insertFirst(51);
        obj2.insertFirst(52);
        obj2.insertLast(55);
        obj2.insertAtPosition(60, 3);
        obj2.display();
        System.out.println("Number of nodes: " + obj2.count());

        // No need for delete obj2 — Java GC handles memory automatically
    }
}
