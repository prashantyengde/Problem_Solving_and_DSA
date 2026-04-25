package CustomizedDBMSusingLinkedList;

class Node
{
    public int rno;
    public String name;
    public int age;
    public Node next;

    {
        this.next = null;
    }

    public Node(int i, String str, int j)
    {
        this.rno = i;
        this.name = str;
        this.age = j;
    }
}
