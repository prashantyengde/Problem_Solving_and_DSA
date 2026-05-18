package SinglyLinkedList;

//─── Node Class ───────────────────────────────────────────────
class Node {
 int data;
 Node next;

 Node(int data) {
     this.data = data;
     this.next = null;
 }
}

//─── LinkedList Class ─────────────────────────────────────────
class SinglyLinkedList {

 Node head;

 // ══════════════════════════════════════════════════════════
 // DISPLAY
 // ══════════════════════════════════════════════════════════
 void display() {
     if (head == null) {
         System.out.println("List is empty!");
         return;
     }
     Node temp = head;
     while (temp != null) {
         System.out.print("|" + temp.data + "|");
         if (temp.next != null)
             System.out.print("->");
         temp = temp.next;
     }
     System.out.println(" -> NULL");
 }

 // ══════════════════════════════════════════════════════════
 // 1. INSERT AT FIRST
 // ══════════════════════════════════════════════════════════
 /*
  * Steps:
  * 1. Create new node
  * 2. If list empty → new node becomes head
  * 3. Else → newn.next = head, head = newn
  *
  * Before: head -> [20] -> [30] -> NULL
  * Insert: 10
  * After:  head -> [10] -> [20] -> [30] -> NULL
  */
 void insertAtFirst(int no) {
     Node newn = new Node(no);

     if (head == null) {
         // List is empty → new node is head
         head = newn;
     } else {
         // Point new node to current head
         newn.next = head;
         // Move head to new node
         head = newn;
     }
 }

 // ══════════════════════════════════════════════════════════
 // 2. INSERT AT LAST
 // ══════════════════════════════════════════════════════════
 /*
  * Steps:
  * 1. Create new node
  * 2. If list empty → new node becomes head
  * 3. Else → traverse to last node, last.next = newn
  *
  * Before: head -> [10] -> [20] -> NULL
  * Insert: 30
  * After:  head -> [10] -> [20] -> [30] -> NULL
  */
 void insertAtLast(int no) {
     Node newn = new Node(no);

     if (head == null) {
         // List is empty → new node is head
         head = newn;
     } else {
         // Traverse to last node
         Node temp = head;
         while (temp.next != null) {
             temp = temp.next;
         }
         // temp is now the last node
         // Link last node to new node
         temp.next = newn;
     }
 }

 // ══════════════════════════════════════════════════════════
 // 3. INSERT IN BETWEEN (after a given value)
 // ══════════════════════════════════════════════════════════
 /*
  * Steps:
  * 1. Create new node
  * 2. Traverse to find node with value = afterValue
  * 3. newn.next = prev.next   ← MUST DO THIS FIRST
  * 4. prev.next = newn        ← then redirect prev
  *
  * Before: head -> [10] -> [20] -> [30] -> NULL
  * Insert: 25 after 20
  * After:  head -> [10] -> [20] -> [25] -> [30] -> NULL
  */
 void insertInBetween(int no, int afterValue) {
     Node newn = new Node(no);

     // Search for the node with afterValue
     Node temp = head;
     while (temp != null) {
         if (temp.data == afterValue) {
             // STEP 1: newn.next = temp.next (point to next node FIRST)
             newn.next = temp.next;
             // STEP 2: temp.next = newn (redirect current node to newn)
             temp.next = newn;
             System.out.println("Inserted " + no + " after " + afterValue);
             return;
         }
         temp = temp.next;
     }
     // If we reach here, afterValue not found
     System.out.println("Value " + afterValue + " not found in list!");
 }

 // ══════════════════════════════════════════════════════════
 // 4. DELETE FROM FIRST
 // ══════════════════════════════════════════════════════════
 /*
  * Steps:
  * 1. Check if list is empty
  * 2. head = head.next (move head forward)
  * 3. Old head is garbage collected automatically
  *
  * Before: head -> [10] -> [20] -> [30] -> NULL
  * After:  head -> [20] -> [30] -> NULL
  */
 void deleteFromFirst() {
     if (head == null) {
         System.out.println("List is empty! Cannot delete.");
         return;
     }
     System.out.println("Deleted from first: " + head.data);
     // Move head to next node (old head gets garbage collected)
     head = head.next;
 }

 // ══════════════════════════════════════════════════════════
 // 5. DELETE FROM LAST
 // ══════════════════════════════════════════════════════════
 /*
  * Steps:
  * 1. Check if list is empty
  * 2. If only 1 node → head = null
  * 3. Else → traverse till second-last node
  * 4. Set second-last node's next = null
  *
  * Before: head -> [10] -> [20] -> [30] -> NULL
  * After:  head -> [10] -> [20] -> NULL
  */
 void deleteFromLast() {
     if (head == null) {
         System.out.println("List is empty! Cannot delete.");
         return;
     }

     // Only one node in list
     if (head.next == null) {
         System.out.println("Deleted from last: " + head.data);
         head = null;
         return;
     }

     // Traverse to second-last node
     Node temp = head;
     while (temp.next.next != null) {
         temp = temp.next;
     }
     // temp is now second-last node
     System.out.println("Deleted from last: " + temp.next.data);
     temp.next = null; // Remove last node
 }

 // ══════════════════════════════════════════════════════════
 // 6. DELETE IN BETWEEN (delete a node with given value)
 // ══════════════════════════════════════════════════════════
 /*
  * Steps:
  * 1. Check if list is empty
  * 2. If head node has the value → call deleteFromFirst
  * 3. Else → traverse with prev and curr pointers
  * 4. When curr.data == value → prev.next = curr.next
  *
  * Before: head -> [10] -> [20] -> [30] -> NULL
  * Delete: 20
  * After:  head -> [10] -> [30] -> NULL
  */
 void deleteInBetween(int value) {
     if (head == null) {
         System.out.println("List is empty! Cannot delete.");
         return;
     }

     // If head node is the one to delete
     if (head.data == value) {
         deleteFromFirst();
         return;
     }

     // Two pointers: prev stays one behind curr
     Node prev = head;
     Node curr = head.next;

     while (curr != null) {
         if (curr.data == value) {
             // Bypass curr: prev jumps over curr
             prev.next = curr.next;
             System.out.println("Deleted node: " + value);
             return;
         }
         prev = curr;
         curr = curr.next;
     }

     // Value not found
     System.out.println("Value " + value + " not found in list!");
 }
}

//─── Main Class ───────────────────────────────────────────────
public class Assignment431 {

 public static void main(String[] args) {

     SinglyLinkedList list = new SinglyLinkedList();

     System.out.println("========================================");
     System.out.println("       INSERT OPERATIONS");
     System.out.println("========================================");

     // ── Insert at First ──────────────────────────────────
     System.out.println("\n--- Insert At First ---");
     list.insertAtFirst(30);
     list.display();                  // |30| -> NULL

     list.insertAtFirst(20);
     list.display();                  // |20|->|30| -> NULL

     list.insertAtFirst(10);
     list.display();                  // |10|->|20|->|30| -> NULL

     // ── Insert at Last ───────────────────────────────────
     System.out.println("\n--- Insert At Last ---");
     list.insertAtLast(40);
     list.display();                  // |10|->|20|->|30|->|40| -> NULL

     list.insertAtLast(50);
     list.display();                  // |10|->|20|->|30|->|40|->|50| -> NULL

     // ── Insert In Between ────────────────────────────────
     System.out.println("\n--- Insert In Between ---");
     list.insertInBetween(25, 20);    // Insert 25 after 20
     list.display();                  // |10|->|20|->|25|->|30|->|40|->|50| -> NULL

     list.insertInBetween(35, 30);    // Insert 35 after 30
     list.display();                  // |10|->|20|->|25|->|30|->|35|->|40|->|50| -> NULL

     list.insertInBetween(99, 999);   // Try inserting after non-existent value

     System.out.println("\n========================================");
     System.out.println("       DELETE OPERATIONS");
     System.out.println("========================================");

     System.out.println("\nCurrent list:");
     list.display();

     // ── Delete from First ────────────────────────────────
     System.out.println("\n--- Delete From First ---");
     list.deleteFromFirst();
     list.display();                  // |20|->|25|->|30|->|35|->|40|->|50| -> NULL

     // ── Delete from Last ─────────────────────────────────
     System.out.println("\n--- Delete From Last ---");
     list.deleteFromLast();
     list.display();                  // |20|->|25|->|30|->|35|->|40| -> NULL

     // ── Delete In Between ────────────────────────────────
     System.out.println("\n--- Delete In Between ---");
     list.deleteInBetween(30);        // Delete node with value 30
     list.display();                  // |20|->|25|->|35|->|40| -> NULL

     list.deleteInBetween(25);        // Delete node with value 25
     list.display();                  // |20|->|35|->|40| -> NULL

     list.deleteInBetween(999);       // Try deleting non-existent value

     System.out.println("\n--- Edge Cases ---");
     // Delete remaining nodes one by one from first
     list.deleteFromFirst();
     list.deleteFromFirst();
     list.deleteFromFirst();
     list.display();                  // List is empty!

     // Try deleting from empty list
     list.deleteFromFirst();
     list.deleteFromLast();
     list.deleteInBetween(10);
 }
}