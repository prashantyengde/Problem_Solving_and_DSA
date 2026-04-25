package CustomizedDBMSusingLinkedList;

import java.util.Scanner;

class Student implements LinkedLL
{
    public Node head;
    public int size;

    public Student()
    {
        head = null;
        size = 0;
    }

    public void InsertFirst(int i, String s, int j)
    {
        Node newn = new Node(i, s, j);

        if (this.head == null)
        {
            this.head = newn;
        }
        else
        {
            newn.next = this.head;
            this.head = newn;
        }
        this.size++;
    }

    public void InsertLast(int i, String s, int j)
    {
        Node temp = this.head;
        Node newn = new Node(i, s, j);

        if (this.head == null)
        {
            this.head = newn;
        }
        else
        {
            while (temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = newn;
        }
        this.size++;
    }

    public void Display()
    {
        Node temp = this.head;

        System.out.println("Members of linked list");

        while (temp != null)
        {
            System.out.println("Rno : " + temp.rno + " Name : " + temp.name + " Age :" + temp.age);
            temp = temp.next;
        }
    }

    public int Count()
    {
        return this.size;
    }

    public void Search(int no)
    {
        Node temp = this.head;

        while (temp != null)
        {
            if (temp.rno == no)
            {
                break;
            }
            temp = temp.next;
        }

        if (temp == null)
        {
            System.out.println("There is no such member");
        }
        else
        {
            System.out.println("Member found of Roll no" + no);
            System.out.println("Name : " + temp.name);
            System.out.println("Roll number : " + temp.rno);
            System.out.println("Age : " + temp.age);
        }
    }

    public void Search(String str)
    {
        Node temp = this.head;

        while (temp != null)
        {
            if (str.equals(temp.name))
            {
                break;
            }
            temp = temp.next;
        }

        if (temp == null)
        {
            System.out.println("There is no such member");
        }
        else
        {
            System.out.println("Member found of name " + str);
            System.out.println("Name : " + temp.name);
            System.out.println("Roll number : " + temp.rno);
            System.out.println("Age : " + temp.age);
        }
    }

    public void Delete(int no)
    {
        Node temp = this.head;
        int i = 0;
        if (head == null)
        {
            return;
        }
        if (head.rno == no)
        {
            head = head.next;
            this.size--;
            return;
        }

        for (i = 1; i < this.size; i++)
        {
            if (temp.next.rno == no)
            {
                break;
            }
            temp = temp.next;
        }

        if (i == this.size)
        {
            System.out.println("No element");
        }
        else
        {
            temp.next = temp.next.next;
            this.size--;
        }
    }

    public void Delete(String str)
    {
        Node temp = this.head;
        int i = 0;
        if (head == null)
        {
            return;
        }
        if (str.equals(head.name))
        {
            head = head.next;
            this.size--;
            return;
        }

        for (i = 1; i < this.size; i++)
        {
            if (str.equals(temp.next.name))
            {
                break;
            }
            temp = temp.next;
        }

        if (i == this.size)
        {
            System.out.println("No element");
        }
        else
        {
            temp.next = temp.next.next;
            this.size--;
        }
    }

    public void Update(int no)
    {
        Node temp = this.head;

        while (temp != null)
        {
            if (temp.rno == no)
            {
                break;
            }
            temp = temp.next;
        }

        if (temp == null)
        {
            System.out.println("There is no such member");
        }
        else
        {
            try (Scanner sobj = new Scanner(System.in)) {
				System.out.println("Update : Name / Age / Both");
				System.out.println("1/2/3");

				int option = sobj.nextInt();
				System.out.println(option);

				switch (option)
				{
				    case 3:
				    case 1:
				        System.out.println("Enter new name");
				        sobj.nextLine();
				        String s = sobj.nextLine();
				        temp.name = s;

				        if (option == 1)
				            break;

				    case 2:
				        System.out.println("Enter new age");
				        int j = sobj.nextInt();
				        temp.age = j;
				        break;
				}
			}
        }
    }
}