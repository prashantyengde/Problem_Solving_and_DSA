package CustomizedDBMSusingLinkedList;

interface LinkedLL
{
    public void InsertFirst(int i, String s, int j);

    public void InsertLast(int i, String s, int j);

    public int Count();

    public void Display();

    public void Search(int z);

    public void Search(String y);

    public void Delete(int a);

    public void Delete(String a);

    public void Update(int a);
}