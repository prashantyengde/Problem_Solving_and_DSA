package CustomizedDBMSusingLinkedList;

import java.util.*;

class CustomizedDBMSusingLinkedList {

	public static void main(String arg[]) {
		Student ss = null;

		Scanner sobj = new Scanner(System.in);

		System.out.println("Marvellous DB Started");

		while (true) {
			System.out.println("MarvellousDB:>");
			String query = sobj.nextLine();

			String tokens[] = query.split("\\s");

			// stop
			if (tokens.length == 1) {
				if (query.equalsIgnoreCase("stop")) {
					System.out.println("Thank you for using Marvellous DB");
					break;
				}

				// COUNT
				// count student
				if (tokens[0].equalsIgnoreCase("count")) {
					if (ss == null) {
						System.out.println("Table is not present");
						continue;
					}
					System.out.println("Total Records : " + ss.Count());
				}
			}

			// select * from student
			if (tokens.length == 4) {
				if (tokens[0].equalsIgnoreCase("select"))
					ss.Display();
			}

			// insert into student value 11 Alice 20
			// delete from student where rno = 11
			if (tokens.length == 7) {
				// INSERTFIRST (existing)
				if (tokens[0].equalsIgnoreCase("insert")) {
					ss.InsertFirst(Integer.parseInt(tokens[4]), tokens[5], Integer.parseInt(tokens[6]));
				}

				// INSERTLAST (new)
				// insertlast into student value 11 Alice 20
				if (tokens[0].equalsIgnoreCase("insertlast")) {
					if (ss == null) {
						System.out.println("Table is not present");
						continue;
					}
					ss.InsertLast(Integer.parseInt(tokens[4]), tokens[5], Integer.parseInt(tokens[6]));
					System.out.println("Record inserted at LAST position");
				}

				// DELETE (existing)
				if (tokens[0].equalsIgnoreCase("delete")) {
					if (ss == null) {
						System.out.println("Table is not present");
						continue;
					}
					ss.Delete(Integer.parseInt(tokens[6]));
				}

				// SEARCH by rno
				// search from student where rno = 11
				if (tokens[0].equalsIgnoreCase("search")) {
					if (ss == null) {
						System.out.println("Table is not present");
						continue;
					}
					ss.Search(Integer.parseInt(tokens[6]));
				}

				// UPDATE
				// update from student where rno = 11
				if (tokens[0].equalsIgnoreCase("update")) {
					if (ss == null) {
						System.out.println("Table is not present");
						continue;
					}
					ss.Update(Integer.parseInt(tokens[6]));
				}
			}

			// SEARCH by name (5 tokens)
			// search from student name Alice
			if (tokens.length == 5) {
				if (tokens[0].equalsIgnoreCase("search")) {
					if (ss == null) {
						System.out.println("Table is not present");
						continue;
					}
					ss.Search(tokens[4]);
				}
			}

			// create table student
			if (tokens.length == 3) {
				if (tokens[0].equalsIgnoreCase("create"))
					ss = new Student();
			}
		}
	}
}