package CustomizedLinkedListStudentClass;


import java.util.*;

// Class which represents the node from linked list
class Node
{
    // Characteristics
    public int rno;        // Roll number
    public int marks;      // Marks of student
    public Node next;      // Next reference
    public String name;    // Name of student

    // Behaviours
    {
        next = null;       // Default value
    }

    public Node()
    {
        rno = 0;
        name = null;
        marks = 0;
    }

    public Node(int rno, String name, int marks)
    {
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }

} // End of node


// Class which creates and manage the linked list
class Student
{
    // Characteristics
    public Node head;

    // Behaviours
    public Student()
    {
        head = null;
    }

    public boolean insert(int no, String name, int marks)
    {
        Node newn = new Node(no, name, marks);

        if (head == null)
        {
            head = newn;
        }
        else
        {
            newn.next = head;
            head = newn;
        }

        return true;
    }

    public void search(int no)
    {
        Node temp = head;

        while (temp != null)
        {
            if (temp.rno == no)
            {
                System.out.print(temp.rno);
                System.out.print(" " + temp.name);
                System.out.print(" " + temp.marks);
                System.out.println();

                break;
            }
            temp = temp.next;
        }

        if (temp == null)
        {
            System.out.println("There is no such student");
        }
    }

    public void search(String str)
    {
        Node temp = head;

        while (temp != null)
        {
            if (str.equals(temp.name))
            {
                System.out.print(temp.rno);
                System.out.print(" " + temp.name);
                System.out.print(" " + temp.marks);
                System.out.println();

                break;
            }
            temp = temp.next;
        }

        if (temp == null)
        {
            System.out.println("There is no such student");
        }
    }

    public void delete(int no)
    {
        Node temp = head;
        Node deletenode = null;

        if (temp.rno == no)  // For first node
        {
            head = head.next;
        }

        // For remaining nodes
        while (temp.next != null)
        {
            if (temp.next.rno == no)
            {
                System.out.println("Information of node that you want to delete : ");
                System.out.print(temp.next.rno);
                System.out.print(" " + temp.next.name);
                System.out.print(" " + temp.next.marks);
                System.out.println();

                break;
            }
            temp = temp.next;
        }

        if (temp.next == null)
        {
            System.out.println("There is no such student");
            return;
        }

        System.out.println("Are you sure to delete the node 1/0");
        Scanner sobj = new Scanner(System.in);
        int option = sobj.nextInt();

        if (option == 0)
        {
            return;
        }
        else
        {
            deletenode = temp.next;
            temp.next = deletenode.next;

            System.out.println("Member deleted successfully");
        }
    }

    public void Update(int no)
    {
        Node temp = head;

        while (temp != null)
        {
            if (temp.rno == no)
            {
                System.out.println("Old information is : ");
                System.out.print(temp.rno);
                System.out.print(" " + temp.name);
                System.out.print(" " + temp.marks);
                System.out.println();

                break;
            }
            temp = temp.next;
        }

        if (temp == null)
        {
            System.out.println("There is no such student");
            return;
        }

        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter new roll number");
        temp.rno = sobj.nextInt();

        System.out.println("Enter new name");
        temp.name = sobj.next();

        System.out.println("Enter new marks");
        temp.marks = sobj.nextInt();

        System.out.println("Update successful..");
    }

    public void Display()
    {
        Node temp = head;

        while (temp != null)
        {
            System.out.print(temp.rno);
            System.out.print(" " + temp.name);
            System.out.print(" " + temp.marks);
            System.out.println();

            temp = temp.next;
        }
    }

    public void MaximumMarks()
    {
        if (head == null)
        {
            return;
        }

        Node temp = head;
        Node maxref = null;
        int max = 0;

        while (temp != null)
        {
            if (temp.marks > max)
            {
                max = temp.marks;
                maxref = temp;
            }

            temp = temp.next;
        }

        if (maxref != null)
        {
            System.out.println("Information of student with max marks :");
            System.out.print(maxref.rno);
            System.out.print(" " + maxref.name);
            System.out.print(" " + maxref.marks);
            System.out.println();
        }
    }

} // End of Student


// Entry point class which contains main
class CustomizedLinkedListStudentClass
{
    public static void main(String ar[])
    {
        Student sobj1 = new Student();
        Student sobj2 = new Student();
        Student sobj3 = new Student();
        Student sobj4 = new Student();

        sobj1.insert(11,  "ABC", 200);
        sobj1.insert(21,  "PQR", 300);
        sobj1.insert(51,  "XYZ", 400);
        sobj1.insert(101, "MNP", 500);
        sobj1.insert(121, "BJP", 600);
        sobj1.insert(151, "NCP", 0);

        sobj1.Display();

        System.out.println();

        sobj1.search(101);
        sobj1.search(100001);
        System.out.println();

        sobj1.search("MNP");
        sobj1.search("PPP");
        System.out.println();

        sobj1.MaximumMarks();

        System.out.println();
        sobj1.delete(51);
        sobj1.Display();
    }
}