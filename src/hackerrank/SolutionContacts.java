package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultContacts {

	/*
	 * Complete the 'contacts' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * 2D_STRING_ARRAY queries as parameter.
	 */

	public static List<Integer> contacts(List<List<String>> queries) {
		List<Integer> result = new ArrayList<Integer>();
		List<String> names = new ArrayList<String>();
		
		
		for (List<String> list : queries) {
			if (list.get(0).equals("add")) {
				names.add(list.get(1));
			} else if (list.get(0).equals("find")) {
				Integer count = 0;
				for (String name : names) {
					if (name.startsWith(list.get(1))) {
						count++;
					}
				}
				result.add(count);
			}
			
		}
		return result;
	}

}

public class SolutionContacts {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\examples\\contacts.txt"));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<String>> queries = new ArrayList<>();

		IntStream.range(0, queriesRows).forEach(i -> {
			try {
				queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> result = ResultContacts.contacts(queries);

		bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
