package CGI;
import java.util.*;

public class CgiFirstRound {
	
	public static void main(String[] prashant) {

	List<String> stringList = new ArrayList<>(Arrays.asList("D", "B", "2","50", "1", "C","A","10", "11"));

	List<String> letters = new ArrayList<>();
	List<String> numbers = new ArrayList<>();

	for (String s : stringList) {
	    if (s.matches("[a-zA-Z]+")) {
	        letters.add(s);
	    } else {
	        numbers.add(s);
	    }
	}

	Collections.sort(letters);
	numbers.sort((a, b) -> Integer.parseInt(a) - Integer.parseInt(b));

	letters.addAll(numbers);
	System.out.println(letters); // [A, B, C, 1, 2, 10, 11]
	}
}
