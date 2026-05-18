package singlyLinkedListProblem;

import java.util.*;



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

	// ─── InsertFirst (given logic converted) ──────────────────
	void insertFirst(int no) {
		Node newn = new Node(no);
		if (head == null) {
			head = newn;
		} else {
			newn.next = head;
			head = newn;
		}
	}

	// ─── Display List ─────────────────────────────────────────
	void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print("|" + temp.data + "|");
			if (temp.next != null)
				System.out.print("->");
			temp = temp.next;
		}
		System.out.println();
	}

	// ══════════════════════════════════════════════════════════
	// PROBLEM 1 — Display Perfect Numbers
	// ══════════════════════════════════════════════════════════
	/*
	 * A Perfect Number equals the sum of its proper divisors. Example: 6 = 1+2+3 =
	 * 6 ✓ 28 = 1+2+4+7+14 = 28 ✓
	 */
	boolean isPerfect(int n) {
		if (n < 2)
			return false;
		int sum = 1;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				sum += i;
				if (i != n / i)
					sum += n / i;
			}
		}
		return sum == n;
	}

	void displayPerfect() {
		Node temp = head;
		System.out.print("Perfect Numbers: ");
		while (temp != null) {
			if (isPerfect(temp.data))
				System.out.print(temp.data + "  ");
			temp = temp.next;
		}
		System.out.println();
	}

	// ══════════════════════════════════════════════════════════
	// PROBLEM 2 — Display Prime Numbers
	// ══════════════════════════════════════════════════════════
	/*
	 * A Prime Number is divisible only by 1 and itself. Example: 11, 17, 41, 89 are
	 * prime
	 */
	boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i * i <= n; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	void displayPrime() {
		Node temp = head;
		System.out.print("Prime Numbers: ");
		while (temp != null) {
			if (isPrime(temp.data))
				System.out.print(temp.data + "  ");
			temp = temp.next;
		}
		System.out.println();
	}

	// ══════════════════════════════════════════════════════════
	// PROBLEM 3 — Addition of All Even Elements
	// ══════════════════════════════════════════════════════════
	/*
	 * Traverse list, add node data if it is even (divisible by 2) Example:
	 * 11->20->32->41 → 20+32 = 52
	 */
	int additionEven() {
		int sum = 0;
		Node temp = head;
		while (temp != null) {
			if (temp.data % 2 == 0)
				sum += temp.data;
			temp = temp.next;
		}
		return sum;
	}

	// ══════════════════════════════════════════════════════════
	// PROBLEM 4 — Second Maximum Element
	// ══════════════════════════════════════════════════════════
	/*
	 * Track max and secondMax while traversing. Example: 110->230->320->240 →
	 * max=320, secMax=240
	 */
	int secMaximum() {
		if (head == null || head.next == null) {
			System.out.println("List has less than 2 elements!");
			return -1;
		}

		int max = Integer.MIN_VALUE;
		int secMax = Integer.MIN_VALUE;
		Node temp = head;

		while (temp != null) {
			if (temp.data > max) {
				secMax = max;
				max = temp.data;
			} else if (temp.data > secMax && temp.data != max) {
				secMax = temp.data;
			}
			temp = temp.next;
		}
		return secMax;
	}

	// ══════════════════════════════════════════════════════════
	// PROBLEM 5 — Sum of Digits of Each Element
	// ══════════════════════════════════════════════════════════
	/*
	 * For each node, extract digits and sum them. Example: 110 → 1+1+0 = 2 230 →
	 * 2+3+0 = 5 640 → 6+4+0 = 10
	 */
	int digitSum(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

	void sumDigit() {
		Node temp = head;
		System.out.print("Digit Sums: ");
		while (temp != null) {
			System.out.print(digitSum(temp.data) + "  ");
			temp = temp.next;
		}
		System.out.println();
	}
}

//─── Main Class ───────────────────────────────────────────────
public class Assignment43 {

	public static void main(String[] args) {

		// ── Q1: Display Perfect Numbers ───────────────────────
		System.out.println("=== Q1: Perfect Numbers ===");
		SinglyLinkedList list1 = new SinglyLinkedList();
		// Insert to get: 11->28->17->41->6->89
		list1.insertFirst(89);
		list1.insertFirst(6);
		list1.insertFirst(41);
		list1.insertFirst(17);
		list1.insertFirst(28);
		list1.insertFirst(11);
		System.out.print("Input:  ");
		list1.display();
		list1.displayPerfect();
		// Output: 6 28

		System.out.println();

		// ── Q2: Display Prime Numbers ─────────────────────────
		System.out.println("=== Q2: Prime Numbers ===");
		SinglyLinkedList list2 = new SinglyLinkedList();
		// Insert to get: 11->20->17->41->22->89
		list2.insertFirst(89);
		list2.insertFirst(22);
		list2.insertFirst(41);
		list2.insertFirst(17);
		list2.insertFirst(20);
		list2.insertFirst(11);
		System.out.print("Input:  ");
		list2.display();
		list2.displayPrime();
		// Output: 11 17 41 89

		System.out.println();

		// ── Q3: Addition of Even Elements ────────────────────
		System.out.println("=== Q3: Addition of Even Elements ===");
		SinglyLinkedList list3 = new SinglyLinkedList();
		// Insert to get: 11->20->32->41
		list3.insertFirst(41);
		list3.insertFirst(32);
		list3.insertFirst(20);
		list3.insertFirst(11);
		System.out.print("Input:  ");
		list3.display();
		System.out.println("Even Sum: " + list3.additionEven());
		// Output: 52

		System.out.println();

		// ── Q4: Second Maximum Element ────────────────────────
		System.out.println("=== Q4: Second Maximum Element ===");
		SinglyLinkedList list4 = new SinglyLinkedList();
		// Insert to get: 110->230->320->240
		list4.insertFirst(240);
		list4.insertFirst(320);
		list4.insertFirst(230);
		list4.insertFirst(110);
		System.out.print("Input:  ");
		list4.display();
		System.out.println("Second Maximum: " + list4.secMaximum());
		// Output: 240

		System.out.println();

		// ── Q5: Sum of Digits of Each Element ─────────────────
		System.out.println("=== Q5: Sum of Digits ===");
		SinglyLinkedList list5 = new SinglyLinkedList();
		// Insert to get: 110->230->20->240->640
		list5.insertFirst(640);
		list5.insertFirst(240);
		list5.insertFirst(20);
		list5.insertFirst(230);
		list5.insertFirst(110);
		System.out.print("Input:  ");
		list5.display();
		list5.sumDigit();
		// Output: 2 5 2 6 10
	}
}

/*
=== Q1: Perfect Numbers ===
Input:  |11|->|28|->|17|->|41|->|6|->|89|
Perfect Numbers: 6  28

=== Q2: Prime Numbers ===
Input:  |11|->|20|->|17|->|41|->|22|->|89|
Prime Numbers: 11  17  41  89

=== Q3: Addition of Even Elements ===
Input:  |11|->|20|->|32|->|41|
Even Sum: 52

=== Q4: Second Maximum Element ===
Input:  |110|->|230|->|320|->|240|
Second Maximum: 240

=== Q5: Sum of Digits ===
Input:  |110|->|230|->|20|->|240|->|640|
Digit Sums: 2  5  2  6  10
*/